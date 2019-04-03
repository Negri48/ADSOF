package es.uam.ads.p4;

import java.util.ArrayList;
import java.util.Collections;

public class Recomendacion {

    // Usuario
    private Long usuario;

    // Lista de tuplas
    private ArrayList<Tupla> recomendaciones;


    public Recomendacion(Long usuario, ArrayList<Tupla> recomendaciones) {
        this.usuario = usuario;
        this.recomendaciones = recomendaciones;
        Collections.sort(recomendaciones);
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Tupla> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(ArrayList<Tupla> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    @Override
    public String toString() {
        return "Recomendacion   [usuario="+ usuario +",  recomendaciones=["+recomendaciones+']';
    }
}
