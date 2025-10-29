package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.PresortedUnique;

public class PreMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        PresortedUnique<Integer> PreSort = new PresortedUnique<>();

        PreSort.Presort(list);
        System.out.println(list);
        sc.close();
    }
}
