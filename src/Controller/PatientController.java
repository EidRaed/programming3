/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB;
import Model.Patient;
import Controller.PatientManagmentController;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Eid Almeshal
 */
public class PatientController implements Initializable {
    
    @FXML
    private Button showAllFree;
    @FXML
    private Button bookfreeappointment;
    @FXML
    private Button showbookwaiting;
    @FXML
    private Button showbookfinish;
    @FXML
    private Button showdoctorcommit;
    @FXML
    private Button logout;
   
    
    
    

    private Statement statment() throws SQLException {
        Connection c = DB.getInstance().getConnection();
        Statement stat = c.createStatement();
        return stat;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void show_All_Free_Appointments(ActionEvent event) throws SQLException {
        ResultSet rs = statment().executeQuery("select * from appointments"
                + "where status = free");
            
        
                 
    }

    @FXML
    private void book_An_Free_Appointment(ActionEvent event) throws SQLException {
        int rs = statment().executeUpdate("UPDATE appointments set status = booked"
                + "where status = free");
            
    }

    @FXML
    private void show_MyAll_Booked_Waiting_Appointments(ActionEvent event) throws SQLException {
        ResultSet rs = statment().executeQuery("select * from  booked_appointments"
                + "where status = waiting");
        
    }

    @FXML
    private void show_My_All_Booked_Finished_Appointments(ActionEvent event) throws SQLException {
        ResultSet rs = statment().executeQuery("select * from  booked_appointments"
                + "where status = finished");
        
    }

    @FXML
    private void show_Doctor_Comment_Finished_Appointment(ActionEvent event) throws SQLException {
        ResultSet rs = statment().executeQuery("select doctor_commnet "
                + "from  booked_appointments"
                + "where status = finished");
        
    }

    @FXML
    private void Log_Out(ActionEvent event) {

    }

}
