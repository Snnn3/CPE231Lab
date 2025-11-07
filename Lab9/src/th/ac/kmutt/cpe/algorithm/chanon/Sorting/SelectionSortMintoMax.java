package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortMintoMax<T extends Comparable <T>> implements SortStrategy<T> {
    public ArrayList<T> sort(ArrayList<T> list){
        for (int i = 0; i < list.size(); i++) {
            int min = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(min)) < 0) {
                    min = j;
                }
            }
            Collections.swap(list, min, i);
        }
        return list;
    }

}
