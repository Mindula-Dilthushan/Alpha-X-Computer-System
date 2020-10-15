package controller.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import util.UtilImpl;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBordFormController implements Initializable {

    public AnchorPane anchorDashBoard;
    public JFXButton btnProduct,btnSupplier,btnCustomer,btnPlaceOrder,btnSells,btnExit;
    public JFXButton btnHome;

    UtilImpl util = new UtilImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/MenuForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnSellsOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/SellsForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
    public void btnCustomerOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/CustomerForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnSupplierOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/SupplierForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnProductOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/ProductForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnExitOnAction(ActionEvent actionEvent) {
        try {
            util.btnExit(btnExit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnHomeOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/MenuForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
