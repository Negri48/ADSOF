package es.uam.ads.p4;

public class Tupla implements Comparable<Tupla>{

    private Long item;

    private Double ratio;


    public Tupla(Long item, Double ratio) {
        this.item = item;
        this.ratio = ratio;
    }


    @Override
    public int compareTo(Tupla t) {
        return (-1) * this.ratio.compareTo(t.ratio);
    }

    @Override
    public String toString() {
        return "Tupla   [elemento="+ item +",   valor=" + ratio +']';
    }
}
