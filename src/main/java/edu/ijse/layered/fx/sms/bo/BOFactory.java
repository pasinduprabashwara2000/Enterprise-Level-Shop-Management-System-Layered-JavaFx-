package edu.ijse.layered.fx.sms.bo;

import edu.ijse.layered.fx.sms.bo.custom.impl.*;

public class BOFactory {

    // Singleton instance
    private static BOFactory instance;

    // Private constructor prevents external creation
    private BOFactory() {}

    // Global access point
    public static BOFactory getInstance() {
        if (instance == null) {
            instance = new BOFactory();
        }
        return instance;
    }

    // BO Types
    public enum BOTypes {
        DASHBOARD,
        CATEGORY,
        CUSTOMER,
        EXPENSE,
        LOGIN,
        ORDER,
        ORDER_PRODUCT,
        PAYMENT,
        PRODUCT,
        PURCHASE_ORDER,
        RETURN,
        ROLE,
        SUPPLIER,
        USER
    }

    // Factory Method
    public Object getBO(BOTypes type) {

        switch (type) {

            case DASHBOARD:
                return new DashboardBOImpl();

            case CATEGORY:
                return new CategoryBOImpl();

            case CUSTOMER:
                return new CustomerBOImpl();

            case EXPENSE:
                return new ExpenseBOImpl();

            case LOGIN:
                return new LoginBOImpl();

            case ORDER:
                return new OrderBOImpl();

            case ORDER_PRODUCT:
                return new OrderProductBOImpl();

            case PAYMENT:
                return new PaymentBOImpl();

            case PRODUCT:
                return new ProductBOImpl();

            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();

            case RETURN:
                return new ReturnBOImpl();

            case ROLE:
                return new RoleBOImpl();

            case SUPPLIER:
                return new SupplierBOImpl();

            case USER:
                return new UserBOImpl();

            default:
                throw new RuntimeException("No BO found for type: " + type);
        }
    }
}
