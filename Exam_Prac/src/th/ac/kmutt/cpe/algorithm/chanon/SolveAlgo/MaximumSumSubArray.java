package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

public class MaximumSumSubArray {
    public int CrossingSum(int[] arr,int l, int mid, int r){
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
        return MaxLeft+MaxRight;
    }

    public int find3Max(int F,int S,int T){
        if (F > S) {
            if (F > T) {
                return F;
            }else{
                return T;
            }
        }else{
            if (S > T) {
                return S;
            }else{
                return T;
            }
        }
    }

    public int MaxSum(int[] arr, int l, int r){
        if (l == r) {
            return arr[r];
        }
        int mid = (l+r)/2;
        //System.out.println(mid);
        int LSS = MaxSum(arr, l, mid);
        int RSS = MaxSum(arr, mid + 1, r);
        //System.out.println(MaxLeft + " "+ MaxRight);
        int CSS = CrossingSum(arr, l, mid, r);
        return find3Max(LSS, RSS, CSS);

    }
}
