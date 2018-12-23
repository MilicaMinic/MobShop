<%-- 
    Document   : headerUlogovani
    Created on : Jul 4, 2018, 1:16:25 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<!DOCTYPE html>
<html lang="sr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MobShop</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>

    <body>


        <div id="header">

            <div id="logo">
                <a  href="ulogovaniKorisnici.jsp"><img src="slike/logo.jpg" alt="Logo" href="ulogovaniKorisnici.jsp"> </a> 
            </div>

            <div id="slogan">
                <p>Mobile Shop</p>
            </div>
            <c:if test="${sessionScope.logged!=null}"> 
                <div style="float: left; padding-left: 185px; font-size: 18px; font-weight: bold;">
                    Dobrodošli, ${sessionScope.username}
                </div>
            </c:if>
            <br><br>
            <c:if test="${sessionScope.logged!=null}">
                <a href="UserLogout">
                    <button type="button" class="btn btn-default btn-sm">Logout</button>
                </a>
            </c:if>
            <c:if test="${sessionScope.logged!=null}">    
                <p>
                    <a href="korpa.jsp">
                        <button type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Korpa
                        </button>
                    </a>
                </p>
            </c:if>
            <!--<%/*<c:if test="${sessionScope.logged!=null}">        
                <a  href="korpa.jsp"> Korpa </a>
            </c:if>*/%>-->
            <br><br>

            <div class="grupadugme">
                <c:if test="${sessionScope.username=='admin'}">
                    <a href="admin.jsp"><div class="dugme" style="font-size: 16px; font-weight: bold; padding-left: 10px; color: #fff;">Unos i pregled podataka</div></a>
                </c:if>

            </div>


        </div> <!--end of header-->

        <div class="topnav-container">
            <div class="topnav">
                <ul>
                    <li><a href="ulogovaniKorisnici.jsp" id="home">  Home  </a></li>
                    <li><a href="#" id="load_mobTel">  Mobilni telefoni  </a></li>
                    <li><a href="#" id="load_kontakt">  Kontakt  </a></li>
                </ul>
            </div>
        </div>


    </body>

</html>