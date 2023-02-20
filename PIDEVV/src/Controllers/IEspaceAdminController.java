/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import Entities.User;
import Services.CRUDPatient;
import Services.CRUDUser;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author DELL
 */
 

public class IEspaceAdminController implements Initializable {
    @FXML
    private TableView<User> table_users;

    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, Integer> phone;
    @FXML
    private TableColumn<User, Integer> email;
    @FXML
    private TableColumn<User, Integer> adr;
    @FXML
    private TableColumn<User, String> role;
    @FXML
    private TableColumn<User, String> mdp;
     @FXML
    private TextField txt_adresse;
   @FXML
    private TextField txt_role;
    @FXML
    private TextField txt_phone;
     @FXML
    private TextField txt_email;
      @FXML
    private TextField txt_nom;
   
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       this.showUsers(); 
    
}
      public void showUsers(){   
        ObservableList<User> list;
        try {
            
            CRUDUser CP=new CRUDUser(); 
            list = CP.showUser(); 
           
         
          nom.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
            phone.setCellValueFactory(new PropertyValueFactory<>("phoneUser"));
            email.setCellValueFactory(new PropertyValueFactory<>("emailUser"));
            adr.setCellValueFactory(new PropertyValueFactory<>("AdrUser"));
            role.setCellValueFactory(new PropertyValueFactory<>("RoleUser"));
             mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
             
             table_users.getColumns().get(5).setVisible(false);
             table_users.getItems().clear();
            table_users.setItems(list);
            table_users.autosize();
         //  System.out.println( table_users.getItems().toString()); 
             
         // autoResizeColumns(table_users);
        

        } catch (Exception ex) {
            Logger.getLogger(IEspaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        


    }
  
  @FXML
private void ModifierUser(ActionEvent event) {
    User selectedUser = table_users.getSelectionModel().getSelectedItem();

    if (selectedUser == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText("Veuillez sélectionner un utilisateur à modifier !");
        alert.showAndWait();
        return;
    }

    // Get updated values from text fields
    String nom = txt_nom.getText();  
    String email = txt_email.getText();
    int phone = Integer.parseInt(txt_phone.getText());
    String role = txt_role.getText();
    String adresse = txt_adresse.getText(); 
        
    // Update selected user object
    selectedUser.setNomUser(nom);
    selectedUser.setEmailUser(email);
    selectedUser.setPhoneUser(phone);
    selectedUser.setRoleUser(role);
    selectedUser.setAdrUser(adresse);
    selectedUser.setMdp( selectedUser.getMdp()); 
    // Update user in database
    System.out.println(selectedUser); 
    CRUDUser CU = new CRUDUser(); 
    CU.editUser(selectedUser);
    System.out.println(selectedUser); 
    // Refresh table view
    table_users.refresh();

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setContentText("Utilisateur Modifié!");
    alert.showAndWait();
}


    
       public static void autoResizeColumns( TableView<?> table )
{
    //Set the right policy
    table.setColumnResizePolicy( TableView.UNCONSTRAINED_RESIZE_POLICY);
    table.getColumns().stream().forEach( (column) ->
    {
        //Minimal width = columnheader
        Text t = new Text( column.getText() );
        double max = t.getLayoutBounds().getWidth();
        for ( int i = 0; i < table.getItems().size(); i++ )
        {
            //cell must not be empty
            if ( column.getCellData( i ) != null )
            {
                t = new Text( column.getCellData( i ).toString() );
                double calcwidth = t.getLayoutBounds().getWidth();
                //remember new max-width
                if ( calcwidth > max )
                {
                    max = calcwidth;
                }
            }
        }
        //set the new max-widht with some extra space
        column.setPrefWidth( max + 10.0d );
   } );
}

    
    
}

