//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_com_shop","root","1023");
    }
    public static DBConnection getInstance()throws Exception{
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
