package es.uam.ads.p4;

import java.util.List;
import java.util.Set;

public class SimilitudCos implements Similitud{


    ModeloDatosR datos;

    public SimilitudCos(ModeloDatosR datos) {
        this.datos = datos;
    }

    @Override
    public double sim(Long u1, Long u2) {

        Set<Long> itemsU1 = datos.getPreferenciasUsuario(u1).keySet();
        Set<Long> itemsU2 = datos.getPreferenciasUsuario(u2).keySet();
        Set<Long> itemsU1U2 = datos.getPreferenciasUsuario(u1).keySet();
        double denominadorU1 = 0.0, denominadorU2 = 0.0;
        double numerador = 0.0;
        double scoreU1 = 0.0, scoreU2 = 0.0;
        double sim = 0.0;

        itemsU1U2.retainAll(itemsU2);

        for (Long i : itemsU1U2){
            scoreU1 = datos.getPreferenciasUsuario(u1).get(i);
            scoreU2 = datos.getPreferenciasUsuario(u2).get(i);

            numerador = numerador + (scoreU1 * scoreU2);
        }

        for (Long i : itemsU1){
            denominadorU1 = denominadorU1 + Math.pow(datos.getPreferenciasUsuario(u1).get(i),2);
        }
        for (Long i : itemsU2){
            denominadorU2 = denominadorU2 + Math.pow(datos.getPreferenciasUsuario(u2).get(i),2);
        }

        sim = numerador/Math.sqrt(denominadorU1*denominadorU2);

        return sim;

    }
}
