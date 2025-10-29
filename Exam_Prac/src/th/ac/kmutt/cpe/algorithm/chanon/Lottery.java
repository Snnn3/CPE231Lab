package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

public class Lottery {

    public static int[] ShiftTable(char[] P,int size){
        int[] table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = P.length;
        }
        for (int j = 0; j < P.length - 1; j++) {
            table[P[j] - 65] = P.length - 1 - j;
        }
        return table;
    }

    public static int[] Horspool(char[] P, char[] T){
        int Table[] = ShiftTable(P, 26);
        // for (int i = 0; i < Table.length; i++) {
        //     System.out.print(Table[i]+ " ");
        // }
        int m = P.length;
        int n = T.length;
        int i = P.length - 1;
        int[] ans = new int[2];
        int time = 0;
        while (i <= n - 1) {
            int k = 0;
            while (k <= m - 1 && P[m - 1 - k] == T[i - k]) {
                k++;
            }
            if (k == m) {
                ans[0] = time;
                ans[1] = i - m + 1;
                
                System.out.println(k + " " + i + " " + m + " "+ time);
                return ans;
            }else{
                System.out.println(k + " " + i + " " + m + " " + time);
                time++;
                i = i + Table[T[i]-65];
            }
            ans[0] = time;
        }
        ans[1] = -1;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String mylot = sc.next();
        String corlot = sc.next();
        char[] arrmy = new char[m];
        char[] arrcor = new char[n];
        //int[] ans = new int[2];
        for (int i = 0; i < m; i++) {
            arrmy[i] = mylot.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            arrcor[i] = corlot.charAt(i);
        }
        int ans[] = Horspool(arrcor, arrmy);
        if (ans[1] == -1) {
            System.out.println("No " + ans[0] + " " + ans[1]);
        }else{
            System.out.println("Yes " + ans[0] + " " + ans[1]);
        }
        sc.close();
    }
}
