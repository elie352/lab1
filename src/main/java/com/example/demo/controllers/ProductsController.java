package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.models.ProductsStore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ProductsController {

    @FXML private TextField nameFld;
    @FXML private ComboBox<String> categoryCombo;
    @FXML private TextField quantityFld;
    @FXML private TextField priceFld;
    @FXML private TextField originFld;
    @FXML private TextField supplierFld;
    @FXML private CheckBox organicChk;

    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;

    @FXML private TableView<Product> productsTable;
    @FXML private TableColumn<Product, String> nameCol;
    @FXML private TableColumn<Product, String> categoryCol;
    @FXML private TableColumn<Product, Double> priceCol;
    @FXML private TableColumn<Product, String> originCol;
    @FXML private TableColumn<Product, Integer> quantityCol;
    @FXML private TableColumn<Product, String> supplierCol;
    @FXML private TableColumn<Product, Boolean> organicCol;

    @FXML private Text errorMsg;

    private final ProductsStore productStore = new ProductsStore();

    @FXML
    public void initialize() {
        categoryCombo.setItems(FXCollections.observableArrayList("Fruit", "Vegetable"));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("pricePerKg"));
        originCol.setCellValueFactory(new PropertyValueFactory<>("origin"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        organicCol.setCellValueFactory(new PropertyValueFactory<>("organic"));

        ObservableList<Product> products = productStore.getProductsList();
        productsTable.setItems(products);

        productsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                nameFld.setText(newSel.getName());
                categoryCombo.setValue(newSel.getCategory());
                quantityFld.setText(Integer.toString(newSel.getQuantity()));
                priceFld.setText(Double.toString(newSel.getPricePerKg()));
                originFld.setText(newSel.getOrigin());
                supplierFld.setText(newSel.getSupplier());
                organicChk.setSelected(newSel.isOrganic());
            }
        });
    }

    @FXML
    void addProduct(ActionEvent event) {
        StringBuilder error = new StringBuilder();
        boolean isValid = true;

        String name = nameFld.getText().trim();
        String category = categoryCombo.getValue();
        String origin = originFld.getText().trim();
        String supplier = supplierFld.getText().trim();

        if (name.isEmpty()) { error.append("Error: Name is required!\n"); isValid = false; }
        if (category == null || category.isEmpty()) { error.append("Error: Category is required!\n"); isValid = false; }
        if (origin.isEmpty()) { error.append("Error: Origin is required!\n"); isValid = false; }
        if (supplier.isEmpty()) { error.append("Error: Supplier is required!\n"); isValid = false; }

        Integer quantity = null;
        if (quantityFld.getText().isEmpty()) {
            error.append("Error: Quantity is required!\n");
            isValid = false;
        } else {
            try { quantity = Integer.parseInt(quantityFld.getText()); }
            catch (NumberFormatException ex) { error.append("Error: Invalid quantity!\n"); isValid = false; }
        }

        Double price = null;
        if (priceFld.getText().isEmpty()) {
            error.append("Error: Price is required!\n");
            isValid = false;
        } else {
            try { price = Double.parseDouble(priceFld.getText()); }
            catch (NumberFormatException ex) { error.append("Error: Invalid price!\n"); isValid = false; }
        }

        boolean organic = organicChk.isSelected();

        if (isValid) {
            productStore.addProduct(new Product(name, category, quantity, price, origin, supplier, organic));
            clearFields();
            errorMsg.setText("");
        } else {
            errorMsg.setText(error.toString());
        }
    }

    @FXML
    void deleteProduct(ActionEvent event) {
        Product selected = productsTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productStore.deleteProduct(selected);
            clearFields();
        } else {
            errorMsg.setText("Select a product to delete.");
        }
    }

    @FXML
    void updateProduct(ActionEvent event) {
        Product selected = productsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            errorMsg.setText("Select a product to update.");
            return;
        }

        StringBuilder error = new StringBuilder();
        boolean isValid = true;

        String name = nameFld.getText().trim();
        String category = categoryCombo.getValue();
        String origin = originFld.getText().trim();
        String supplier = supplierFld.getText().trim();

        if (name.isEmpty()) { error.append("Error: Name is required!\n"); isValid = false; }
        if (category == null || category.isEmpty()) { error.append("Error: Category is required!\n"); isValid = false; }
        if (origin.isEmpty()) { error.append("Error: Origin is required!\n"); isValid = false; }
        if (supplier.isEmpty()) { error.append("Error: Supplier is required!\n"); isValid = false; }

        Integer quantity = null;
        Double price = null;

        try { quantity = Integer.parseInt(quantityFld.getText()); }
        catch (NumberFormatException ex) { error.append("Error: Invalid quantity!\n"); isValid = false; }

        try { price = Double.parseDouble(priceFld.getText()); }
        catch (NumberFormatException ex) { error.append("Error: Invalid price!\n"); isValid = false; }

        boolean organic = organicChk.isSelected();

        if (isValid) {
            productStore.updateProduct(selected, name, category, quantity, price, origin, supplier, organic);
            errorMsg.setText("");
            productsTable.refresh();
        } else {
            errorMsg.setText(error.toString());
        }
    }

    private void clearFields() {
        nameFld.clear();
        categoryCombo.getSelectionModel().clearSelection();
        quantityFld.clear();
        priceFld.clear();
        originFld.clear();
        supplierFld.clear();
        organicChk.setSelected(false);
    }
}