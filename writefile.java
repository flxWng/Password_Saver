package Testarea;

import java.io.*;

    public class writefile {
        public static void main() {

            // The name of the file to open.
            String fileName = "write1.txt";

            try {
                // Assume default encoding.
                FileWriter fileWriter =
                        new FileWriter(fileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                        new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                bufferedWriter.write("Website1");
                bufferedWriter.newLine();

                // Always close files.
                bufferedWriter.close();
            }
            catch(IOException ex) {
                System.out.println(
                        "Error writing to file '"
                                + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
        }
    }

