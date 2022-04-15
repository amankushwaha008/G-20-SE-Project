import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class instituteMngController implements Initializable{

    @FXML
    private Button addManagement;
    @FXML
    private TextField enteredEmail;
    @FXML
    private TextField enteredName;
    @FXML
    private TextField enteredNumber;
    @FXML
    private TextField enteredPassword;
    @FXML
    private TextField enteredUserName;
    @FXML
    private GridPane managementWindow;
    @FXML
    private Label ManagementAddedNote;

    @FXML
    void addManagementAction(ActionEvent event) throws Exception{
        String name = enteredName.getText();
        String userName = enteredUserName.getText();
        String password = enteredPassword.getText();
        String email = enteredEmail.getText();
        String phoneNumString = enteredNumber.getText();
        
        if(name.length() == 0 || userName.length() == 0 || password.length() == 0 || email.length() == 0 || phoneNumString.length() == 0){
            ManagementAddedNote.setText("All fields must be filled");
            return;
        } for(char ch : name.toCharArray()){
            if(ch != ' ' && !Character.isLetter(ch)){
                ManagementAddedNote.setText("Enter valid name");
                return;
            }
        } if(!email.endsWith("@iiitg.ac.in") && !email.endsWith("@gmail.com")){
            ManagementAddedNote.setText("Enter valid email");
            return;
        } if(phoneNumString.length() != 10){
            ManagementAddedNote.setText("Enter valid phone number");
            return;
        } else{
            String numFirstHalf = phoneNumString.substring(0, 5);
            String numSecondHalf = phoneNumString.substring(5);
            try{
                Integer.parseInt(numFirstHalf);
                Integer.parseInt(numSecondHalf);
            } catch(Exception e){
                ManagementAddedNote.setText("Enter valid phone number");
                return;
            }
        }

        
        ManagementAddedNote.setText("Institute Management Added");
        clearFields();

    }

    void clearFields(){
        enteredName.clear();
        enteredUserName.clear();
        enteredPassword.clear();
        enteredEmail.clear();
        enteredNumber.clear();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}
