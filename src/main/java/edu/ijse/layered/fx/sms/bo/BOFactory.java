package edu.ijse.layered.fx.sms.bo;

import edu.ijse.layered.fx.sms.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        CATEGORY,CUSTOMER,EXPENSE,LOGIN,ORDER, ORDER_PRODUCT, PAYMENT, PRODUCT, PURCHASE_ORDER,
        RETURN, ROLE, SUPPLIER, USER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CATEGORY -> new CategoryBOImpl();
            case CUSTOMER -> new CustomerBOImpl();
            case EXPENSE -> new ExpenseBOImpl();
            case LOGIN -> new LoginBOImpl();
            case ORDER -> new OrderBOImpl();
            case ORDER_PRODUCT -> new OrderProductBOImpl();
            case PAYMENT -> new PaymentBOImpl();
            case PRODUCT -> new ProductBOImpl();
            case PURCHASE_ORDER -> new PurchaseOrderBOImpl();
            case RETURN -> new ReturnBOImpl();
            case ROLE -> new RoleBOImpl();
            case SUPPLIER -> new SupplierBOImpl();
            case USER -> new UserBOImpl();
        }

        return null;
    }

}
