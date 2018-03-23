package Testarea;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.List;

public class shows_websiteList {

    public static void display(List Hallo){

        Stage window = new Stage();
        //block user interaction with other windows until this is resolved
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("List of websites");
        window.setMinWidth(200);
        String Websiteliste = fillLabel(Hallo);
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
        String message = new String();
        String[] containsMessage = (String[]) liste.toArray(new String[0]);
        int laenge = liste.size();
        for (int i = 0; i< laenge;i++)
        {
            message = message + containsMessage[i] + "\n";
        }
        return message;
    }
}



