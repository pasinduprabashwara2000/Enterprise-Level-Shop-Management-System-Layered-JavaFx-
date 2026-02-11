package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.PurchaseOrderDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.PurchaseOrderEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

    @Override
    public String save(PurchaseOrderEntity purchaseOrderEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO purchase_order (supplier_id, total_cost, status, create_at, expected_date) VALUES (?,?,?,?,?)",
                purchaseOrderEntity.getSupplierId(),
                purchaseOrderEntity.getTotalCost(),
                purchaseOrderEntity.getStatus(),
                purchaseOrderEntity.getCreatedAt(),
                purchaseOrderEntity.getExpectedDate());
    }

    @Override
    public String update(PurchaseOrderEntity purchaseOrderEntity) throws Exception {
        return CrudUtil.execute("UPDATE purchase_order SET supplier_id = ?, total_cost = ?, status = ?, create_at = ?, expected_date = ? WHERE po_id = ?",
                purchaseOrderEntity.getSupplierId(),
                purchaseOrderEntity.getTotalCost(),
                purchaseOrderEntity.getStatus(),
                purchaseOrderEntity.getCreatedAt(),
                purchaseOrderEntity.getExpectedDate(),
                purchaseOrderEntity.getPoId());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM purchase_order WHERE po_id = ?",
                id);
    }

    @Override
    public PurchaseOrderEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM purchase_order WHERE po_id = ?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM purchase_order");
    }
}
