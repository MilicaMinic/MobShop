<%-- 
    Document   : model
    Created on : Jul 9, 2018, 9:28:22 PM
    Author     : Srcko
--%>


<%@page import="org.hibernate.Transaction"%>
<%@page import="model.Model_Karakteristike"%>
<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="db.Upiti"%>
<%@page import="model.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Model</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <div id="wrapper">

            <%@include file="headerUlogovani.jsp"%>

            <div id="central" style="margin-top: 40px;">
                <%
                    Session sesija = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = sesija.beginTransaction();
                    int id_modela = 1;
                    id_modela = Integer.parseInt(request.getParameter("id"));
                    Model m = (Model) sesija.get(Model.class, id_modela);
                %>
                <div style="border: 1px solid #000; overflow: hidden; margin: 0 auto; width: 50%;">

                    <h3 style="padding: 15px; margin: 0 auto; margin-top: 10px; padding-left: 25%;">Informacije o modelu<%m.getNaziv();%></h3><hr><br>
                    <div class="jedanmodel">
                        <img src="<%=m.getSlika()%>">
                        <div style="padding-top: 20px;">
                            <%
                                List<Model_Karakteristike> listaKarakteristika = m.getListaMKarakteristike();

                                for (Model_Karakteristike item : listaKarakteristika) {
                                    out.println(item.getKarakteristike().getNaziv() + ": " + item.getVrednost() + "<br> ");
                                }
                            %>
                        </div>
                        <p style="padding-top: 20px;"><b>Cena: <%=m.getCena()%></b></p>
                    </div>
                    <br><br>
                    <c:if test="${sessionScope.logged!=null}"> 
                        <div class="col-md-5">
                            <%{%><a href="ServletDodajUKorpu?idMod=<%=m.getId_modela()%>"><button type="button" class="btn btn-primary">Dodaj u korpu</button></a><%}%>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.logged==null}">
                        <p style="padding-top: 15px; padding-bottom: 20px;">Ako želite da poručite ovaj model, molimo Vas <a href="loginForma.jsp">ulogujte se.</a></p>
                    </c:if>

                </div>
                <%
                    sesija.getTransaction().commit();
                    if (sesija.isOpen()) {
                        sesija.close();
                    }
                %>



            </div><!-- end of central-->


            <script src ="js/samePage.js"></script>
            <br>
            <br>

            <%@include file="footer.jsp"%>
        </div>
    </body>
</html>
