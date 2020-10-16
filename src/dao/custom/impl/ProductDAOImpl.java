//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-16-20
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ProductDAO;
import entity.custom.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean save(Product product) throws Exception {
        return CrudUtil.execute("INSERT INTO product VALUES(?,?,?,?,?,?)",
                product.getPid(),
                product.getPbrand(),
                product.getPname(),
                product.getPdesc(),
                product.getPqty(),
                product.getPprice()
        );
    }
    @Override
    public boolean delete(String s) throws Exception {
        boolean product_delete = CrudUtil.execute(" DELETE FROM product WHERE pid=?", s);
        return  product_delete;
    }
    @Override
    public boolean update(Product product) throws Exception {
        return CrudUtil.execute(" UPDATE product SET pbrand=?,pname=?,pdesc=?,pqty=?,pprice=? WHERE pid=?",
                product.getPbrand(),
                product.getPname(),
                product.getPdesc(),
                product.getPqty(),
                product.getPprice(),
                product.getPid()
        );
    }
    @Override
    public Product search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM product WHERE pname=?",s);
        if (resultSet.next()) {
            return new Product(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(6)
            );
        } else {
            return null;
        }
    }
    @Override
    public List<Product> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM product");
        ArrayList<Product> productArrayList = new ArrayList<>();
            while (resultSet.next()) {
                productArrayList.add(
                        new Product(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getInt(5),
                                resultSet.getDouble(6)
                        )
                );
            }
            return productArrayList;
    }
    @Override
    public Product getProID(String id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM product WHERE pid=?",id);
        if (resultSet.next()) {
            return new Product(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(6)
            );
        } else {
            return null;
        }
    }
    @Override
    public int getProCount() throws Exception {
        String SQL = "SELECT COUNT(pid) FROM product";
        ResultSet rst = CrudUtil.execute(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }
    @Override
    public int sumProductQty() throws Exception {
        String getIncome = "SELECT SUM(pqty) as getAll FROM product";
            ResultSet resultSet = CrudUtil.execute(getIncome);
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }
                return 0;
    }
    @Override
    public String getListener() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT pid FROM product ORDER BY pid DESC LIMIT 1");
        String pid="P001";
        if (set.next()){
            String temp=set.getString(1);
            String[] cs = temp.split("P");
            int selectedId=Integer.parseInt(cs[1]);
            if (selectedId>10){
                pid="P0"+(selectedId+1);
            }
        }
        return pid;
    }
}
