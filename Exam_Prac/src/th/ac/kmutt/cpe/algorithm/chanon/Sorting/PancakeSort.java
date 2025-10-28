package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class PancakeSort<T extends Comparable <T>> implements SortStrategy<T> {
    public void sort(ArrayList<T> list){
        int pos = list.size()-1;
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            //System.out.println(pos);
            for (int j = 0; j <= pos; j++) {
                if (list.get(j).compareTo(list.get(max)) > 0) {
                    max = j;
                }
            }
            if (max != 0) {
                reverse(list, max);
            }else if (list.get(0).compareTo(list.get(1)) < 0) {
                break;
            }
            
            Collections.swap(list, 0, pos);
            pos--;
        }
        
    }

    private void reverse(ArrayList<T> list,int max){
        int end = max;
        int start = 0;
        while (start < end) {
            Collections.swap(list, start, end);
            start++;
            end--;
        }
    }
}
