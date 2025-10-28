package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;

public interface SortStrategy<T extends Comparable<T>> {
    public void sort(ArrayList<T> list); 
}
