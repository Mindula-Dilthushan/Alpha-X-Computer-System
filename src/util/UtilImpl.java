//Alpha X Com System
//Software Design Alpha X Software Solution
package util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import java.net.URL;

public class UtilImpl {


    public void lordAntoAn(AnchorPane anchorPane, String location) throws Exception {
        anchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/" + location));
        anchorPane.getChildren().addAll(load.getChildren());
    }

    public void lordUIandExit(String location, JFXButton btn) throws Exception {
        Stage exit_stage = (Stage) btn.getScene().getWindow();
        exit_stage.close();
        URL resource = this.getClass().getResource("/view/"+location);
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public void ImgNotification(String url, String title, String text) {
        Image image = new Image(url,50,50,false,false);
        Notifications notifications = Notifications.create();
        notifications.title(title);
        notifications.graphic(new ImageView(image));
        notifications.text(text);
        notifications.hideAfter(Duration.seconds(5));
        notifications.position(Pos.TOP_RIGHT);
        notifications.darkStyle();
        notifications.show();
    }

    public void btnExit(JFXButton btn) throws Exception {
        Stage exit_stage = (Stage) btn.getScene().getWindow();
        exit_stage.close();
    }
    public void textFocusColor(JFXTextField txt)throws Exception{
        txt.requestFocus();
        txt.setFocusColor(Paint.valueOf("red"));
    }
}
