/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Evenement;
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
public class CRUDEvenement {
 public void addEvenement(Evenement e ) {
        try {
            String requete = "INSERT INTO Evenement (Nom,Type,DteEve,LieuEve,HrEve,DescrEve)" + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst;
            pst = new MyConnection().connexion.prepareStatement(requete);
            pst.setString(2, e .getNom());
            pst.setString(3, e.getType());
            pst.setDate(4, (Date) e .getDteEve());          
            pst.setString(5, e.getLieuEve());
            pst.setString(6, e.getHrEve());
            pst.setString(7, e.getDescrEve());
            pst.executeUpdate();

            System.out.println("Evenement ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CRUDEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Evenement> showEvenement() {
        ObservableList<Evenement> list;
      list = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM Evenement";
            PreparedStatement pst
                    = new MyConnection().connexion.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            list.add(new Evenement(rs.getInt("Id"),rs.getString("Nom"),rs.getString("Type"),rs.getDate("DteEve"), rs.getString("LieuEve"), rs.getTime("HrEve"),rs.getString("DescrEve")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUDEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void editEvenement(Evenement a) {
        try {

            String requete = "UPDATE Action  Id= ? ,Nom= ? ,Type=?,DteEve= ? ,LieuEve = ? ,HrEve= ?,DescrEve=?  where Id = ? ";
            PreparedStatement pst
                    = new MyConnection().connexion.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getNom());
            pst.setDate(3, (Date) a.getDteEve());
            pst.setString(4, a.getLieuEve());
            pst.setString(5, a.getHrEve());
            pst.executeUpdate();

            System.out.println("Evenement modifié!");

        } catch (SQLException ex) {
            Logger.getLogger(CRUDEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteEvenement(int Id) {

        try {
            String requete = "DELETE FROM Evenement WHERE Id = ?";
            PreparedStatement pst
                    = new MyConnection().connexion.prepareStatement(requete);
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  public ObservableList<String> showTypes() {
    ObservableList<String> list = FXCollections.observableArrayList();
    list.add("conférence ");
    list.add("congrès");
    list.add("séminaire");
    return list;
}

}    

