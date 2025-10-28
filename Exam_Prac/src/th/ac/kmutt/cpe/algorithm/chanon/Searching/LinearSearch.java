package th.ac.kmutt.cpe.algorithm.chanon.Searching;

import java.util.ArrayList;

public class LinearSearch<T extends Comparable<T>> implements SearchStrategy<T,ArrayList<Integer>> {
  public ArrayList<Integer> search(ArrayList<T> list, T target){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(target) == 0) {
                arr.add(i);
            }
        }
        return arr;
    }

}
