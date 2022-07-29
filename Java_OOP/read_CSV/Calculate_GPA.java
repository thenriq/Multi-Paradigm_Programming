public class Calculate_GPA {

    public double calculate_GPA(double grades_average){

        double[] gpavalue = {0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2, 2.2, 2.4, 2.6, 2.8, 3, 3.2, 3.4, 3.6, 3.8, 4, 4.2};
        Integer i = 10;
        Integer gpa_index = 0;
        double gpa_value;
        
        for (i = 10; i < 100; i += 5 ){
            if (grades_average >= i) {
                if ((i+5) > grades_average) {
                    gpa_index = ((i / 5) - 2);
                }
            }
        }

        gpa_value = (gpavalue[gpa_index]);
        return gpa_value;

        
    }
    
}
