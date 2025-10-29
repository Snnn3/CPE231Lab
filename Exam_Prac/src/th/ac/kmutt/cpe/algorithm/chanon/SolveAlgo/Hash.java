package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

import java.util.ArrayList;

public class Hash {
    public ArrayList<String> table = new ArrayList<>();
    public int size;

    public Hash (int Z){
        this.size = Z;
        for (int i = 0; i < Z; i++) {
            this.table.add("");
        }
    }
    
    private int order(String s){
        int order = 0;
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i));
            //System.out.println(s.charAt(i) - 64);
            order += (s.charAt(i) - 64);
            
        }
        System.out.print(order + " ");
        return  order;
    }

    public void addHash(String str){
        int index = order(str)%size;
        if (index == size) {
            index = 0;
        }
        // System.out.print(str + " ");
        // System.out.println(index);
        int down = index;
        //System.out.println(index);
        //ArrayList<String> list = new ArrayList<>();
        while (true) {
            if (table.get(index).isBlank()) {
                table.set(index, str);
                //System.out.println(index);
                //System.out.println(table);
                break;
            }else{
                index++;
            }
            if (index >= size) {
                index = 0;
            }else if (index == down) {
                break;
            }
        }
    }
    
}