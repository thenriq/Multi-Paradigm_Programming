import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public void csvReader() {
        BufferedReader br;
        String file = "CTASample.csv";
        //String line;
        String line = "";
        String delimiter = ",";
        int iteration = 0;
        int max_courses = 6;
        
        String data[];
        String[] grades = new String[max_courses];
        String[] module_names = {"Intro to Programming", "Databases", "Computer Architecture", "Ethics in Computer Science", "Advanced Programming", "Puzzles and Problem Solving"};
        
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> mod1 = new ArrayList<String>();
        ArrayList<String> mod2 = new ArrayList<String>();
        ArrayList<String> mod3 = new ArrayList<String>();
        ArrayList<String> mod4 = new ArrayList<String>();
        ArrayList<String> mod5 = new ArrayList<String>();
        ArrayList<String> mod6 = new ArrayList<String>();
       
        
        try{
            br = new BufferedReader(new FileReader(new File(file)));
            
            while ((line=br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }

                data = line.split(delimiter);
                students.add(data[0]);
                mod1.add(data[1]);
                mod2.add(data[2]);
                mod3.add(data[3]);
                mod4.add(data[4]);
                mod5.add(data[5]);
                mod6.add(data[6]);
                

            }

            for (int i = 0; i < students.size(); i++  ) {
                grades[0] = mod1.get(i);
                grades[1] = mod2.get(i);
                grades[2] = mod3.get(i);
                grades[3] = mod4.get(i);
                grades[4] = mod5.get(i);
                grades[5] = mod6.get(i);
                //System.out.println(grades[i]);
                
                System.out.println(String.format("\n%s, GPA: <>",students.get(i)));

                for (int j = 0; j < grades.length; j++){
                    System.out.println (String.format("%s, Module: %s",grades[j], module_names[j]));
                    //System.out.println("");
                }
            }
            
            /*/
            System.out.println(students);
            System.out.println(mod1);
            System.out.println(mod2);
            System.out.println(mod3);
            System.out.println(mod4);
            System.out.println(mod5);
            System.out.println(mod5);
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
