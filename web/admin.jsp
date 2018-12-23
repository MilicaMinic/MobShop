<%-- 
    Document   : adminNoviPodaci
    Created on : Jul 11, 2018, 1:20:55 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.logged=='admin'}">
    <%response.sendRedirect("index.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Unos i pregled podataka</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">

                <div id="logo">
                    <a  href="#"><img src="slike/logo.jpg" alt="Logo" href="index.jsp"> </a> 
                </div>

                <div id="slogan">
                    <p>Mobile Shop</p>
                </div>
                <c:if test="${sessionScope.logged!=null}"> 
                    <div style="float: left; padding-left: 100px; font-size: 18px; font-weight: bold;">
                        Dobrodošli, ${sessionScope.username}
                    </div>
                </c:if>
                <c:if test="${sessionScope.logged!=null}">
                    <a href="UserLogout"><div style="font-size: 16px; font-weight: bold;">Logout</div></a>
                </c:if>
                <br><br>

            </div>

            <div id="admincentral" style="padding: 10px; clear: both;">
                <div>
                <a href="noviBrend.jsp"><div class="adugme">Unesi novi Brend</div></a>
                <a href="prikazBrendova.jsp"><div class="adugme">Prikazi Brendove</div></a>
                
                <a href="noviModel.jsp"><div class="adugme">Unesi novi Model</div></a>
                <a href="prikazModela.jsp"><div class="adugme">Prikazi Modele</div></a>

                <a href="sviKorisnici.jsp"><div class="adugme">Prikaz svih korisnika</div></a>

                <a href="kupovina.jsp"><div class="adugme">Prikaz porudzbina</div></a>
                </div>
            </div> <!-- end of central-->

            <br>
            <br>

            <%@include file="footer.jsp"%>


        </div> <!-- end of #wrapper -->

    </body>

</html>
