package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Collections;

public class HistogramSelect{
    public double Select(ArrayList<Double> list,int k,int b){
        ArrayList<Double> temp = new ArrayList<>();
        temp.addAll(list);
        while (true) {
            double max = Collections.max(temp);
            double min = Collections.min(temp);
            double with = (max-min)/b;
            ArrayList<bin> binlist = new ArrayList<>();
            double withbin = (min + with); 
            for (int i = 0; i < b; i++) {
                binlist.add(new bin(withbin));
                withbin += with;
            }
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < binlist.size(); j++) {
                    if (temp.get(i)  <= binlist.get(j).range) {
                        binlist.get(j).value.add(temp.get(i));
                        binlist.get(j).count++;
                        break;
                    }
                }
            }
            int size = 0;
            int thisbin = 0;
            for (int i = 0; i < binlist.size(); i++) {
                if (size + binlist.get(i).count >= k) {
                    thisbin = i;
                    if (i == 0) {
                        size = 0;
                    }
                    break;
                }else{
                    size += binlist.get(i).count;
                }
            }
            
            if (k == 1 && binlist.get(thisbin).count == 1) {
                return binlist.get(thisbin).value.getFirst();
            }else{
                for (int j = 0; j < temp.size(); j++) {
                    if (!binlist.get(thisbin).value.contains(temp.get(j))) {
                        System.out.println(temp.get(j));
                        temp.remove(j);
                        j--;
                    }
                }
                k =  k - size;
                binlist.removeAll(binlist);
            }
        }
    }
}
 