package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

public class Pair implements Comparable<Pair> {
    private double x;
    private double y;

    public Pair(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return this.y;
    }
    public void setY(double y){
        this.y = y;
    }

    public double distance(Pair second){
        double x = this.x - second.getX();
        double y = this.y - second.getY();
        double dis = Math.sqrt((x*x)+(y*y));
        return dis;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.x > o.x) {
            return 1;
        }else if (this.x < o.x) {
            return -1;
        }
        return 0;
    }
    
}
