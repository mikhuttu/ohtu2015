package ohtu;

<<<<<<< HEAD
import java.util.ArrayList;

public class Submission {
    private String week;
    private String hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    
    public ArrayList<String> tehdytTehtavat() {
        ArrayList<String> tehdyt = new ArrayList<String>();
        lisaaJosTehty(tehdyt, a1, "1");
        lisaaJosTehty(tehdyt, a2, "2");
        lisaaJosTehty(tehdyt, a3, "3");
        lisaaJosTehty(tehdyt, a4, "4");
        lisaaJosTehty(tehdyt, a5, "5");
        lisaaJosTehty(tehdyt, a6, "6");
        lisaaJosTehty(tehdyt, a7, "7");
        lisaaJosTehty(tehdyt, a8, "8");
        lisaaJosTehty(tehdyt, a9, "9");
        lisaaJosTehty(tehdyt, a10, "10");
        lisaaJosTehty(tehdyt, a11, "11");
        lisaaJosTehty(tehdyt, a12, "12");
        lisaaJosTehty(tehdyt, a13, "13");
        lisaaJosTehty(tehdyt, a14, "14");
        lisaaJosTehty(tehdyt, a15, "15");
        lisaaJosTehty(tehdyt, a16, "16");
        lisaaJosTehty(tehdyt, a17, "17");
        lisaaJosTehty(tehdyt, a18, "18");
        lisaaJosTehty(tehdyt, a19, "19");
        lisaaJosTehty(tehdyt, a20, "20");
        lisaaJosTehty(tehdyt, a21, "21");
        
        return tehdyt;
    }

    public int getHours() {
        return Integer.parseInt(hours);
    }
    
    public int getCompletedExercises() {
        return tehdytTehtavat().size();
    }
    
    @Override
    public String toString() {
        ArrayList<String> tehdytTehtavat = tehdytTehtavat();
        
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + tehdytTehtavat.size() +
                ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + tehdytTehtavatListattuna(tehdytTehtavat);
    }

    private String tehdytTehtavatListattuna(ArrayList<String> tehdytTehtavat) {
        StringBuilder listattuna = new StringBuilder();
        
        for (String teht : tehdytTehtavat) {
            listattuna.append(teht);
            listattuna.append(" ");
        }
        return listattuna.toString();
    }

    private void lisaaJosTehty(ArrayList<String> tehdyt, boolean tehtava, String tehtNr) {
        if (tehtava) {
            tehdyt.add(tehtNr);
        }
=======
public class Submission {
    private String student_number;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return student_number;
>>>>>>> mluukkai-lokaali
    }
    
}