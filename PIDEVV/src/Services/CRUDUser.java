/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ProfSante;
import Entities.User;
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
public class CRUDUser {
     public void addUser(User P) {
        try {
                String requete = "INSERT INTO user (Nom,Photo,Phone,Email,Adresse,Role)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomUser());
            pst.setString(2, P.getPhotoUser());
            pst.setInt(3, P.getPhoneUser());
            pst.setString(4,P.getEmailUser());
            pst.setString(5, P.getAdrUser());
            pst.setString(6, P.getRoleUser());
            pst.executeUpdate();

            System.out.println("Utilisateur  ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<User> showUser() {
        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM user";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                
                list.add(new User(rs.getString("nomUser"),rs.getString("photoUser"),rs.getInt("phoneUser"),rs.getString("emailUser"),rs.getString("AdrUser"),rs.getString("RoleUser"))); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editUser(User P) {
        try {

            String requete = "UPDATE user  Nom= ? ,Photo= ? ,Phone= ? ,Email = ? ,Adresse= ? , Role= ?" ; 
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomUser());
            pst.setString(2, P.getPhotoUser());
            pst.setInt(3, P.getPhoneUser());
            pst.setString(4,P.getEmailUser());
            pst.setString(5, P.getAdrUser());
            pst.setString(6, P.getRoleUser());
            
        
            pst.executeUpdate();

            System.out.println("Utilisateur modifié!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int Phone) {

        try {
            String requete = "DELETE FROM user WHERE Phone = ?";
            PreparedStatement pst   = new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1,Phone);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
