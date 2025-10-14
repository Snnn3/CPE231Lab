public class Rectangle extends Shape {
    private Pair p1;
    private Pair p2;

    public Rectangle(double x1,double y1,double x2,double y2,String color){
        super(color);
        this.p1 = new Pair(x1, y1);
        this.p2 = new Pair(x2, y2);
    }

    public Pair getP1(){
        return this.p1;
    }
    public void setP1(double x,double y){
        this.p1.setX(x);
        this.p1.setY(y);
    }
    public Pair getP2(){
        return this.p2;
    }
    public void setP2(double x,double y){
        this.p2.setX(x);
        this.p2.setY(y);
    }

    public double area(){
        return Math.abs(this.p1.getX()-this.p2.getX())*Math.abs(this.p1.getY()-this.p2.getY());
    }

    public double perimeter(){
        return 2*(Math.abs(this.p1.getX()-this.p2.getX())+Math.abs(this.p1.getY()-this.p2.getY()));
    }
}
