<%-- 
    Document   : kontakt
    Created on : Jul 2, 2018, 1:34:07 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.contact-container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    margin-top: 15px;
}
</style>

<div class="contact-container" style="width: 60%; margin: 0 auto; border: 1px solid #000; margin-top: 15px;">
    <form action="ServletKontakt" method="post">

    <label for="ime">Ime</label>
    <input type="text" id="ime" placeholder="Vaše ime..." name="ime">

    <label for="prezime">Prezime</label>
    <input type="text" id="prezime" placeholder="Vaše prezime..." name="prezime">
    
    <label for="email">e-mail</label>
    <input type="text" id="email" placeholder="Vaš email..." name="email">

    <!--<label for="city">Grad</label>
    <select id="city" name="city">
      <option value="beograd">Beograd</option>
      <option value="novisad">Novi Sad</option>
      <option value="nis">Niš</option>
      <option value="cacak">Čačak</option>
    </select>-->

    <label for="pitanje">Pitanje:</label>
    <textarea id="subject" placeholder="Napišite Vaše pitanje..."  name="pitanje" style="height:200px"></textarea>

    <input type="submit" value="Pošaljite!">

  </form>
</div>