package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ProductDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.ProductEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public String save(ProductEntity productEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Product (SKU, barCode, name, unitPrice, qyt, active, categoryID) VALUES (?, ?, ?, ?, ?, ?, ?)",
                productEntity.getSKU(),
                productEntity.getBarCode(),
                productEntity.getName(),
                productEntity.getUnitPrice(),
                productEntity.getQyt(),
                productEntity.isActive(),
                productEntity.getCategoryID());
    }

    @Override
    public String update(ProductEntity productEntity) throws Exception {
        return CrudUtil.execute("UPDATE Product SET SKU = ?, barCode = ?, name = ?, unitPrice = ?, qyt = ?, active = ?, categoryID = ? WHERE productID = ?",
                productEntity.getSKU(),
                productEntity.getBarCode(),
                productEntity.getName(),
                productEntity.getUnitPrice(),
                productEntity.getQyt(),
                productEntity.isActive(),
                productEntity.getCategoryID(),
                productEntity.getProductID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Product WHERE productID = ?",
                id);
    }

    @Override
    public ProductEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Product WHERE productID = ?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Product");
    }
}
