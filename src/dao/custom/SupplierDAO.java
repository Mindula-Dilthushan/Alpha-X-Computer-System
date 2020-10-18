//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-17-20
package dao.custom;

import dao.CrudDAO;
import entity.custom.Supplier;

public interface SupplierDAO extends CrudDAO<Supplier,String> {
    public Supplier getSupCont(String cont) throws Exception;
    public String getListener() throws Exception;
    public int getSupCount() throws Exception;
}
