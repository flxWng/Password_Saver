package Testarea;

import java.io.*;
import java.util.List;

public class writefile {
        public static void write(String Username, String PW) {

            // The name of the file to open.
            String Namelist = Username +"_sites.txt";
            String PWlist = Username +"_passwords.txt";
            try {
                // Assume default encoding.
                FileWriter fileWriterUser =
                        new FileWriter(Namelist);
                FileWriter fileWriterPW =
                        new FileWriter(PWlist);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter userWriter =
                        new BufferedWriter(fileWriterUser);
                BufferedWriter pwWriter =
                        new BufferedWriter(fileWriterPW);

                // Note that write() does not automatically
                // append a newline character.
                //userWriter.write("Website1");
                //userWriter.newLine();

                // Always close files.
                userWriter.close();
                pwWriter.close();
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

