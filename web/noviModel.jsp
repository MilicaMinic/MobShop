<%-- 
    Document   : noviTelefon
    Created on : Jul 10, 2018, 11:52:10 PM
    Author     : Srcko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-6">
    <h2>Unesi novi model u bazu:</h2>
    <form action="ServletUnosNovogModela" method="post" style="border: 1px solid; text-align: center; padding: 10px;" >
        <div class="form-group">
            
            <label for="ImeModela">Naziv modela: </label>
            <input type="text" name="naziv" class="form-control" id="ImeModela">
            
            <label for="Cena">Cena: </label>
            <input type="text" name="cena" class="form-control" id="cena">
            
            <label for="slika">Slika: </label>
            <input type="text" name="slika" class="form-control" id="slika">
            
            <label for="id_brenda">IdBrenda: </label>
            <input type="text" name="id_brenda" class="form-control" id="id_brenda">
            <div class="logdugme">
            <input type="submit" value="Dodaj telefon">
        </div>
    </form>
</div>
    
            
           <!-- <label for="Karakteristike">Karekteristike: </label>
            
            <label for="Procesor">Procesor: </label>
            <input type="text" name="vrednost" class="form-control" id="procesor" required>
            
            <label for="RAM">RAM: </label>
            <input type="text" name="vrednost" class="form-control" id="ram" required>
            
            <label for="VelicinaEkrana">Velicina ekrana: </label>
            <input type="text" name="vrednost" class="form-control" id="velicinaekrana" required>
            
            <label for="Rezolucija">Rezolucija: </label>
            <input type="text" name="vrednost" class="form-control" id="rezolucija" required>
            
            <label for="Kamera">Kamera: </label>
            <input type="text" name="vrednost" class="form-control" id="kamera" required>
            
            <label for="Memorija">Memorija: </label>
            <input type="text" name="vrednost" class="form-control" id="memorija" required>
            
            <label for="Baterija">Baterija: </label>
            <input type="text" name="vrednost" class="form-control" id="baterija" required>-->
        </div>
        
