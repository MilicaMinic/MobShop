<%-- 
    Document   : noviTelefon
    Created on : Jul 10, 2018, 11:52:10 PM
    Author     : Srcko
--%>

<%@page import="prepare.Prikaz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-6">
    <h2>Unesi novi brend u bazu:</h2>
    <form action="ServletUnosNovogBrenda" method="post" style="border: 1px solid; text-align: center; padding: 10px;" >
        <div class="form-group">
            
            <label for="ImeBrenda">Naziv brenda: </label>
            <input type="text" name="naziv" class="form-control" id="ImeBrenda">
            
            <div class="logdugme">
            <input type="submit" value="Dodaj brend">
        </div>
    </form>
</div>
    <div class="tabelabrendova">
        <%= Prikaz.getBrend()%>
</div>
</div>
          
        
