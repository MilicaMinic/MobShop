/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Brend;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Srcko
 */
@WebServlet(name = "ServletUnosNovogBrenda", urlPatterns = {"/ServletUnosNovogBrenda"})
public class ServletUnosNovogBrenda extends HttpServlet {

        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Brend spustiBrend(HttpServletRequest request) throws org.hibernate.exception.ConstraintViolationException{
        Brend noviUnos = new Brend (request.getParameter("naziv"));
        
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesija.beginTransaction();
        sesija.save(noviUnos);
        t.commit();
        if(sesija != null)
            sesija.close();
        
        return noviUnos;
    }
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                try{
            /* TODO output your page here. You may use following sample code. */
            Brend noviUnos = spustiBrend(request);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<title>Novi unos</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='login'>");
            out.println("Naziv brenda je: " + noviUnos.getNaziv() + "<br><br> ");
            out.println("<script>alert('Podaci su uneti u bazu')</script>");
            out.println("<button><a href='noviBrend.jsp'>NAZAD</a></button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
            catch(org.hibernate.exception.ConstraintViolationException e){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<title>Novi unos</title>");  
                out.println("</head>");
                out.println("<body>");
                out.println("<div id='login'>");;
                out.println("<script>alert('Unos postoji!')</script>");
                out.println("Molimo ponovite unos <br><br>");
                out.println("<button><a href='noviBrend.jsp'>NAZAD</a></button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } }catch(java.lang.NumberFormatException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<title>Novi unos</title>");  
                out.println("</head>");
                out.println("<body>");
                out.println("<div id='login'>");;
                out.println("<script>alert('Neispravan unos!')</script>");
                out.println("Molimo popunite tražena polja <br><br>");
                out.println("<button><a href='noviBrend.jsp'>NAZAD</a></button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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