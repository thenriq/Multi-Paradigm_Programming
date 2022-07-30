import java.util.Scanner;

public class Menu {
    public void show_menu(){
        Scanner sc = new Scanner(System.in);
        CSVReader reader = new CSVReader();
        New_Modules newmodules = new New_Modules();

        boolean exit = false;
        Integer choice = 0;
        do {
            
            System.out.println(String.format("\n1) See all notes"));
            System.out.println(String.format("2) Enter Grades"));
            System.out.println(String.format("3) Reprint entered notes"));
            System.out.println(String.format("0) Quit"));

            System.out.print(String.format("Enter Choice: "));
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    reader.csvReader();
                    
                    break;
    
                case 2:
                    newmodules.new_Modules();
                    break;
    
                case 3:
                    newmodules.reprint();
                    break;
    
                case 0:
                    exit = true;
                    System.out.println("Thanks for using this program");
                    break;
            }
            
                
        } while (!exit);
    
        
    }

    
    
}
