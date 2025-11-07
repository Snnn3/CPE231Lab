package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEgyptian {
    public static ArrayList<Integer> toEgytian(int numerator, int denominator){
        ArrayList<Integer> list = new ArrayList<>();
        int faction = 1;
        while (true) {
            int topLeft = numerator*faction;
            int topRight = 1 * denominator;
            if (topLeft - topRight >= 0) {
                numerator = topLeft- topRight;
                denominator = denominator*faction;
                list.add(faction);
                if(topLeft-topRight == 0) break;
            } 
            faction++;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Numerator");
        int numerator = sc.nextInt();
        System.out.println("Enter denominator");
        int denominator = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list = toEgytian(numerator, denominator);
        System.out.println("Egyptian Fraction of " + numerator + "/" + denominator + " is");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1) {
                System.out.println("1/" + list.get(i));
            }else System.out.print("1/" + list.get(i) + " + ");
        }

        sc.close();
    }
}
