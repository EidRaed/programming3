/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Eid Almeshal
 */
public class AdminLoginController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button cancel;

    private Stage admindashboardStage;
    public void login(ActionEvent event) throws IOException {
        // Perform validation logic
        if (username.getText().equals("EidAlmeshal") 
                && password.getText().equals("22072001")) {
            // Successful login
             // TODO: Open the admin dashboard or perform other actions
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, Admin!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboardPage.fxml"));
                AnchorPane root = loader.load();
                Scene scene = new Scene(root);
                admindashboardStage = new Stage();
                admindashboardStage.setScene(scene);
                admindashboardStage.setTitle("Admin Dashboard");
                admindashboardStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

         
        } else {
            // Invalid login
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cancel(ActionEvent event) {
      admindashboardStage.close();
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
