package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

import java.util.ArrayList;

import th.ac.kmutt.cpe.algorithm.chanon.Sorting.NewQuickKuy;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;

public class PresortedUnique<T extends Comparable <T>> {
    public void Presort(ArrayList<T> list){
        SortContext<T> sort = new SortContext<T>(new NewQuickKuy<>());
        sort.executeSort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                i--;
            }
        }

        return;
    }

}
