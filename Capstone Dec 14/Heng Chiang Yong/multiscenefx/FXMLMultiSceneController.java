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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author chiangyong
 */
public class FXMLMultiSceneController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnMain;
    @FXML
    private TextField mainText;
    @FXML
    private AnchorPane MainScene;
    @FXML
    private Text maindispText;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        // code to navigate from one scene to the other with instance referencing the values.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLScene1.fxml"));
        Parent root = loader.load();
        FXMLScene1Controller second = loader.getController();
        second.myFunction(mainText.getText());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(mainText.getText());
        stage.show();

// Closing the Current Scene.
        Stage stage1 = (Stage) btnMain.getScene().getWindow();
        stage1.close();
        
        
    }
    
    public void myFunction(String str)
    {
         maindispText.setText(str);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
