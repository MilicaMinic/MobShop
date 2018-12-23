<%-- 
    Document   : korpa
    Created on : Jul 8, 2018, 12:34:38 AM
    Author     : Ivana
--%>

<%@page import="prepare.Prikaz"%>
<%@page import="db.Upiti"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.logged==null}">
    <%response.sendRedirect("index.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Korpa: <%=(String) session.getAttribute("username")%></title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>


    <body>
        <%String korisnik = (String) session.getAttribute("username");%>
        <% int id_korisnika = Upiti.getIdKorisnika(korisnik); %>
        <% int id_korpe = Upiti.getIdKorpe(id_korisnika);%>
        <div id="wrapper">
            <%@include file="headerUlogovani.jsp" %>
            <div id="central">

                <div class="korpa-container">
                    <form class="forma" id="Korpa3" name="Korpa" action="ServletKupovina" method="post">
                        <p style="padding-left: 10px; padding-top: 10px; font-size: 16px;"> Vaši proizvodi:</p><br><p> <%=Prikaz.izlistajIzabraneModele(id_korisnika)%> </p> 
                        <br>
                        <p style="float: right; border: 1px solid black; padding: 5px;"> 
                            Ukupna cena: <%=Prikaz.ukupnaCena(id_korisnika)%> </p>
                        &nbsp;
                        <input style="clear: both; float: right; margin-bottom: 10px; margin-top: 10px; font-size: 20px;" id="dugme" type="submit" value="Poruči!"/>
                    </form>

                    <c:if test="${sessionScope.emptyCart==true}">
                        <p>Vasa korpa je prazna!</p> 
                    </c:if> 
                </div>

            </div> <!--end of central-->
            <script src ="js/samePage.js"></script>
            <%@include file="footer.jsp" %>

        </div>
    </body>
</html>
