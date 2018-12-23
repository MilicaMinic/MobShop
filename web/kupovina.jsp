<%-- 
    Document   : kupovina
    Created on : Jul 9, 2018, 2:53:50 PM
    Author     : Srcko
--%>


<%@page import="prepare.Prikaz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.logged=='admin'}">
    <%response.sendRedirect("ulogovaniKorisnici.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Kupovina</title>
    </head>
    <body>
        
                <div id="srednji"> 
                    
                        <%=Prikaz.izlistajPorudzbine()%>
                    
                </div>

    </body>
</html>
