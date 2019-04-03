package es.uam.ads.p4;

import java.io.IOException;
import java.util.Map;

public class RecomendadorVecinos extends RecomendadorGeneral {


    Similitud s = new SimilitudCos(datos);

    public RecomendadorVecinos(String fichero) throws IOException {
        super(fichero);
    }



    @Override
    public double calcularCoste(Long usuario, Long elemento) {

        Map<Long,Double> valoracionesItem = datos.getPreferenciasItem(elemento);
        double score = 0.0;

        for (Long user : valoracionesItem.keySet()){
            score = score + valoracionesItem.get(user)*s.sim(usuario,user);
        }
        return score;
    }


}
