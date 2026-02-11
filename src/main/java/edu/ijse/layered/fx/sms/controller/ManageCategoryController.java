package edu.ijse.layered.fx.sms.controller;

import edu.ijse.layered.fx.sms.dao.custom.CategoryDAO;
import edu.ijse.layered.fx.sms.dao.custom.impl.CategoryDAOImpl;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.CategoryEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageCategoryController {

    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @FXML
    private TextField categoryIDTxt;

    @FXML
    private TableColumn<CategoryDTO, String> colCategoryId;

    @FXML
    private TableColumn<CategoryDTO, String> colDescription;

    @FXML
    private TableColumn<CategoryDTO, String> colName;

    @FXML
    private Button deleteBtn;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private TableView<CategoryDTO> detailsTable;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTxt;

    @FXML
    private Button resetBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button updateBtn;

    public void initialize(){
        colCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadTable();

        detailsTable.setOnMouseClicked(event -> {
            if(event.getClickCount() == 1){
                loadSelectedRow();
            }
        });

    }

    private void loadSelectedRow(){

        CategoryDTO selectedCategory = detailsTable.getSelectionModel().getSelectedItem();

        if(selectedCategory != null){
            categoryIDTxt.setText(selectedCategory.getCategoryID());
            nameTxt.setText(selectedCategory.getName());
            descriptionTxt.setText(selectedCategory.getDescription());
        }

    }

    private void loadTable() {
        try {
            detailsTable.getItems().clear();
            detailsTable.getItems().addAll(categoryDAO.getAll());
        } catch (Exception e) {
            new Alert(AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void navigateDelete(ActionEvent event) {
        try {
            String res = categoryDAO.delete(categoryIDTxt.getText());
            new Alert(AlertType.INFORMATION,res).show();
            loadTable();
            navigateReset(event);
        } catch (Exception e){
            new Alert(AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void navigateReset(ActionEvent event) {
        nameTxt.clear();
        descriptionTxt.clear();
    }

    @FXML
    void navigateSave(ActionEvent event) {
        try{
            CategoryEntity categoryEntity= new CategoryEntity(
                    null,
                    nameTxt.getText(),
                    descriptionTxt.getText()
            );
            String res = categoryDAO.save(categoryEntity);
            new Alert(Alert.AlertType.INFORMATION,res).show();
            loadTable();
            navigateReset(event);
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void navigateUpdate(ActionEvent event) {
        try {
            CategoryEntity categoryEntity = new CategoryEntity(
                categoryIDTxt.getText(),
                nameTxt.getText(),
                descriptionTxt.getText()
            );
            String res = categoryDAO.update(categoryEntity);
            new Alert(AlertType.INFORMATION,res).show();
            loadTable();
            navigateReset(event);
        } catch (Exception e){
            new Alert(AlertType.ERROR,e.getMessage()).show();
        }
    }

}
