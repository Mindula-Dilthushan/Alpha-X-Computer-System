//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-19-20
package controller.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    public JFXButton btnSupOrder;
    public JFXButton btnCustOrder;
    public Label lblOutPay;
    public Label lblOutOrder;
    public Label lblInPay;
    public Label lblInOrder;
    public Label lblCustomOrder;
    public Label lblSupplierOrder;

    UtilImpl util = new UtilImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            util.lordAntoAn(anchorOrderForm,"dashboard/SupplierOrderForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        custSetVisibleFalse();
        lblCustomOrder.setVisible(false);
        lblSupplierOrder.setVisible(true);
    }

    public void btnCustOrderOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorOrderForm,"dashboard/CustomerOrderForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        custSetVisibleTrue();
        supSetVisibleFalse();
        lblCustomOrder.setVisible(true);
        lblSupplierOrder.setVisible(false);
    }
    public void btnSupOrderOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorOrderForm,"dashboard/SupplierOrderForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        custSetVisibleFalse();
        supSetVisibleTrue();
        lblCustomOrder.setVisible(false);
        lblSupplierOrder.setVisible(true);
    }
    private void supSetVisibleFalse(){
        txtOutPayID.setVisible(false);
        txtSupOrderID.setVisible(false);
        lblOutOrder.setVisible(false);
        lblOutPay.setVisible(false);
    }
    private void supSetVisibleTrue(){
        txtOutPayID.setVisible(true);
        txtSupOrderID.setVisible(true);
        lblOutOrder.setVisible(true);
        lblOutPay.setVisible(true);
    }
    private void custSetVisibleFalse(){
        txtCustOrderID.setVisible(false);
        txtIncomeID.setVisible(false);
        lblInPay.setVisible(false);
        lblInOrder.setVisible(false);
    }
    private void custSetVisibleTrue(){
        txtCustOrderID.setVisible(true);
        txtIncomeID.setVisible(true);
        lblInPay.setVisible(true);
        lblInOrder.setVisible(true);
    }
}
