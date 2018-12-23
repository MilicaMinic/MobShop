/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepare;

import db.DbConnection;
import db.Upiti;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IzabraniModel;
import model.Korisnik;
import model.Korpa;
import model.Model;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Srcko
 */
public class Prikaz {

    public static String prikazKorisnika() {
        ArrayList<Korisnik> korisnici = Upiti.getKorisnik();
        String rez = "<table border='2px solid black'>\n"
                + "<tr>"
                + "<th>Id</th>"
                + "<th>Username</th>"
                + "</tr>";
        for (int i = 0; i < korisnici.size(); i++) {
            rez
                    += "<tr>"
                    + "<td style='text-align:center'>" + korisnici.get(i).getId_korisnika() + "</td>\n"
                    + "<td>" + korisnici.get(i).getUsername() + "</td>\n"
                    + "</tr>";
        }
        rez += "</table> ";

        return rez;
    }

    public static String getBrend() {
        String rez = "<table width='50%' border='1px solid' >\n"
                + "<tr>"
                + "<th>IdBrenda</th>"
                + "<th>Naziv</th>"
                + "</tr>";
        Connection baza = DbConnection.getConn();
        String upit = "select * from brend order by id_brenda";
        try {
            Statement ps = baza.createStatement();
            ResultSet rs = ps.executeQuery(upit);

            while (rs.next()) {
                rez += "<tr>";
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    rez += "<td>";
                    rez += rs.getString(i);
                    rez += "</td>";

                }
                rez += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }

        rez += "</table>";
        return rez;
    }

    public static String getModel() {
        String rez = "<table width='50%' border='1px solid' >\n"
                + "<tr>"
                + "<th>Id Modela</th>"
                + "<th>Naziv</th>"
                + "<th>Cena</th>"
                + "<th>Slika</th>"
                + "<th>Id Brenda</th>"
                + "</tr>";
        Connection baza = DbConnection.getConn();
        String upit = "select * from model order by naziv";
        try {
            Statement ps = baza.createStatement();
            ResultSet rs = ps.executeQuery(upit);

            while (rs.next()) {
                rez += "<tr>";
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    rez += "<td>";
                    rez += rs.getString(i);
                    rez += "</td>";

                }
                rez += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }

        rez += "</table>";
        return rez;
    }

    public static String getKarakteristike() {
        String rez = "<table width='100%' 1px solid >\n"
                + "<tr>"
                + "<th>Id</th>"
                + "<th>Naziv</th>"
                + "</tr>";
        Connection baza = DbConnection.getConn();
        String upit = "select vrednost from model_karakteristike;";
        try {
            Statement ps = baza.createStatement();
            ResultSet rs = ps.executeQuery(upit);

            while (rs.next()) {
                rez += "<tr>";
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    rez += "<td>";
                    rez += rs.getString(i);
                    rez += "</td>";

                }
                rez += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }

        rez += "</table>";
        return rez;
    }

    public static double ukupnaCena(int id_korisnika) throws SQLException {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesija.beginTransaction();
        int id_korpe = Upiti.najveciIdKorpe(id_korisnika);
        ArrayList<IzabraniModel> izabraniModeli = (ArrayList<IzabraniModel>) sesija.createSQLQuery("SELECT * FROM izabrani_model where id_korpe=" + id_korpe + ";").
                addEntity(IzabraniModel.class).list();

        double ukupnaCena = 0;
        for (IzabraniModel pom : izabraniModeli) {
            ukupnaCena = ukupnaCena + pom.getModel().getCena();

        }

        sesija.getTransaction().commit();
        if (sesija.isOpen()) {
            sesija.close();
        }

        return ukupnaCena;
    }

    public static String izlistajIzabraneModele(int id_korisnika) throws SQLException {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesija.beginTransaction();
        int id_korpe = Upiti.najveciIdKorpe(id_korisnika);

        ArrayList<IzabraniModel> izabraniModeli
                = (ArrayList<IzabraniModel>) sesija.createSQLQuery
                    ("SELECT * FROM izabrani_model where id_korpe=" + id_korpe + ";").
                        addEntity(IzabraniModel.class).list();

        String rez = " ";
        for (IzabraniModel pom : izabraniModeli) {
            rez += " <div id='prikazkorpe'> "
                    + pom.getModel().getNaziv() + " |"
                    + " Cena:" + pom.getModel().getCena() + " |"
                    + "<a href=\"ServletBrisanjeIzKorpe?idOM=" + pom.getId_izabranog_modela() + "\"> Obrisati iz korpe? "
                    + "</a> "
                    + "</div> ";
        }

        sesija.getTransaction().commit();
        if (sesija.isOpen()) {
            sesija.close();
        }
        return rez;
    }

    public static String izlistajIzabraneModelePoKorpaId(int id_korpe) throws SQLException {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesija.beginTransaction();

        ArrayList<IzabraniModel> izabraniModeli
                = (ArrayList<IzabraniModel>) sesija.createSQLQuery("SELECT * FROM izabrani_model where id_korpe=" + id_korpe + ";").
                        addEntity(IzabraniModel.class).list();

        String rez = " ";
        for (IzabraniModel pom : izabraniModeli) {
            rez += " <td> "
                    + pom.getModel().getNaziv() + "</td>";
        }

        sesija.getTransaction().commit();
        if (sesija.isOpen()) {
            sesija.close();
        }
        return rez;
    }

    public static String izlistajPorudzbine() throws SQLException {
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sesija.beginTransaction();

        ArrayList<Korpa> porudzbine
                = (ArrayList<Korpa>) sesija.createSQLQuery("SELECT * FROM korpa WHERE ukupna_cena>0;").
                        addEntity(Korpa.class).list();

        String rez = " ";
        double ukupnaCena = 0;
        for (Korpa pom : porudzbine) {
            rez += "<div id='cart'>"
                    + "<table> <tr> "
                    + "<td>" + pom.getId_korpe() + "</td>"
                    + "<td> Podaci za dostavu: </td>"
                    + "<td> Ukupna cena: " + pom.getUkupna_cena() + "</td>"
                    + "<td> Korisnik: " + pom.getKorisnik().getUsername() + "</td>"
                    + "<td> Adresa: " + pom.getKorisnik().getAdresa() + "</td>"
                    + "</tr>"
                    + "<tr>" + "<td></td>"
                    + "<td> Artikli za dostavu:" + Prikaz.izlistajIzabraneModelePoKorpaId(pom.getId_korpe()) + "</td>"
                    + "<td> <a href=\"Transactions?id_korpe=" + pom.getId_korpe() + "\"> Poslato </a> </td> </tr>"
                    + "</table>"
                    + "</div>";

        }

        sesija.getTransaction().commit();
        if (sesija.isOpen()) {
            sesija.close();
        }

        return rez;
    }

}
