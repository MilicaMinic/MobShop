function ucitajModele(id_brenda) {
    var zahtev = new XMLHttpRequest();
    zahtev.open("GET", "ServletModeli?id=" + id_brenda);
    zahtev.send();
    /*setTimeout(function(){
     document.getElementById("proizvodi").innerText=zahtev.responseText;  
     }, 6000);*/
    zahtev.onreadystatechange =
            function () {
                if (zahtev.readyState === 4) {
                    //var modeli = JSON.parse(zahtev.responseText);
                    //zahtev.responseType = "document";
                    document.getElementById("modeli").innerHTML = zahtev.response;                   
                }    
            };
}

function otvoriModel(id_modela) {
    
    var zahtev = new XMLHttpRequest();
    zahtev.open("GET", "ServletModel?id=" + id_modela);
    zahtev.send();
    /*setTimeout(function(){
     document.getElementById("proizvodi").innerText=zahtev.responseText;  
     }, 6000);*/
    zahtev.onreadystatechange =
            function () {
                if (zahtev.readyState === 4) {
                    //var modeli = JSON.parse(zahtev.responseText);
                    //zahtev.responseType = "document"; 
                    document.getElementById("main").style.height='auto';
                    document.getElementById("main").innerHTML = zahtev.response;
                }    
            };
}
