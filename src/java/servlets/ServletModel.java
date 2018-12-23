/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Model;
import model.Model_Karakteristike;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Srcko
 */
@WebServlet(name = "ServletModel", urlPatterns = {"/ServletModel"})
public class ServletModel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */
                int id_modela = 1;
                id_modela = Integer.parseInt(request.getParameter("id"));

                Session sesija = HibernateUtil.getSessionFactory().openSession();
                Model m = (Model) sesija.get(Model.class, id_modela);
                // Model m = Upiti.selectModel(id_modela);
                
                out.println("<hr>");
                out.println("<div id='naziv'>");
                out.println(m.getNaziv() + "<br> ");
                out.println("</div>");
                out.println("<hr>");
                
                out.println("<div id='slika'>");
                out.println("<img src=" + m.getSlika() + ">" + "<br> ");
                out.println("</div>");
                
                out.println("<div class='container-for-model'>");
                out.println("<br>");
                out.println("Cena: " + m.getCena() + "<br> ");
                out.println("<br>");

                List<Model_Karakteristike> listaKarakteristika = m.getListaMKarakteristike();

                for (Model_Karakteristike item : listaKarakteristika) {
                    out.println(item.getKarakteristike().getNaziv() + ": " + item.getVrednost() + "<br> ");
                    out.println("<br>");
                }
                
                //out.println("<br><br>");
                //out.println("<form action=\"ServletKorpa\" method=\"get\">");
                //out.println("<br>");
                //out.println("<input type=\"submit\" value=\"UNESI\" class=\"btn\">");
                //out.println("</form>");
                //out.println("<a href='ServletDodajUKorpu?idMod='" + m.getId_modela()+ ">");
                //out.println("<button>DODAJ U KORPU</a></button>");
                if (sesija != null) {
                    sesija.close();
                }
                out.println("<div id='dugmekorpa'>");
                out.println("<button><a href='ServletDodajUKorpu?idMod=" + m.getId_modela()+"'"+">Stavi u korpu</a></button><br><br>");
                out.println("<p>*Da biste izvršili kupovinu, morate se <a href='loginForma.jsp' style='color: blue;'>ulogovati!</a></p>");
                out.println("</div>");
                out.println("</div>");
                
                out.println("<div id='mobhr'>");
                out.println("<hr>");
                out.println("</div>");
                
            } catch (Exception ex) {
                out.println(ex.getMessage());
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
