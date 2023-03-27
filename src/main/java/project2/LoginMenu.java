package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginMenu {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}