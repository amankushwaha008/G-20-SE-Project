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
import javafx.scene.layout.StackPane;

public class messDuesController implements Initializable{

    @FXML
    private Label batchField;

    @FXML
    private Label batchValue;

    @FXML
    private Label deptField;

    @FXML
    private Label deptValue;

    @FXML
    private Label duesField;

    @FXML
    private Label duesValue;

    @FXML
    private Label emailField;

    @FXML
    private Label emailValue;

    @FXML
    private ChoiceBox<String> enteredBatch;

    @FXML
    private TextField enteredRollNum;

    @FXML
    private Button getDetails;

    @FXML
    private StackPane informationWindow;

    @FXML
    private GridPane messDuesWindow;

    @FXML
    private Label nameField;

    @FXML
    private Label nameValue;

    @FXML
    private Label phoneNumField;

    @FXML
    private Label phoneNumValue;

    @FXML
    private Label rollNumField;

    @FXML
    private Label rollNumValue;

    @FXML
    private Label studentFoundNote;

    @FXML
    private Label userNameField;

    @FXML
    private Label userNameValue;

    @FXML
    void getDetailsAction(ActionEvent event) {
        String rollNum = enteredRollNum.getText();
        String batch = enteredBatch.getValue();

        if(rollNum.length() == 0 || batch == null){
            studentFoundNote.setText("All fields must be filled");
            clearData();
            return;
        } if(rollNum.length() != 6){
            studentFoundNote.setText("Enter valid roll number");
            clearData();
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                studentFoundNote.setText("Enter valid roll number");
                clearData();
                return;
            }
        } boolean found = false;

        if(!found){
            duesField.setText("Mess Dues");
            nameField.setText("Name");
            userNameField.setText("UserName");
            rollNumField.setText("Roll No");
            phoneNumField.setText("Phone No");
            batchField.setText("Batch");
            deptField.setText("Dept");
            emailField.setText("Email");

            duesValue.setText("0");
            nameValue.setText("Abhinav Sharma");
            userNameValue.setText("abhinav001");
            rollNumValue.setText("220001");
            phoneNumValue.setText("9654782101");
            batchValue.setText("2022");
            deptValue.setText("CSE");
            emailValue.setText("abhinav@iiitg.ac.in");

            enteredBatch.getSelectionModel().clearSelection();
            enteredRollNum.clear();
        } else{
            studentFoundNote.setText("No such student found. Recheck credentials");
            clearData();
        }
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);
    }

    void clearData(){
        duesField.setText("");
            nameField.setText("");
            userNameField.setText("");
            rollNumField.setText("");
            phoneNumField.setText("");
            batchField.setText("");
            deptField.setText("");
            emailField.setText("");

            duesValue.setText("");
            nameValue.setText("");
            userNameValue.setText("");
            rollNumValue.setText("");
            phoneNumValue.setText("");
            batchValue.setText("");
            deptValue.setText("");
            emailValue.setText("");
    }

}
