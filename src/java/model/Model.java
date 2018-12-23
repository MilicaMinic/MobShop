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
@Table (name = "model", uniqueConstraints = {@UniqueConstraint(columnNames = {"naziv"})})
public class Model {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_modela;
    @Column (unique = true)
    private String naziv;
    private double cena;
    private String slika;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_brenda", nullable = false)
    private Brend brend;
    
    @OneToMany(mappedBy = "model")
    private List<Model_Karakteristike> listaMKarakteristike = new ArrayList();
    
    @OneToMany(mappedBy = "model")
    private List<IzabraniModel> listaIzabranihModela = new ArrayList();

    public Model() {
    }

    public Model(int id_modela, String naziv, double cena, String slika) {
        this.id_modela = id_modela;
        this.naziv = naziv;
        this.cena = cena;
        this.slika = slika;
    }

    public Model(String naziv, double cena, String slika) {
        this.naziv = naziv;
        this.cena = cena;
        this.slika = slika;
    }

    public Model(String naziv, double cena, String slika, Brend brend) {
        this.naziv = naziv;
        this.cena = cena;
        this.slika = slika;
        this.brend = brend;
    }

    public Brend getBrend() {
        return brend;
    }

    public void setBrend(Brend brend) {
        this.brend = brend;
    }
    
    public List<Model_Karakteristike> getListaMKarakteristike() {
        return listaMKarakteristike;
    }

    public void setListaMKarakteristike(List<Model_Karakteristike> listaMKarakteristike) {
        this.listaMKarakteristike = listaMKarakteristike;
    }

    public List<IzabraniModel> getListaIzabranihModela() {
        return listaIzabranihModela;
    }

    public void setListaIzabranihModela(List<IzabraniModel> listaIzabranihModela) {
        this.listaIzabranihModela = listaIzabranihModela;
    }
   
    public int getId_modela() {
        return id_modela;
    }

    public void setId_modela(int id_modela) {
        this.id_modela = id_modela;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public String toString() {
        //return "{\"id_modela\":" + id_modela + ", \"naziv\":\"" + naziv + "\", \"cena\":" + cena + ", \"kolicina\":" + kolicina + "}";
        
            return "<div id='string-model'>"
                + "<li>"
                + "<a onclick='otvoriModel("
                + id_modela
                + ")' "
                + "href='javascript:void(0)'>" + naziv
                + "</a></li></div>";
    }
}
