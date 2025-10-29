package th.ac.kmutt.cpe.algorithm.chanon;

public class Point implements Comparable<Point>{
    
    int x;
    int y;

    public Point(int X,int Y){
        this.x = X;
        this.y = Y;
    }

    public int compareTo(Point P2) {
        if(this.x > P2.x){
            return 1;
        }else if(this.x < P2.x){
            return -1;
        }else{
            if(this.y > P2.y){
                return 1;
            }else if(this.y < P2.y){
                return -1;
            }else{
                return 0;
            }
        }
    }

    
}
