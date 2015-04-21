package com.mycompany.webkauppa;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Tuote;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.ToimitusjarjestelmaFasaadi;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaksaOstoksetServlet extends WebKauppaServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Ostoskori ostoskori = haeSessionOstoskori(request);

        request.setAttribute("hinta", ostoskori.hinta());
        request.setAttribute("ostokset", ostoskori.ostokset());

        naytaSivu("/maksa_ostokset.jsp", request, response);
    }

    protected void doPost(PankkiFasaadi pankki, ToimitusjarjestelmaFasaadi toimitus, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nimi = request.getParameter("nimi");
        String osoite = request.getParameter("osoite");
        String luottokorttinumero = request.getParameter("luottokorttinumero");

        Ostoskori ostoskori = haeSessionOstoskori(request);

        if (request.getParameter("ostokset") != null) {
            ostoskori = muodostaOstoskori(request);
        }

        request.setAttribute("osoite", osoite);
        request.setAttribute("hinta", ostoskori.hinta());

        if (tehdas.ostoksenSuoritus(pankki, nimi, osoite, luottokorttinumero, ostoskori).suorita(toimitus)) {
            naytaSivu("/maksu_suoritettu.jsp", request, response);
        } else {
            naytaSivu("/maksu_epaonnistui.jsp", request, response);
        }

    }

    private Ostoskori muodostaOstoskori(HttpServletRequest request) {
        String ostokset = request.getParameter("ostokset");
        Ostoskori kori = new Ostoskori();
        
        System.out.println(ostokset);

        for (String ostos : ostokset.split(";") ) {

            String[] ostoksenOsat = ostos.split(",");
            Tuote tuote = varasto.etsiTuote(Long.parseLong(ostoksenOsat[0]));
            for (int i = 0; i < Integer.parseInt(ostoksenOsat[1]); i++) {
                varasto.otaVarastosta(tuote.getId());
                kori.lisaaTuote(tuote);
            }
        }

        return kori;
    }
}