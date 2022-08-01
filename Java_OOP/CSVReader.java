import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader {
    public void csvReader() {

        //Calling all constructor
        Calculate_GPA calcgpa = new Calculate_GPA();
        Get_LETTER getletter = new Get_LETTER();
        Max_Min_Median maxMinMedian = new Max_Min_Median();
        Calc_STD calcstd = new Calc_STD();
        
        BufferedReader br;
        String file = "../CTASample.csv";
        String line = "";
        String delimiter = ",";
        int iteration = 0;
        int max_courses = 6;
        double grades_average = 0.0;
        
        String data[];
        Integer[] grades = new Integer[max_courses];
        String[] module_names = {"Intro to Programming", "Databases", "Computer Architecture", "Ethics in Computer Science", "Advanced Programming", "Puzzles and Problem Solving"};
        

        // Creating arrays for module grades and module names
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
                
                // feeding each arrays with colums "students" and "grades"
                data = line.split(delimiter);
                students.add(data[0]);
                mod1.add(data[1]);
                mod2.add(data[2]);
                mod3.add(data[3]);
                mod4.add(data[4]);
                mod5.add(data[5]);
                mod6.add(data[6]);

            }

            // Main looping - this will print each of student's names along with their grades, GPA and letter marks
            for (int i = 0; i < students.size(); i++  ) {
                // feeding array "grades" with students grades
                grades[0] = Integer.parseInt(mod1.get(i));
                grades[1] = Integer.parseInt(mod2.get(i));
                grades[2] = Integer.parseInt(mod3.get(i));
                grades[3] = Integer.parseInt(mod4.get(i));
                grades[4] = Integer.parseInt(mod5.get(i));
                grades[5] = Integer.parseInt(mod6.get(i));
                
                // calculating grades average
                // this will be used to calculate GPa value afterwards
                grades_average = maxMinMedian.get_average(grades);
                System.out.println(String.format("\n%s, GPA: %.2f",students.get(i), calcgpa.calculate_GPA(grades_average) ));

                for (int j = 0; j < grades.length; j++){
                    System.out.println (String.format("Letter: %s, Module: %s", getletter.get_Letter(grades[j]) , module_names[j]));
                }
               

                int minValue = grades[0];
                for (int k = 1; k < grades.length; k++) {
                    if (grades[k] < minValue) {
                        minValue = grades[k];
                    }
                }

                // As a footer for each student, it follows the High and lowest score, the standard deviation and median values
                System.out.println( String.format("Highest scoring: %d, Module: %s", maxMinMedian.get_max(grades), module_names[ maxMinMedian.get_max_index(grades)]));
                System.out.println( String.format("Lowest scoring: %d, MOdule: %s", maxMinMedian.get_min(grades), module_names[maxMinMedian.get_min_index(grades)]));
                System.out.println( String.format("Standard Deviation: %.3f", calcstd.calc_std(grades)));
                System.out.println( String.format("Median Value: %.2f", maxMinMedian.get_average(grades)));

            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
