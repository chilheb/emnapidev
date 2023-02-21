/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Action;
import java.sql.Date;
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
 * @author Asus
 */
public class CRUDAction {
  public void addAction(Action a) {
        try {
            
            String requete = "INSERT INTO action (Id,Nom,LieuAct,DteAct,HrAct,DescrAct)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst;
            pst = new MyConnection().connexion.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getNom());          
            pst.setString(3, a.getLieuAct());
            pst.setDate(4, new java.sql.Date(a.getDteAct().getTime()));
            pst.setString(5, a.getHrAct());
            pst.setString(6,a.getDescrAct());
            pst.executeUpdate();

            System.out.println("Action ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Action> showAction() {
        ObservableList<Action> list;
      list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM action";
            PreparedStatement pst
                    = new MyConnection().connexion.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            list.add(new Action(rs.getInt("Id"),rs.getString("Nom"),rs.getString("LieuAct"),rs.getDate("DteAct"),  rs.getString("HrAct"), rs.getString("DescrAct")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editAction(Action a) {
        try {

            String requete = "UPDATE action  Id= ? ,Nom= ? ,DteAct= ? ,LieuAct = ? ,HrAct= ?,DescrAct=?  where Id = ? ";
            PreparedStatement pst = new MyConnection().connexion.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getNom());
            pst.setDate(3, (Date) a.getDteAct());
            pst.setString(4, a.getLieuAct());
            pst.setString(5, a.getHrAct());
            pst.setString(6,a.getDescrAct());
            pst.executeUpdate();

            System.out.println("Action modifié!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAction(int Id) {

        try {
            String requete = "DELETE FROM Action WHERE Id = ?";
            PreparedStatement pst= new MyConnection().connexion.prepareStatement(requete);
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

}  
