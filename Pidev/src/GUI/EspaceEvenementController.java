/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Services.CRUDEvenement;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Asus
 */
public class EspaceEvenementController {
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
    private ComboBox idtype ;
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
private TableView<Evenement> eveTable;

@FXML
private TableColumn<Evenement, Integer> idColumn;

@FXML
private TableColumn<Evenement, String> nomColumn;

@FXML
private TableColumn<Evenement, ComboBox> typeColumn;

@FXML
private TableColumn<Evenement, String> lieuColumn;

@FXML
private TableColumn<Evenement, Date> dateColumn;

@FXML
private TableColumn<Evenement, Time> timeColumn;

@FXML
private TableColumn<Evenement, String> descrColumn;

private final  ObservableList<Evenement> eveList = FXCollections.observableArrayList();

    @FXML
    private Label errorMessage;
    @FXML
    private Label successMessage;

    private CRUDEvenement crud;
    
    public void showErrorMessage(String message) {
    errorMessage.setText(message);
    errorMessage.setVisible(true);
}
    public void showSuccessMessage(String message) {
    successMessage.setText(message);
    successMessage.setVisible(true);
}

    public void initialize(URL url, ResourceBundle rb) {
        crud = new CRUDEvenement();
        ObservableList<String> types = crud.showTypes();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        lieuColumn.setCellValueFactory(new PropertyValueFactory<>("LieuAct"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Dteact"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("HrAct"));
        descrColumn.setCellValueFactory(new PropertyValueFactory<>("DescrAct"));
        idbuttajout.setOnAction(this::handleAjouter);
        idbuttmodif.setOnAction(this::handleModifier);
        idbuttsupp.setOnAction(this::handleSupprimer);
        eveTable.setItems(eveList);

    }
     private void handleAjouter(ActionEvent event) {
        if (idnom.getText().isEmpty() || iddate.getValue() == null || idlieu.getText().isEmpty() || idheure.getText().isEmpty() || idtype.getValue()==null ) {
       
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez remplir tous les champs!.");
            alert.showAndWait();
} else {
        Evenement eve = new Evenement();
        eve.setNom(idnom.getText());
        eve.setLieuEve(idlieu.getText());
        eve.setDteEve(Date.valueOf(iddate.getValue()));
        eve.setHrEve(idheure.getText());
        crud.addEvenement(eve);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Action Ajouté !");
            alert.showAndWait();}
    }
      @FXML
    private void handleModifier(ActionEvent event) {
    Evenement selectedeve = eveTable.getSelectionModel().getSelectedItem();
    if (selectedeve == null) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner l'evenement à modifier !");
            alert.showAndWait();
        
    }
  if (idnom.getText().isEmpty() || iddate.getValue() == null || idlieu.getText().isEmpty() || idheure.getText().isEmpty() || idtype.getValue()==null ) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez remplir tous les champs !");
            alert.showAndWait();
        
    }
    selectedeve.setNom(idnom.getText());
    selectedeve.setType((String) idtype.getValue());
    selectedeve.setDteEve(Date.valueOf(iddate.getValue()));
    selectedeve.setLieuEve(idlieu.getText());
    selectedeve.setHrEve(idheure.getText());
    selectedeve.setDescrEve(iddescr.getText());
    crud.editEvenement(selectedeve);

    // Debug messages
    System.out.println("Before refresh:");
    eveTable.getItems().forEach(System.out::println);
    eveTable.refresh();
    // Debug messages
    System.out.println("After refresh:");
    eveTable.getItems().forEach(System.out::println);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Action Modifié!");
            alert.showAndWait();
    
} 
    @FXML
private void handleSupprimer(ActionEvent event) {
    Evenement selectedeve = eveTable.getSelectionModel().getSelectedItem();
    if (selectedeve == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Veuillez sélectionner l'Evenement  à supprimer !");
        alert.showAndWait();
        return;
    }

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Voulez-vous vraiment supprimer l'evenement sélectionné ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        System.out.println("Before delete:");
        eveTable.getItems().forEach(System.out::println);
        crud.deleteEvenement(selectedeve.getId());
        System.out.println("After delete:");
        eveTable.getItems().forEach(System.out::println);
        Alert alert2;
        alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Evenement supprimé!");
            alert.showAndWait();
        showSuccessMessage("Evenement supprimé !");
    }
}
}

