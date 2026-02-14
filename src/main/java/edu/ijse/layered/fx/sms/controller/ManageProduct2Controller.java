package edu.ijse.layered.fx.sms.controller;

import edu.ijse.layered.fx.sms.bo.custom.ProductBO;
import edu.ijse.layered.fx.sms.bo.custom.impl.ProductBOImpl;
import edu.ijse.layered.fx.sms.dto.ProductDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageProduct2Controller {

    private final ProductBO productBO = new ProductBOImpl();

    @FXML
    private TableColumn<ProductDTO, String> colProductID;

    @FXML
    private TableColumn<ProductDTO, String> colName;

    @FXML
    private TableColumn<ProductDTO, String> colCategoryID;

    @FXML
    private TableColumn<ProductDTO, String> colSKU;

    @FXML
    private TableColumn<ProductDTO, Double> colUnitPrice;

    @FXML
    private TableColumn<ProductDTO, String> colUnit;

    @FXML
    private TableColumn<ProductDTO, Double> colTaxRate;

    @FXML
    private TableColumn<ProductDTO, Boolean> colActive;

    @FXML
    private TableColumn<ProductDTO, String> colBarcode;

    @FXML
    private TableView<ProductDTO> detailsTable;

    @FXML
    void initialize() {
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colSKU.setCellValueFactory(new PropertyValueFactory<>("SKU"));
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barCode"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));

        loadTable();

    }

    private void loadTable() {
        try {
            detailsTable.getItems().clear();
            detailsTable.getItems().addAll(productBO.getAll());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
    }

    }

}
