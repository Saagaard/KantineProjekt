package com.example.kantineprojekt.Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Håndterer Menu-interfacet
 */
public class MenuController {

    private Employee currentEmployee;
    private List<Product> products;
    private float totalPrice = 0;

    @FXML
    private Label nameLabel;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private GridPane buttonGrid;

    @FXML
    private VBox orderList;

    /**
     * Henter alle produkter fra databasen, og laver en Button til hver produkt
     */
    public void initialize() throws Exception {

        ProductDAO productDAO = new ProductDAOImplementation();
        this.products = new ArrayList<>();
        this.products = productDAO.readAll();

        int column = 0;
        int row = 0;

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            Button button = new Button(product.getName() + "\n" + product.getPrice() + " kr.-");
            button.getStyleClass().add("buttonProduct");

            button.setOnAction(event -> {
                //System.out.println("Selected: " + product.getName());
                addToOrder(product);
            });

            buttonGrid.add(button, column, row);

            column++;
            if (column >= 3) { // GridPane er 3x3
                column = 0;
                row++;
            }
        }

    }

    /**
     * Tilføjer det valgte produkt til ordren, og laver et Label i UI'et
     * Derudover opdateres det totale beløb i ordren
     */
    public void addToOrder(Product product) {
        Label productLabel = new Label();
        productLabel.getStyleClass().add("productLabel");
        productLabel.setText(product.getName() + " " + product.getPrice() + " kr.-");
        orderList.getChildren().add(productLabel);

        totalPrice += product.getPrice();
        totalPriceLabel.setText(totalPrice + "kr.-");
    }

    /**
     * Kaldes fra LoginController ved login
     * Sætter den valgte medarbejder, og bruger deres navn i UI'et
     * Ville være meget relevant hvis man skulle tjekke og opdatere deres saldo
     */
    public void setEmployee(Employee employee) {
        this.currentEmployee = employee;
        nameLabel.setText(currentEmployee.getFirstName() + " " + currentEmployee.getLastName());

    }

}

