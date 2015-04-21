package com.mycompany.webkauppa.ulkoiset_rajapinnat;

import java.util.ArrayList;
import java.util.Date;

public class PankkiFasaadi {
<<<<<<< HEAD

    private static PankkiFasaadi instance;

    public static PankkiFasaadi getInstance() {
        if (instance == null) {
            instance = new PankkiFasaadi();
        }

        return instance;
    }

    public PankkiFasaadi() {
        maksut = new ArrayList<String>();
    }
    
    private ArrayList<String> maksut;

=======
    private ArrayList<String> maksut;
    
    public PankkiFasaadi() {
        maksut = new ArrayList<>();
    }
    
>>>>>>> mluukkai-lokaali
    public boolean maksa(String nimi, String luottokortti, int hinta) {
        if (luottokortti.length() < 2) {
            return false;
        }

        maksut.add( new Date() + " " + nimi + " " + luottokortti + " " + hinta );
<<<<<<< HEAD

=======
>>>>>>> mluukkai-lokaali
        return true;
    }
    
    public ArrayList<String> maksut() {
        return maksut;
    }
}
