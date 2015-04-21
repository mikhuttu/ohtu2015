
package com.mycompany.webkauppa;

<<<<<<< HEAD
=======
import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
>>>>>>> mluukkai-lokaali
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class WebKauppaServlet extends HttpServlet {
<<<<<<< HEAD

    protected HttpSession sessio;
    protected Varasto varasto;

    public WebKauppaServlet() {
        varasto = Varasto.getInstance();
    }        
=======
    protected HttpSession sessio;
    protected KomentoTehdas tehdas;
    protected Varasto varasto;

    public WebKauppaServlet() {
        tehdas = new KomentoTehdas();
        varasto = new Varasto();
    }
>>>>>>> mluukkai-lokaali
    
    public void naytaSivu(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);       
    }

    public Ostoskori haeSessionOstoskori(HttpServletRequest request) {
        haeSessio(request);
        if ( sessio.getAttribute("ostoskori")==null ) {
            sessio.setAttribute("ostoskori", new Ostoskori());
<<<<<<< HEAD
        }        
        Ostoskori ostoskori = (Ostoskori)sessio.getAttribute("ostoskori");
        return ostoskori;
=======
        }
        return (Ostoskori) sessio.getAttribute("ostoskori");
>>>>>>> mluukkai-lokaali
    }
    
    public void haeSessio(HttpServletRequest request) {
        sessio = request.getSession();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
