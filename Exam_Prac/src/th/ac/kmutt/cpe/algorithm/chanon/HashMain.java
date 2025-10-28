package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.Scanner;

public class HashMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Z = sc.nextInt();
        int n = sc.nextInt();
        Hash hashtable = new Hash(Z);
        
        for (int i = 0; i < n; i++) {
            //table.addHash(sc.next());
            hashtable.addHash(sc.next());
        }
        for (int i = 0; i < Z; i++) {
            if (hashtable.table.get(i).isBlank()) {
                System.out.print("NULL ");
            }else{
                System.out.print(hashtable.table.get(i) + " ");
            }
        }
        
        sc.close();
    }
}
