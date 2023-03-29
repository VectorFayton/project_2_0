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
    private Label empty_username_error;

    @FXML
    private Label empty_password_error;

    @FXML
    protected void onLoginButtonClick() {
        FileCreate file_create = new FileCreate();
        Boolean checkData = file_create.checkData(username_text_field.getText(), password_field.getText());
        if (username_text_field.getText().equals("")) {
            empty_username_error.setText("username is empty");
        } if(password_field.getText().equals("")){
            empty_password_error.setText("password is empty");
        } else if (checkData){
            OpenScene("NewsMenuBar");
        } else
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