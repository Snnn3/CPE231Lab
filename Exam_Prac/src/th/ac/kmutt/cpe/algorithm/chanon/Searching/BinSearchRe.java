package th.ac.kmutt.cpe.algorithm.chanon.Searching;

import java.util.ArrayList;

public class BinSearchRe<T extends Comparable<T>> implements SearchStrategy<T,Integer> {
    public Integer search(ArrayList<T> list, T target){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(searchhelp(list, 0, list.size()-1, target));
        return ans.getFirst();
    }

    public int searchhelp(ArrayList<T> list,int l,int r,T K){
        if (l > r) {
            return -1;
        }
        int mid = (l+r)/2;
        if (list.get(mid).compareTo(K) == 0) {
            return mid;
        }else if (K.compareTo(list.get(mid)) < 0) {
            return searchhelp(list, l, mid, K);
        }else{
            return searchhelp(list, mid + 1, r, K);
        }
    }
}
