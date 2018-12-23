/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;
import model.Karakteristike;
import model.Model;

/**
 *
 * @author Srcko
 */
@Entity
@Table (name = "model_karakteristike")
public class Model_Karakteristike {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String vrednost;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_modela", nullable = false)
    private Model model;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_karakteristike", nullable = false)
    private Karakteristike karakteristike;

    public Model_Karakteristike() {
    }

    public Model_Karakteristike(String vrednost) {
        this.vrednost = vrednost;
    }
    
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Karakteristike getKarakteristike() {
        return karakteristike;
    }

    public void setKarakteristike(Karakteristike karakteristike) {
        this.karakteristike = karakteristike;
    }
    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }
    
    @Override
    public String toString() {
        return "Model_Karakteristike{" + "Vrednost=" + vrednost + '}';
    }

}
