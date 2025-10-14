public class Triangle extends Shape {
    private Pair p1;
    private Pair p2;
    private Pair p3;

    public Triangle(double x1,double y1,double x2,double y2,double x3,double y3,String color){
        super(color);
        this.p1 = new Pair(x1, y1);
        this.p2 = new Pair(x2, y2);
        this.p3 = new Pair(x3, y3);
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
    public Pair getP3(){
        return this.p3;
    }
    public void setP3(double x,double y){
        this.p3.setX(x);
        this.p3.setY(y);
    }

    public double area(){
        double a = Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()+p2.getY(), 2)); 
        double b = Math.sqrt(Math.pow(p1.getX()-p3.getX(), 2)+Math.pow(p1.getY()+p3.getY(), 2)); 
        double c = Math.sqrt(Math.pow(p2.getX()-p3.getX(), 2)+Math.pow(p2.getY()+p3.getY(), 2)); 
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public double perimeter(){
        double a = Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()+p2.getY(), 2)); 
        double b = Math.sqrt(Math.pow(p1.getX()-p3.getX(), 2)+Math.pow(p1.getY()+p3.getY(), 2)); 
        double c = Math.sqrt(Math.pow(p2.getX()-p3.getX(), 2)+Math.pow(p2.getY()+p3.getY(), 2)); 
        return a+b+c;
    }
}
