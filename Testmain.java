package Testarea;

import java.util.ArrayList;
import java.util.List;

public class Testmain {

    static List a = new ArrayList();

    public static void main(String[] args) {
        //red out list with websites
        String User = "Felix_sites.txt";
        a = Readfile.read(User);
        a.clear();
        //Read out list with passwords
        String PW = "Felix_passwords.txt";
        a = Readfile.read(PW);
        //Print out new list
        for (int i = 0; i< a.size();i++)
        {
            System.out.println(a.get(i));
        }


    }

    public static List read(List liste){
        List lol = Read.display(liste);
        return lol;
    }

}
