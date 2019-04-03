package es.uam.ads.p4;

public interface Recomendador {

    Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida;

}
