import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class messRateController implements Initializable{

    @FXML
    private TextField breakfastRate;

    @FXML
    private Button changeRates;

    @FXML
    private TextField dinnerRate;

    @FXML
    private TextField lunchRate;

    @FXML
    private GridPane messRatesWindow;

    @FXML
    private Label ratesChangedNote;

    @FXML
    void changeRatesAction(ActionEvent event) {
        String breakFast = breakfastRate.getText();
        String lunch = lunchRate.getText();
        String dinner = dinnerRate.getText();

        try{
            Integer.parseInt(breakFast);
            Integer.parseInt(lunch);
            Integer.parseInt(dinner);
        } catch(Exception e){
            ratesChangedNote.setText("Enter valid rates");
            return;
        }

        ratesChangedNote.setText("Rates changed");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        breakfastRate.setText("45");
        lunchRate.setText("55");
        dinnerRate.setText("50");


    }

}
