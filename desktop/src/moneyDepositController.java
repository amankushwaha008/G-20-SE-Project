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

public class moneyDepositController implements Initializable{

    @FXML
    private Button depositMoney;

    @FXML
    private GridPane depositMoneyAction;

    @FXML
    private Label duesLeftNote;

    @FXML
    private TextField enteredAmount;

    @FXML
    private ChoiceBox<String> enteredBatch;

    @FXML
    private TextField enteredRollNum;

    @FXML
    private Label moneyDepositedNote;

    @FXML
    void depositMoneyAction(ActionEvent event) {
        String batch = enteredBatch.getValue();
        String rollNum = enteredRollNum.getText();
        String amount = enteredAmount.getText();

        if(batch == null || rollNum.length() == 0 || amount.length() == 0){
            moneyDepositedNote.setText("All fields must be filled");
            return;
        } if(rollNum.length() != 6){
            moneyDepositedNote.setText("Enter valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                moneyDepositedNote.setText("Enter valid roll number");
                return;
            }
        } try{
            Integer.parseInt(amount);
        } catch(Exception e){
            moneyDepositedNote.setText("Enter valid money amount");
            return;
        }


        moneyDepositedNote.setText("Money Deposited");
        clearFields();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);
    }

    void clearFields(){
        enteredBatch.getSelectionModel().clearSelection();
        enteredAmount.clear();
        enteredRollNum.clear();
    }

}
