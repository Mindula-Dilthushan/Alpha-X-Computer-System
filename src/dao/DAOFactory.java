//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package dao;

import dao.custom.impl.*;

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
        SUPPLIER,
        CUSTOMER,
        SUPPLIERORDER,
        SUPPLIERORDERDETAIL,
        OUTPAYMENT,

    }
    public <T> T getDAO(DAOType daoType){
        switch (daoType){
            case LOGIN:
                return (T) new LoginDAOImpl();
            case PRODUCT:
                return (T) new ProductDAOImpl();
            case SUPPLIER:
                return (T) new SupplierDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case SUPPLIERORDER:
                return (T) new SupplierOrderDAOImpl();
            case SUPPLIERORDERDETAIL:
                return (T) new SupplierOrderDetailDAOImpl();
            case OUTPAYMENT:
                return (T) new OutPaymentDAOImpl();
            default:
                return null;
        }
    }
}
