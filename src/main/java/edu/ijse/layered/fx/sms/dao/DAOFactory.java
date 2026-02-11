package edu.ijse.layered.fx.sms.dao;

import edu.ijse.layered.fx.sms.dao.custom.impl.*;

public class DAOFactory {

    public static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CATEGORY,CUSTOMER,EXPENSE,LOGIN,ORDER, ORDER_PRODUCT, PAYMENT, PRODUCT, PURCHASE_ORDER,
        RETURN, ROLE, SUPPLIER, USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes) {
            case CATEGORY -> new CategoryDAOImpl();
            case CUSTOMER -> new CustomerDAOImpl();
            case EXPENSE -> new ExpenseDAOImpl();
            case LOGIN -> new LoginDAOImpl();
            case ORDER -> new OrderDAOImpl();
            case ORDER_PRODUCT -> new OrderProductDAOImpl();
            case PAYMENT -> new PaymentDAOImpl();
            case PRODUCT -> new ProductDAOImpl();
            case PURCHASE_ORDER -> new PurchaseOrderDAOImpl();
            case RETURN -> new ReturnDAOImpl();
            case ROLE -> new RoleDAOImpl();
            case SUPPLIER -> new SupplierDAOImpl();
            case USER -> new UserDAOImpl();
        }

        return null;
    }

}
