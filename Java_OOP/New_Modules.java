import java.util.Scanner;

public class New_Modules {
    Calculate_GPA calcgpa = new Calculate_GPA();
    Get_LETTER getletter = new Get_LETTER();
    Max_Min_Median maxMinMedian = new Max_Min_Median();
    
    // "Global" variables - these need to be public so as it can be used in more than 1 method
    public static int number_modules = 6;
    public static String[] new_mod_name = new String[number_modules];
    public static Integer[] new_mod_grade = new Integer[number_modules];
    
    public void new_Modules(){
        Scanner sc = new Scanner(System.in);
        Integer i = 0, number_modules = 6;
        System.out.println(String.format("\nEnter Modules name and grades"));

        // Getting user input
        for (i = 0; i < number_modules; i++) {
            System.out.println(String.format("\nModule %d:", i + 1));
            new_mod_name[i] = sc.next();
            System.out.println(String.format("\nGrade for module %s", new_mod_name[i]));
            
            new_mod_grade[i] = sc.nextInt();
            
            while ((new_mod_grade[i]) > 99 || (new_mod_grade[i]) < 1) {
                System.out.println(String.format(">> Grades must be between 1 and 99, please try again! <<"));
                System.out.println(String.format("Grade for module %s", new_mod_name[i]));
                new_mod_grade[i] = sc.nextInt();
            }
            
        }
        //sc.close();
       
        // outputing results
        System.out.println(String.format("GPA: %.2f", (calcgpa.calculate_GPA(maxMinMedian.get_average(new_mod_grade))) ));
        for (i = 0; i < number_modules; i++) {
            System.out.println(String.format("Letter: %s, Module: %s",getletter.get_Letter(new_mod_grade[i]), new_mod_name[i]));
        }
        
    }

    public void reprint() {
        
        try {
            System.out.println(String.format("GPA: %.2f", (calcgpa.calculate_GPA(maxMinMedian.get_average(new_mod_grade))) ));
            for (int i = 0; i < number_modules; i++) {
                System.out.println(String.format("Letter: %s, Module: %s",getletter.get_Letter(new_mod_grade[i]), new_mod_name[i]));
            }
        } catch(Exception e) {
            System.out.println("\nNo grades have been entered yet");
        }
    }
}
