package controller.dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import util.UtilImpl;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashBordFormController implements Initializable {

    public AnchorPane anchorDashBoard;
    public JFXButton btnProduct,btnSupplier,btnCustomer,btnPlaceOrder,btnSells,btnExit;
    public JFXButton btnHome;
    public Label lblTime;
    public Label lblDate;

    //Property Injection
    UtilImpl util = new UtilImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/MenuForm.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        generateDateTime();
    }
    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        try {
            util.lordAntoAn(anchorDashBoard,"dashboard/OrderMainForm.fxml");
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
    private void generateDateTime() {
        lblDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
