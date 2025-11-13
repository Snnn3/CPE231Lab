package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class HistogramMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextDouble());
        }
        int k = sc.nextInt();
        HistogramSelect solve = new HistogramSelect();
        System.out.println(solve.Select(list, k, b));
        sc.close();
    }
}
