/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxjdbcdate;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author sridh
 */
public class FXMLJdbcDateController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<Testage> tvage;
    @FXML
    private TableColumn<Testage, String> tcname;
    @FXML
    private TableColumn<Testage, Date> tcdob;
    @FXML
    private TextField txtname;
    @FXML
    private DatePicker dpdob;
    @FXML
    private Button btn;

    @FXML
    private void handleButtonAction(ActionEvent event) {
             createRecord();
    }


    public Connection getConnection() {
        Connection conn;
        try {
            //  Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sridhar", "simon");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ObservableList<Testage> getNames() {
        ObservableList<Testage> agelist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "Select * from testage";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            Testage age;
            while (rs.next()) {
                age = new Testage(rs.getString("name"), rs.getDate("dob"));
                agelist.add(age);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return agelist;
    }

    public void displayRecords() {
        ObservableList<Testage> listage = getNames();
        tcname.setCellValueFactory(new PropertyValueFactory<Testage, String>("name"));
        tcdob.setCellValueFactory(new PropertyValueFactory<Testage, Date>("dob"));
        tvage.setItems(listage);
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createRecord() {
        String query = "INSERT into testage (name,dob) VALUES ('"+ txtname.getText() +"' ,TO_DATE('"+ dpdob.getValue()+ "', 'YYYY-MM-DD'))";
        System.out.println(query);
        executeQuery(query);
        displayRecords();
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                displayRecords();
    }
      
 
}
