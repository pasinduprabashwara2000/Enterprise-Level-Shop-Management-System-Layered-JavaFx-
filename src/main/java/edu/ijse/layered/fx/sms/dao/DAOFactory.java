package edu.ijse.layered.fx.sms.dao;

import edu.ijse.layered.fx.sms.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory instance;

    private DAOFactory() {}

    // Singleton access
    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public enum DAOTypes {
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

    public Object getDAO(DAOTypes type) {

        switch (type) {

            case DASHBOARD:
                return new DashboardDAOImpl();

            case CATEGORY:
                return new CategoryDAOImpl();

            case CUSTOMER:
                return new CustomerDAOImpl();

            case EXPENSE:
                return new ExpenseDAOImpl();

            case LOGIN:
                return new LoginDAOImpl();

            case ORDER:
                return new OrderDAOImpl();

            case ORDER_PRODUCT:
                return new OrderProductDAOImpl();

            case PAYMENT:
                return new PaymentDAOImpl();

            case PRODUCT:
                return new ProductDAOImpl();

            case PURCHASE_ORDER:
                return new PurchaseOrderDAOImpl();

            case RETURN:
                return new ReturnDAOImpl();

            case ROLE:
                return new RoleDAOImpl();

            case SUPPLIER:
                return new SupplierDAOImpl();

            case USER:
                return new UserDAOImpl();

            default:
                throw new RuntimeException("No DAO found for type: " + type);
        }
    }
}
