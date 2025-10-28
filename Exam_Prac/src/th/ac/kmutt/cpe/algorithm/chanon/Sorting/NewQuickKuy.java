package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;

public class NewQuickKuy<T extends Comparable<T>> implements SortStrategy<T> {
    public void sort(ArrayList<T> list){
        sorthelp(list, 0 , list.size() - 1);
        
    }
    
    private void sorthelp(ArrayList<T> list ,int l, int r){
        if (l<r) {
            int s = Hoare(list, l, r);
            sorthelp(list, l, s-1);
            sorthelp(list, s + 1, r);
        }
        
    }

    private int Hoare(ArrayList<T> list, int l, int r){
        T p = list.get(l);
        int i = l;
        int j = r + 1;
        while (i<j){
            do {
                i++;
            } while (list.get(i).compareTo(p) < 0 );

            do {
                j--;
            } while (list.get(j).compareTo(p) > 0 );
          
            swap(list, i, j);
            
        }
        swap(list, i, j);
        swap(list, l, j);
        return j;
    }

    private void swap(ArrayList<T> list, int i, int j){
        if (i == j) {
            return;
        }
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
