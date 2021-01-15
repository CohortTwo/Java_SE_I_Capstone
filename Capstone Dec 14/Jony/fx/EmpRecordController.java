package EmpRecordFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.List;

public class EmpRecordController implements Initializable {

    @FXML
    private Button btnRet;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnRem;
    @FXML
    private TextField txtlname;
    @FXML
    private TextField txtjob;
    @FXML
    private ChoiceBox cbdeptid;
    @FXML
    private ChoiceBox cbmid;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtsal;
    @FXML
    private ChoiceBox cbcomms;
    @FXML
    private DatePicker dphdate;
    @FXML
    private TextField txteid;
    @FXML
    private TextField txtfname;

    @FXML
    private TableView<Employees> tvemp;
    @FXML
    private TableColumn<Employees, Integer> coleid;
    @FXML
    private TableColumn<Employees, String> colfname;
    @FXML
    private TableColumn<Employees, String> collname;
    @FXML
    private TableColumn<Employees, Integer> coldeptid;
    @FXML
    private TableColumn<Employees, String> coljob;
    @FXML
    private TableColumn<Employees, Integer> colsal;
    @FXML
    private TableColumn<Employees, Integer> colcomms;
    @FXML
    private TableColumn<Employees, String> colemail;
    @FXML
    private TableColumn<Employees, Date> colhdate;
    @FXML
    private TableColumn<Employees, Integer> colmid;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnAdd) {
            createRecords();
        } else if (event.getSource() == btnEdit) {
            editRecord();
        } else if (event.getSource() == btnRem) {
            removeRecord();
        }

    }

//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        if (event.getSource() == btnAdd) {
//            createRecords();
//        } else if (event.getSource() == btnEdit) {
//            editRecord();
//        } else if (event.getSource() == btnRem) {
//            removeRecord();
//        } else if (event.getSource() == btnRet) {
//            retrieveRecord();
//        }
//
//    }



    public Connection getConnection() {
        Connection conn;
        try {
//            conn = DriverManager
//                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sridhar", "simon");
            conn = DriverManager
                    .getConnection("jdbc:sqlite://Users/jony/Desktop/SGUS/Java/EmpRecordFX/sqlite_emp.db");
//            Statement stmt = conn.createStatement();
//            stmt.execute("CREATE TABLE IF NOT EXISTS employees" +
//                    "(eid INTEGER, fname TEXT, lname TEXT, job TEXT, deptid INTEGER, mid INTEGER, email TEXT, salary INTEGER, comms INTEGER, hdate TEXT)");
            return conn;
        } catch (Exception e) {
            return null;
        }

    }

    public ObservableList<Employees> getEmployeeList() {
        ObservableList<Employees> emplist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "Select * from emp";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            Employees emp;
            while (rs.next()) {
                emp = new Employees(rs.getInt("eid"), rs.getString("fname"), rs.getString("lname"), rs.getString("job"), rs.getInt("deptid"), rs.getInt("mid"), rs.getString("email"), rs.getInt("salary"), rs.getInt("comms"), rs.getDate("hdate"));
                emplist.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emplist;
    }

    public void displayEmpRecords() {
        ObservableList<Employees> listemp = getEmployeeList();
        coleid.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("eid"));
        colfname.setCellValueFactory(new PropertyValueFactory<Employees, String>("fname"));
        collname.setCellValueFactory(new PropertyValueFactory<Employees, String>("lname"));
        colmid.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("mid"));
        coljob.setCellValueFactory(new PropertyValueFactory<Employees, String>("job"));
        coldeptid.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("deptid"));
        colhdate.setCellValueFactory(new PropertyValueFactory<Employees, Date>("hdate"));
        colcomms.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("comms"));
        colsal.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("salary"));
        colemail.setCellValueFactory(new PropertyValueFactory<Employees, String>("email"));

        tvemp.setItems(listemp);

    }

    private void loaddata() {

//        List list = new ArrayList();
//        list.remove(list);
//
//        list.addAll();
//        cbdeptid.getItems().addAll(list);
    }


    private void createRecords() {
        String query = "INSERT into emp (eid,fname,lname,job,deptid,mid,email,salary,comms,hdate) VALUES ('" + txteid.getText() + "','" + txtfname.getText() + "','" + txtlname.getText() + "','" + txtjob.getText() + "','"
                + cbdeptid.getValue() + "','" + cbmid.getValue() + "','" + txtemail.getText() + "','" + txtsal.getText() + "','" + cbcomms.getValue() + "', + TO_DATE('" + dphdate.getValue() + "', 'YYYY-MM-DD'))";
        executeQuery(query);
        displayEmpRecords();
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

    private void removeRecord() {
        String query = "delete from emp where eid =" + txteid.getText();
        executeQuery(query);
        displayEmpRecords();
    }

    private void editRecord() {
        System.out.println("Hello editing");
        String query = "UPDATE emp set fname = " + txtfname.getText()
                + "', lname ='" + txtlname.getText()
                + "', job ='" + txtjob.getText()
                + "', deptid ='" + cbdeptid.getValue()
                + "', mid =" + cbmid.getValue()
                + "', email ='" + txtemail.getText()
                + ", salary =" + txtsal.getText()
                + ", comms =" + cbcomms.getValue()
                + ", hdate =" + dphdate.getValue()
                + " where eid =" + txteid.getText() + "";
        executeQuery(query);
        System.out.println(query);
        displayEmpRecords();
    }

//    private void retrieveRecord() {
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbdeptid.getItems().removeAll(cbdeptid.getItems());
        cbdeptid.getItems().addAll(" ", "10", "20", "30", "40", "50");
        cbdeptid.getSelectionModel().select(" ");

        cbmid.getItems().removeAll(cbmid.getItems());
        cbmid.getItems().addAll(" ", "1100", "1200", "1300", "1400", "1500");
        cbmid.getSelectionModel().select(" ");

        cbcomms.getItems().removeAll(cbcomms.getItems());
        cbcomms.getItems().addAll("0", "2", "3", "4", "5");
        cbcomms.getSelectionModel().select("0");

    }

    @FXML
    private void handleScrollAction(MouseEvent event) {
        System.out.println("hello");
        Employees emp = tvemp.getSelectionModel().getSelectedItem();
        txteid.setText("" + emp.getEid());
        txtfname.setText(emp.getFname());
        txtlname.setText(emp.getLname());
        txtjob.setText(emp.getJob());
        cbmid.setValue("" + emp.getMid());
        cbdeptid.setValue("" + emp.getDeptid());
        txtemail.setText(emp.getEmail());
        cbcomms.setValue("" + emp.getComms());
        txtsal.setText("" + emp.getSalary());
//        dphdate.set(emp.getHdate());
    }
}
