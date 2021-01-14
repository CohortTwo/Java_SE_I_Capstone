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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FXMLDocument2Controller implements Initializable {

   @FXML
    private Button buttonsecond;

    @FXML
    private Label label2;

   
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        loader.load();
                      
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        
        stage.setScene(new Scene(p));
        stage.show(); 
        
        Stage stage1 = (Stage) buttonsecond.getScene().getWindow();
        stage1.close();
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setLabel2(String text) {
        label2.setText(text);
    }
    
}
