package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.PurchaseOrderBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.PurchaseOrderDAO;
import edu.ijse.layered.fx.sms.dto.PurchaseOrderDTO;
import edu.ijse.layered.fx.sms.entity.PurchaseOrderEntity;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PURCHASE_ORDER);

    @Override
    public String save(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        PurchaseOrderEntity purchaseOrderEntity = new PurchaseOrderEntity(
                purchaseOrderDTO.getPoId(),
                purchaseOrderDTO.getSupplierId(),
                purchaseOrderDTO.getTotalCost(),
                purchaseOrderDTO.getStatus(),
                purchaseOrderDTO.getCreatedAt(),
                purchaseOrderDTO.getExpectedDate()
        );
        return Boolean.parseBoolean(purchaseOrderDAO.save(purchaseOrderEntity)) ? "Purchase Order Save Successfully" : "Purchase Order Save Failed";
    }

    @Override
    public String update(PurchaseOrderDTO purchaseOrderDTO) throws Exception {
        PurchaseOrderEntity purchaseOrderEntity = new PurchaseOrderEntity(
                purchaseOrderDTO.getPoId(),
                purchaseOrderDTO.getSupplierId(),
                purchaseOrderDTO.getTotalCost(),
                purchaseOrderDTO.getStatus(),
                purchaseOrderDTO.getCreatedAt(),
                purchaseOrderDTO.getExpectedDate()
        );
        return Boolean.parseBoolean(purchaseOrderDAO.update(purchaseOrderEntity)) ? "Purchase Order Update Successfully" : "Purchase Order Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(purchaseOrderDAO.delete(id)) ? "Purchase Order Delete Successfully" : "Purchase Order Delete Failed";
    }

    @Override
    public PurchaseOrderDTO search(String id) throws Exception {
        PurchaseOrderEntity purchaseOrderEntity = purchaseOrderDAO.search(id);
        return new PurchaseOrderDTO(
                purchaseOrderEntity.getPoId(),
                purchaseOrderEntity.getSupplierId(),
                purchaseOrderEntity.getTotalCost(),
                purchaseOrderEntity.getStatus(),
                purchaseOrderEntity.getCreatedAt(),
                purchaseOrderEntity.getExpectedDate()
        );
    }

    @Override
    public ArrayList<PurchaseOrderDTO> getAll() throws Exception {

        ArrayList <PurchaseOrderEntity> purchaseOrderEntities = purchaseOrderDAO.getAll();
        ArrayList <PurchaseOrderDTO> purchaseOrderDTOS = new ArrayList<>();

        for (PurchaseOrderEntity purchaseOrderEntity : purchaseOrderEntities){
            purchaseOrderDTOS.add(new PurchaseOrderDTO(
                    purchaseOrderEntity.getPoId(),
                    purchaseOrderEntity.getSupplierId(),
                    purchaseOrderEntity.getTotalCost(),
                    purchaseOrderEntity.getStatus(),
                    purchaseOrderEntity.getCreatedAt(),
                    purchaseOrderEntity.getExpectedDate()
            ));
        }

        return purchaseOrderDTOS;
    }
}
