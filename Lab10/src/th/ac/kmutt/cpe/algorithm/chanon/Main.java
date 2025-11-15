package th.ac.kmutt.cpe.algorithm.chanon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] com = new int[n][n];
        int[][] stu = new int[n][n];       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stu[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                com[i][j] = sc.nextInt();
            }
        }
        
        ArrayList<Integer> freeS = new ArrayList<>();
        int[] selected = new int[n];
        Arrays.fill(selected, -1);
        for (int i = 0; i < n; i++) {
            freeS.add(i); 
        }

        while (!freeS.isEmpty()) {
            int s = freeS.removeFirst();
            int c = -1;
            for (int i = 0; i < n; i++) {
                if (stu[s][i] != 99) {
                    c = stu[s][i];
                    stu[s][i] = 99;
                    break;
                }
            }
            if (selected[c] == -1) {
                selected[c] = s;
            }else{
                int oldS = selected[c];
               for (int i = 0; i < n; i++) {
                    if (com[c][i] == s) {
                        selected[c] = s;
                        freeS.add(oldS);
                        break;
                    } else if (com[c][i] == oldS) {
                        freeS.add(s);
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < selected.length; i++) {
            System.out.println(i + " " + selected[i]);
        }

        sc.close();
    }
}
