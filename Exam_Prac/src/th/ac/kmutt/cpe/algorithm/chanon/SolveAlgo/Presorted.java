package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

import java.util.ArrayList;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class Presorted<T extends Comparable <T>> {
    public void Presort(ArrayList<T> list){
        SortContext<T> sort = new SortContext<T>(new QuickSort<T>());
        sort.executeSort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                i--;
            }
        }

        return;
    }

    public T PersortMode(ArrayList<T> list){
        SortContext<T> sort = new SortContext<>(new QuickSort<T>());
        sort.executeSort(list);
        int i = 0;
        int modefrequency = 0;
        T modevalue = null;
        while (i < list.size() ) {
            int runlength = 1;
            T runvalue = list.get(i);
            while (i + runlength < list.size() && list.get(i+runlength).compareTo(runvalue) == 0) {
                runlength++;
            }
            if (runlength > modefrequency) {
                modefrequency = runlength;
                modevalue = runvalue;
            }
            if (runlength == modefrequency && runvalue.compareTo(modevalue) > 0) {
                modevalue = null;
                //&& runvalue.compareTo(modevalue) > 0
            }
            i += runlength;
        }
        return modevalue;
    }

}
