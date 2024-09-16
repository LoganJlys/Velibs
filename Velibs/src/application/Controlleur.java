package application;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class Controlleur {

    @FXML
    private TableView<Station> tableView;
    
    @FXML
    private RadioButton arrondissement1;
    
    @FXML
    private RadioButton arrondissement2;
    
    @FXML
    private RadioButton arrondissement3;
    
    @FXML
    private RadioButton arrondissement4;
    
    @FXML
    private RadioButton arrondissement5;
    
    @FXML
    private RadioButton arrondissement6;
    
    @FXML
    private RadioButton arrondissement7;
    
    @FXML
    private RadioButton arrondissement8;
    
    @FXML
    private RadioButton arrondissement9;
    
    @FXML
    private RadioButton arrondissement10;
    
    @FXML
    private RadioButton arrondissement11;
    
    @FXML
    private RadioButton arrondissement12;
    
    @FXML
    private RadioButton arrondissement13;
    
    @FXML
    private RadioButton arrondissement14;
    
    @FXML
    private RadioButton arrondissement15;
    
    @FXML
    private RadioButton arrondissement16;
    
    @FXML
    private RadioButton arrondissement17;
    
    @FXML
    private RadioButton arrondissement18;
    
    @FXML
    private RadioButton arrondissement19;
    
    @FXML
    private RadioButton arrondissement20;
    
    @FXML
    private RadioButton arrondissement92;
    
    @FXML
    private RadioButton arrondissement93;
    
    @FXML
    private RadioButton arrondissement94;
    
    @FXML
    private RadioButton arrondissement95;
    
    @FXML
    private RadioButton arrondissementMobile;
    
    @FXML
    private ToggleGroup arrondissementToggleGroup;

    @FXML
    private Text numeroText;
    
    @FXML
    private Text nomText;
    
    @FXML
    private Text arrondissementText;
    
    @FXML
    private Text villeText;
    
    @FXML
    private Text ouvertText;
    
    @FXML
    private Text capaciteText;
    
    @FXML
    private Text veloDispoText;
    
    @FXML
    private Text attacheDispoText;
    
    @FXML
    private Text carteBText;
    
    @FXML
    private Text peutDeposeText;
 
    @FXML
    TableColumn<Station, String> nomColonne,numeroColonne,cbColonne,ouvertColonne;
    
    private Carte carte;
    private ConnectAPI connectAPI;

    public Controlleur() {
        this.carte = new Carte();
        this.connectAPI = new ConnectAPI();
    }

    @FXML
    public void initialize() {
        try {
            // Charge les stations depuis l'API et les ajouter à la carte
            ArrayList<Station> stations = connectAPI.chargerStations();
            carte.setCarte(stations);
            
            // Créer des cellules personnalisées pour les colonnes "Nom", "Numéro", "CB" et "Ouvert"
            nomColonne.setCellValueFactory(cellData ->  new ReadOnlyStringWrapper(cellData.getValue().getNom()));
            numeroColonne.setCellValueFactory(cellData ->  new ReadOnlyStringWrapper(cellData.getValue().getNumero()));
            cbColonne.setCellValueFactory(cellData ->  new ReadOnlyStringWrapper(cellData.getValue().getCarteB()));
            ouvertColonne.setCellValueFactory(cellData ->  new ReadOnlyStringWrapper(cellData.getValue().getStatut()));
            
            // Ajoute les stations à la TableView
            tableView.getItems().addAll(carte.getStations());
            //tableView.setItems(FXCollections.observableArrayList(carte.getStations()));
            // Créer un groupe de basculement pour les boutons d'arrondissement
            arrondissementToggleGroup = new ToggleGroup();

            // Ajouter les boutons d'arrondissement au groupe de basculement
            arrondissement1.setToggleGroup(arrondissementToggleGroup);
            arrondissement2.setToggleGroup(arrondissementToggleGroup);
            arrondissement3.setToggleGroup(arrondissementToggleGroup);
            arrondissement4.setToggleGroup(arrondissementToggleGroup);
            arrondissement5.setToggleGroup(arrondissementToggleGroup);
            arrondissement6.setToggleGroup(arrondissementToggleGroup);
            arrondissement7.setToggleGroup(arrondissementToggleGroup);
            arrondissement8.setToggleGroup(arrondissementToggleGroup);
            arrondissement9.setToggleGroup(arrondissementToggleGroup);
            arrondissement10.setToggleGroup(arrondissementToggleGroup);
            arrondissement11.setToggleGroup(arrondissementToggleGroup);
            arrondissement12.setToggleGroup(arrondissementToggleGroup);
            arrondissement13.setToggleGroup(arrondissementToggleGroup);
            arrondissement14.setToggleGroup(arrondissementToggleGroup);
            arrondissement15.setToggleGroup(arrondissementToggleGroup);
            arrondissement16.setToggleGroup(arrondissementToggleGroup);
            arrondissement17.setToggleGroup(arrondissementToggleGroup);
            arrondissement18.setToggleGroup(arrondissementToggleGroup);
            arrondissement19.setToggleGroup(arrondissementToggleGroup);
            arrondissement20.setToggleGroup(arrondissementToggleGroup);
            arrondissement92.setToggleGroup(arrondissementToggleGroup);
            arrondissement93.setToggleGroup(arrondissementToggleGroup);
            arrondissement94.setToggleGroup(arrondissementToggleGroup);
            arrondissement95.setToggleGroup(arrondissementToggleGroup);
            arrondissementMobile.setToggleGroup(arrondissementToggleGroup);

            // Écouter les changements de sélection des boutons de filtre d'arrondissement
            arrondissementToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Récupérer l'arrondissement sélectionné
                    RadioButton selectedRadioButton = (RadioButton) newValue;
                    String selectedArrondissement = selectedRadioButton.getText();

                    // Filtrer les stations par arrondissement et mettre à jour la TableView
                    ArrayList<Station> filteredStations = carte.filterStationsByArrondissement(selectedArrondissement);
                    tableView.getItems().clear();
                    tableView.getItems().addAll(filteredStations);
                }else {
                    // Si aucun bouton n'est sélectionné, afficher toutes les stations
                    tableView.getItems().clear();
                    tableView.getItems().addAll(carte.getStations());
                }
            });
            
            // Affiche les stations dans le TableView (adapter en fonction de votre TableView)
            tableView.getItems().addAll(stations);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            // Gérer les erreurs de chargement des données depuis l'API
        }
        
        // détecter les clics sur une ligne de la TableView
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Mettre à jour les informations de l'encadré dédié en fonction de la station sélectionnée
                updateSelectedStationInfo(newSelection);
            }
        });
    }
    
    private void updateSelectedStationInfo(Station selectedStation) {

        // Mettre à jour les informations de l'encadré dédié en fonction de la station sélectionnée
        numeroText.setText(selectedStation.getNumero());
        nomText.setText(selectedStation.getNom());
        arrondissementText.setText(selectedStation.getArrondissement());
        villeText.setText(selectedStation.getVille());
        ouvertText.setText(selectedStation.getStatut());
        capaciteText.setText(String.valueOf(selectedStation.getCapacite()));
        veloDispoText.setText(String.valueOf(selectedStation.getVeloDispo()));
        attacheDispoText.setText(String.valueOf(selectedStation.getAttacheDispo()));
        carteBText.setText(selectedStation.getCarteB());
        peutDeposeText.setText(selectedStation.getPeutDepose());
    }

}
