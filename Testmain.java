package Testarea;

import java.util.ArrayList;
import java.util.List;

public class Testmain {

    static List a = new ArrayList();

    public static void main(String[] args) {
        //red out list with websites
        String User = "Georg_sites.txt";
        writefile.write(User);
        //Print out new list


    }

    public static List read(List liste){
        List lol = Read.display(liste);
        return lol;
    }

}
