//Alpha X Com System
//Software Design Alpha X Software Solution
package controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import util.UtilImpl;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    public AnchorPane anchorMainForm;

    //Property Injection
    UtilImpl util = new UtilImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            util.lordAntoAn(anchorMainForm,"LoginForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
