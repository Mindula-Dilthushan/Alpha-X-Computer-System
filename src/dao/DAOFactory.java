//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package dao;

import dao.custom.impl.LoginDAOImpl;
import dao.custom.impl.ProductDAOImpl;
import dao.custom.impl.SupplierDAOImpl;

public class DAOFactory {

    private static  DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getInstance(){
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : (daoFactory);
    }
    public enum DAOType{
        LOGIN,
        PRODUCT,
        SUPPLIER
    }
    public <T> T getDAO(DAOType daoType){
        switch (daoType){
            case LOGIN:
                return (T) new LoginDAOImpl();
            case PRODUCT:
                return (T) new ProductDAOImpl();
            case SUPPLIER:
                return (T) new SupplierDAOImpl();
            default:
                return null;
        }
    }
}
