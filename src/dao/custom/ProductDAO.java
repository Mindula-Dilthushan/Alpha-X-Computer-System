//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-16-20
package dao.custom;

import dao.CrudDAO;
import entity.custom.Product;

public interface ProductDAO extends CrudDAO<Product,String> {
    public Product getProID(String id) throws Exception;
    public int getProCount() throws Exception;
    public int sumProductQty() throws Exception;
    public String getListener() throws Exception;
}
