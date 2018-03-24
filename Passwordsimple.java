package Testarea;

import com.oracle.tools.packager.Log;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.naming.Name;
import javax.swing.JOptionPane;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Passwordsimple extends Application {

    public static Stage window;
    Button Login, adduser,choose_user;
    String Username, pssword;
    List<String> Namen,Passwoerter,User_saved,Pw_saved,Filewebnames,Passwordwusers;
    String Currentuser = "Choose";
    Boolean loggedin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
        //Array listen
        Namen = new ArrayList();
        Passwoerter = new ArrayList();
        User_saved = new ArrayList();
        Pw_saved = new ArrayList<>();
        Filewebnames = new ArrayList<>();
        String existingUsers = "Userlist.txt";
        String currUserPws = "Userpw.txt";
        Filewebnames = shows_websiteList.read(existingUsers);
        Passwordwusers = shows_websiteList.read(currUserPws);
        // Add test variables
        Namen.add("Choose");
        //Add_website.display(Currentuser,pssword);

        //
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        window = primarystage;
        window.setTitle("FLX - First Password Program");

        //sets action before window closes
        window.setOnCloseRequest(e -> {
            //consume the exit event
            e.consume();
            closeProgram();
        });
// ****************************** CHOOSE USER *********************************************************
        choose_user = new Button("Choose existing Users");
        GridPane.setConstraints(choose_user, 1, 3);
        choose_user.setOnAction(e -> {
            Filewebnames = shows_websiteList.read(existingUsers);
            Currentuser = show_user();
        });
 // ********************************* LOG IN OF EXISTING USERS****************************************************

        //CheckIfInDatalist(User_saved, Pw_saved, Username, pssword);
        Login = new Button("Login");
        GridPane.setConstraints(Login,1,4);
        Login.setOnAction(e->{
            try {
                Filewebnames = shows_websiteList.read(existingUsers);
                Passwordwusers = shows_websiteList.read(currUserPws);
                Currentuser = show_user();
                pssword = JOptionPane.showInputDialog("Enter Password", "Password");
                loggedin = CheckIfInDatalist(Filewebnames, Passwordwusers, Currentuser, pssword);
                loggedin = loggedin(loggedin);
            }
            catch (Exception e1){
                JOptionPane.showMessageDialog(null,"No Existing Users","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

// ******************************* ADD USER ********************************************************
        //Add User
        adduser = new Button("Add User");
        GridPane.setConstraints(adduser, 1, 2);
        adduser.setOnAction(e -> {
            //Action of Click goes here
            Filewebnames = shows_websiteList.read(existingUsers);
            Passwordwusers = shows_websiteList.read(currUserPws);
            Username = JOptionPane.showInputDialog("Enter Username", "Username");
            writefile.write(existingUsers,Username);
            pssword = enter_pw();
            writefile.write(currUserPws,pssword);
        });

        // ******************************** SHOW BUTTON *******************************************************
        //which buttons are added to the grid
        grid.getChildren().addAll(adduser, Login);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 300, 300);
        window.setScene(scene);
        window.show();
    }

// ***************************************************************************************
//                                  FUNCTIONS
// ***************************************************************************************

    private void closeProgram() {
        Boolean answer = true;//
        if (answer)
            window.close();
    }
// ******************************* CHECK IF USER EXISTS IN LIST******************************************************

    private Boolean CheckIfInDatalist(List Uname,List PW,String NamEing, String PwEing) {
        Boolean success = false;
        int laenge = Uname.size();
        for (int i = 0; i < laenge; i++) {
            if (Uname.get(i).equals(NamEing)) {
                if (PW.get(i).equals(PwEing)) {
                    success = true;
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Username or Password wrong!",
                            "Failed Login",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
                if (i == laenge - 1) {
                    JOptionPane.showMessageDialog(null,
                            "Username or Password wrong!",
                            "Failed Login", JOptionPane.ERROR_MESSAGE);
                }
            }
            return success;
        }
// ****************************** DROP DOWN MENU OF USERS*********************************************************

        // Prints out the existing users, that were added to the system
        private String show_user() {
            Object selectedValue;
            String CurrentChoice = "";
            String[] Liste = Filewebnames.toArray(new String[0]);
            selectedValue = JOptionPane.showInputDialog(null,
                    "Choose one", "Users",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    Liste, Liste[0]);
            CurrentChoice = "" + selectedValue;
            return CurrentChoice;
        }
    // ****************************** Enter Password *********************************************************
         private String enter_pw(){
             pssword = JOptionPane.showInputDialog("Enter Password", "Password");
             return pssword;
         }

         private Boolean loggedin(Boolean success){
            if (success){
                Add_website.display(Currentuser);
            }
            success = false;
            return success;
         }
//end
}
