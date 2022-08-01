public class Get_LETTER {

    //Calculating LETTERS values based on grades from 0 to 100%
    public String get_Letter(Integer grade) {
        int letter_index = 0;
        
        String[] letter = {"F-","F","F+","E-","E","E+","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"};
        
        for(int i = 10; i < 100; i += 5){ //Letters will be calculated on chunks of 5% increment on grades (0 to 100)
            
            if (grade >= i) {
                if ((i + 5) > grade) {
                    letter_index = ((i / 5) - 2); // assigning GPA value based on its index in array
                }
            }
        }
        
        return letter[letter_index];
    }
    
}
