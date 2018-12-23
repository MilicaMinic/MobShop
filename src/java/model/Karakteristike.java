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
@Table (name = "karakteristike")
public class Karakteristike {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_karakteristike;
    private String naziv;
    
    @OneToMany(mappedBy = "karakteristike")
    private List<Model_Karakteristike> listaMKarakteristika = new ArrayList();

    public Karakteristike() {
    }

    public Karakteristike(int id_karakteristike, String naziv) {
        this.id_karakteristike = id_karakteristike;
        this.naziv = naziv;
    }
    
    public List<Model_Karakteristike> getListaMKarakteristika() {
        return listaMKarakteristika;
    }

    public void setListaMKarakteristika(List<Model_Karakteristike> listaMKarakteristika) {
        this.listaMKarakteristika = listaMKarakteristika;
    }

    public Karakteristike(String naziv) {
        this.naziv = naziv;
    }

    public int getId_karakteristike() {
        return id_karakteristike;
    }

    public void setIdikarakteristike(int id_karakteristike) {
        this.id_karakteristike = id_karakteristike;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Karakteristike{" + "id_karakteristike=" + id_karakteristike + ", Naziv=" + naziv + '}';
    }
    
    
}
