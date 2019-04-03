package es.uam.ads.p4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public abstract class RecomendadorGeneral implements Recomendador{

    protected ModeloDatosR datos = new ModeloDatosR() ;


    public RecomendadorGeneral(String fichero) throws IOException {
        datos.leeFicheroPreferencias(fichero);
    }

    public ModeloDatosR getDatos() {
        return datos;
    }



    public abstract double calcularCoste(Long usuario, Long elemento);

    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {

        Set<Long> usuarios = datos.getUsuariosUnicos();
        Set<Long> items = datos.getItemsUnicos();
        ArrayList<Tupla> tuplas = new ArrayList<>();
        double score;
        Tupla t;
        Recomendacion r;


        if((usuarios.contains(u) == false) || longitudRecomendacion <= 0){
            throw new RecomendacionInvalida();
        }

        for (Long elemento : items) {
            if(datos.getPreferenciasUsuario(u).containsKey(elemento) == false) {
                score = calcularCoste(u,elemento);
                t = new Tupla(elemento,score);
                tuplas.add(t);
                if(tuplas.size() == longitudRecomendacion) {
                    break;
                }
            }
        }

        r = new Recomendacion(u,tuplas);
        return r;
    }







}
