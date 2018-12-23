<%-- 
    Document   : sviKorisnici
    Created on : Jul 26, 2018, 9:46:55 PM
    Author     : Srcko
--%>

<%@page import="prepare.Prikaz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.logged=='admin'}">
    <%response.sendRedirect("index.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <title>Korisnici</title>
    </head>
    <body>

        <div id="srednji" style="margin: 0 auto;"> 
            <div style="margin: 0 auto;">
                <%=Prikaz.prikazKorisnika()%>
            </div>
        </div>

    </body>
</html>