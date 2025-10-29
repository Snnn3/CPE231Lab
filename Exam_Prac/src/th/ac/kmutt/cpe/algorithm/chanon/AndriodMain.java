package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.Searching.LinearSearch;
import th.ac.kmutt.cpe.algorithm.chanon.Searching.SearchContext;
import th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo.LexicographicalOrder;



public class AndriodMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = alph.substring(0, n);
        //SortContext<Character> sort = new SortContext<>(new PancakeSort<Character>());
        LexicographicalOrder LXsolve = new LexicographicalOrder();
        ArrayList<String> PerSet = LXsolve.nextPermutation(str);
        SearchContext<String,ArrayList<Integer>> solver = new SearchContext<>(new LinearSearch<String>());
        System.out.println(PerSet);
        for (int i = 0; i < m; i++) {
            String finding = sc.next();
            ArrayList<Integer> index = solver.executeSearch(PerSet, finding);
            if (index.isEmpty()) {
                System.out.println("Not Found");
            }else{
                System.out.println(index.getFirst()+1);
            }
        }   
        
        sc.close();
        }   
}
