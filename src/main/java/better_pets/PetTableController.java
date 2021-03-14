package better_pets;

import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
    public void initialize() throws SQLException {
        // Get a list of all of pets in the database
        ObservableList<Pet> petsList;
        
        // Set this list into the TableView
        
        // Set all the columns in to tableview columns
        
    }
}