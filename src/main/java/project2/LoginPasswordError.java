package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginPasswordError {

    @FXML
    private Button close_button;

    @FXML
    protected void onCloseButtonClick(){
        close_button.getScene().getWindow().hide();
    }


}
