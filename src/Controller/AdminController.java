/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Eid Almeshal
 */
public class AdminController implements Initializable{
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
    private void show_All_Booked_Appointments(ActionEvent event) throws SQLException {
             ResultSet rs = statment().executeQuery("select * from appointments"
                 + "where status = booked");
    }
    
     @FXML
    private void show_All_Free_Appointments (ActionEvent event) throws SQLException {
          ResultSet rs = statment().executeQuery("select * from appointments"
                 + "where status = free");
    }
    
     @FXML
    private void booked_Appointmen_My_Comment_And_Make_Finished_Appointmen(ActionEvent event) throws SQLException {
         ResultSet rs = statment().executeQuery("select * from appointments"
                 + "where status = free");
    }
    
      @FXML
    private void search_Booked_Appointments_By_Patient_FirstName  (ActionEvent event) throws SQLException {
         ResultSet rs = statment().executeQuery("select * from appointments"
                 + "where status = free");
    }
    

      @FXML
    private void create_New_Appointment  (ActionEvent event) {
         // ResultSet rs = statment().execute("");
               
    }
      @FXML
    private void update_Appointment  (ActionEvent event) {
        
    }
      @FXML
    private void delete_Appointment (ActionEvent event) {
        
    }
    

     @FXML
    private void Log_Out (ActionEvent event) {
        
    }
    
    
    
    
    
    
    
}
