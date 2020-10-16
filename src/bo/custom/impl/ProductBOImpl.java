package bo.custom.impl;

import bo.custom.ProductBO;
import dao.DAOFactory;
import dao.custom.ProductDAO;
import dto.ProductDTO;
import entity.custom.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBOImpl implements ProductBO {

    //Property Injection
    private ProductDAO productDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PRODUCT);

    @Override
    public boolean saveProduct(ProductDTO productDTO) throws Exception {
        productDAO.save(
                new Product(
                    productDTO.getPid(),
                    productDTO.getPbrand(),
                    productDTO.getPname(),
                    productDTO.getPdesc(),
                    productDTO.getPqty(),
                    productDTO.getPprice()
                )
        );
        return false;
    }
    @Override
    public ProductDTO searchProduct(String brand) throws Exception {
        Product product=productDAO.search(brand);
            return new ProductDTO(
                    product.getPid(),
                    product.getPbrand(),
                    product.getPname(),
                    product.getPdesc(),
                    product.getPqty(),
                    product.getPprice()
            );
    }
    @Override
    public ProductDTO getProId(String id) throws Exception {
        Product product=productDAO.getProID(id);
        return new ProductDTO(
                product.getPid(),
                product.getPbrand(),
                product.getPname(),
                product.getPdesc(),
                product.getPqty(),
                product.getPprice()
        );
    }
    @Override
    public boolean deleteProduct(String id) throws Exception {
        return productDAO.delete(id);
    }
    @Override
    public boolean updateProduct(ProductDTO productDTO) throws Exception {
        return productDAO.update(
                new Product(
                        productDTO.getPid(),
                        productDTO.getPbrand(),
                        productDTO.getPname(),
                        productDTO.getPdesc(),
                        productDTO.getPqty(),
                        productDTO.getPprice()
                )
        );
    }
    @Override
    public ArrayList<ProductDTO> getAllProduct() throws Exception {
        List<Product> productList = productDAO.getAll();
        ArrayList<ProductDTO> productDTOArrayList = new ArrayList();
            for (Product product : productList) {
                productDTOArrayList.add(
                        new ProductDTO(
                            product.getPid(),
                            product.getPbrand(),
                            product.getPname(),
                            product.getPdesc(),
                            product.getPqty(),
                            product.getPprice()
                        )
                );
            }
        return productDTOArrayList;
    }
    @Override
    public int getProCount() throws Exception {
        return productDAO.getProCount();
    }
    @Override
    public int sumProductQty() throws Exception {
        return productDAO.sumProductQty();
    }

    @Override
    public String getListener() throws Exception {
        return productDAO.getListener();
    }
}
