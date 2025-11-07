package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

public class MainHuff {
    
    public static ArrayList<HuffmanNode> frequencyCount(String str){
        ArrayList<HuffmanNode> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            boolean contain = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).alphabet == str.charAt(i)) {
                    list.get(j).frequency++;
                    contain = true;
                }
            }
            if(!contain){
                list.add(new HuffmanNode(str.charAt(i), 0));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.next();
        ArrayList<HuffmanNode> list = frequencyCount(str);
        HuffmanTree tree = new HuffmanTree(null);
        tree.root = tree.createTree(list) ;
        tree.enMap();
        System.out.println("Binary code for each character");
        tree.printMap();
        
        //output 
        System.out.println("Enter the String that you want to encode");
        String willencode = sc.next();
        String encode = tree.encode(willencode);
        if (encode.isBlank()) {
            System.out.println(willencode + " can't encode");
        }else{
            System.out.println(willencode + " encode to " + encode);
        }
        System.out.println("Enter the String that you want to decode");
        String willdecode = sc.next();
        String decode = tree.decode(willdecode);
        if (decode.isBlank()) {
            System.out.println(willdecode + " can't decode");
        }else{
            System.out.println(willdecode + " decode to " + decode);
        }
        sc.close();
    }
}
