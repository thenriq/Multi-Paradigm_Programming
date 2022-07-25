import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadAColumnFromCSVFileJava {

    public static void main(String[]args){
        String[] data = ReadCol(0,"CTASample.csv",",");
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

      
    }

    public static String[] ReadCol(int col, String filepath, String delimiter) {

        String data[];
        String currentLine;
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> mod1 = new ArrayList<String>();
        int iteration = 0;

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null) {
                
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                data = currentLine.split(delimiter);
                students.add(data[0]);
                mod1.add(data[1]);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return students.toArray(new String[0]);
        

    }

   
    
}
