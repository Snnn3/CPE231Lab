package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;

public class Sorter<T extends Comparable<T>> {

    public void selectionSort(ArrayList<T> list){
                for (int i = 0; i < list.size() ; i++) {
            int mnIdx = i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).compareTo(list.get(mnIdx)) < 0){
                    mnIdx = j;
                }
            }
            swap(list,i,mnIdx);
        }
    }

    public void swap(ArrayList<T> list,int i,int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    } 
}
