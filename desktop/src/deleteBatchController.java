import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class deleteBatchController implements Initializable{

    @FXML
    private Label batchDeletedNote;

    @FXML
    private Button deleteBatch;

    @FXML
    private ChoiceBox<String> enteredBatch;

    @FXML
    private GridPane deleteBatchWindow;

    @FXML
    void deleteBatchAction(ActionEvent event) {
        String batch = enteredBatch.getValue();
        if(batch == null){
            batchDeletedNote.setText("Select a batch");
            return;
        }

        
        enteredBatch.getSelectionModel().clearSelection();
        batchDeletedNote.setText("Batch Deleted");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);
    }

}
