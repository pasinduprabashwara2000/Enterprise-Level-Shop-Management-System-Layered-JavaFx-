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

        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_suppliers FROM Supplier");
        if (rst.next()) {
            return rst.getInt("total_suppliers");
        }
        return 0;
    }

    @Override
    public int getInventoryCount() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT SUM(qyt) AS total_inventory FROM Product");
        if (rst.next()) {
            return rst.getInt("total_inventory");
        }
        return 0;
    }

    @Override
    public int getOrderCount() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_orders FROM orders");
        if (rst.next()) {
            return rst.getInt("total_orders");
        }
        return 0;
    }

    @Override
    public int getPaymentCount() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_payment FROM Payment");
        if (rst.next()) {
            return rst.getInt("total_payment");
        }
        return 0;
    }

    @Override
    public int getReturnCount() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS total_return FROM Returns");
        if (rst.next()) {
            return rst.getInt("total_return");
        }
        return 0;
    }

    @Override
    public ArrayList<ProductTM> topSellingProducts() throws Exception {

        String sql =
                "SELECT p.productID, p.name, p.SKU, p.barCode, " +
                        "SUM(op.qty) AS total_qty, p.unitPrice, p.categoryID " +
                        "FROM Product p " +
                        "JOIN order_products op ON p.productID = op.product_id " +
                        "GROUP BY p.productID, p.name, p.SKU, p.barCode, p.unitPrice, p.categoryID " +
                        "ORDER BY total_qty DESC " +
                        "LIMIT 10";

        ResultSet rst = CrudUtil.execute(sql);

        ArrayList<ProductTM> products = new ArrayList<>();

        while (rst.next()) {
            products.add(new ProductTM(
                    rst.getString("productID"),
                    rst.getString("name"),
                    rst.getString("SKU"),
                    rst.getString("barCode"),
                    rst.getInt("total_qty"),
                    rst.getDouble("unitPrice"),
                    rst.getString("categoryID")
            ));
        }

        return products;
    }

    @Override
    public double calculateTotalRevenue() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT SUM(amount) AS revenue_total FROM Payment");
        if (rst.next()) {
            return rst.getDouble("revenue_total");
        }
        return 0.0;

    }

    @Override
    public double calculateTotalProfit() throws Exception {

        ResultSet rstRevenue = CrudUtil.execute("SELECT SUM(amount) AS total_revenue FROM Payment");
        ResultSet rstRefund = CrudUtil.execute("SELECT SUM(refundAmount) AS total_refund FROM Returns");

        double totalRevenue = rstRevenue.next() ? rstRevenue.getDouble("total_revenue") : 0.0;
        double totalRefund = rstRefund.next() ? rstRefund.getDouble("total_refund") : 0.0;

        return totalRevenue - totalRefund;

    }
}
