//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-17-20
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.SupplierDAO;
import entity.custom.Supplier;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean save(Supplier supplier) throws Exception {
        return CrudUtil.execute("INSERT INTO supplier VALUES(?,?,?,?,?)",
                supplier.getSid(),
                supplier.getSname(),
                supplier.getSaddress(),
                supplier.getScontact(),
                supplier.getSemail()
        );
    }
    @Override
    public boolean delete(String s) throws Exception {
        boolean supplier_delete = CrudUtil.execute(" DELETE FROM supplier WHERE sid=?", s);
        return  supplier_delete;
    }
    @Override
    public boolean update(Supplier supplier) throws Exception {
        return CrudUtil.execute(" UPDATE supplier SET sname=?,saddress=?,scontact=?,semail=? WHERE sid=?",
                supplier.getSname(),
                supplier.getSaddress(),
                supplier.getScontact(),
                supplier.getSemail(),
                supplier.getSid()
        );
    }
    @Override
    public Supplier search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM supplier WHERE sid=?",s);
            if (resultSet.next()) {
                return new Supplier(
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
    public List<Supplier> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM supplier");
        ArrayList<Supplier> supplierArrayList = new ArrayList<>();
        while (resultSet.next()) {
            supplierArrayList.add(
                    new Supplier(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5)
                    )
            );
        }
        return supplierArrayList;
    }
    @Override
    public Supplier getSupCont(String cont) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM supplier WHERE scontact=?",cont);
        if (resultSet.next()) {
            return new Supplier(
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
        ResultSet set = CrudUtil.execute("SELECT sid FROM supplier ORDER BY sid DESC LIMIT 1");
        String sid="S001";
        if (set.next()){
            String temp=set.getString(1);
            String[] cs = temp.split("S");
            int selectedId=Integer.parseInt(cs[1]);
            if (selectedId>10){
                sid="S0"+(selectedId+1);
            }
        }
        return sid;
    }

    @Override
    public int getSupCount() throws Exception {
        String SQL = "SELECT COUNT(sid) FROM supplier";
        ResultSet rst = CrudUtil.execute(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }

    @Override
    public int sumSup() throws Exception {
        String getIncome = "SELECT SUM(sid) as getAll FROM supplier";
        ResultSet resultSet = CrudUtil.execute(getIncome);
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }
}
