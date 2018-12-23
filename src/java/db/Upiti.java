/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Brend;
import model.Karakteristike;
import model.Korisnik;
import model.Korpa;
import model.Model;
import model.Model_Karakteristike;

/**
 *
 * @author Srcko
 */
public class Upiti {

    public static int getIdKorisnika(String username, String password) {
        Connection baza = DbConnection.getConn();
        int id_korisnika = -1;
        String upit = "select id_korisnika from korisnik where username=? and password=?;";
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id_korisnika = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_korisnika;
    }

    public static int getIdKorisnika(String username) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "select id_korisnika from korisnik where username='" + username + "';";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(upit);
        rs.next();
        int id = rs.getInt(1);

        return id;
    }

    /*
    BREND BREND BREND
     */
    public static Brend selectBrend(int id_brenda) {
        Brend brend = null;
        String sql = "select * from brend where id_brenda=?;";
        Connection conn = DbConnection.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_brenda);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                brend = new Brend();
                brend.setId_brenda(id_brenda);
                brend.setNaziv(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return brend;
    }

    public static ArrayList<Brend> getBrend() {
        ArrayList<Brend> brend = new ArrayList<Brend>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from brend;";
        try {
            Statement st = baza.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id_brenda = rs.getInt(1);
                String naziv = rs.getString(2);
                Brend novi = new Brend(id_brenda, naziv);
                brend.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brend;
    }

    /*
    MODEL MODEL MODEL
     */
    public static ArrayList<Model> getModelByBrend(int id_brenda) {
        ArrayList<Model> model = new ArrayList<Model>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from model where id_brenda=?;";
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, id_brenda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_modela = rs.getInt(1);
                String naziv = rs.getString(2);
                double cena = rs.getDouble(3);
                String slika = rs.getString(4);
                Model novi = new Model(id_modela, naziv, cena, slika);
                model.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public static ArrayList<Model> getModelsById(int id_modela) {
        ArrayList<Model> model = new ArrayList<Model>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from model where id_modela=?;";
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, id_modela);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String naziv = rs.getString(1);
                double cena = rs.getDouble(2);
                String slika = rs.getString(3);
                Model novi = new Model(naziv, cena, slika);
                model.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public static ArrayList<Model> getAllModels() {
        ArrayList<Model> model = new ArrayList<Model>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from model;";
        try {
            Statement st = baza.prepareStatement(upit);
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id_modela = rs.getInt(1);
                String naziv = rs.getString(2);
                double cena = rs.getDouble(3);
                String slika = rs.getString(4);
                Model novi = new Model(id_modela, naziv, cena, slika);
                model.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    /*public static Model selectModel(int id_modela) {
        Model model = null;
        String sql = "select * from model where id_modela=?;";
        Connection conn = DbConnection.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_modela);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model = new Model();
                model.setId_modela(id_modela);
                model.setNaziv(rs.getString(2));
                model.setCena(rs.getDouble(3));
                model.setKolicina(rs.getInt(4));
                model.setSlika(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return model;
    }*/
    public static Model getAllInfoModel(String naziv, double cena, int kolicina, String slika) {
        Connection baza = DbConnection.getConn();
        Model novi = new Model();

        int id_modela = -1;
        String upit = "select * from model where naziv=? and cena=? and slika=?;";

        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setString(1, naziv);
            ps.setDouble(2, cena);
            ps.setString(3, slika);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                novi.setId_modela(rs.getInt(1));
                novi.setNaziv(rs.getString(2));
                novi.setCena(rs.getDouble(3));
                novi.setSlika(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novi;
    }

    public static ArrayList<Karakteristike> getKarakteristike() {
        ArrayList<Karakteristike> karakteristike = new ArrayList<Karakteristike>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from karakteristike;";
        try {
            Statement st = baza.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id_karakteristike = rs.getInt(1);
                String naziv = rs.getString(2);
                Karakteristike nova = new Karakteristike(id_karakteristike, naziv);
                karakteristike.add(nova);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return karakteristike;
    }

    public static ArrayList<Korpa> getAllKById(int idkorpe) {
        ArrayList<Korpa> korpe = new ArrayList<Korpa>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from korpa where id_korpe=?;";
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idkorpe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int kolicina = rs.getInt(1);
                Korpa novi = new Korpa(kolicina);
                korpe.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korpe;
    }

    public static ArrayList<Korpa> getSveKorpe() {
        ArrayList<Korpa> korpe = new ArrayList<Korpa>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from korpa;";
        try {
            Statement st = baza.prepareStatement(upit);
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id_korpe = rs.getInt(1);
                int kolicina = rs.getInt(2);
                Korpa nova = new Korpa(id_korpe, kolicina);
                korpe.add(nova);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korpe;
    }

    public static ArrayList<Korisnik> getKorisnik() {
        ArrayList<Korisnik> korisnik = new ArrayList<Korisnik>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from korisnik;";
        try {
            Statement st = baza.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id_korisnika = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                Korisnik novi = new Korisnik(id_korisnika, username, password);
                korisnik.add(novi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnik;
    }

    /*
    KORPA KORPA KORPA
     */
    public static int najveciIdKorpe(int id_korisnika) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "SELECT MAX(id_korpe) FROM korpa WHERE id_korisnika=" + id_korisnika + ";";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(upit);
        rs.next();
        int id = rs.getInt(1);

        return id;
    }
    
    public static void dodajUIzabraneModele(int id_modela, int id_korpe) throws SQLException {
        Connection conn = DbConnection.getConn();
        Model m = new Model();
        String upit = "INSERT INTO izabrani_model (id_modela, id_korpe) values(" + id_modela + "," + id_korpe + ");";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.executeUpdate();
        ps.close();
    }
    
    public static void obrisiIzKorpe(int id_izabranog_modela) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "DELETE FROM izabrani_model WHERE id_izabranog_modela=" + id_izabranog_modela + ";";

        PreparedStatement ps = conn.prepareStatement(upit);
        ps.executeUpdate();
        ps.close();
    }
    
    public static void upisiCenu(int id_korpe, double cena) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "UPDATE korpa SET ukupna_cena=" + cena + " WHERE id_korpe=" + id_korpe + ";";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.executeUpdate();
        ps.close();
    }
    
    public static void updateujCenu(int id_korpe) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "UPDATE korpa SET ukupna_cena=0.0  WHERE id_korpe=" + id_korpe + ";";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.executeUpdate();
        ps.close();
    }
    
    public static void kreiranjeNoveKorpe(int id_korisnika) throws SQLException {
        Connection conn = DbConnection.getConn();
        Korpa korpa = new Korpa();
        String upit = "insert into korpa (id_korisnika) values (?);";
        PreparedStatement ps = conn.prepareStatement(upit);
        ps.setInt(1, id_korisnika);
        ps.executeUpdate();
        ps.close();
    }

    public static int getIdKorpe(int id_korisnika) throws SQLException {
        Connection conn = DbConnection.getConn();
        String upit = "select id_korpe from korpa where id_korisnika=" + id_korisnika + ";";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(upit);
        rs.next();
        int id = rs.getInt(1);

        return id;
    }
    
    public static ArrayList<Model_Karakteristike> getModelKarakteristike() {
        ArrayList<Model_Karakteristike> mk = new ArrayList<Model_Karakteristike>();
        Connection baza = DbConnection.getConn();
        String upit = "select * from model_karakteristike;";
        try {
            Statement st = baza.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                String vrednost = rs.getString(1);
                Model_Karakteristike nova = new Model_Karakteristike(vrednost);
                mk.add(nova);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mk;
    }

}
