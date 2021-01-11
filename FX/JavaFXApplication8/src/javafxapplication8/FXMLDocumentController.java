/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author sridh
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button btnclk;
    @FXML
    private Label lbl1;
    @FXML
    private TextField txt1;
    @FXML
    private Label lbl2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
            
           // String s = txt1.getText();
            //lbl1.setText(s);
            String append =  txt1.getText().toUpperCase()+ "\n";
            append = append + " " +txt1.getText().toLowerCase()+ "\n";
            append = append + " The length of the string entererd is "+txt1.getText().length()+ "\n";
                    lbl1.setText(append);
            append = "*";        
            for (int x = 1; x <50; x++)
            {
                 append = append+" ";
            }
           append = append+"*";
            lbl2.setText(append);
            
            
           
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
