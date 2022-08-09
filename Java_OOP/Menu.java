import java.util.Scanner;

public class Menu {
    public void show_menu(){
        Scanner sc = new Scanner(System.in);
        CSVReader reader = new CSVReader();
        New_Modules newmodules = new New_Modules();
        boolean exit = false;
        Integer choice = 0;
        
        // menu to the user
        do {
            // present the menu, accept the user's choice
            System.out.println(String.format("\n1) See all notes"));
            System.out.println(String.format("2) Enter Grades"));
            System.out.println(String.format("3) Reprint entered notes"));
            System.out.println(String.format("0) Quit"));

            System.out.print(String.format("Enter Choice: "));
            choice = sc.nextInt();

            // decide what action to carry out based on the user's choice
            switch(choice) {
                    // print values
                case 1:
                    reader.csvReader();
                    
                    break;
    
                    // Enter new grades
                case 2:
                    newmodules.new_Modules();
                    break;
    
                    // Reprint grades entered by user
                case 3:
                    newmodules.reprint();
                    break;
    
                    // quit
                case 0:
                    exit = true;
                    System.out.println("Thanks for using this program");
                    break;
            }
                
        } while (!exit);
        sc.close();
    }
}