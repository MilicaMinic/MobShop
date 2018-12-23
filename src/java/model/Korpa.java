/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Srcko
 */
@Entity
@Table (name = "korpa")
public class Korpa {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_korpe;
    private int ukupna_cena;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_korisnika", nullable = false)
    private Korisnik korisnik;

    @OneToMany(mappedBy = "korpa")
    private List<IzabraniModel> listaIzabranihModela = new ArrayList();
    

    public Korpa() {
    }

    public Korpa(int id_korpe, int ukupna_cena) {
        this.id_korpe = id_korpe;
        this.ukupna_cena = ukupna_cena;
    }

    public Korpa(int ukupna_cena) {
        this.ukupna_cena = ukupna_cena;
    }

    public int getId_korpe() {
        return id_korpe;
    }

    public void setId_korpe(int id_korpe) {
        this.id_korpe = id_korpe;
    }

    public int getUkupna_cena() {
        return ukupna_cena;
    }

    public void setUkupna_cena(int ukupna_cena) {
        this.ukupna_cena = ukupna_cena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<IzabraniModel> getListaIzabranihModela() {
        return listaIzabranihModela;
    }

    public void setListaIzabranihModela(List<IzabraniModel> listaIzabranihModela) {
        this.listaIzabranihModela = listaIzabranihModela;
    }

    @Override
    public String toString() {
        return "Korpa{" + "id_korpe=" + id_korpe + ", ukupna_cena=" + ukupna_cena + ", korisnik=" + korisnik + '}';
    }

    public void setInt(int i, int id_korisnika) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
