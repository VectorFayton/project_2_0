package project2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationMenu {

    @FXML
    private Button sign_up_button;
    @FXML
    private TextField surname_text_field;

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
    private Label username_error_message_label;
    @FXML
    private Label password_error_message_label;
    @FXML
    private Label email_error_message_label;

    @FXML
    protected void onSignUpButtonClick(){
        if (surname_text_field.getText().equals("")) {
            username_error_message_label.setText("username is empty");
        } else if(new_password_field.getText().equals("")) {
            password_error_message_label.setText("password is empty");
        } else if(email_text_field.getText().equals("")){
            email_error_message_label.setText("email is empty");
        } else if(new_password_field.getText().equals(surname_text_field.getText()) || username_error_message_label.equals(new_password_field.getText())){
            username_error_message_label.setText("username and password is same");
            password_error_message_label.setText("username and password is same");
        } else {
            FileCreate.addData(surname_text_field.getText(), new_password_field.getText(), email_text_field.getText(), "Users");
            email_text_field.getScene().getWindow().hide();
            LoginMenu.OpenScene("NewsMenuBar");
        }
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
