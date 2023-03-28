package project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMenu {
    @FXML
    private Label welcomeText;
    @FXML
    private Label register_button_label;

    @FXML
    private TextField username_text_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private CheckBox remember_me_check_box;
    @FXML
    private Label forgot_password_button_label;
    @FXML
    private Button login_button;

    @FXML
    protected void onLoginButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        OpenScene("LoginPasswordError");
    }
    @FXML
    protected void onRegisterButtonClicked(){
        register_button_label.getScene().getWindow().hide();
        OpenScene("RegistrationMenu");
    }
    @FXML
    protected void onForgotPasswordMouseClick(){
        welcomeText.setText("ForgotPassword");
    }
    protected void ErrorEmptyFields(){

    }

    public static void OpenScene(String name_of_fxml_file){
        FXMLLoader loader_registration_menu = new FXMLLoader(LoginMenu.class.getResource(String.format("%s.fxml", name_of_fxml_file)));

        try {
            loader_registration_menu.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader_registration_menu.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}