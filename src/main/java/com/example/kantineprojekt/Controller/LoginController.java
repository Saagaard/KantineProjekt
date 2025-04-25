package com.example.kantineprojekt.Controller;

import Model.Employee;
import Model.EmployeeDAO;
import Model.EmployeeDAOImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Håndterer Login-interfacet
 */
public class LoginController {

    @FXML
    private PasswordField loginField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorMessage;

    /**
     * Håndterer login
     * Henter Employee med id fra loginField
     * Validerer om employee findes, og skifter til MenuUI ved succes
     */
    public void login(ActionEvent event) throws Exception {
        if (!loginField.getText().isEmpty()) {

            int employeeID = Integer.parseInt(loginField.getText());
            //System.out.println(employeeID);

            EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
            Employee employee = employeeDAO.read(employeeID);

            if (employee != null) {
                //System.out.println(employee.getFirstName());
                //errorMessage.setText("Login successful");
                switchToMenu(employee, event);
            } else {
                errorMessage.setText("Det indtastede ID er ugyldigt. Prøv igen");
                loginField.clear();
            }
        }
    }

    /**
     * Håndterer scene-skift til MenuUI
     * Employee fra login() bliver brugt som parameter, og overføres til MenuController
     */

    @FXML
    private void switchToMenu(Employee employee, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kantineprojekt/View/menu.fxml"));
        Parent root = loader.load();

        MenuController menuController = loader.getController();
        menuController.setEmployee(employee);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/kantineprojekt/View/CSS/menu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}

