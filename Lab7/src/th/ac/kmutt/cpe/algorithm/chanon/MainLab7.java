package th.ac.kmutt.cpe.algorithm.chanon;

import java.util.ArrayList;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.chanon.CSVread.CSVread;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SelectionSortMaxtoMin;
import th.ac.kmutt.cpe.algorithm.chanon.Sorting.SortContext;
import th.ac.kmutt.cpe.algorithm.chanon.free.Pack;

 /* อธิบาย Output
 * 5 บรรทัดแรก คือการให้เลือกกล่อง
 * ถัดมาคือ บอกจำนวนกล่องทั้งหมด และมีกล่องขนาดอะไรบ้าง ลำดับ : กว้าง สูง
 * จะจบการบอกขนาดที่บรรทัด -----------------
 * จากนั้นจะให้กรอกขนาดของกล่องบรรจุ กว้าง*สูง
 * บรรทัดถัดมาจะมี Output ได้ 2 แบบ คือ
 * แบบที่ 1 คือการสร้าง level ใหม่ โดย จะเริ่มจาก level ที่ 0 และกล่องขณะนั้น เป็นตัวตั้งของ level เช่น
 * Create a new level is level 0 : 0.00 10.20 and Put box 0 in
 * คือ สร้าง level ใหม่ คือ level 0 ที่เริ่มจาก 0.00 ถึง 10.20 และใส่กล่องที่ 0 ลงไป
 * แบบที่ 2 คือการใส่กล่องลงไปในแต่ละ level เช่น Put box 8 at level 1 คือการใส่กล่องที่ 8 ลงใน level ที่ 1
 * เมื่อจบขบวนการใส่กล่อง
 * จะแสดงว่าใช้ทั้งหมดกี่กล่อง และกล่องไหนบ้างพร้อมลำดับ
 * จากนั้นแสดงว่าไม่ได้ใช้ทั้งหมดกี่กล่อง และกล่องไหนบ้างที่ไม่ได้ใช้พร้อมลำดับ
 * บรรทัดสุดท้ายแสดงว่า พื้นที่ที่เหลือทั้งหมด 
 */
public class MainLab7 {

    public static void BoxSolveBF(ArrayList<Pack> Box,ArrayList<Pack> used, Double x, Double y){
        ArrayList<Pack> level = new ArrayList<>();
        level.add(new Pack(0.0, 0.0));
        for (int i = 0; i < Box.size(); i++) {
            if (!used.contains(Box.get(i))) {
                for (int j = 1; j < level.size(); j++) {
                    if (Box.get(i).height < level.get(j).height - level.get(j - 1).height && Box.get(i).wide + level.get(j).wide < x) { 
                        used.add(Box.get(i)); 
                        level.get(j).wide += Box.get(i).wide; 
                        System.out.println("Put box " + i + " at level " + (level.indexOf(level.get(j)) - 1));
                        break;
                    }
                }
                if (!used.contains(Box.get(i)) && level.getLast().height + Box.get(i).height < y && Box.get(i).wide < x) { 
                    used.add(Box.get(i)); 
                    level.add(new Pack(Box.get(i).wide, level.getLast().height + Box.get(i).height));         
                    System.out.printf("Create a new level is level %d : %.2f %.2f and Put box %d in\n",(level.size() - 2),level.get(level.indexOf(level.getLast())-1).height,level.getLast().height,i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String one = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize1.csv";
        String two = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize2.csv";
        String three = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize3.csv";
        String four = "src\\th\\ac\\kmutt\\cpe\\algorithm\\chanon\\free\\boxSize4.csv";
        CSVread reader = new CSVread();
        ArrayList<Pack> box = new ArrayList<>();
        
        System.out.println("Select Box");
        System.out.println("1. boxSize1.csv");
        System.out.println("2. boxSize2.csv");
        System.out.println("3. boxSize3.csv");
        System.out.println("4. boxSize4.csv");
        System.out.print("Enter : ");
        int choice = sc.nextInt();
        ArrayList<ArrayList<String>> allbox = null;
        if (choice == 1) {
            allbox = reader.read(one);
        }else if (choice == 2) {
            allbox = reader.read(two);
        }else if (choice == 3) {
            allbox = reader.read(three);
        }else if (choice == 4) {
            allbox = reader.read(four);
        }
        for (int i = 0; i < allbox.size(); i++) {
            box.add(new Pack(Double.parseDouble(allbox.get(i).get(0)), Double.parseDouble(allbox.get(i).get(1))));
        }
        SortContext<Pack> solver = new SortContext<Pack>(new SelectionSortMaxtoMin<>());
        solver.executeSearch(box);
        System.out.println("The total number of boxes is " + box.size());
        for (int i = 0; i < box.size(); i++) {
            System.out.print(i);
            System.out.print(" : " + box.get(i).wide);
            System.out.println(" " + box.get(i).height);
        }
        System.out.println("-----------------");
        ArrayList<Pack> usedbox = new ArrayList<>();
        System.out.println("Contrainer size(Wide * Height)");
        System.out.print("Wide : ");
        Integer y = sc.nextInt();
        System.out.print("Height : ");
        Integer x = sc.nextInt();
        BoxSolveBF(box,usedbox,x.doubleValue(),y.doubleValue());
        Double area = 0.0;
        System.out.println("Used : " + (usedbox.size()));
        for (int i = 0; i < box.size(); i++) {
            if (usedbox.contains(box.get(i))) {
                System.out.print(i);
                System.out.print(" : " + box.get(i).wide);
                System.out.println(" " + box.get(i).height); 
            }
        }
        System.out.println("Left : " + (box.size() - usedbox.size()));
        for (int i = 0; i < box.size(); i++) {
            if (!usedbox.contains(box.get(i))) {
                System.out.print(i);
                System.out.print(" : " + box.get(i).wide);
                System.out.println(" " + box.get(i).height);
                
            }else{
                area += box.get(i).area;
            }
        }
        System.out.printf("Area Left: %.2f",x*y - area);

        sc.close();
    }
    
    
}