<<<<<<< HEAD

package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.OstoksenLisaysKoriin;
=======
package com.mycompany.webkauppa;

>>>>>>> mluukkai-lokaali
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LisaaOstoskoriinServlet extends WebKauppaServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
<<<<<<< HEAD
                        
        OstoksenLisaysKoriin lisays = new OstoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId);
        lisays.suorita();
=======
        tehdas.ostoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId).suorita(varasto);
>>>>>>> mluukkai-lokaali
        
        naytaSivu("/Tuotelista", request, response);   
    }
}
