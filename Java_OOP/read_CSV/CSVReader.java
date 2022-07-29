import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.List;
import java.util.Arrays;

public class CSVReader {
    public void csvReader() {
        Calculate_GPA calcgpa = new Calculate_GPA();
        
        Get_LETTER getletter = new Get_LETTER();

        Max_Min_Median maxMinMedian = new Max_Min_Median();

        
        BufferedReader br;
        String file = "CTASample.csv";
        //String line;
        String line = "";
        String delimiter = ",";
        int iteration = 0;
        int max_courses = 6;
        double grades_average = 0.0;
        
        String data[];
        Integer[] grades = new Integer[max_courses];
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
                grades[0] = Integer.parseInt(mod1.get(i));
                grades[1] = Integer.parseInt(mod2.get(i));
                grades[2] = Integer.parseInt(mod3.get(i));
                grades[3] = Integer.parseInt(mod4.get(i));
                grades[4] = Integer.parseInt(mod5.get(i));
                grades[5] = Integer.parseInt(mod6.get(i));
                
             
                grades_average = maxMinMedian.get_average(grades);
                System.out.println(String.format("\n%s, GPA: %.2f",students.get(i), calcgpa.calculate_GPA(grades_average) ));

                for (int j = 0; j < grades.length; j++){
                    System.out.println (String.format("Letter: %s, Module: %s", getletter.get_Letter(grades[j]) , module_names[j]));
                    //System.out.println("");
                }
                

                int minValue = grades[0];
                for (int k = 1; k < grades.length; k++) {
                    if (grades[k] < minValue) {
                        minValue = grades[k];
                    }
                }

                System.out.println(maxMinMedian.get_max(grades));
                System.out.println(maxMinMedian.min(grades));
                //System.out.println(minValue);

                
                              
                
                

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
