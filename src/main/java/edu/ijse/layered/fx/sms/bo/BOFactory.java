package edu.ijse.layered.fx.sms.bo;

import edu.ijse.layered.fx.sms.bo.custom.impl.CategoryBOImpl;
import edu.ijse.layered.fx.sms.bo.custom.impl.CustomerBOImpl;

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
        }
        return null;
    }

}
