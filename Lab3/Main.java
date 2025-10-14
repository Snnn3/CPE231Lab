import java.util.Scanner;
//Test 
// 3
// 1
// red 0 0 1
// 2
// red 0 0 1 1
// 3
// red 0 0 0 2 2 0
// red: 6.14
// green: 0.00
// blue: 0.00
// black: 17.11
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double red = 0, green = 0, blue = 0, black = 0; 
        System.out.println("Select Shape");
        System.out.println("1.Circle");
        System.out.println("2.Rectangle");
        System.out.println("3.Triangle");
        for (int i = 0; i < n; i++) {
            int option = sc.nextInt();
            if (option == 1) {
                String color = sc.next();
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double r = sc.nextDouble();
                Circle cir = new Circle(x, y, r, color);
                if (cir.getColor().equals("red")) {
                    red += cir.area();
                }else if (cir.getColor().equals("green")) {
                    green += cir.area();
                }else if (cir.getColor().equals("blue")) {
                    blue += cir.area();
                }
                black += cir.perimeter();
            }else if (option == 2) {
                String color = sc.next();
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                Rectangle reg = new Rectangle(x1, y1, x2, y2, color);
                if (reg.getColor().equals("red")) {
                    red += reg.area();
                }else if (reg.getColor().equals("green")) {
                    green += reg.area();
                }else if (reg.getColor().equals("blue")) {
                    blue += reg.area();
                }
                black += reg.perimeter();
            }
            else if (option == 3) {
                String color = sc.next();
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                double x3 = sc.nextDouble();
                double y3 = sc.nextDouble();
                Triangle tri = new Triangle(x1, y1, x2, y2, x3, y3, color);
                if (tri.getColor().equals("red")) {
                    red += tri.area();
                }else if (tri.getColor().equals("green")) {
                    green += tri.area();
                }else if (tri.getColor().equals("blue")) {
                    blue += tri.area();
                }
                black += tri.perimeter();
            }
        }
        System.out.printf("red: %.2f\n",red);
        System.out.printf("green: %.2f\n",green);
        System.out.printf("blue: %.2f\n",blue);
        System.out.printf("black: %.2f\n",black);
        
        sc.close();
    }
}
