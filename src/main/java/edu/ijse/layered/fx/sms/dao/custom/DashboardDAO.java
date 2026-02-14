package edu.ijse.layered.fx.sms.dao.custom;

import edu.ijse.layered.fx.sms.dto.custom.ProductTM;
import java.util.ArrayList;

public interface DashboardDAO {

    int getProductsCount() throws Exception;
    int getCustomerCount() throws Exception;
    int getSupplierCount() throws Exception;
    int getInventoryCount() throws Exception;
    int getOrderCount() throws Exception;
    int getPaymentCount() throws Exception;
    int getReturnCount() throws Exception;
    ArrayList<ProductTM> topSellingProducts() throws Exception;
    double calculateTotalRevenue() throws Exception;
    double calculateTotalProfit() throws Exception;

}
