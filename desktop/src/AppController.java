import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AppController implements Initializable{

    @FXML
    private PasswordField enteredPassword;
    @FXML
    private TextField enteredUserName;
    @FXML
    private Label instituteTitle;
    @FXML
    private Button login;
    @FXML
    private Label wrongPasswordNote;
    @FXML
    private BorderPane appWindow;

    @FXML
    void loginAction(ActionEvent event) throws Exception {
        String username = enteredUserName.getText();
        String password = enteredPassword.getText();

        if(username.equals("admin") && password.equals("admin")){
            BorderPane view = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene = ((Node)event.getSource()).getScene();
            scene.setRoot(view);
        } else{
            wrongPasswordNote.setText("Wrong Credentials !! Please Try Again.");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

}
