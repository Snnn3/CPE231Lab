package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

public class QuickSelcet {
    public static Integer Lumoto(int[] arr, int st, int ed){
        int pivot = ed;
        int i = st;
        for (int j = st; j < ed; j++) {
            if (arr[j] <= arr[pivot]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static Integer QuickSelect(int[] arr, int k, int st, int ed){
        int pivot = Lumoto(arr, st, ed);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" P: "+ pivot);
        if (pivot == k) {
            return pivot;
        }else if (pivot > k) {
            return QuickSelect(arr, k, st, pivot - 1);
        }else if (pivot < k) {
            return QuickSelect(arr, k, pivot + 1, ed);
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } 
        int k = sc.nextInt();
        int ans = QuickSelect(arr, k-1, 0, n-1);
        System.out.println(arr[ans]);
        
        sc.close();
    }
}
