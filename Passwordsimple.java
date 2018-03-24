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
import java.util.List;
import java.util.ArrayList;

public class Passwordsimple extends Application {

    public static Stage window;
    Button Login, adduser,choose_user;
    String Username, pssword;
    List<String> Namen,Passwoerter,User_saved,Pw_saved;
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

        // Add test variables
        Namen.add("Choose");
        Add_website.display(Currentuser);

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
            Currentuser = show_user();
            System.out.print(Currentuser);
        });
 // ********************************* LOG IN OF EXISTING USERS****************************************************

        //CheckIfInDatalist(User_saved, Pw_saved, Username, pssword);
        Login = new Button("Login");
        GridPane.setConstraints(Login,1,4);
        Login.setOnAction(e->{
            Currentuser = show_user();
            pssword = JOptionPane.showInputDialog("Enter Password", "Password");
            loggedin = CheckIfInDatalist(Namen,Passwoerter,Currentuser,pssword);
            loggedin = loggedin(loggedin);
        });

// ******************************* ADD USER ********************************************************
        //Add User
        adduser = new Button("Add User");
        GridPane.setConstraints(adduser, 1, 2);
        adduser.setOnAction(e -> {
            //Action of Click goes here
            Username = JOptionPane.showInputDialog("Enter Username", "Username");
            Namen.add(Username);
            Passwoerter.add(enter_pw());
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
            String ifempty = Namen.get(0);
            if (ifempty.equals("Choose")){
                JOptionPane.showMessageDialog(null,
                        "No users available",
                        "Failed Login", JOptionPane.ERROR_MESSAGE);
                break;
            }

            if (Uname.get(i).equals(NamEing)) {
                if (PW.get(i).equals(PwEing)) {
//                    JOptionPane.showMessageDialog(null,
//                            "Login Successful!",
//                            "Success", JOptionPane.PLAIN_MESSAGE);
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
            String[] Liste = Namen.toArray(new String[0]);
            String ifempty = Namen.get(0);
            if (ifempty.equals("Choose")){
                Namen.remove(0);
            }
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
