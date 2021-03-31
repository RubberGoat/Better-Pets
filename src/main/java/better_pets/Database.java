/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package better_pets;

/**
 *
 * @author Rjian
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.P;

public class Database {
    
    final private String database= "jdbc:sqlite:PetDatabase.db";
    
    public static void setupDatabase() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        
        // Connect to Database 
        Connection conn = DriverManager.getConnection("jdbc:sqlite:PetDatabase.db");
        
        Statement st = conn.createStatement();
       
        // Create Users table, with id, username, and password fields
        String createUsers = "CREATE TABLE IF NOT EXISTS USERS ("
                     + "id INT(255) NOT NULL"
                    + ",username VARCHAR(255) NOT NULL"
                    + ", password VARCHAR(255) NOT NULL" 
                    + ", PRIMARY KEY (id))";
 
        
         st.execute(createUsers);
           
        
        // Insert a user account
//        st.executeUpdate("INSERT INTO USERS " + " VALUES ('1','aldo','ay')");
        
        // Create Pets Table, with id, name, species, colour, and owner fields
        String createPETS = "CREATE TABLE IF NOT EXISTS PETS ("
                    + "id INT(255) NOT NULL"
                    + ", name VARCHAR(255) NOT NULL"
                    + ", species VARCHAR(255) NOT NULL"
                    + ", colour VARCHAR(255) NOT NULL"
                    + ", owner VARCHAR(255) NOT NULL" 
                    + ", PRIMARY KEY (id))";
        
        
        st.execute(createPETS);
        
        // Insert some pets into this table
//        st.executeUpdate("INSERT INTO PETS " + " VALUES ('20','Shenron','Dragon', 'Green', 'Goku' )");
        
        // Close connections and statements
     
        
           st.close();
            conn.close();
    }
    
    public static void insertPets() throws SQLException{
        //create connection
        Connection conn = DriverManager.getConnection("jdbc:sqlite:PetDatabase.db");
        //create statement	
        Statement st = conn.createStatement();

        //write the SQL query and the java code to insert all four pets
        PreparedStatement pSt = conn.prepareStatement(
            "INSERT OR IGNORE INTO PETS (id, name, species, colour, owner) VALUES (?,?,?,?,?)"
        );

        // Data to insert
        String[] names = {"Kitty", "Blair", "Mimi", "QuackyMooMoo"};
        String[] species = {"cat", "cat", "frog", "dog"};
        String[] colour = {"grey", "white", "green", "brown"};
        String[] owner = {"Andrew", "Yenni", "Hatherine", "Phoebe"};

        // Loop to insert via sanitised prepared statements
        for (int i = 0; i < 4; i++) {
            pSt.setInt(1, i);
            pSt.setString(2, names[i]);
            pSt.setString(3, species[i]);
            pSt.setString(4, colour[i]);
            pSt.setString(5, owner[i]);
            pSt.executeUpdate();
        }
        
        st.close();
        conn.close();
    }
    
    public static boolean login(String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:PetDatabase.db");
        PreparedStatement pst = conn.prepareStatement(
            "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?"
        );
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        
        // Check if user exists - if so return true, else return false

        
        
        if(rs.next()){
            pst.close();
            conn.close();
            return true;
        } else {
            pst.close();
            conn.close();
            return false;
        }
        
       
        
       
        
    }
    

    
    public static ObservableList<Pet> getPets() throws SQLException {
        // Get ResultSet of all pets that exist in the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:PetDatabase.db");
        Statement st = conn.createStatement();
        
        String query = "SELECT id, name, species, colour, owner FROM PETS";
        ResultSet rs = st.executeQuery(query);
        
        ObservableList<Pet> petsList = FXCollections.observableArrayList();
        // Add each row in the ResultSet to the petsList
        
        while(rs.next()){

           
            petsList.add(new Pet(rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)));
        }     
  
        // Close 
        st.close();
        conn.close();
        return petsList;
    }
    
//     public static void TABLEDelete()throws IOException, SQLException{
//////        
////       
//         //create connection
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:PetDatabase.db");
//        //create statement	
//        Statement st = conn.createStatement();
//        //write the SQL query and the java code to insert all four pets
//        PreparedStatement pSt = conn.prepareStatement("DROP TABLE USERS "
//        );
//       
//       pSt.executeUpdate();
//       
//        PreparedStatement sts = conn.prepareStatement("DROP TABLE PETS "
//        );
//       
//       sts.executeUpdate();
//
//       st.close();
//       conn.close();
//
//
//       System.out.println("TABLE DELETEEE");
////        
////        
//        
//    }
}
