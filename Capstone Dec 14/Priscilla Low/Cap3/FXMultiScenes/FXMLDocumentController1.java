/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmultiscenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author blueg
 */
public class FXMLDocumentController1 implements Initializable {
    
    @FXML
    private Button button2;
    @FXML
    private Label label2;
    @FXML
    private TextField textfield2;
    @FXML
    private AnchorPane rootpane;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        //navigate from one scene to another
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        rootpane.getChildren().setAll(pane);
        
        //navigate from one scene to another with instance referencing the values
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
       
        FXMLDocumentController firstwindow = loader.getController();
        firstwindow.strFunction(textfield2.getText());
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(textfield2.getText());
        stage.show();
        
        Stage stage1 = (Stage) button2.getScene().getWindow();
        stage1.close();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void strFunction(String str){
        label2.setText(str);
    }


    
}
