<%-- 
    Document   : header
    Created on : Jun 15, 2018, 3:26:07 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div id="header">

            <div id="logo">
                <a  href="index.jsp"><img src="slike/logo.jpg" alt="Logo" href="index.jsp"> </a> 
            </div>

            <div id="slogan">
                <p>Mobile Shop</p>
            </div>
    <div id="dugmiciindex">
        <a href="registerForma.jsp">Register</a>
    
        <a href="loginForma.jsp">Login</a>
    </div>  
     <c:if test="${sessionScope.logged!=null}">
        <a href="UserLogout">Logout</a>
        </c:if>
        
  
      
</div> <!--end of header-->

<div class="topnav-container">
            <div class="topnav">
            <ul>
                <li><a href="index.jsp">  Home  </a></li>
                <li><a href="#" id="load_mobTel">  Mobilni telefoni  </a></li>
                <li><a href="#" id="load_kontakt">  Kontakt  </a></li>
            </ul>
            </div>
</div>