package better_pets;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    Database database = new Database();

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException, SQLException {
        System.out.println("clicked login");
        // Check if username and password exist as a user in the database
        // (Hint: use a function in the Database class)

        // If the username and password are correct - move to the PetTable screen
        // Otherwise display text "Incorrect username or password"
    }

    private void switchToPetTable() throws IOException {
        App.setRoot("PetsScreen");
    }
    
}