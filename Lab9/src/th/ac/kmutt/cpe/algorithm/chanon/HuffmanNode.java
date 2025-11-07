package th.ac.kmutt.cpe.algorithm.chanon;


public class HuffmanNode implements Comparable<HuffmanNode> {
    public Integer frequency;
    public char alphabet;
    public HuffmanNode leftChild;
    public HuffmanNode rightChild;
    
    public HuffmanNode(int frequency, char alphabet){
        this.alphabet = alphabet;
        this.frequency = frequency;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public int compareTo(HuffmanNode other){
        return this.frequency.compareTo(other.frequency);
    }
}
