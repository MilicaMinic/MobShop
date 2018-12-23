<%-- 
    Document   : devices
    Created on : Jun 22, 2018, 12:08:03 PM
    Author     : Srcko
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="model.Model"%>
<%@page import="db.Upiti"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!DOCTYPE html>
<html lang="sr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MobShop</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">

    </head>

    <body>

        <div class="mobilniTelefoni">
            <div class="model-container">
                <% Model m = new Model();
                    ArrayList<Model> lista = Upiti.getAllModels();
                %>
                <%
                    for (Model pom : lista) {
                %>
                <div class="m1" style="padding-bottom: 50px;">
                    <h5 style="padding-left: 15px; padding-top: 15px;"><%= pom.getNaziv()%></h5>
                    <hr>
                    <div>
                        <img src="<%= pom.getSlika()%>" class="img-models" alt="Modeli">
                        <br>
                        <div class="tekst">
                            <p>Šifra proizvoda: <b><%= pom.getId_modela()%></b></p>
                        </div>
                        <br><br><br><br>

                        <h4><%= pom.getCena()%> eura</h4>
                        <br><br>
                        <a href="model.jsp?id=<%=pom.getId_modela()%>"><button type="button" class="btnm1">Detaljnije</button></a>
                        <br><br><br><br><br>
                    </div>

                </div>
                <%}%>
            </div>
        </div>

    </body>

</html>