/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmenu;

import com.sun.jndi.dns.DnsContextFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author sridh
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private MenuItem fmclose;
    @FXML
    private MenuBar menubar;
    @FXML
    private Menu filemenu;
    @FXML
    private Menu menuedit;
    @FXML
    private Menu menuhelp;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void CloseAPP(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
}
