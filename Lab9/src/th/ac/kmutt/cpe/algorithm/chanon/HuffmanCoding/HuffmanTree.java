package th.ac.kmutt.cpe.algorithm.chanon.HuffmanCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class HuffmanTree {
    public HuffmanNode root;
    private Map<Character,String> enMap;

    public HuffmanTree(HuffmanNode root){
        this.root = root;
        this.enMap = new HashMap<>();
    }


    public HuffmanNode createTree(ArrayList<HuffmanNode> list){
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
         for (HuffmanNode node : list) {
            pq.add(node);
        }
        while (true) {    
            HuffmanNode fir = pq.poll();
            HuffmanNode sec = pq.poll();
            int sumfre = fir.frequency + sec.frequency;
            HuffmanNode temp = new HuffmanNode(' ', sumfre);
            temp.leftChild = fir;
            temp.rightChild = sec;
            if (pq.isEmpty()) {
                this.root = temp;
                break;
            }
            pq.add(temp);
        }

        return this.root;
    }

    public void printMap(){
        for (Character ch : this.enMap.keySet()) {
            System.out.println(ch + " " + this.enMap.get(ch));
        }
    }

    public void enMap(){
        enMap("", this.root);
    }

    private void enMap(String curString, HuffmanNode curNode){
        if (curNode == null)return;
        if (curNode.leftChild == null && curNode.rightChild == null) {
            enMap.put(curNode.alphabet, curString);
        }
        enMap(curString + '0', curNode.leftChild);
        enMap(curString + '1', curNode.rightChild);
    }


    public String encode(String str){
        String encoded = new String();
        for (int i = 0; i < str.length(); i++) {
            if (this.enMap.containsKey(str.charAt(i))) {
                encoded += this.enMap.get(str.charAt(i));
            }else{
                return "";
            }
        }
        return encoded;
    }

    public String decode(String str){
        String decoded = new String();
        Map<String,Character> decodeMap = decodeMap();
        String temp = new String();
        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            if (decodeMap.containsKey(temp)) {
                decoded += decodeMap.get(temp);
                temp = "";
            }
        }

        if (!temp.isEmpty()) {
            decoded = "";
            return decoded;
        }
        return decoded;
    }

    private Map<String,Character> decodeMap(){
        Map<String,Character> decodeMap = new HashMap<>();
        for (Entry<Character, String> de : this.enMap.entrySet()) {
            decodeMap.put(de.getValue(), de.getKey());
        }
        return decodeMap;
    }
    
}
