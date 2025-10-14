public class Circle extends Shape {
    private Pair p;
    private double r;
    
    public Circle(double x,double y,double r,String color){
        super(color);
        this.p = new Pair(x, y);
        this.r = r;
    }
    
    public Pair getP(){
        return this.p;
    }
    public void setP(int x,int y){
        this.p.setX(x);
        this.p.setY(y);
    }

    public double getR(){
        return this.r;
    }
    public void setR(double r){
        this.r = r;
    }

    public double area(){
        return Math.PI*r*r;
    }

    public double perimeter(){
        return Math.PI*r*2;
    }

    
}
