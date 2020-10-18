package controller.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SupplierOrderFormController {
    public JFXTextField txtSupID;
    public JFXTextField txtSupName;
    public JFXTextField txtSupCont;
    public JFXTextField txtProID;
    public JFXTextField txtProBrand;
    public JFXTextField txtProName;
    public JFXTextField txtProDesc;
    public JFXTextField txtProPrice;
    public TextField txtQtyOnHand;
    public JFXButton btnSupClear;
    public JFXButton btnProClear;
    public TableView tblOutCome;
    public TableColumn colOtp;
    public TableColumn colOrid;
    public TableColumn colSid;
    public TableColumn colPid;
    public TableColumn colQty;
    public TableColumn colQtyTotal;
    public JFXButton btnPlus;
    public JFXButton btnMin;
    public Label lblCustomTotal;
    public Label txtAllTotal;
    public JFXButton btnPayNow;
    public RadioButton cash;
    public RadioButton rbtncard;
    public ToggleGroup rbtnPayType;

    public void btnPayNowOnAction(ActionEvent actionEvent) {
    }

    public void btnMinOnAction(ActionEvent actionEvent) {
    }

    public void btnPlusOnAction(ActionEvent actionEvent) {
    }

    public void btnProClearOnAction(ActionEvent actionEvent) {
    }

    public void btnSupClearOnAction(ActionEvent actionEvent) {
    }

    public void txtProIDOnAction(ActionEvent actionEvent) {
    }

    public void txtSupIDOnAction(ActionEvent actionEvent) {
    }
}
