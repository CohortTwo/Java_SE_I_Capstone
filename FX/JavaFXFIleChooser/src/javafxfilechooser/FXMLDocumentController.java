/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxfilechooser;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

/**
 *
 * @author sridh
 */
public class FXMLDocumentController implements Initializable {

 
    @FXML
    private ListView<String> filelist;
    @FXML
    private MenuItem fopen;
    @FXML
    private MenuItem fclose;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filelist.setVisible(false);
    }

    public void SelectFile() {
        FileChooser fc = new FileChooser();
           fc.setInitialDirectory(new File("D:\\Sample folder"));
           fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text","*.txt"));

        File selectedfile = fc.showOpenDialog(null);
        filelist.setVisible(true);

        if (selectedfile != null) {
            filelist.getItems().add(selectedfile.getAbsolutePath());
        } else {
            System.out.println("File Not Valid");
        }
    }

    @FXML
    public void SelectFiles() {
        FileChooser fc = new FileChooser();
//           fc.setInitialDirectory(new File("D:\\Sample folder"));
//           fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text","*.txt"));
        List<File> selectedfiles = fc.showOpenMultipleDialog(null);

        if (selectedfiles != null) {
            for (int i = 0; i < selectedfiles.size(); i++) {
                String temp = selectedfiles.get(i).getAbsolutePath();
                filelist.getItems().add(temp);
                filelist.setVisible(true);
            }
        } else {
            System.out.println("File Not Valid");
        }
    }

    @FXML
    public void CloseAPP(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
