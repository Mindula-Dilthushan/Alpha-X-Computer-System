package dao.custom.impl;

import dao.custom.SupplierOrderDAO;
import entity.custom.SupplierOrder;
import java.util.List;

public class SupplierOrderDAOImpl implements SupplierOrderDAO {
    
    @Override
    public boolean save(SupplierOrder supplierOrder) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(SupplierOrder supplierOrder) throws Exception {
        return false;
    }

    @Override
    public SupplierOrder search(String s) throws Exception {
        return null;
    }

    @Override
    public List<SupplierOrder> getAll() throws Exception {
        return null;
    }
}
