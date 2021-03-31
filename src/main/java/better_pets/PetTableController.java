package better_pets;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PetTableController {

    Database database = new Database();
    
    @FXML
    TableView<Pet> petTbl;
    
    @FXML
    TableColumn<Pet, String> nameCol;
    
    @FXML
    TableColumn<Pet, String> speciesCol;
    
    @FXML
    TableColumn<Pet, String> colourCol;
    
    @FXML
    TableColumn<Pet, String> ownerCol;
    @FXML
    private Label welcome;
    
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        
        
//      Database.TABLEDelete();


        ObservableList<Pet> petsList = FXCollections.observableArrayList(Database.getPets());
        
        // Get a list of all of pets in the database
        
        
        Database.insertPets();
        
        
        
        // Set this list into the TableView
        petTbl.setItems(petsList);
        
          // Set all the columns in to tableview columns
        nameCol.setCellValueFactory(
                   new PropertyValueFactory<Pet, String>("name"));
        speciesCol.setCellValueFactory(
                   new PropertyValueFactory<Pet, String>("species"));
        colourCol.setCellValueFactory(
                   new PropertyValueFactory<Pet, String>("colour"));
        ownerCol.setCellValueFactory(
                   new PropertyValueFactory<Pet, String>("owner"));
        
       
 
         
    
     System.out.println("HOOLAAA AMIGOS");

 
        
    }
}