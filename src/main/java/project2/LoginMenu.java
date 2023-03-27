package project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMenu {
    @FXML
    private Label welcomeText;
    @FXML
    private Label registration_button;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onRegisterButtonClicked(){
        welcomeText.setText("Registration");
        registration_button.getScene().getWindow().hide();

        FXMLLoader loader_registration_menu = new FXMLLoader();
        loader_registration_menu.setLocation(getClass().getResource("RegistrationMenu.fxml"));

        try {
            loader_registration_menu.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader_registration_menu.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    @FXML
    protected void onForgotPasswordMouseClick(){
        welcomeText.setText("ForgotPassword");
    }
}