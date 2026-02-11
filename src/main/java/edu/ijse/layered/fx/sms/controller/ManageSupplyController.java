package edu.ijse.layered.fx.sms.controller;

import edu.ijse.mvc.fx.shopmanagementsystem.DTO.ProductDTO;
import edu.ijse.mvc.fx.shopmanagementsystem.DTO.SupplierDTO;
import edu.ijse.mvc.fx.shopmanagementsystem.DTO.SupplyDTO;
import edu.ijse.mvc.fx.shopmanagementsystem.model.ProductModel;
import edu.ijse.mvc.fx.shopmanagementsystem.model.SupplierModel;
import edu.ijse.mvc.fx.shopmanagementsystem.model.SupplyModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class ManageSupplyController {

    final private SupplyModel supplyModel = new SupplyModel();
    final private ProductModel productModel = new ProductModel();
    final private SupplierModel supplierModel = new SupplierModel();

    @FXML
    private TableColumn<SupplyDTO, Double> colLastCost;

    @FXML
    private TableColumn<SupplyDTO, String> colProductId;

    @FXML
    private TableColumn<SupplyDTO, String> colSupplierId;

    @FXML
    private TableColumn<SupplyDTO, String> colSupplierProductCode;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<SupplyDTO> detailsTable;

    @FXML
    private Label productIDLabel;

    @FXML
    private ComboBox<String> productIdCombo;

    @FXML
    private Button resetBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Label supplierCodeLabel;

    @FXML
    private TextField supplierCodeTxt;

    @FXML
    private Label supplierIDLabel;

    @FXML
    private ComboBox<String> supplierIdCombo;

    @FXML
    private Button updateBtn;

    @FXML
    public void initialize(){
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        colSupplierProductCode.setCellValueFactory(new PropertyValueFactory<>("supplierProductCode"));

        loadTableThread();
        loadProductIdThread();
        loadSupplierIdThread();

        detailsTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 1){
                loadSelectedRow();
            }
        });

    }

    private void loadTableThread(){
        Task <ObservableList<SupplyDTO>> task = new Task<ObservableList<SupplyDTO>>() {
            @Override
            protected ObservableList<SupplyDTO> call() throws Exception {
                return FXCollections.observableArrayList(supplyModel.getAllSupplies());
            }
        };
        task.setOnSucceeded(event -> detailsTable.setItems(task.getValue()));
        task.setOnFailed(event -> new Alert(Alert.AlertType.ERROR,task.getMessage()).show());
        new Thread(task).start();
    }

    private void loadSelectedRow(){
        SupplyDTO selectedSupply = detailsTable.getSelectionModel().getSelectedItem();

        if(selectedSupply != null){
            supplierIdCombo.setValue(selectedSupply.getSupplierID());
            productIdCombo.setValue(selectedSupply.getProductID());
            supplierCodeTxt.setText(selectedSupply.getSupplierProductCode());
        }

     }

    private void loadProductIdThread() {

        Task<ObservableList<String>> task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {

                ArrayList<ProductDTO> productDTOS = productModel.getAllProducts();
                return FXCollections.observableArrayList(
                        productDTOS.stream()
                                .map(ProductDTO::getProductID)
                                .toList()
                );
            }
        };

        task.setOnSucceeded(event -> {
            productIdCombo.setItems(task.getValue());
        });

        task.setOnFailed(event -> {
            new Alert(Alert.AlertType.ERROR, task.getException().getMessage()).show();
        });
        new Thread(task).start();
    }

    private void loadSupplierIdThread() {

        Task<ObservableList<String>> task = new Task<>() {

            @Override
            protected ObservableList<String> call() throws Exception {
                ArrayList<SupplierDTO> suppliers =
                        supplierModel.getAllSuppliers();

                return FXCollections.observableArrayList(
                        suppliers.stream()
                                .map(SupplierDTO::getSupplierID)
                                .toList()
                );
            }
        };

        task.setOnSucceeded(event ->
                supplierIdCombo.setItems(task.getValue())
        );

        task.setOnFailed(event ->
                new Alert(
                        Alert.AlertType.ERROR,
                        task.getException().getMessage()
                ).show()
        );
        new Thread(task).start();
    }


    @FXML
    void navigateDelete(ActionEvent event) {
        try {
            String rsp = supplyModel.deleteSupply(productIdCombo.getValue(), supplierIdCombo.getValue());
            new Alert(Alert.AlertType.INFORMATION, rsp).show();
            loadTableThread();
            navigateReset(event);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
    }

    }

    @FXML
    void navigateReset(ActionEvent event) {
        productIdCombo.setValue(null);
        supplierIdCombo.setValue(null);
        supplierCodeTxt.setText("");

    }

    @FXML
    void navigateSave(ActionEvent event) {
        try{
            SupplyDTO supplyDTO = new SupplyDTO(
                    productIdCombo.getValue(),
                    supplierIdCombo.getValue(),
                    supplierCodeTxt.getText()
            );
            String rsp = supplyModel.saveSupply(supplyDTO);
            new Alert(Alert.AlertType.INFORMATION,rsp).show();
            loadTableThread();
            navigateReset(event);
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void navigateUpdate(ActionEvent event) {
        try {
            SupplyDTO supplyDTO = new SupplyDTO(
                    productIdCombo.getValue(),
                    supplierIdCombo.getValue(),
                    supplierCodeTxt.getText()
            );
            String rsp = supplyModel.updateSupply(supplyDTO);
            new Alert(Alert.AlertType.INFORMATION, rsp).show();
            loadTableThread();
            navigateReset(event);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();;
        }
    }

}
