import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public void csvReader() {
        BufferedReader br;
        String file = "CTASample.csv";
        String line;
        try{
            br = new BufferedReader(new FileReader(new File(file)));
            while ((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
