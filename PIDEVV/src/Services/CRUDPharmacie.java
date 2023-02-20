/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Pharmacie;
import Entities.Pharmacien;
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
public class CRUDPharmacie {
  public void addPharmacie(Pharmacie P) {
        try {
                String requete = "INSERT INTO pharmacie(Nom,Emplacement,NumTel)" + "VALUES (?,?,?)";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomPharmacie());
            pst.setString(2, P.getEmplacement());
            pst.setInt(3,P.getNumTel());
           
            pst.executeUpdate();

            System.out.println("Pharmacie ajoutée!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPharmacie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Pharmacie> showPharmacie() {
        ObservableList<Pharmacie> list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM pharmacie";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                
                list.add(new Pharmacie(rs.getString("nomPharmacie"),rs.getString("Emplacement"),rs.getInt("numTel"))); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDPharmacie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editPharmacien(Pharmacie P) {
        try {

            String requete = "UPDATE pharmacie  Nom= ? ,Emplacement = ? ,NumTel= ?  " ; 
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomPharmacie());
            pst.setString(2, P.getEmplacement());
            pst.setInt(3, P.getNumTel());
          
            
        
            pst.executeUpdate();

            System.out.println("Pharmacie modifiée!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDPharmacie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletePharmacie(String Emplacement) {

        try {
            String requete = "DELETE FROM pharmacie WHERE Emplacement = ?";
            PreparedStatement pst   = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1,Emplacement);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPharmacie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  
}
