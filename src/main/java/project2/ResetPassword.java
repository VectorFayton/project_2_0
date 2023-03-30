package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ResetPassword {
    @FXML
    private Button safe_changes_button;
    @FXML
    private TextField username_text_field;
    @FXML
    private PasswordField password_field;
    @FXML
    protected void onSafeChangesButtonClick() throws IOException {
        FileCreate.resetPassword(username_text_field.getText(), password_field.getText(), "Users");
        safe_changes_button.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
    @FXML
    protected void onSignInButtonLabelClick(){
        password_field.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
}
