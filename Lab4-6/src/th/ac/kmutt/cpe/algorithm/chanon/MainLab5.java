package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.CSVread.CSVread;
import th.ac.kmutt.cpe.algorithm.chanon.Searching.EMSSearch;
import th.ac.kmutt.cpe.algorithm.chanon.Searching.SearchContext;

public class MainLab5 {
    public static void main(String[] args) {
        String pathDomestic = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\EMS_Domestic.csv";
        String pathWorld = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\EMS_World.csv";
        SearchContext<Integer,Integer> solver = new SearchContext<Integer,Integer>(new EMSSearch<>());
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Domestic");
        System.out.println("2: World");
        CSVread reader = new CSVread();
        Character op = sc.next().charAt(0);
        System.out.print("Weight : ");
        Double weightf = sc.nextDouble();
        Double weight = Math.ceil(weightf);
        if (op == '1'){
            ArrayList<ArrayList<String>> Dome = reader.read(pathDomestic);
            ArrayList<Integer> DomeCol = new ArrayList<>();
            for (int i = 1; i < Dome.size(); i++) { 
                DomeCol.add(Integer.parseInt(Dome.get(i).get(0)));
            }
            System.out.println(weight.intValue());
            int ans = solver.executeSearch(DomeCol, weight.intValue());
            System.out.println(Dome.get(ans).get(2));
        }else if (op == '2') {
            ArrayList<ArrayList<String>> World = reader.read(pathWorld);
            ArrayList<Integer> WorCol = new ArrayList<>();
            for (int i = 1; i < World.size(); i++) { 
                WorCol.add(Integer.parseInt(World.get(i).get(0)));
            }
            int ans = solver.executeSearch(WorCol, weight.intValue());
            System.out.print("Zone : ");
            int Zone = sc.nextInt();
            if (Zone == 9 && weight > 20000) {
                System.out.println("Can't");
            }else{
                System.out.println(World.get(ans).get(Zone + 1));
            }
        }
        // if (op == '1'){
        //     for (int i = 1; i <= Dome.size(); i++) {
        //         if (weight <= Integer.parseInt(Dome.get(i).get(1)) && weight >= Integer.parseInt(Dome.get(i).get(0))) {
        //             System.out.println("Cost : "+Dome.get(i).get(2));
        //             break;
        //         }
        //     }
        // }else if (op == '2') {
        //     System.out.print("Zone : ");
        //     int Zone = sc.nextInt();
        //     for (int i = 1; i <= World.size()-1; i++) {
        //         if (weight <= Integer.parseInt(World.get(i).get(1)) && weight >= Integer.parseInt(World.get(i).get(0))) {
        //             if (Zone == 9 && weight > 20000) {
        //                 System.out.println("Can't");
        //             }else{
        //                 System.out.println("Cost : " + World.get(i).get(Zone + 1));
        //             }
        //             break;
        //         }
        
        //     }
        //     if (Zone == 9 && weight > 30000) {
        //         System.out.println("Can't");
        //     }else if(weight > 30000){
        //         System.out.println("Cost : "+ World.getLast().get(Zone + 1));
        //     }
        // }
        sc.close();
    }
}
