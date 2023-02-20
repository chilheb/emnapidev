/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Patient;
import Entities.User;
import Services.CRUDPatient;
import Services.CRUDUser;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
/**
 * FXML Controller class
 *
 * @author DELL
 */


public class IConnexionPatientController implements Initializable {
     @FXML
    private TextField txt_num;
    @FXML
    private TextField txt_mdp;
    
     public boolean isValidPhoneNumber(int phoneNumber) {
    String phoneNumberStr = Integer.toString(phoneNumber);
    
    
    if (phoneNumberStr.length() != 8) {
        return false;
    }
    
    
    for (int i = 0; i < phoneNumberStr.length(); i++) {
        if (!Character.isDigit(phoneNumberStr.charAt(i))) {
            return false;
        }
    }
    
    
    if (phoneNumber == 12345678) {
        return false;
    }
    return true;
}
    @FXML 
    private void Seconnecter(ActionEvent event)throws ClassNotFoundException, SQLException, IOException {
        boolean test=true ; 
      //  System.out.println("non");
      String ch =txt_num.getText(); 
       String ch1= txt_mdp.getText(); 
       int num = Integer.parseInt(ch);
      // System.out.println("ch="+ch +"ch1="+ch1);
      
        if(    (ch.isEmpty()==true || ch1.isEmpty()==true ))
              //(ch == null || ch.equals("") || ch1 == null || ch1.equals("") ))
             
             {   test=false ; 
                 JOptionPane.showMessageDialog(null, "Les champs sont vides veuillez remplir tous les champs", "Echec", JOptionPane.ERROR_MESSAGE);}
               
       if (isValidPhoneNumber(num)==false){
            test=false ; 
            JOptionPane.showMessageDialog(null, "Le numéro de télephone doit être valide ", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
      try { 
           
           CRUDPatient CP= new CRUDPatient();  
            boolean ok =CP.chercherPatientInt(num,ch1) ; 
            Patient P=CP.chercherPatient(num) ; 
           if (ok==true && test==true){
              //  System.out.println("oui");
         

         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/IMenu.fxml")));
        stage.setScene(scene);
        stage.show();
                    
   
           }else {
               JOptionPane.showMessageDialog(null, "Vous n'êtes pas inscrit sur HealthHaven veuillez faire un compte ou verifier vos coordonnées ! ", "COMPTE INEXISTANT", JOptionPane.INFORMATION_MESSAGE) ; 
          }
            
     } catch (HeadlessException | IOException e) {
           e.printStackTrace();
        }
           
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   /*      Patient P=CP.chercherPatient(num) ; 
        Preferences prefs = Preferences.userRoot().node("/Interfaces/IConnexionPatient.fxml");
          int phone=P.getPhonePatient();
       System.out.println("int");
       System.out.println(Phone);
       String tel = Integer.toString(phone);
       System.out.println("string");
       System.out.println(tel);
       String Mdp = P.getMdp();
        String user = prefs.get(tel,Mdp); 
       System.out.println(user);
       Preferences userPreferences = Preferences.userRoot();
               userPreferences.put("Phone",P.getPhonePatient() +"Mdp"+P.getMdp());
              //String ch= userPreferences.get(ch, ch1) ; 
              // Récupération des préférences utilisateur*/
              
           //    String user = prefs.get(tel,Mdp); */
}}
