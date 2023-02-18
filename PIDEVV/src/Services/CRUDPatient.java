/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Patient;
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
public class CRUDPatient {
   public void addPatient(Patient P) {
        try {
            String requete = "INSERT INTO patient (Nom,Photo,Phone,Email,Adresse)" + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomPatient());
            pst.setString(2, P.getPhotoPatient());
            pst.setInt(3, P.getPhonePatient());
            pst.setString(4, P.getEmailPatient());
            pst.setString(5, P.getAdrPatient());
          
            pst.executeUpdate();

            System.out.println("Patient ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Patient> showPatient() {
        ObservableList<Patient> list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM patient";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                
                list.add(new Patient(rs.getString("nomPatient"),rs.getString("photoPatient"),rs.getInt("phonePatient"),rs.getString("emailPatient"),rs.getString("AdrPatient"),rs.getString("RoleUser"))); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editPatient(Patient P) {
        try {

            String requete = "UPDATE patient  Nom= ? ,Photo= ? ,Phone= ? ,Email = ? ,Adresse= ? " ; 
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomPatient());
            pst.setString(2, P.getPhotoPatient());
            pst.setInt(3, P.getPhonePatient());
            pst.setString(4, P.getEmailPatient());
            pst.setString(5, P.getAdrPatient());
            
        
            pst.executeUpdate();

            System.out.println("Patient modifiée!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletePatient(int Phone) {

        try {
            String requete = "DELETE FROM patient WHERE Phone = ?";
            PreparedStatement pst   = new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, Phone);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}  
