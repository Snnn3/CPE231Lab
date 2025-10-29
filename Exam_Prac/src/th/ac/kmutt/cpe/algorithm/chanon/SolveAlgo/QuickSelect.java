package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

public class QuickSelect {
    public Integer Lumoto(int[] arr, int st, int ed){
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

    public Integer Select(int[] arr, int k, int st, int ed){
        int pivot = Lumoto(arr, st, ed);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" P: "+ pivot);
        if (pivot == k) {
            return pivot;
        }else if (pivot > k) {
            return Select(arr, k, st, pivot - 1);
        }else if (pivot < k) {
            return Select(arr, k, pivot + 1, ed);
        }
        return -1;
    }

}
