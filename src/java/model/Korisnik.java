package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "korisnik")
public class Korisnik {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_korisnika;
    private String ime;
    private String prezime;
    private String adresa;
    private String username;
    private String password;
    
    @OneToMany(mappedBy = "korisnik")
    private List<Korpa> listaKorpe = new ArrayList();

    public Korisnik() {
    }

    public Korisnik(int id_korisnika, String ime, String prezime, String adresa, String username, String password) {
        this.id_korisnika = id_korisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.username = username;
        this.password = password;
    }

    public Korisnik(String ime, String prezime, String adresa, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.username = username;
        this.password = password;
    }

    public Korisnik(int id_korisnika, String username, String password) {
        this.id_korisnika = id_korisnika;
        this.username = username;
        this.password = password;
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public int getId_korisnika() {
        return id_korisnika;
    }

    public void setId_korisnika(int id_korisnika) {
        this.id_korisnika = id_korisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Korpa> getListaKorpe() {
        return listaKorpe;
    }

    public void setListaKorpe(List<Korpa> listaKorpe) {
        this.listaKorpe = listaKorpe;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id_korisnika=" + id_korisnika + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", username=" + username + ", password=" + password + '}';
    }

    
}
