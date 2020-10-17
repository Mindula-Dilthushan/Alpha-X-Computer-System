//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package bo.custom;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.AnchorPane;

public interface LoginBO {
    public void loginNow(AnchorPane anchorPane, JFXTextField tel, JFXPasswordField password, String location, JFXButton btn)throws Exception;
}
