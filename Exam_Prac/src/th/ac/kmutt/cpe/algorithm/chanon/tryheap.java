package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class tryheap {
    public static void insert(ArrayList<Long> he, long value){
        he.add(value);
        int index = he.size() - 1;

        while (index > 0 && he.get((index - 1) / 2) > he.get(index)){ 
            swap(he, index, (index - 1) / 2); 
            index = (index - 1) / 2; 
        }
    }

    public static Long delet(ArrayList<Long> he){
        if (he.isEmpty()) {
            return (long) (-1);
        }
        Long first = he.getFirst();
        Long last = he.remove(he.size() - 1);
        if (!he.isEmpty()) {
            he.set(0, last);
            down(he, 0);
        }

        return first;
    }

    public static void down(ArrayList<Long> he, int i){
        int n = he.size();
        
        while (true) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int small = i;
            if (left < n && he.get(left) < he.get(small)) {
                small = left;
            }

            if (right < n && he.get(right) < he.get(small)) {
                small = right;
            }

            if (i == small) {
                break;
            }

            swap(he, i, small);
            i = small;
        }
    }
    
    public static void swap(ArrayList<Long> he, int i, int j){
        Long temp = he.get(i);
        he.set(i, he.get(j));
        he.set(j, temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        long n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            insert(list, sc.nextInt());
        }

        while (list.size() > 1) {
            long first = delet(list);
            long second = delet(list);
            long cost = first + second;
            insert(list, cost);
            sum += cost;
        }
        

        System.out.println(sum);

        sc.close();
    }
}
