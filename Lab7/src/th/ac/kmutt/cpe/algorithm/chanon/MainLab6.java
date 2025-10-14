package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.CSVread.CSVread;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SelectionSortMaxtoMin;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.chanon.free.Pack;

public class MainLab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize1.csv";
        String two = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize2.csv";
        String three = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize3.csv";
        CSVread reader = new CSVread();
        ArrayList<Pack> box = new ArrayList<>();
        
        System.out.println("Select Box");
        System.out.println("1. boxSize1.csv");
        System.out.println("2. boxSize2.csv");
        System.out.println("3. boxSize3.csv");
        System.out.print("Enter : ");
        int choice = sc.nextInt();
        ArrayList<ArrayList<String>> allbox = null;
        if (choice == 1) {
            allbox = reader.read(one);
        }else if (choice == 2) {
            allbox = reader.read(two);
        }else if (choice == 3) {
            allbox = reader.read(three);
        }
        //System.err.println(allbox);
        for (int i = 0; i < allbox.size(); i++) {
            box.add(new Pack(Double.parseDouble(allbox.get(i).get(0)), Double.parseDouble(allbox.get(i).get(1))));
        }
        SortContext<Pack> solver = new SortContext<Pack>(new SelectionSortMaxtoMin<>());
        solver.executeSearch(box);
        // for (Pack List : box) {
        //     System.out.print(List.wide);
        //     System.out.println(" " + List.height);
        // }
        ArrayList<Pack> usedbox = new ArrayList<>();
        BoxSolve(box,usedbox,0.0,20.0,0.0,20.0);
        //BoxSolve1(box, usedbox, MaxPack, 0);
        //System.out.println(usedbox.get(0).height);
        Double area = 0.0;
        System.out.println("Left : " + (box.size() - usedbox.size()));
        for (int i = 0; i < box.size(); i++) {
            if (!usedbox.contains(box.get(i))) {
                System.out.print(box.get(i).wide);
                System.out.println(" " + box.get(i).height);
                
            }else{
                area += box.get(i).area;
            }
        }
        System.out.printf("Area Left: %.2f",20*20 - area);

        sc.close();
    }
    
    public static void BoxSolve(ArrayList<Pack> Box,ArrayList<Pack> used, Double xLeft, Double xRight, Double yTop, Double yBot){
        for (int i = 0; i < Box.size(); i++) {
            if (Box.get(i).wide < xRight - xLeft && Box.get(i).height < yBot - yTop && !used.contains(Box.get(i))) {
                used.add(Box.get(i));
                BoxSolve(Box, used, Box.get(i).wide + xLeft, xRight, yTop, yTop + Box.get(i).height);
                BoxSolve(Box, used, xLeft, xRight, yTop + Box.get(i).height, yBot);
                break;               
            }
        }
    }

    public static void BoxSolve1(ArrayList<Pack> Box, ArrayList<Pack> used, Pack maxbox,int i){
        if (i == Box.size()) {
            return;
        }
        if (Box.get(i).wide < maxbox.wide && Box.get(i).height < maxbox.height){
            used.add(Box.get(i));
            Pack Rbox = new Pack(maxbox.wide - Box.get(i).wide, maxbox.height);
            BoxSolve1(Box, used, Rbox, i + 1);
            Pack Bbox = new Pack(maxbox.wide, maxbox.height - Box.get(i).height);
            BoxSolve1(Box, used, Bbox, i + 1); 
        }
    }
    
}