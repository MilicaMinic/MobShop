/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.Upiti;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author Srcko
 */
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {
	
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if (request.getParameter("username") != null 
                    && request.getParameter("password") != null) {
                int id_korisnika = Upiti.getIdKorisnika(request.getParameter("username"),
                        request.getParameter("password"));
                if (id_korisnika!=-1) {
                    request.getSession(true).setAttribute("id", id_korisnika);
                    request.getSession(true).setAttribute("logged", true);
                    request.getSession(true).setAttribute("username",
                            request.getParameter("username"));
                    response.sendRedirect("ulogovaniKorisnici.jsp");
                /*} else {*/
                    //response.setContentType("text/html;charset=UTF-8");
                    //response.getOutputStream().print("<script>alert('Pogrešan unos')</script>");
                    //response.sendRedirect("index.jsp");
                     /*response.getOutputStream().print("<!DOCTYPE html>");
                response.getOutputStream().print("<html>");
                response.getOutputStream().print("<head>");
                response.getOutputStream().print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                response.getOutputStream().print("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                response.getOutputStream().print("<title>Novi unos</title>");  
                response.getOutputStream().print("</head>");
                response.getOutputStream().print("<body>");
                response.getOutputStream().print("<div id='login'>");
                response.getOutputStream().print("<script>alert('Neispravan unos!')</script>");
                response.getOutputStream().print("Molimo unesite ispravan username i password. <br><br>");
                response.getOutputStream().print("<button><a href='index.jsp'>LOGIN</a></button>");
                response.getOutputStream().print("</div>");
                response.getOutputStream().print("</body>");
                response.getOutputStream().print("</html>");
                }*/
            } else {
                response.setContentType("text/html;charset=UTF-8");
                response.getOutputStream().print("<!DOCTYPE html>");
                response.getOutputStream().print("<html>");
                response.getOutputStream().print("<head>");
                response.getOutputStream().print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                response.getOutputStream().print("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">");
                response.getOutputStream().print("<title>Novi unos</title>");  
                response.getOutputStream().print("</head>");
                response.getOutputStream().print("<body>");
                response.getOutputStream().print("<div id='errorlogin'>");
                response.getOutputStream().print("Pogrešan unos! <br><br>");
                response.getOutputStream().print("Molimo unesite ispravan username i password. <br><br>");
                response.getOutputStream().print("<button><a href='loginForma.jsp'>NAZAD</a></button>");
                response.getOutputStream().print("</div>");
                response.getOutputStream().print("</body>");
                response.getOutputStream().print("</html>");
            }
        }
    }
}
