/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eid Almeshal
 */
public class PatientDashboard extends Stage {

    // All Scenes that PatientDashboard page have
    private Scene PatientDashboard;
    private Scene PatintLogin;
    private Scene PatientRegister;

    //private Scene operationsScene;
    public PatientDashboard() throws IOException {

        FXMLLoader PatientDashboardPage = new FXMLLoader(getClass().getResource("ViewsFXML/PatientDashboardPage.fxml"));
        Parent patientDashboard = PatientDashboardPage.load();
        PatientDashboard = new Scene(patientDashboard);

        FXMLLoader PatientLoginPage = new FXMLLoader(getClass().getResource("ViewsFXML/PatientLoginPage.fxml"));
        Parent patientLogin = PatientLoginPage.load();
        PatintLogin = new Scene(patientLogin);

        FXMLLoader PatientRegisterPage = new FXMLLoader(getClass().getResource("ViewsFXML/PatientRegisterPage.fxml"));
        Parent patientRegister = PatientRegisterPage.load();
        PatientRegister = new Scene(patientRegister);

        // Set Main Scene in Patient Dasboard ( PatintLogin Scene )
        this.setScene(PatintLogin);
        this.setTitle("Patient Login Page");

    }

    public void changeSceneToRegisterPatient() {
        this.setScene(PatientRegister);
    }

    public void changeSceneToPatientLogin() {
        this.setScene(PatintLogin);
    }

}
