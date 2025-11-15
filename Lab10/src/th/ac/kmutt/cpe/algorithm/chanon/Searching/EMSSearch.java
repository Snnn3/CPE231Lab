package th.ac.kmutt.cpe.algorithm.chanon.Searching;

import java.util.ArrayList;

public class EMSSearch<T extends Comparable<T>> implements SearchStrategy<T,Integer> {
    public Integer search(ArrayList<T> list , T target){
        for (int i = 1; i <= list.size() -1; i++) {
               if (target.compareTo(list.get(i)) <= 0) {
                    return i;
                }
            }
        return list.size();
    }
}
