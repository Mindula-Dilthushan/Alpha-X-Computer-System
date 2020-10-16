package bo.custom;

import dto.ProductDTO;
import java.util.ArrayList;

public interface ProductBO {
    public boolean saveProduct(ProductDTO productDTO)throws Exception;
    public boolean deleteProduct(String id) throws Exception;
    public boolean updateProduct(ProductDTO productDTO) throws Exception;
    public ProductDTO searchProduct(String brand) throws Exception;
    public ProductDTO getProId(String id) throws Exception;
    public ArrayList<ProductDTO> getAllProduct() throws Exception;
    public int getProCount() throws Exception;
    public int sumProductQty() throws Exception;
    public String getListener()throws Exception;
}
