//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-17-20
package bo.custom.impl;

import bo.custom.SupplierBO;
import dao.DAOFactory;
import dao.custom.SupplierDAO;
import dto.SupplierDTO;
import entity.custom.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    //Property Injection
    private SupplierDAO supplierDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SUPPLIER);

    @Override
    public boolean saveSupplier(SupplierDTO supplierDTO) throws Exception {
        return supplierDAO.save(
                new Supplier(
                        supplierDTO.getSid(),
                        supplierDTO.getSname(),
                        supplierDTO.getSaddress(),
                        supplierDTO.getScontact(),
                        supplierDTO.getSemail()
                )
        );
    }
    @Override
    public boolean deleteSupplier(String id) throws Exception {
        return supplierDAO.delete(id);
    }
    @Override
    public boolean updateSupplier(SupplierDTO supplierDTO) throws Exception {
        return supplierDAO.update(
                new Supplier(
                        supplierDTO.getSid(),
                        supplierDTO.getSname(),
                        supplierDTO.getSaddress(),
                        supplierDTO.getScontact(),
                        supplierDTO.getSemail()
                )
        );
    }
    @Override
    public SupplierDTO searchSupplier(String id) throws Exception {
        Supplier supplier=supplierDAO.search(id);
        return new SupplierDTO(
                supplier.getSid(),
                supplier.getSname(),
                supplier.getSaddress(),
                supplier.getScontact(),
                supplier.getSemail()
        );
    }
    @Override
    public SupplierDTO getSupCont(String cont) throws Exception {
        Supplier supplier=supplierDAO.getSupCont(cont);
        return new SupplierDTO(
                supplier.getSid(),
                supplier.getSname(),
                supplier.getSaddress(),
                supplier.getScontact(),
                supplier.getSemail()
        );
    }
    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws Exception {
        List<Supplier> supplierList = supplierDAO.getAll();
        ArrayList<SupplierDTO> supplierDTOArrayList = new ArrayList();
        for (Supplier supplier: supplierList) {
            supplierDTOArrayList.add(
                    new SupplierDTO(
                            supplier.getSid(),
                            supplier.getSname(),
                            supplier.getSaddress(),
                            supplier.getScontact(),
                            supplier.getSemail()
                    )
            );
        }
        return supplierDTOArrayList;
    }
    @Override
    public String getListener() throws Exception {
        return supplierDAO.getListener();
    }
    @Override
    public int getSupCount() throws Exception {
        return supplierDAO.getSupCount();
    }
}
