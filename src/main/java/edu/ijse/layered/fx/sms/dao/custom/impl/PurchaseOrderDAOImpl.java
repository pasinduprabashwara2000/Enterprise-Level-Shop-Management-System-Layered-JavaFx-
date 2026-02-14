package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.PurchaseOrderDAO;
import edu.ijse.layered.fx.sms.entity.PurchaseOrderEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM purchase_order WHERE po_id = ?", id);
    }

    @Override
    public PurchaseOrderEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM purchase_order WHERE po_id = ?", id);
        return new PurchaseOrderEntity(
                rst.getString("po_id"),
                rst.getString("supplier_id"),
                rst.getDouble("total_cost"),
                rst.getString("status"),
                rst.getDate("create_at").toLocalDate(),
                rst.getDate("expected_date").toLocalDate()
        );
    }

    @Override
    public ArrayList<PurchaseOrderEntity> getAll() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT * FROM purchase_order");
        ArrayList <PurchaseOrderEntity> purchaseOrderEntities = new ArrayList<>();

        while (rst.next()){
            purchaseOrderEntities.add(new PurchaseOrderEntity(
                    rst.getString("po_id"),
                    rst.getString("supplier_id"),
                    rst.getDouble("total_cost"),
                    rst.getString("status"),
                    rst.getDate("create_at").toLocalDate(),
                    rst.getDate("expected_date").toLocalDate()
            ));
        }
        return purchaseOrderEntities;
    }
}
