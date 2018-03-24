package Testarea;

import java.io.*;
import java.util.List;

public class writefile {
        public static void write(String Username,String eingabe) {

            // The name of the file to open.
            String Namelist = Username;
            try {
                // Assume default encoding.
                //true means file is not overwritten
                FileWriter fileWriterUser =
                        new FileWriter(Namelist,true);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter userWriter =
                        new BufferedWriter(fileWriterUser);

                // Note that write() does not automatically
                // append a newline character.
                userWriter.newLine();
                userWriter.write(eingabe);


                // Always close files.
                userWriter.close();
            }
            catch(IOException ex) {
                System.out.println(
                        "Error writing to file '"
                                + Namelist + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
        }
    }

