package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.DashboardBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.DashboardDAO;
import edu.ijse.layered.fx.sms.dto.custom.ProductTM;
import java.util.ArrayList;

public class DashboardBOImpl implements DashboardBO {

    DashboardDAO dashboardDAO = (DashboardDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DASHBOARD);

    @Override
    public int getProductsCount() throws Exception {
        return 0;
    }

    @Override
    public int getCustomerCount() throws Exception {
        return 0;
    }

    @Override
    public int getSupplierCount() throws Exception {
        return 0;
    }

    @Override
    public int getInventoryCount() throws Exception {
        return 0;
    }

    @Override
    public int getOrderCount() throws Exception {
        return 0;
    }

    @Override
    public int getPaymentCount() throws Exception {
        return 0;
    }

    @Override
    public int getReturnCount() throws Exception {
        return 0;
    }

    @Override
    public ArrayList<ProductTM> topSellingProducts() throws Exception {
        return null;
    }

    @Override
    public double calculateTotalRevenue() throws Exception {
        return 0;
    }

    @Override
    public double calculateTotalProfit() throws Exception {
        return 0;
    }
}
