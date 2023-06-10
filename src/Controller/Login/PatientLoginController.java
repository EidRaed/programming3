/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Login;

import Controller.PatientManagmentController;
import Controller.PatientManagmentController;
import Model.Patient;
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
public class PatientLoginController implements Initializable {

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
    
    @FXML
    private Button cancelToLogin;

    @FXML
    private Button patientRegistration;

    @FXML
    private Button adminLogin;

    private Stage patientdashboardStage;

    private Patient pat;   //to call username and password save database

    public void login(ActionEvent event) throws IOException {
        // Perform validation logic
        if (username.getText().equals(pat.getUsername())
                && password.getText().equals(pat.getPassword())) {
            // Successful login
            // TODO: Open the patient dashboard or perform other actions
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, Patient!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientDashboardPage.fxml"));
                AnchorPane root = loader.load();
                Scene scene = new Scene(root);
                patientdashboardStage = new Stage();
                patientdashboardStage.setScene(scene);
                patientdashboardStage.setTitle("Patint Dashboard");
                patientdashboardStage.show();
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

    public void cancel1(ActionEvent event) {
      View.ViewManager.patientPage.changeSceneToRegisterPatient();
        //patientdashboardStage.close();
    }
//     public void cancel2(ActionEvent event) {
//      View.ViewManager.patientPage.changeSceneToPatientLogin();
//       
//    }

    public void GoPatientRegister(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientRegisterPage.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage patientRegisterPage = new Stage();
            patientRegisterPage.setScene(scene);
            patientRegisterPage.setTitle("Patient Register");
            patientRegisterPage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GoAdminLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLoginPage.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage adminLoginPage = new Stage();
            adminLoginPage.setScene(scene);
            adminLoginPage.setTitle("Admin Login");
            adminLoginPage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
