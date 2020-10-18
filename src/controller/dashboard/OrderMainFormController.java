//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-19-20
package controller.dashboard;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.UtilImpl;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderMainFormController implements Initializable {
    public AnchorPane anchorOrderForm;
    public TextField txtOutPayID;
    public TextField txtSupOrderID;
    public TextField txtIncomeID;
    public TextField txtCustOrderID;

    UtilImpl util = new UtilImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            util.lordAntoAn(anchorOrderForm,"dashboard/SupplierOrderForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
