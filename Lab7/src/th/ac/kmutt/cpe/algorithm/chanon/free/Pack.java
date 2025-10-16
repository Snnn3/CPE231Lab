package th.ac.kmutt.cpe.algorithm.chanon.free;

public class Pack implements Comparable<Pack> {
    public Double wide;
    public Double height;
    public Double area;

    public Pack(Double wide, Double height){
        this.wide = wide;
        this.height = height;
        this.area = height*wide;
    }
    
    @Override
    public int compareTo(Pack other){
        return this.height.compareTo(other.height);
    }
}
