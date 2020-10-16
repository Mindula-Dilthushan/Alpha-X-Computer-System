//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-15-20
package bo;

import bo.custom.impl.LoginBOImpl;
import bo.custom.impl.ProductBOImpl;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getInstance(){
        return (boFactory==null) ? (boFactory = new BOFactory()) : (boFactory);
    }
    public enum BOType{
        LOGIN,
        PRODUCT
    }
    public <T> T getBO(BOType boType){
        switch (boType){
            case LOGIN:
                return (T) new LoginBOImpl();
            case PRODUCT:
                return (T) new ProductBOImpl();
            default:
                return null;
        }
    }
}
