package Testarea;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Readfile {
    public static List read(String Uname) {
        List ReadWebn= new ArrayList();
        // The name of the file to open.
        String Namelist = Uname;
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader Ureader =
                    new FileReader(Namelist);


            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedUreader =
                    new BufferedReader(Ureader);

            while((line = bufferedUreader.readLine()) != null) {
                //System.out.println(line);
                ReadWebn.add(line);
            }

            // Always close files.
            bufferedUreader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            Namelist + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + Namelist + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return ReadWebn;
    }
}
