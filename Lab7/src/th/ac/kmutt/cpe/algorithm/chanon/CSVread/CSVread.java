package th.ac.kmutt.cpe.algorithm.chanon.CSVread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVread{
    public ArrayList<ArrayList<String>> read(String filePath){
        ArrayList<ArrayList<String>> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {

                String[] values = parseLine(line);
                content.add(new ArrayList<String>(Arrays.asList(values)));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return content;
    }

    private static String[] parseLine(String line) {
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }
    
}