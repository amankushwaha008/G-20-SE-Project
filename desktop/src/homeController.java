import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class homeController {

    @FXML
    private Button addBatch;
    @FXML
    private Button addStudent;
    @FXML
    private Button deleteBatch;
    @FXML
    private Button deleteStudent;
    @FXML
    private Button exit;
    @FXML
    private Button home;
    @FXML
    private HBox homeLowerWindow;
    @FXML
    private BorderPane homeOptionsWindow;
    @FXML
    private StackPane homeRightLogo;
    @FXML
    private StackPane homeLeftWindow;
    @FXML
    private BorderPane homeMainWindow;
    @FXML
    private HBox homeTitleWIndow;
    @FXML
    private Button instituteManagement;
    @FXML
    private Label loggedInUser;
    @FXML
    private Button logout;
    @FXML
    private Button messDeposit;
    @FXML
    private Button messDues;
    @FXML
    private Button messManagement;
    @FXML
    private Button messMenu;
    @FXML
    private Button messRates;
    @FXML
    private GridPane homeOptionsGrid;
    
    @FXML
    void addBatchAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("addBatch.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void addStudentAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void deleteBatchAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("deleteBatch.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void deleteStudentAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("deleteStudent.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void exitAction(ActionEvent event) {
        Stage stage = (Stage) (homeMainWindow.getScene().getWindow());
        stage.close();
    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = ((Node)event.getSource()).getScene();
        scene.setRoot(view);
    }

    @FXML
    void instituteManagementAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("instituteMngHome.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(getClass().getResource("App.fxml"));
        Scene scene = ((Node)event.getSource()).getScene();
        scene.setRoot(view);
    }

    @FXML
    void messDepositAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("moneyDeposit.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void messDuesAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("messDues.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void messManagementAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("messMngHome.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void messMenuAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("messMenu.fxml"));
        homeOptionsWindow.setCenter(view);
    }

    @FXML
    void messRatesAction(ActionEvent event) throws IOException {
        GridPane view = FXMLLoader.load(getClass().getResource("messRate.fxml"));
        homeOptionsWindow.setCenter(view);
    }

}
