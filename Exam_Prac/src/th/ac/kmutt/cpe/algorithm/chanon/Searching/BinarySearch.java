package th.ac.kmutt.cpe.algorithm.chanon.Searching;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements SearchStrategy<T,ArrayList<Integer>> {
    public ArrayList<Integer> search(ArrayList<T> list, T traget){
        int l = 0;
        int r = list.size() - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (l <= r) {
            int m = (l+r)/2;
            if (list.get(m).compareTo(traget) == 0) {
                ans.add(m);
                return new ArrayList<>(List.of(m));
            }else if (traget.compareTo(list.get(m)) < 0) {
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return new ArrayList<>();
    }
}
