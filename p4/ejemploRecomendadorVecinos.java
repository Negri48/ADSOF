package es.uam.ads.p4;

import java.io.IOException;
import java.util.ArrayList;

public class ejemploRecomendadorVecinos {

    public static void main(String[] args) throws IOException {

        ModeloDatosR datos = new ModeloDatosR();

        Long u1,u2;

        datos.leeFicheroPreferencias("PruebaTraining.txt");

        SimilitudCos s = new SimilitudCos(datos);

        u1 = Long.valueOf(175);
        u2 = Long.valueOf(190);

        System.out.println("La similitud entre " + u1 + "y " + u2 + "es = "+s.sim(u1,u2));

        u1 = Long.valueOf(175);
        u2 = Long.valueOf(267);

        System.out.println("La similitud entre " + u1 + "y " + u2 + "es = "+s.sim(u1,u2));

        u1 = Long.valueOf(267);
        u2 = Long.valueOf(190);

        System.out.println("La similitud entre " + u1 + "y " + u2 + "es = "+s.sim(u1,u2));

        u1 = Long.valueOf(190);


    }
}
