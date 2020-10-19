package controller.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CustomerOrderFormController {
    public JFXTextField txtCustID;
    public JFXTextField txtCustName;
    public JFXTextField txtCustCont;
    public JFXTextField txtProID;
    public JFXTextField txtProBrand;
    public JFXTextField txtProName;
    public JFXTextField txtProDesc;
    public JFXTextField txtProPrice;
    public TextField txtQtyOnHand;
    public JFXButton btnCustClear;
    public JFXButton btnProClear;
    public TableView tblInCome;
    public TableColumn colInp;
    public TableColumn colOrid;
    public TableColumn colCid;
    public TableColumn colPid;
    public TableColumn colQty;
    public TableColumn colQtyTotal;
    public JFXButton btnPlus;
    public Label lblCustomTotal;
    public Label txtAllTotal;
    public JFXButton btnPayNow;
    public RadioButton cash;
    public ToggleGroup rbtnInPayType;
    public RadioButton rbtncard;
    public ToggleGroup rbtnPayType;
    public JFXButton btnMin;

    public void btnMinOnAction(ActionEvent actionEvent) {
    }

    public void btnPayNowOnAction(ActionEvent actionEvent) {
    }

    public void btnPlusOnAction(ActionEvent actionEvent) {
    }

    public void btnProClearOnAction(ActionEvent actionEvent) {
    }

    public void btnCustClearOnAction(ActionEvent actionEvent) {
    }

    public void txtProIDOnAction(ActionEvent actionEvent) {
    }

    public void txtSupIDOnAction(ActionEvent actionEvent) {
    }
}
