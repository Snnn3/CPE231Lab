package th.ac.kmutt.cpe.algorithm.chanon.Searching;

import java.util.ArrayList;

public class SearchContext<T extends Comparable<T>,R> {
    private SearchStrategy<T,R> strategy;
    
    public SearchContext(SearchStrategy<T,R> strategy){
        this.strategy = strategy;
    }

    public void setStrategy(SearchStrategy<T,R> strategy){
        this.strategy = strategy;
    }

    public R executeSearch(ArrayList<T> list, T target){
        return strategy.search(list, target);
    }

    
}
