package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;


public class Lexi {
    public char[] swap(char[] arr,int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    public char[] reverse(char[] arr,int start){
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    public ArrayList<String> nextPermutation(String str){
        ArrayList<String> perList = new ArrayList<>();
        perList.add(str);
        char[] newPer = str.toCharArray();
        while (true) {
            int Max_I = -1;
            int Max_J = 0;
            for (int i = 0; i < str.length() -1; i++) {
                if (newPer[i] < newPer[i + 1]) {
                    Max_I = i;
                }
            }
            if (Max_I == -1) {
                break;
            }
            for (int j = 0; j < str.length(); j++) {
                if (newPer[Max_I] < newPer[j]) {
                    Max_J = j;
                }
            }
            newPer = swap(newPer, Max_I, Max_J);
            newPer = reverse(newPer, Max_I + 1);
            perList.add(new String(newPer));    
        }
        return perList;
    }
}
