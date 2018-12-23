/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "brend", uniqueConstraints = {@UniqueConstraint(columnNames = {"naziv"})})
public class Brend {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_brenda;
    @Column (unique = true)
    private String naziv;
    
    @OneToMany(mappedBy = "brend")
    private List<Model> listaModela = new ArrayList(); 
    
    public Brend() {
    }

    public Brend(String naziv) {
        this.naziv = naziv;
    }

    public Brend(int id_brenda, String naziv) {
        this.id_brenda = id_brenda;
        this.naziv = naziv;
    }
    
    public List<Model> getListaModela() {
        return listaModela;
    }

    public void setListaModela(List<Model> listaModela) {
        this.listaModela = listaModela;
    }

    public int getId_brenda() {
        return id_brenda;
    }

    public void setId_brenda(int id_brenda) {
        this.id_brenda = id_brenda;
    }
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Brend{" + "naziv=" + naziv + '}';
    }
    
    
}
