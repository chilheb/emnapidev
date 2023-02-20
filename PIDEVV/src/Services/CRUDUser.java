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
                String requete = "INSERT INTO user (Nom,Phone,Email,Adresse,Role,mdp)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1,P.getNomUser());
            pst.setInt(2,P.getPhoneUser());
            pst.setString(3,P.getEmailUser());
            pst.setString(4, P.getAdrUser());
            pst.setString(5, P.getRoleUser());
            pst.setString(6, P.getMdp());
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
             //  list=(ObservableList<User>)rs ; 
                    
            //  rs.toString() ; 
              // ObservableList<User> list = getList(rs);
               User u =new User(rs.getString("Nom"),rs.getInt("Phone"),rs.getString("Email"),rs.getString("Adresse"),rs.getString("Role"),rs.getString("mdp"));
               
                u.setPhoneUser(rs.getInt("Phone"));
                list.add(u) ; 
            
            // ObservableList <User> list = getList(rs);
             //  list.add(new User(rs.getString("Nom"),rs.getInt("Phone"),rs.getString("Email"),rs.getString("Adresse"),rs.getString("Role"),rs.getString("mdp"))); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editUser(User P) {
        try {

            String requete = "UPDATE user  Nom= ? ,Phone= ? ,Email = ? ,Adresse= ? , Role= ? , Mdp= ?"; 
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
            pst.setString(1, P.getNomUser());
            pst.setInt(2, P.getPhoneUser());
            pst.setString(3,P.getEmailUser());
            pst.setString(4, P.getAdrUser());
            pst.setString(5, P.getRoleUser());
             pst.setString(6, P.getMdp());
        
        
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
