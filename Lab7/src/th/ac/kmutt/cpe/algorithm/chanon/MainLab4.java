package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Searching.LinearSearch;
import th.ac.kmutt.cpe.algorithm.chanon.Searching.SearchContext;

public class MainLab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        ArrayList<Character> str = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            str.add(temp.charAt(i));
        }
        Character first = sc.next().charAt(0);
        Character last = sc.next().charAt(0);
        int len = sc.nextInt();

        SearchContext<Character,ArrayList<Integer>> solver = new SearchContext<Character,ArrayList<Integer>>(new LinearSearch<>());
        ArrayList<Integer> Flist = solver.executeSearch(str, first);
        ArrayList<Integer> Llist = solver.executeSearch(str, last);
        int ans = 0;
        for (Integer i : Flist) {
            for (Integer j : Llist) {
                if (j - i + 1 >= len) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
