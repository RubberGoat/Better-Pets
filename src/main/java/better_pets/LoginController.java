package better_pets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    Database database = new Database();
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label outputLabel;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("clicked login");
        
                
        // Check if username and password exist as a user in the database
        // (Hint: use a function in the Database class)
        
       // If the username and password are correct - move to the PetTable screen

        if (Database.login(usernameField.getText(),passwordField.getText())){
             
//            outputLabel.setText("Correct username or password");
            App.setRoot("PetsScreen");
             
  
        } else {
              // Otherwise display text "Incorrect username or password"
                 outputLabel.setText("Incorrect username or password");
 
        }
               
                
    
       
    }

//    private void switchToPetTable() throws IOException {
//        App.setRoot("PetsScreen");
//    }
    
}