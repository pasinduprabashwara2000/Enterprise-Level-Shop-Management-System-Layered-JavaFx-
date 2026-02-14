package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ProductDAO;
import edu.ijse.layered.fx.sms.entity.ProductEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM Product WHERE productID = ?", id);
    }

    @Override
    public ProductEntity search(String id) throws Exception {
        ResultSet rst =  CrudUtil.execute("SELECT * FROM Product WHERE productID = ?", id);
        return new ProductEntity(
                rst.getString("productID"),
                rst.getString("SKU"),
                rst.getInt("barCode"),
                rst.getString("name"),
                rst.getDouble("unitPrice"),
                rst.getInt("qyt"),
                rst.getBoolean("active"),
                rst.getString("categoryID")
        );
    }

    @Override
    public ArrayList<ProductEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Product");
        ArrayList <ProductEntity> productEntities = new ArrayList<>();

        while (rst.next()){
            productEntities.add(new ProductEntity(
                    rst.getString("productID"),
                    rst.getString("SKU"),
                    rst.getInt("barCode"),
                    rst.getString("name"),
                    rst.getDouble("unitPrice"),
                    rst.getInt("qyt"),
                    rst.getBoolean("active"),
                    rst.getString("categoryID")
            ));
        }
        return productEntities;
    }

    @Override
    public boolean decreaseProductQTY(String productId, int qty) throws Exception {
        return CrudUtil.execute(
                "UPDATE Product SET qyt = qyt - ? WHERE productID = ?",
                qty,
                productId
        );
    }

}
