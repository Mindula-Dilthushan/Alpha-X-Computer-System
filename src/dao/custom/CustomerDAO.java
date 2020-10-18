//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package dao.custom;

import dao.CrudDAO;
import entity.custom.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    public Customer getCustCont(String cont) throws Exception;
    public String getListener() throws Exception;
    public int getCustCount() throws Exception;
}
