package dao.custom.impl;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.custom.LoginDAO;
import db.DBConnection;
import entity.custom.Login;
import javafx.scene.layout.AnchorPane;
import util.UtilImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {

    UtilImpl util = new UtilImpl();

    @Override
    public void loginNow(AnchorPane anchorPane, JFXTextField tp, JFXPasswordField pw, String location, JFXButton btn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM login WHERE tp=? AND pw=?");
            ps.setString(1,tp.getText());
            ps.setString(2,pw.getText());
                ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        util.ImgNotification("asserts/ok.png","Login Success","Welcome Alpha X Computer System");
                        util.lordAntoAn(anchorPane,location);
                    } else {
                        util.ImgNotification("asserts/wrong.png","Login UnSuccess","Try Again Now");
                    }
    }
    @Override
    public boolean save(Login login) throws Exception {
        return false;
    }
    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }
    @Override
    public boolean update(Login login) throws Exception {
        return false;
    }
    @Override
    public Login search(String s) throws Exception {
        return null;
    }
    @Override
    public List<Login> getAll() throws Exception {
        return null;
    }
}
