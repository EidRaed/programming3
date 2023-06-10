/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB;
import Model.Patient;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author amir
 */
public class PatientManagmentController implements Initializable {

    @FXML
    private TableView<Patient> tableview;

    @FXML
    private TableColumn<Patient, Integer> id;

    @FXML
    private TableColumn<Patient, String> firstname;

    @FXML
    private TableColumn<Patient, String> lastname;

    @FXML
    private TableColumn<Patient, String> username;

    @FXML
    private TableColumn<Patient, String> email;

    @FXML
    private TableColumn<Patient, String> password;

    @FXML
    private TableColumn<Patient, String> phone;

    @FXML
    private TableColumn<Patient, String> age;

    @FXML
    private TableColumn<Patient, String> gender;

    @FXML
    private TableColumn<Patient, String> role;

    @FXML
    private TextField id_tf;

    @FXML
    private TextField firstname_tf;

    @FXML
    private TextField lastname_tf;

    @FXML
    private TextField username_tf;

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField email_tf;

    @FXML
    private TextField age_tf;

    @FXML
    private TextField phone_tf;

    @FXML
    private TextField gender_tf;

    @FXML
    private TextField role_tf;

    @FXML
    private TextField textfieldsearch;

    ObservableList<Patient> listM;
    ObservableList<Patient> dataList;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UpdateTable();
        } catch (SQLException ex) {
            Logger.getLogger(PatientManagmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            search_user();
        } catch (SQLException ex) {
            Logger.getLogger(PatientManagmentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Add_users() throws SQLException {
        Connection conn = DB.getInstance().getConnection();
        String sql = "insert into users (firstname,lastname,username,password,email,phone,age,gender,role)values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, firstname_tf.getText());
            pst.setString(2, lastname_tf.getText());
            pst.setString(3, username_tf.getText());
            pst.setString(4, password_tf.getText());
            pst.setString(5, email_tf.getText());
            pst.setString(6, phone_tf.getText());
            pst.setString(7, age_tf.getText());
            pst.setString(8, gender_tf.getText());
            pst.setString(9, role_tf.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //////// methode select users ///////
    @FXML
    void getSelected(MouseEvent event) {
        index = tableview.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        id_tf.setText(id.getCellData(index).toString());
        firstname_tf.setText(firstname.getCellData(index).toString());
        lastname_tf.setText(lastname.getCellData(index).toString());
        username_tf.setText(username.getCellData(index).toString());
        password_tf.setText(password.getCellData(index).toString());
        email_tf.setText(email.getCellData(index).toString());
        phone_tf.setText(phone.getCellData(index).toString());
        age_tf.setText(age.getCellData(index).toString());
        gender_tf.setText(gender.getCellData(index).toString());
        role_tf.setText(role.getCellData(index).toString());

    }

    public void Edit() {
        try {
            Connection conn = DB.getInstance().getConnection();
            String value1 = id.getText();
            String value2 = firstname.getText();
            String value3 = lastname.getText();
            String value4 = username.getText();
            String value5 = password.getText();
            String value6 = email.getText();
            String value7 = phone.getText();
            String value8 = age.getText();
            String value9 = gender.getText();
            String value10 = role.getText();
            String sql = "update users set id= '" + value1 + "',firstName= '" + value2 + "',LastName= '"
                    + value3 + "',username= '" + value4 + "',password= '" + value5 + "',email= '" + value6 + "',phone= '"
                    + "" + value7 + "',age= '" + value8 + "',gender= '" + value9 + "',role= '" + value10 + "' where id='" + value1 + "' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Delete() throws SQLException {
        Connection c = DB.getInstance().getConnection();
        String sql = "delete from users where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void UpdateTable() throws SQLException {
        id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastname"));
        username.setCellValueFactory(new PropertyValueFactory<Patient, String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<Patient, String>("password"));
        email.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
        age.setCellValueFactory(new PropertyValueFactory<Patient, String>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        role.setCellValueFactory(new PropertyValueFactory<Patient, String>("role"));

        listM = getDatausers();
        tableview.setItems(listM);
    }

    @FXML
    void search_user() throws SQLException {
        id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastname"));
        username.setCellValueFactory(new PropertyValueFactory<Patient, String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<Patient, String>("password"));
        email.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
        age.setCellValueFactory(new PropertyValueFactory<Patient, String>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        role.setCellValueFactory(new PropertyValueFactory<Patient, String>("role"));
        dataList = getDatausers();
        tableview.setItems(dataList);
        FilteredList<Patient> filteredData = new FilteredList<>(dataList, b -> true);
        textfieldsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches firstName
                } else {
                    return false;
                }

            });
        });
        SortedList<Patient> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
    }

   

    public static ObservableList<Patient> getDatausers() throws SQLException {
        Connection c = DB.getInstance().getConnection();
        ObservableList<Patient> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = c.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Patient(rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

            }
        } catch (Exception e) {
        }
        return list;
    }
    
     public void cancel2(ActionEvent event) {
      View.ViewManager.patientPage.changeSceneToPatientLogin();
       
    }
}
