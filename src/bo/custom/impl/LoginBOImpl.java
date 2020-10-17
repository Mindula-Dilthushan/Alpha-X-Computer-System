//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package bo.custom.impl;

import bo.custom.LoginBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.custom.LoginDAO;
import javafx.scene.layout.AnchorPane;

public class LoginBOImpl implements LoginBO {

    //Property Injection
    private LoginDAO loginDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.LOGIN);

    @Override
    public void loginNow(AnchorPane anchorPane,JFXTextField tel, JFXPasswordField password, String location, JFXButton btn) throws Exception {
        loginDAO.loginNow(anchorPane,tel,password,location,btn);
    }
}
