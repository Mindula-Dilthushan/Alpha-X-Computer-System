//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package bo.custom;

import dto.CustomerDTO;
import java.util.ArrayList;

public interface CustomerBO {
    public boolean saveCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(String id) throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception;
    public CustomerDTO searchCustomer(String id) throws Exception;
    public CustomerDTO getCustCont(String cont) throws Exception;
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception;
    public String getListener() throws Exception;
    public int getCustCount() throws Exception;
}
