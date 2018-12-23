<%-- 
    Document   : index
    Created on : Jun 14, 2018, 1:00:00 PM
    Author     : Srcko
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Brend"%>
<%@page import="db.Upiti"%>
<%@page import="db.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="sr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MobShop</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>

    <body>

        <div id="wrapper">

            <%@include file="header.jsp"%>

            <div>
                <div class="slideshow-container">

                    <div class="mySlides fade">
                        <div class="numbertext">1 / 4</div>
                        <img src="slike/1.png" alt="1" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">2 / 4</div>
                        <img src="slike/2.jpg" alt="2" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">3 / 4</div>
                        <img src="slike/3.jpeg" alt="3" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext">4 / 4</div>
                        <img src="slike/4.jpg" alt="4" style="width:100%">
                        <div class="text"></div>
                    </div>

                </div>
                <br>

                <div style="text-align:center">
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                    <span class="dot"></span> 
                </div>
            </div>
            <script src ="js/showslides.js"></script>





            <div id="central">

                <div class="sidebar-container">
                    <div class="sidebar">
                        <div class="filter">
                            <br>
                            IZABERITE BREND
                            <br><br><br>
                            <% ArrayList<Brend> brend = Upiti.getBrend();
                                for (int i = 0; i < brend.size(); i++) {
                                    out.println("<div id='string-brend'>"
                                            + "<li>"
                                            + "<a onclick='ucitajModele("
                                            + brend.get(i).getId_brenda()
                                            + ")' "
                                            + "href='javascript:void(0)'>" + brend.get(i).getNaziv()
                                            + "</a></li></div>");
                                }
                            %>
                            <br>
                        </div>
                        <div id="modeli" class="filter2">
                        </div>
                    </div>
                    <script src ="js/modeli.js"></script>
                </div>


                <div id="main">

                    <%@include file="oNama.jsp"%>

                </div>

            </div> <!-- end of central-->
            <script src ="js/samePage.js"></script>
            <br>
            <br>

            <%@include file="footer.jsp"%>


        </div> <!-- end of #wrapper -->

    </body>

</html>