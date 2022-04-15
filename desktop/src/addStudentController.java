import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addStudentController implements Initializable{

    @FXML
    private Button addStudent;

    @FXML
    private GridPane addStudentWindow;

    @FXML
    private ChoiceBox<String> enteredBatch;

    @FXML
    private ChoiceBox<String> enteredDept;

    @FXML
    private TextField enteredEmail;

    @FXML
    private TextField enteredName;

    @FXML
    private TextField enteredPassword;

    @FXML
    private TextField enteredPhoneNum;

    @FXML
    private TextField enteredRollNum;

    @FXML
    private TextField enteredUserName;

    @FXML
    private Label studentAddedNote;

    @FXML
    void addStudentAction(ActionEvent event) {
        String name = enteredName.getText();
        String userName = enteredUserName.getText();
        String password = enteredPassword.getText();
        String rollNum = enteredRollNum.getText();
        String phoneNumString = enteredPhoneNum.getText();
        String email = enteredEmail.getText();
        String batch = enteredBatch.getValue();
        String dept = enteredDept.getValue();
        
        if(name.length() == 0 || userName.length() == 0 || password.length() == 0 || email.length() == 0 || phoneNumString.length() == 0 || rollNum.length() == 0 || batch == null || dept == null){
            studentAddedNote.setText("All fields must be filled");
            return;
        } for(char ch : name.toCharArray()){
            if(ch != ' ' && !Character.isLetter(ch)){
                studentAddedNote.setText("Enter valid name");
                return;
            }
        } if(!email.endsWith("@iiitg.ac.in") && !email.endsWith("@gmail.com")){
            studentAddedNote.setText("Enter valid email");
            return;
        } if(phoneNumString.length() != 10){
            studentAddedNote.setText("Enter valid phone number");
            return;
        } else{
            String numFirstHalf = phoneNumString.substring(0, 5);
            String numSecondHalf = phoneNumString.substring(5);
            try{
                Integer.parseInt(numFirstHalf);
                Integer.parseInt(numSecondHalf);
            } catch(Exception e){
                studentAddedNote.setText("Enter valid phone number");
                return;
            }
        } if(rollNum.length() != 6){
            studentAddedNote.setText("Enter valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                studentAddedNote.setText("Enter valid roll number");
                return;
            }
        }

        
        studentAddedNote.setText("Student Added");
        clearFields();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);

        String[] depts = {"CSE", "ECE"};
        enteredDept.getItems().addAll(depts);
    }

    void clearFields(){
        enteredName.clear();
        enteredUserName.clear();
        enteredPassword.clear();
        enteredEmail.clear();
        enteredPhoneNum.clear();
        enteredRollNum.clear();
        enteredBatch.getSelectionModel().clearSelection();
        enteredDept.getSelectionModel().clearSelection();
    }

}
