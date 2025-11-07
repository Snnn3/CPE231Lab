package th.ac.kmutt.cpe.algorithm.chanon.SolveAlgo;

import java.util.ArrayList;

public class ClosetPair2D {
    // public Double ClosetPair (ArrayList<Pair> P){
    //     double dminsq = 0.0;
    //     if (P.size() <= 3) {
    //         return P.get(0).getX();
    //     }else{
    //         ArrayList<Pair> PL = new ArrayList<>();
    //         ArrayList<Pair> PR = new ArrayList<>();
    //         PL.addAll(P.subList(0, P.size()/2));
    //         PR.addAll(P.subList((P.size()/2), P.size()));
    //         Double disL = ClosetPair(PL);
    //         Double disR = ClosetPair(PR);

    //         Double d = Math.min(disL, disR);
    //         Double m = P.get((P.size()/2)-1).getX();
    //         ArrayList<Pair> S = new ArrayList<>();
    //         for (int i = 0; i < P.size(); i++) {
    //             if (P.get(i).getX() - m < d) {
    //                 S.add(P.get(i));
    //             }
    //         }
    //         dminsq = d*d;
            
    //         for (int i = 0; i < S.size() - 1; i++) {
    //             int k = i + 1;
                
    //             while (k <= S.size() && (S.get(k).getY() - S.get(i).getY()) * (S.get(k).getY() - S.get(i).getY()) < dminsq) {
    //                 dminsq = Math.min(dminsq, S.get(i).distance(S.get(i), S.get(k)));
    //                 k++;
    //             }
    //         }
    //     }

    //     return Math.sqrt(dminsq);
    // }

    public double ClosePair(ArrayList<Pair> P,int l, int r){
        if (r == l) {
            return Double.MAX_VALUE;
        }else if (r-1 == l) {
            return P.get(r).distance(P.get(l));
        }else{
            int mid = l+r/2;
            double midline = (P.get(l).getX()+ P.get(r).getX())/2;
            for (int i = l; i <= r ; i++) {
                if (P.get(i).getX() > midline) {
                    mid = i - 1;
                    break;
                }
            }
            double Closeleft = ClosePair(P, l, mid);
            double Closeright = ClosePair(P, mid + 1, r);
            double Closest = Math.min(Closeleft, Closeright);
            ArrayList<Pair> Sleft = new ArrayList<>();
            ArrayList<Pair> Sright = new ArrayList<>();
            for (int i = mid; i >= l; i--) {
                if (midline - P.get(i).getX() <= Closest) {
                    Sleft.add(P.get(i));
                }else{
                    break;
                }
            }
            for (int i = mid + 1; i <= r; i++) {
                if (P.get(i).getX() - midline <= Closest) {
                    Sright.add(P.get(i));
                }else{
                    break;
                }
            }
            for (Pair L : Sleft) {
                for (Pair R : Sright) {
                    Closest = Math.min(Closest, L.distance(R));
                }
            }
            return Closest;
        }


    }
}
