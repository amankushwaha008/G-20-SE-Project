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

public class deleteStudentController implements Initializable{

    @FXML
    private Button deleteStu;

    @FXML
    private GridPane deleteStuWindow;

    @FXML
    private ChoiceBox<String> enteredBatch;

    @FXML
    private TextField enteredRollNum;

    @FXML
    private Label stuDeletedNote;

    @FXML
    void deleteStuAction(ActionEvent event) {
        String rollNum = enteredRollNum.getText();
        String batch = enteredBatch.getValue();
        if(batch == null){
            stuDeletedNote.setText("Select a batch");
            return;
        } if(rollNum.length() != 6){
            stuDeletedNote.setText("Enter a valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                stuDeletedNote.setText("Enter a valid roll number");
                return;
            }
        }

        enteredRollNum.clear();
        enteredBatch.getSelectionModel().clearSelection();
        stuDeletedNote.setText("Student deleted");
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);  
    }

}
