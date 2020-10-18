package dao.custom.impl;

import dao.custom.OutPaymentDAO;
import entity.custom.OutPayment;
import java.util.List;

public class OutPaymentDAOImpl implements OutPaymentDAO {
    @Override
    public boolean save(OutPayment outPayment) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(OutPayment outPayment) throws Exception {
        return false;
    }

    @Override
    public OutPayment search(String s) throws Exception {
        return null;
    }

    @Override
    public List<OutPayment> getAll() throws Exception {
        return null;
    }
}
