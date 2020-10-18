//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.custom.Customer;
import entity.custom.Supplier;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?)",
                customer.getCid(),
                customer.getCname(),
                customer.getCaddress(),
                customer.getCcontact(),
                customer.getCemail()
        );
    }
    @Override
    public boolean delete(String s) throws Exception {
        boolean customer_delete = CrudUtil.execute(" DELETE FROM customer WHERE cid=?", s);
        return  customer_delete;
    }
    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.execute(" UPDATE customer SET cname=?,caddress=?,ccontact=?,cemail=? WHERE cid=?",
                customer.getCname(),
                customer.getCaddress(),
                customer.getCcontact(),
                customer.getCemail(),
                customer.getCid()
        );
    }
    @Override
    public Customer search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer WHERE cid=?",s);
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }
    @Override
    public List<Customer> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        while (resultSet.next()) {
            customerArrayList.add(
                    new Customer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5)
                    )
            );
        }
        return customerArrayList;
    }
    @Override
    public Customer getCustCont(String cont) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer WHERE ccontact=?",cont);
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }
    @Override
    public String getListener() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT cid FROM customer ORDER BY cid DESC LIMIT 1");
        String cid="C001";
            if (set.next()){
                String temp=set.getString(1);
                String[] cs = temp.split("C");
                int selectedId=Integer.parseInt(cs[1]);
                if (selectedId>10){
                    cid="C0"+(selectedId+1);
                }
            }
            return cid;
    }
    @Override
    public int getCustCount() throws Exception {
        String SQL = "SELECT COUNT(cid) FROM customer";
        ResultSet rst = CrudUtil.execute(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }
}
