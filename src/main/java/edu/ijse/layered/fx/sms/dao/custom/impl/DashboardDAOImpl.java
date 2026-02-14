package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.DashboardDAO;
import edu.ijse.layered.fx.sms.dto.custom.ProductTM;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DashboardDAOImpl implements DashboardDAO {

    @Override
    public int getProductsCount() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_products FROM Product");
        if (rst.next()) {
            return rst.getInt("total_products");
        }
        return 0;
    }

    @Override
    public int getCustomerCount() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_customers FROM Customer");
        if (rst.next()) {
            return rst.getInt("total_customers");
        }
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
