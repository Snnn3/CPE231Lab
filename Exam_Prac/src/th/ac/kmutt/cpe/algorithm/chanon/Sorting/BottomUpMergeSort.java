package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;

public class BottomUpMergeSort<T extends Comparable <T>> implements SortStrategy<T> {
    public void sort(ArrayList<T> list){
        if (list.size() < 2) {
            return;
        }
        int i = 1;
        while (i < list.size()) {
            int j = 0;
            while (j < list.size() - i) {
                if (list.size() < j + (2*i)) {
                    ArrayList<T> SubList1 = new ArrayList<>();
                    ArrayList<T> SubList2 = new ArrayList<>();
                    SubList1.addAll(list.subList(j,j+i));
                    SubList2.addAll(list.subList(j+i, list.size()));
                    merge(list, SubList1,SubList2,j);
                }else{
                    ArrayList<T> SubList1 = new ArrayList<>();
                    ArrayList<T> SubList2 = new ArrayList<>();
                    SubList1.addAll(list.subList(j,j+i-1));
                    SubList2.addAll(list.subList(j+i, j+2*i-1));
                    merge(list, SubList1,SubList2,j);
                    }
                    j = j + 2*i;   
                }
                i = i*2;
            }
        //     if (list.size() > 1) {
        //         ArrayList<T> SubList1 = new ArrayList<>();
        //         ArrayList<T> SubList2 = new ArrayList<>();
        //         SubList1.addAll(list.subList(0,list.size()/2));
        //         SubList2.addAll(list.subList(list.size()/2, list.size()));
        //         sort(SubList1);
        //         sort(SubList2);
        //         merge(list, SubList1, SubList2, 0);
        // }
        return;
    }

    private void merge(ArrayList<T> list,ArrayList<T> sublist1,ArrayList<T> sublist2,int st){
        while (!sublist1.isEmpty() && !sublist2.isEmpty()) {
            if (sublist1.getFirst().compareTo(sublist2.getFirst()) <= 0) {
                list.set(st, sublist1.getFirst());
                sublist1.removeFirst();
                st++;
            }else if (sublist1.getFirst().compareTo(sublist2.getFirst()) > 0) {
                list.set(st, sublist2.getFirst());
                sublist2.removeFirst();
                st++;
            }
        }
        if (sublist1.isEmpty()) {
            for (T t : sublist2) {
                list.set(st, t);
                st++;
            }
        }
        if (sublist2.isEmpty()) {
            for (T t : sublist1) {
                list.set(st, t);
                st++;
            }
        }
        return;
    }



}
