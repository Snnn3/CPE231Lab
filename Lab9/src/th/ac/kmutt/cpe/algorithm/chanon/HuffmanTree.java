package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
    public HuffmanNode root;
    public Map<Character,String> Map;

    public HuffmanTree(HuffmanNode root){
        this.root = root;
        this.Map = new HashMap<>();
    }

    public void enMap(String curString, HuffmanNode curNode){
        if (curNode.leftChild == null && curNode.rightChild == null) {
            Map.put(curNode.alphabet, curString);
        }
        enMap(curString + '0', curNode.leftChild);
        enMap(curString + '1', curNode.rightChild);
    }

    
}
