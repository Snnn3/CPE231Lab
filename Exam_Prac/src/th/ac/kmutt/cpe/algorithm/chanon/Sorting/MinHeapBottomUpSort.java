package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;

public class MinHeapBottomUpSort<T extends Comparable<T>> implements SortStrategy<T> {
    public void sort(ArrayList<T> list){
        int n = list.size() - 1;
        heapify(list, n);
        System.out.println(list);
        for (int i = n; i >= 0; i--) {
            heapify(list,i);
            swap(list, 0, i);
        }
    }
    private void heapify(ArrayList<T> list,int ed){
        int n = ed;
        for (int i = (n-1)/2; i >= 0; i--) {
            int k = i;
            T v = list.get(k);
            Boolean heap = false;
            while (!heap && 2*k + 1 <= n) {
                int j = 2*k + 1;
                if (j < n) {
                    if (list.get(j).compareTo(list.get(j + 1)) >= 0) {
                        j++;
                    }
                }
                if (v.compareTo(list.get(j)) < 0) {
                    heap = true;
                }else{
                    list.set(k, list.get(j));
                    k = j;
                }
            }
            list.set(k, v);
        }
    }

    private void swap(ArrayList<T> list, int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
