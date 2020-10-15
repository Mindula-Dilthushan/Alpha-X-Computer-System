package dao;

import db.DBConnection;

import java.sql.PreparedStatement;

public class CrudUtil {
    public static <T> T execute(String sql,Object...args) throws Exception {
        PreparedStatement pstm= DBConnection.getInstance().getConnection().prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pstm.setObject((i+1),args[i]);
            }
                if (sql.startsWith("SELECT")){
                    return (T)pstm.executeQuery();
                }
                return ((T)(Boolean)(pstm.executeUpdate()>0));
    }
}
