package Working_set;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Add_website {

        static boolean answer;
        static List Webnamen = new ArrayList();
        static List Password = new ArrayList();
        static String webchoice = "";
        public static boolean display(String currentchoice){
            Webnamen.add("Choose");
            Stage window = new Stage();
            //block user interaction with other windows until this is resolved
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(currentchoice + "'s mainpage");
            window.setMinWidth(200);

            //gridpane
            GridPane layout = new GridPane();
            layout.setPadding(new Insets(10, 10, 10, 10));
            layout.setVgap(8);
            layout.setHgap(8);
            Label label = new Label(currentchoice);
            GridPane.setConstraints(label,6,2);
//------------------- ADD WEBSITE ----------------------------------------------
            Button addweb = new Button("Add Website");
            GridPane.setConstraints(addweb,5,3);
            addweb.setOnAction(e->{
                if (Webnamen.get(0).equals("Choose")) {
                    Webnamen.remove(0);
                }
                webeingabe();
                pweingabe();
            });
//-----------Action for getting Password-----------------------------------------
            Button getpw = new Button("Get Password");
            GridPane.setConstraints(getpw,5,4);
            getpw.setOnAction(e->{
                webchoice = show_websites();
                String requestedPW = checkifavailable(webchoice);
                String Message = "The password for " + webchoice + " is:\n" + requestedPW;
                JOptionPane.showMessageDialog(null,Message,"" ,JOptionPane.PLAIN_MESSAGE);
            });
//------------------------ Window Options -----------------------------------------

            layout.getChildren().addAll(addweb,getpw);
            Scene scene = new Scene(layout, 300,300);
            window.setScene(scene);
            window.showAndWait();

            return answer;
        }

 //-------------------------------- FUNCTIONS ---------------------------------------------
    private static String show_websites() {
            Object selectedValue;
            String CurrentChoice = "";
            String[] Liste = (String[]) Webnamen.toArray(new String[0]);
            String ifempty = (String) Webnamen.get(0);
            if (ifempty.equals("Choose")){
                Webnamen.remove(0);
            }
            selectedValue = JOptionPane.showInputDialog(null,
                    "Choose one", "Websites",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    Liste, Liste[0]);
            CurrentChoice = "" + selectedValue;
            return CurrentChoice;
    }

    private static String pweingabe() {
        String pweingabe = JOptionPane.showInputDialog("Enter Password", "Password");
        Password.add(pweingabe);
        return pweingabe;
    }
    private static String webeingabe() {
        String seiteeingabe = JOptionPane.showInputDialog("Enter Website", "Website");
        Webnamen.add(seiteeingabe);
        return seiteeingabe;
    }

    private static String checkifavailable(String webname) {
            String password_for_site ="Error";
        String[] Webliste = (String[]) Webnamen.toArray(new String[0]);
        String[] PWliste = (String[]) Password.toArray(new String[0]);
        int laenge = Webnamen.size();
        for (int i = 0; i< laenge;i++)
        {
            if (webname.equals(Webliste[i])){
                password_for_site = PWliste[i];
                break;
            }
        }
        return password_for_site;
    }
    //ende

}



