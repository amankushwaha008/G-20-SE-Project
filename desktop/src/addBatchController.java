import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addBatchController {

    @FXML
    private Button addBatch;

    @FXML
    private GridPane addBatchWindow;

    @FXML
    private Label batchAddedNote;

    @FXML
    private TextField enteredBatch;

    @FXML
    void addBatchAction(ActionEvent event) {
        String batch = enteredBatch.getText();
        if(batch.length() == 0){
            batchAddedNote.setText("Enter valid batch name");
            return;
        } for(char ch : batch.toCharArray()){
            if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch != '_'){
                batchAddedNote.setText("Enter valid batch name");
                return;
            }
        }


        enteredBatch.clear();
        batchAddedNote.setText("Batch added");
    }

}
