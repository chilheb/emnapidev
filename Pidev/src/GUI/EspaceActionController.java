/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;


import Entity.Action;
import Services.CRUDAction;
import java.net.URL;
import java.sql.Time;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class EspaceActionController implements Initializable {
    @FXML
    private AnchorPane scene1;
    @FXML
    private Label label1;
    @FXML
    private ImageView idImg;
    @FXML
    private TextField idnom;
    @FXML
    private DatePicker iddate;
    @FXML
    private TextField idheure ;
    @FXML
    private TextArea iddescr ;
    @FXML
    private Button idbuttajout;
    @FXML
    private Button idbuttmodif;
    @FXML
    private Button idbuttsupp;
    @FXML
    private TextField idlieu;
  @FXML
private TableView<Action> actionTable;

@FXML
private TableColumn<Action, Integer> idColumn;

@FXML
private TableColumn<Action, String> nomColumn;

@FXML
private TableColumn<Action, String> lieuColumn;

@FXML
private TableColumn<Action, Date> dateColumn;

@FXML
private TableColumn<Action, Time> timeColumn;

@FXML
private TableColumn<Action, String> descrColumn;

private final  ObservableList<Action> actionList = FXCollections.observableArrayList();

    @FXML
    private Label errorMessage;
    @FXML
    private Label successMessage;

    private CRUDAction crud;
    
    public void showErrorMessage(String message) {
    errorMessage.setText(message);
    errorMessage.setVisible(true);
}
    public void showSuccessMessage(String message) {
    successMessage.setText(message);
    successMessage.setVisible(true);
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crud = new CRUDAction();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        lieuColumn.setCellValueFactory(new PropertyValueFactory<>("LieuAct"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Dteact"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("HrAct"));
        descrColumn.setCellValueFactory(new PropertyValueFactory<>("DescrAct"));
        idbuttajout.setOnAction(this::handleAjouter);
        idbuttmodif.setOnAction(this::handleModifier);
        idbuttsupp.setOnAction(this::handleSupprimer);
        actionTable.setItems(actionList);

    }
     private void handleAjouter(ActionEvent event) {
        if (idnom.getText().isEmpty() || iddate.getValue() == null || idlieu.getText().isEmpty() || idheure.getText().isEmpty() ) {
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez remplir tous les champs!.");
            alert.showAndWait();
} else {
        Action act = new Action();
        act.setNom(idnom.getText());
        act.setLieuAct(idlieu.getText());
        act.setDteAct(Date.valueOf(iddate.getValue()));
        act.setHrAct(idheure.getText());
        crud.addAction(act);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Action Ajouté !");
            alert.showAndWait();}
    }
      @FXML
    private void handleModifier(ActionEvent event) {
    Action selectedact = actionTable.getSelectionModel().getSelectedItem();
    if (selectedact == null) {
          Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner l'Action à modifier !");
            alert.showAndWait();
        
    }
   if (idnom.getText().isEmpty() || iddate.getValue() == null || idlieu.getText().isEmpty() || idheure.getText().isEmpty() ) {
        Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Veuillez remplir tous les champs !");
            alert.showAndWait();
        
    }
    selectedact.setNom(idnom.getText());
    selectedact.setDteAct(Date.valueOf(iddate.getValue()));
    selectedact.setLieuAct(idlieu.getText());
    selectedact.setHrAct(idheure.getText());
    selectedact.setDescrAct(iddescr.getText());
    crud.editAction(selectedact);

    // Debug messages
    System.out.println("Before refresh:");
    actionTable.getItems().forEach(System.out::println);
    actionTable.refresh();
    // Debug messages
    System.out.println("After refresh:");
    actionTable.getItems().forEach(System.out::println);
    Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Action Modifié!");
            alert.showAndWait();
    
} 
    @FXML
private void handleSupprimer(ActionEvent event) {
    Action selectedact = actionTable.getSelectionModel().getSelectedItem();
    if (selectedact == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText("Veuillez sélectionner l'action  à supprimer !");
        alert.showAndWait();
        return;
    }

    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setContentText("Voulez-vous vraiment supprimer l'action sélectionné ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        System.out.println("Before delete:");
        actionTable.getItems().forEach(System.out::println);
        crud.deleteAction(selectedact.getId());
        System.out.println("After delete:");
        actionTable.getItems().forEach(System.out::println);
        Alert alert2;
        alert2 = new Alert(AlertType.INFORMATION);
            alert.setContentText("Action supprimé!");
            alert.showAndWait();
        showSuccessMessage("Action supprimé !");
    }
}
}
   


