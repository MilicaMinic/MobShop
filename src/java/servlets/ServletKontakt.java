/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Kontakt;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Srcko
 */
@WebServlet(name = "ServletKontakt", urlPatterns = {"/ServletKontakt"})
public class ServletKontakt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Kontakt spustiKontakt(HttpServletRequest request) throws org.hibernate.exception.ConstraintViolationException, SQLException {
        Kontakt noviUnos = new Kontakt (request.getParameter("ime"),
                request.getParameter("prezime"),
                request.getParameter("email"),
                request.getParameter("pitanje"));

        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesija.beginTransaction();
        sesija.save(noviUnos);
        t.commit();
        if (sesija != null) {
            sesija.close();
        }

        return noviUnos;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Kontakt noviUnos = spustiKontakt(request);
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<title>Kontakt</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id='register'>");
                
                out.println("Poštovani/a " + noviUnos.getIme()+ ", ");
                out.println("<br><br>");
                out.println("Podaci su uneti u bazu. Dobićete odgovor u roku od 24h.");
                out.println("<br><br> S poštovanjem, ");
                out.println("<br><br> MobileShop Team ");
                out.println("<br><br>");
                out.println("<button><a href='index.jsp'>NAZAD</a></button>");
                
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception ex) {
               ex.getMessage();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
