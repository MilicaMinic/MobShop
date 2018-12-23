/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author Srcko
 */
@Entity
@Table (name = "kontakt")
public class Kontakt {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_kontakta;
    private String ime;
    private String prezime;
    private String email;
    private String pitanje;

    public Kontakt() {
    }

    public Kontakt(int id_kontakta, String ime, String prezime, String email, String pitanje) {
        this.id_kontakta = id_kontakta;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.pitanje = pitanje;
    }

    public Kontakt(String ime, String prezime, String email, String pitanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.pitanje = pitanje;
    }

    public int getId_kontakta() {
        return id_kontakta;
    }

    public void setId_kontakta(int id_kontakta) {
        this.id_kontakta = id_kontakta;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    @Override
    public String toString() {
        return "Kontakt{" + "id_kontakta=" + id_kontakta + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", pitanje=" + pitanje + '}';
    }

}
