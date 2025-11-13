package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class tryheap {
    public static void insert(ArrayList<Integer> he, int value){
        he.add(value);
        int index = he.size() - 1;

        while (index > 0 && he.get((index / 2) + 1) > he.get(index)){
            swap(he, index, (index / 2) + 1 );
            index = (index / 2) - 1;
        }
    }

    public static int delet(ArrayList<Integer> he){
        if (he.isEmpty()) {
            return -1;
        }
        int first = he.getFirst();
        int last = he.remove(he.size() - 1);
        if (!he.isEmpty()) {
            he.set(0, last);
            down(he, 0);
        }

        return first;
    }

    public static void down(ArrayList<Integer> he, int i){
        int n = he.size() - 1;
        int small = i;

        while (true) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
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
    
    public static void swap(ArrayList<Integer> he, int i, int j){
        int temp = he.get(i);
        he.set(i, he.get(j));
        he.set(j, temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(list, sc.nextInt());
        }

        while (list.size() != 1) {
            int first = delet(list);
            int second = delet(list);
            insert(list, first + second);
        }
        

        System.out.println(list.getFirst());

        sc.close();
    }
}
