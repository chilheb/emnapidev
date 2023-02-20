/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Pharmacien;
import Entities.ProfSante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Tools.MyConnection;

/**
 *
 * @author DELL
 */
public class CRUDProfSante {
     public void addProfSante(ProfSante P) {
        try {
                String requete = "INSERT INTO prof_sante (Nom,Phone,Email,Adresse,Titre,Mdp)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomProfS());
            pst.setInt(2, P.getPhoneProfS());
            pst.setString(3, P.getEmailProfS());
            pst.setString(4, P.getAdrProfS());
             pst.setString(5,P.getTitreProfS());
             pst.setString(6, P.getMdp());
            pst.executeUpdate();

            System.out.println("Professionnel de santé  ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDProfSante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<ProfSante> showProfSante() {
        ObservableList<ProfSante> list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM prof_sante";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {   
           
                list.add(new ProfSante(rs.getString("nomProfS"),rs.getInt("phoneProfS"),rs.getString("emailProfS") ,rs.getString("AdrProfS") ,rs.getString("titreProfS"),"ProfSante", rs.getString("Mdp"))); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDProfSante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editProfSante(ProfSante P) {
        try {

            String requete = "UPDATE prof_sante  Nom= ? ,Phone= ? ,Email = ? ,Adresse= ? " ; 
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomProfS());
            pst.setInt(2, P.getPhoneProfS());
            pst.setString(3, P.getEmailUser());
            pst.setString(4, P.getAdrProfS());
          
        
            pst.executeUpdate();

            System.out.println("Professionnel de sante modifié!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDProfSante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteProfSante(int Phone) {

        try {
            String requete = "DELETE FROM prof_sante WHERE Phone = ?";
            PreparedStatement pst   = new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1,Phone);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDProfSante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
