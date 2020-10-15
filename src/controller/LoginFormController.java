//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;


public class LoginFormController{

    public JFXTextField txtTele;
    public JFXPasswordField txtPw;
    public JFXButton btnLogin;
    public AnchorPane anchorLoginForm;

    LoginBO loginBO = BOFactory.getInstance().getBO(BOFactory.BOType.LOGIN);

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        try {
            loginBO.loginNow(anchorLoginForm,txtTele,txtPw,"dashboard/DashBordForm.fxml",btnLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard/DashBordForm.fxml"));
//        Scene scene = btnLogin.getScene();
//
//        root.translateXProperty().set(scene.getHeight());
//
//        AnchorPane anchorPane = (AnchorPane) scene.getRoot();
//        anchorPane.getChildren().add(root);
//
//        Timeline timeline = new Timeline();
//        KeyValue keyValue = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_OUT);
//        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
//        timeline.getKeyFrames().add(keyFrame);
//        timeline.setOnFinished(event -> {
//            anchorPane.getChildren().remove(anchorLoginForm);
//        });
    }
}
