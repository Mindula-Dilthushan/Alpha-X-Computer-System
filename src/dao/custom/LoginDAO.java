//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package dao.custom;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.CrudDAO;
import entity.custom.Login;
import javafx.scene.layout.AnchorPane;

public interface LoginDAO extends CrudDAO <Login,String> {
    public void loginNow(AnchorPane anchorPane,JFXTextField tp, JFXPasswordField pw, String location, JFXButton btn)throws Exception;
}
