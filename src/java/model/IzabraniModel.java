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
@Table (name = "izabrani_model")
public class IzabraniModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_izabranog_modela;
    private int kolicina;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_korpe")
    private Korpa korpa;
	
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modela")
    private Model model;

    public IzabraniModel() {
    }

    public IzabraniModel(int id_izabranog_modela, int kolicina) {
        this.id_izabranog_modela = id_izabranog_modela;
        this.kolicina = kolicina;
    }

    public IzabraniModel(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getId_izabranog_modela() {
        return id_izabranog_modela;
    }

    public void setId_izabranog_modela(int id_izabranog_modela) {
        this.id_izabranog_modela = id_izabranog_modela;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    @Override
    public String toString() {
        return "IzabraniModel{" + "id_izabranog_modela=" + id_izabranog_modela + ", kolicina=" + kolicina + '}';
    }
   
}
