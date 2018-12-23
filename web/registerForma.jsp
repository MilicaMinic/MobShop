<%-- 
    Document   : registerForma
    Created on : Jun 26, 2018, 12:38:06 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <form action="UserRegister" method="post" style="margin: 0 auto; border: 1px solid black; margin: 100px; padding: 30px;">
                    <div class="login-container" style="clear: both; margin: 0 auto; padding: 10px; border: 1px solid black; width: 40%;">
                        <label for="ime"><b>Ime</b></label>
                        <input type="text" placeholder="Unesite Vaše ime" name="ime" required>
                        <br><br>
                        <label for="prezime"><b>Prezime</b></label>
                        <input type="text" placeholder="Unesite Vaše prezime" name="prezime" required>
                        <br><br>
                        <label for="adresa"><b>Adresa</b></label>
                        <input type="text" placeholder="Unesite Vaše adresu" name="adresa" required>
                        <br><br>
                        <label for="username"><b>Username</b></label>
                        <input type="text" placeholder="Unesite username" name="username" required>
                        <br><br>
                        <label for="password"><b>Password</b></label>
                        <input type="password" placeholder="Unesite password" name="password" required>
                        <br><br>
                        <input style="margin: 0 auto; width: 30%;" type="submit" value="Register" class="btn">
                        <br><br>
                        <p class="message">Već imate nalog? <a href="loginForma.jsp">Ulogujte se</a></p>
                    </div>
                </form>
            </div>

            <%@include file="footer.jsp"%>


        </div> <!-- end of #wrapper -->

    </body>

</html>