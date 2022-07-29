public class Get_LETTER {
    public String get_Letter(Integer grade) {
        int letter_index = 0;
        
        String[] letter = {"F-","F","F+","E-","E","E+","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"};
        
        for(int i = 10; i < 100; i += 5){
            
            if (grade >= i) {
                if ((i + 5) > grade) {
                    letter_index = ((i / 5) - 2);
                }
            }
        }
        
        return letter[letter_index];
    }
    
}
