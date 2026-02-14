package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.ProductBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.ProductDAO;
import edu.ijse.layered.fx.sms.dto.ProductDTO;
import edu.ijse.layered.fx.sms.entity.ProductEntity;
import java.util.ArrayList;

public class ProductBOImpl implements ProductBO {

    ProductDAO productDAO = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);

    @Override
    public String save(ProductDTO productDTO) throws Exception {
        ProductEntity productEntity = new ProductEntity(
                productDTO.getProductID(),
                productDTO.getSKU(),
                productDTO.getBarCode(),
                productDTO.getName(),
                productDTO.getUnitPrice(),
                productDTO.getQyt(),
                productDTO.isActive(),
                productDTO.getCategoryID()
        );
        return Boolean.parseBoolean(productDAO.save(productEntity)) ? "Product Save Successfully" : "Product Save Failed";
    }

    @Override
    public String update(ProductDTO productDTO) throws Exception {
        ProductEntity productEntity = new ProductEntity(
                productDTO.getProductID(),
                productDTO.getSKU(),
                productDTO.getBarCode(),
                productDTO.getName(),
                productDTO.getUnitPrice(),
                productDTO.getQyt(),
                productDTO.isActive(),
                productDTO.getCategoryID()
        );
        return Boolean.parseBoolean(productDAO.update(productEntity)) ? "Product Update Successfully" : "Product Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(productDAO.delete(id)) ? "Product Delete Successfully" : "Product Delete Failed";
    }

    @Override
    public ProductDTO search(String id) throws Exception {
        ProductEntity productEntity = productDAO.search(id);
        return new ProductDTO(
                productEntity.getProductID(),
                productEntity.getSKU(),
                productEntity.getBarCode(),
                productEntity.getName(),
                productEntity.getUnitPrice(),
                productEntity.getQyt(),
                productEntity.isActive(),
                productEntity.getCategoryID()
        );
    }

    @Override
    public ArrayList<ProductDTO> getAll() throws Exception {
        ArrayList <ProductEntity> productEntities = productDAO.getAll();
        ArrayList <ProductDTO> productDTOS = new ArrayList<>();

        for (ProductEntity productEntity : productEntities){
            productDTOS.add(new ProductDTO(
                    productEntity.getProductID(),
                    productEntity.getSKU(),
                    productEntity.getBarCode(),
                    productEntity.getName(),
                    productEntity.getUnitPrice(),
                    productEntity.getQyt(),
                    productEntity.isActive(),
                    productEntity.getCategoryID()
            ));
        }

        return productDTOS;
    }
}
