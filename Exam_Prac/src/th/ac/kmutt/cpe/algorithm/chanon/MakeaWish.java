package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

public class MakeaWish {
    public static int MaxSum(int[] arr, int l, int r){
        if (l == r) {
            return arr[r];
        }
        int mid = (l+r)/2;
        //System.out.println(mid);
        int LSS = MaxSum(arr, l, mid);
        int RSS = MaxSum(arr, mid + 1, r);
        int MaxLeft = Integer.MIN_VALUE;
        int MaxRight = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = mid; i >= l ; i--) {
            temp += arr[i];
            if (MaxLeft < temp) {
                MaxLeft = temp;
            }
        }
        temp = 0;
        for (int i = mid + 1; i <= r; i++) {
            temp += arr[i];
            if (MaxRight < temp) {
                MaxRight = temp;
            }
        }
        //System.out.println(MaxLeft + " "+ MaxRight);
        int CSS = MaxLeft+MaxRight;
        if (CSS > LSS) {
            if (CSS > RSS) {
                return CSS;
            }else{
                return RSS;
            }
        }else{
            if (LSS > RSS) {
                return LSS;
            }else{
                return RSS;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(MaxSum(arr, 0, n-1));
        sc.close();
    }
}
