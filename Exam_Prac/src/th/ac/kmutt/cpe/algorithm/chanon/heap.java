package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class heap {
    public static void insertheap(ArrayList<Integer> list, int value){
        list.add(value);
        int idx = list.size() - 1;

        while (idx > 0 && list.get((idx - 1) / 2) > list.get(idx)) {
            swap(list, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    public static int remove(ArrayList<Integer> list){
        if (list.isEmpty()) {
            return -1;
        }
        
        int root = list.getFirst();
        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            heapify(list, 0);
        }
        return root;
    }

    public static void heapify(ArrayList<Integer> list, int i){
        int n = list.size();
        int small = i;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && list.get(left) < list.get(small)) {
                small = left;
            }
            if (right < n && list.get(right) < list.get(small)) {
                small = right;
            }

            if (small == i) {
                break;
            }

            swap(list, i, small);
            i = small;
        }
    }

    public static void swap(ArrayList<Integer> list, int fir, int sec){
        int temp = list.get(sec);
        list.set(sec, list.get(fir));
        list.set(fir, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insertheap(heap, sc.nextInt());        
        }
        while (heap.size() > 1) {
            int first = remove(heap);
            int second = remove(heap);
            insertheap(heap, first + second);

        }
        System.out.println(heap.getFirst());
        sc.close();
    }
}
