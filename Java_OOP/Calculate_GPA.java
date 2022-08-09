public class Calculate_GPA {

    //Calculating GPA values based on grades from 0 to 100%
    public double calculate_GPA(double grades_average){

        // array size 18 matches with number of elements of array letter (from A+ down to F-)
        double[] gpavalue = {0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2, 2.2, 2.4, 2.6, 2.8, 3, 3.2, 3.4, 3.6, 3.8, 4, 4.2};
        Integer i = 10;
        Integer gpa_index = 0;
        double gpa_value;
        
        for (i = 10; i < 100; i += 5 ){ // 100 is the maximum grade allowed
            //GPA will be calculated on chunks of 5% increment
            if (grades_average >= i) {
                if ((i+5) > grades_average) {
                    gpa_index = ((i / 5) - 2);
                }
            }
        }

        gpa_value = (gpavalue[gpa_index]); // assigning GPA value based on its index in array "gpavalue"
        return gpa_value;
    }
}
