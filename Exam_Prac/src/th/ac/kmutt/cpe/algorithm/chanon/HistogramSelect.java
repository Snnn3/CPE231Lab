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
            //withbin = Math.round((withbin*1000.0))/1000.0;
            for (int i = 0; i < b; i++) {
                binlist.add(new bin(withbin));
                withbin += with;
                //withbin = Math.round((withbin*1000.0))/1000.0;
            }
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < binlist.size(); j++) {
                    boolean fill = false;
                    if (temp.get(i)  <= binlist.get(j).range) {
                        binlist.get(j).value.add(temp.get(i));
                        binlist.get(j).count++;
                        fill = true;
                        break;
                    }

                    if (!fill) {
                        binlist.getLast().value.add(temp.get(i));
                        binlist.getLast().count++;
                    }
                }
            }
            int size = 0;
            int thisbin = 0;
            for (int i = 0; i < binlist.size(); i++) {
                if (size + binlist.get(i).count >= k) {
                    thisbin = i;
                    break;
                }else{
                    size += binlist.get(i).count;
                }
            }
            
            if (binlist.get(thisbin).count == 1) {
                return binlist.get(thisbin).value.get(0);
            }else{
                ArrayList<Double> next = new ArrayList<>();
                double low = min + thisbin * with;
                double high = min + (thisbin + 1) * with;
                for (double v : temp) {
                if (v >= low && v <= high) {
                    next.add(v);
                }
            }

                k =  k - size;
                temp = next;
            }
        }
    }
}
 