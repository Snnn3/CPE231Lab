package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;

import th.ac.kmutt.cpe.algorithm.chanon.Searching.BinSearchRe;
import th.ac.kmutt.cpe.algorithm.chanon.Searching.SearchContext;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.InsertionSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class PresortMode {
    public static void main(String[] args) {
        int[] arr ={4,3,2,1,0};

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        SortContext<Integer> sort = new SortContext<>(new InsertionSort<Integer>());
        SearchContext<Integer,Integer> search = new SearchContext<Integer,Integer>(new BinSearchRe<>());
        sort.executeSort(list);
        System.out.println(list);
        search.executeSearch(list,5);
        System.out.println();
    }
}
