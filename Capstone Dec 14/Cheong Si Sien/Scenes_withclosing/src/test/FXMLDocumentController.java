/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author A
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button buttonfirst;

    @FXML
    private Label label1;

    @FXML
    private TextField text1;

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String temp = text1.getText();
        System.out.println("tex is " + temp);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument2.fxml"));
        loader.load();
        FXMLDocument2Controller temp1 = loader.getController();
        temp1.setLabel2(temp);
        
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        
        stage.setScene(new Scene(p));
        stage.show(); 
        Stage stage1 = (Stage) buttonfirst.getScene().getWindow();
        stage1.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
