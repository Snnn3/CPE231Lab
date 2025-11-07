package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.PriorityQueue;

public class MainHuff {
    public static void main(String[] args) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        pq.add(new HuffmanNode(5,'a'));
        pq.add(new HuffmanNode(9, 'b'));
        pq.add(new HuffmanNode(16, 'e'));
        pq.add(new HuffmanNode(13, 'd'));
        pq.add(new HuffmanNode(12, 'c'));
        pq.add(new HuffmanNode(45, 'f'));
        HuffmanTree tree = new HuffmanTree(null);
        while (true) {    
            HuffmanNode fir = pq.poll();
            HuffmanNode sec = pq.poll();
            int sumfre = fir.frequency + sec.frequency;
            HuffmanNode temp = new HuffmanNode(sumfre, ' ');
            temp.leftChild = fir;
            temp.rightChild = sec;
            if (pq.isEmpty()) {
                tree.root = temp;
                break;
            }
            pq.add(temp);
        }
        System.out.println(tree.root.frequency);
        System.out.println(tree.traverse(tree));
    }
}
