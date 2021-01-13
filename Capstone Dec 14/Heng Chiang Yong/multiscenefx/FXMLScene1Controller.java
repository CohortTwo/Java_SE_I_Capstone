/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiscenefx;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chiangyong
 */
public class FXMLScene1Controller implements Initializable {

    @FXML
    private AnchorPane scene1;
    @FXML
    private Button btnScene1;
    @FXML
    private TextField mainText;
    @FXML
    private Text dispText;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMultiScene.fxml"));
        Parent root = loader.load();
        FXMLMultiSceneController second = loader.getController();
        second.myFunction(mainText.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(mainText.getText());
        stage.show();

// Closing the Current Scene.
        Stage stage1 = (Stage) btnScene1.getScene().getWindow();
        stage1.close();
    }
    
    public void myFunction(String str)
    {
        dispText.setText(str);
    }
    
}
