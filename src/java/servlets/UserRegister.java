/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.Upiti;
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
import model.Korisnik;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Srcko
 */
@WebServlet(name = "UserRegister", urlPatterns = {"/UserRegister"})
public class UserRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Korisnik spustiKorisnika(HttpServletRequest request) throws org.hibernate.exception.ConstraintViolationException, SQLException {
        Korisnik noviUnos = new Korisnik(request.getParameter("ime"),
                request.getParameter("prezime"),
                request.getParameter("adresa"),
                request.getParameter("username"),
                request.getParameter("password"));

        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesija.beginTransaction();
        sesija.save(noviUnos);
        t.commit();
        Upiti.kreiranjeNoveKorpe(noviUnos.getId_korisnika());
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
                Korisnik noviUnos = spustiKorisnika(request);
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<title>Novi unos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id='register'>");
                out.println("Ime: " + noviUnos.getIme()+ "<br> ");
                out.println("Prezime: " + noviUnos.getPrezime()+ "<br> ");
                out.println("Adresa: " + noviUnos.getAdresa()+ "<br> ");
                out.println("Username: " + noviUnos.getUsername() + "<br> ");
                out.println("Password: " + noviUnos.getPassword() + "<br><br> ");
                out.println("<script>alert('Podaci su uneti u bazu')</script>");
                out.println("<button><a href='loginForma.jsp'>ULOGUJ SE</a></button>");
                out.println("<button><a href='index.jsp'>NAZAD</a></button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } catch (org.hibernate.exception.ConstraintViolationException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<title>Novi unos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id='register'>");;
                out.println("<script>alert('Unos postoji!')</script>");
                out.println("Molimo ponovite unos <br><br>");
                out.println("<button><a href='registerForma.jsp'>NAZAD</a></button>");
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
