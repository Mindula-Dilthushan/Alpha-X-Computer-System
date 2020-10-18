//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.custom.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    //Property Injection
    private CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.save(
                new Customer(
                        customerDTO.getCid(),
                        customerDTO.getCname(),
                        customerDTO.getCaddress(),
                        customerDTO.getCcontact(),
                        customerDTO.getCemail()
                )
        );
    }
    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.update(
                new Customer(
                        customerDTO.getCid(),
                        customerDTO.getCname(),
                        customerDTO.getCaddress(),
                        customerDTO.getCcontact(),
                        customerDTO.getCemail()
                )
        );
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer customer=customerDAO.search(id);
        return new CustomerDTO(
                customer.getCid(),
                customer.getCname(),
                customer.getCaddress(),
                customer.getCcontact(),
                customer.getCemail()
        );
    }
    @Override
    public CustomerDTO getCustCont(String cont) throws Exception {
        Customer customer=customerDAO.getCustCont(cont);
        return new CustomerDTO(
                customer.getCid(),
                customer.getCname(),
                customer.getCaddress(),
                customer.getCcontact(),
                customer.getCemail()
        );
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        List<Customer> customerList = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOArrayList = new ArrayList();
        for (Customer customer: customerList) {
            customerDTOArrayList.add(
                    new CustomerDTO(
                            customer.getCid(),
                            customer.getCname(),
                            customer.getCaddress(),
                            customer.getCcontact(),
                            customer.getCemail()
                    )
            );
        }
        return customerDTOArrayList;
    }
    @Override
    public String getListener() throws Exception {
        return customerDAO.getListener();
    }
    @Override
    public int getCustCount() throws Exception {
        return customerDAO.getCustCount();
    }
}
