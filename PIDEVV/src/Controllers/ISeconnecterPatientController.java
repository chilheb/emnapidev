/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import com.sun.javafx.util.Utils;
import Entities.Patient;
import Entities.User;
import Services.CRUDPatient;
import Services.CRUDUser;
import com.sun.javafx.util.Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.P;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ISeconnecterPatientController implements Initializable {
   
    @FXML
    private TextField txt_Nom;
    @FXML
    private TextField txt_Email;
    @FXML
    private TextField txt_Tel;
    @FXML
    private TextField txt_mdp;
    @FXML 
    private TextField txt_Adr ; 
   

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
    
    // Si toutes les conditions sont remplies, le numéro de téléphone est valide
    return true;
}
  
     private boolean isValid(String email) {
        String M_mailm = "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z0-9]+)+";
        Pattern pat = Pattern.compile(M_mailm);
        if (txt_Email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }
    @FXML 
    private void register(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
       boolean test = true ; 
       String ch = txt_Nom.getText();
       String ch1 = txt_Email.getText();
        int ch2 = Integer.parseInt(txt_Tel.getText());
       String ch3 = txt_mdp.getText();
       String ch4 =txt_Adr.getText(); 

        if(
              (ch == null || ch.equals("") || ch1 == null || ch1.equals("") ||ch2 == 0  ||(ch3 == null || ch3.equals("") )))
             
             {   test=false ; 
                 JOptionPane.showMessageDialog(null, "Les champs sont vides veuillez remplir tous les champs", "Echec", JOptionPane.ERROR_MESSAGE);}
                
       if (isValid(ch1)==false){
           test=false ; 
           JOptionPane.showMessageDialog(null, "Le champs email n'est pas valide ", "Echec", JOptionPane.ERROR_MESSAGE);}
        if (isValidPhoneNumber(ch2)==false){
            test=false ; 
            JOptionPane.showMessageDialog(null, "Le numéro de télephone doit être valide ", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
       if(test==true ){
          
        Patient P =new Patient (ch,ch2,ch1,ch4,ch3,"Patient");
        CRUDPatient CP=new CRUDPatient();
       User U =new User(ch, ch2, ch1, ch4, ch3, "Patient"); 
        CRUDUser CU=new CRUDUser();
        CP.addPatient(P);
        CU.addUser(U);
    //  System.out.println(test); 
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/IMenu.fxml")));
        stage.setScene(scene);
        stage.show();}
       
    } 
        
                  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //To change body of generated methods, choose Tools | Templates.
    }
}
