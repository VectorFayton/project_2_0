package project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationMenu {

    @FXML
    private Button sign_up_button;
    @FXML
    private TextField name_surname_text_field;

    @FXML
    private PasswordField new_password_field;

    @FXML
    private RadioButton male_radio_button;
    @FXML
    private RadioButton female_radio_button;
    @FXML
    private RadioButton other_radio_button;
    @FXML
    private TextField email_text_field;

    @FXML
    private ToggleGroup gender_toggle_group;

    @FXML
    protected void onSignUpButtonClick(){
        FileCreate.addData(name_surname_text_field.getText(), new_password_field.getText(), email_text_field.getText(), "Users");
    }
    @FXML
    protected void onLoginLabelButtonClick(){
        sign_up_button.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
    @FXML
    protected void onFemaleRadioButtonClick(){
        Genders();
    }

    @FXML
    protected void onMaleRadioButtonClick(){
        Genders();
    }
    @FXML
    protected void onOtherRadioButtonClick(){
        Genders();
    }

    private void Genders(){
        ToggleGroup gender_toggle_group = new ToggleGroup();
        female_radio_button.setToggleGroup(gender_toggle_group);
        male_radio_button.setToggleGroup(gender_toggle_group);
        other_radio_button.setToggleGroup(gender_toggle_group);
    }
}
