/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import db.Upiti;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Brend;
import model.IzabraniModel;
import model.Karakteristike;
import model.Korisnik;
import model.Korpa;
import model.Model;
import model.Model_Karakteristike;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Srcko
 */
public class HibernateToJava {

    public static ArrayList<Brend> getBrendId(int id) {
        ArrayList<Brend> brend = new ArrayList<Brend>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesija = sf.openSession();
        sesija.beginTransaction();
        Brend novi = (Brend) sesija.load(Brend.class, new Integer(id));
        System.out.println("novi " + novi);
        brend.add(novi);
        sesija.getTransaction().commit();
        if (sesija != null) {
            sesija.close();
        }
        return brend;
    }

    public static ArrayList<Brend> getAllBrend() {
        ArrayList<Brend> brendovi = new ArrayList<Brend>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            brendovi = (ArrayList<Brend>) sesija.createCriteria(Brend.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return brendovi;
    }

    public static ArrayList<Model> getModelId(int id) {
        ArrayList<Model> model = new ArrayList<Model>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesija = sf.openSession();
        sesija.beginTransaction();
        Model novi = (Model) sesija.load(Model.class, new Integer(id));
        System.out.println("novi " + novi);
        model.add(novi);
        sesija.getTransaction().commit();
        if (sesija != null) {
            sesija.close();
        }
        return model;
    }

    public static ArrayList<Model> getAllModels() {
        ArrayList<Model> modeli = new ArrayList<Model>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            modeli = (ArrayList<Model>) sesija.createCriteria(Model.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return modeli;
    }

    public static ArrayList<Karakteristike> getAllKarakteristike() {
        ArrayList<Karakteristike> karakteristike = new ArrayList<Karakteristike>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            karakteristike = (ArrayList<Karakteristike>) sesija.createCriteria(Karakteristike.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return karakteristike;
    }

    public static ArrayList<Korisnik> getKorisnikId(int id_korisnika) {
        ArrayList<Korisnik> k = new ArrayList<Korisnik>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Korisnik k1 = (Korisnik) s.load(Korisnik.class, new Integer(id_korisnika));
        System.out.println("k1 " + k1);
        k.add(k1);
        s.getTransaction().commit();
        if (s != null) {
            s.close();
        }
        return k;
    }

    public static ArrayList<Korisnik> getAllKorisnike() {
        ArrayList<Korisnik> korisnik = new ArrayList<Korisnik>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            korisnik = (ArrayList<Korisnik>) sesija.createCriteria(Korisnik.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return korisnik;
    }


    public static ArrayList<Korpa> getAllKorpa() {
        ArrayList<Korpa> list = new ArrayList<Korpa>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            list = (ArrayList<Korpa>) sesija.createCriteria(Korpa.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return list;
    }

    public static ArrayList<Model_Karakteristike> getAllModelKarakteristike() {
        ArrayList<Model_Karakteristike> list = new ArrayList<Model_Karakteristike>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesija = sf.openSession();
            list = (ArrayList<Model_Karakteristike>) sesija.createCriteria(Model_Karakteristike.class).list();
            if (sesija != null) {
                sesija.close();
            }
        } catch (Exception e) {

        }
        return list;
    }

}