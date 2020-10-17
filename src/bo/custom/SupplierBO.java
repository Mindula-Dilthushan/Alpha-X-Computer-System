package bo.custom;

import dto.SupplierDTO;
import java.util.ArrayList;

public interface SupplierBO {
    public boolean saveSupplier(SupplierDTO supplierDTO)throws Exception;
    public boolean deleteSupplier(String id) throws Exception;
    public boolean updateSupplier(SupplierDTO supplierDTO) throws Exception;
    public SupplierDTO searchSupplier(String id) throws Exception;
    public SupplierDTO getSupCont(String cont) throws Exception;
    public ArrayList<SupplierDTO> getAllSupplier() throws Exception;
    public String getListener() throws Exception;
    public int getSupCount() throws Exception;
    public int sumSup() throws Exception;
}
