package th.ac.kmutt.cpe.algorithm.chanon.Sorting;

import java.util.ArrayList;


public class SortContext<T extends Comparable<T>> {
    private SortStrategy<T> strategy;
    
    public SortContext(SortStrategy<T> strategy){
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy){
        this.strategy = strategy;
    }

    public ArrayList<T> executeSearch(ArrayList<T> list){
        return strategy.sort(list);
    }

    
}
