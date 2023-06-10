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
public class AdminDashboard extends Stage {

    // All Scenes that AdminDashboard page have
    private Scene AdminDashboard;
    private Scene AdminLogin;
    private Scene PatientManagment;

    //private Scene operationsScene;
    public AdminDashboard() throws IOException {

        FXMLLoader AdminDashboardPage = new FXMLLoader(getClass().getResource("ViewsFXML/AdminDashboardPage.fxml"));
        Parent adminDashboard = AdminDashboardPage.load();
        AdminDashboard = new Scene(adminDashboard);

        FXMLLoader AdminLoginPage = new FXMLLoader(getClass().getResource("ViewsFXML/AdminLoginPage.fxml"));
        Parent adminLogin = AdminLoginPage.load();
        AdminLogin = new Scene(adminLogin);

        FXMLLoader PatientManagmentPage = new FXMLLoader(getClass().getResource("ViewsFXML/PatientManagment.fxml"));
        Parent patientManagment = PatientManagmentPage.load();
        PatientManagment = new Scene(patientManagment);

    }
//    public void changeSceneToCreateUser(){
//        this.setScene(createUserScene);
//    }
//    public void changeSceneToUsersManagment(){
//        this.setScene(usersManagmentScene);
//    }
//    
//    public void changeSceneToAccountsManagment(){
//        this.setScene(accountsManagmentScene);
//    }

}
