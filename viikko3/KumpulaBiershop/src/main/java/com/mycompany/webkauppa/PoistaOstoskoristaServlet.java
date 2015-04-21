package com.mycompany.webkauppa;

<<<<<<< HEAD
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
=======
>>>>>>> mluukkai-lokaali
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoistaOstoskoristaServlet extends WebKauppaServlet {
             
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
        
<<<<<<< HEAD
        OstoksenPoistoKorista poisto = new OstoksenPoistoKorista(haeSessionOstoskori(request),  tuoteId );          
        poisto.suorita();        
=======
        tehdas.ostoksenPoistoKorista(haeSessionOstoskori(request), tuoteId).suorita(varasto);
>>>>>>> mluukkai-lokaali
        
        naytaSivu("/MaksaOstokset", request, response);
    }
}
