package Testarea;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class shows_websiteList {

    public static void display(String currentuser){
        List Filewebnames;
        String currUserFilename = currentuser + "_sites.txt";
        Filewebnames = read(currUserFilename);
        Stage window = new Stage();
        //block user interaction with other windows until this is resolved
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("List of websites");
        window.setMinWidth(200);
        String Websiteliste = fillLabel(Filewebnames);
        Label label = new Label(Websiteliste);
        //gridpane
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);


        layout.getChildren().addAll(label);
        Scene scene = new Scene(layout, 300,500);
        window.setScene(scene);
        window.showAndWait();

    }

    private static String fillLabel(List liste){
        String message;
        message = "Your websites:\n";
        String[] containsMessage = (String[]) liste.toArray(new String[0]);
        int laenge = liste.size();
        for (int i = 0; i< laenge;i++)
        {
            message = message + containsMessage[i] + "\n";
        }
        return message;
    }

    //------------------------------- Read from Existing list -----------------------------
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



