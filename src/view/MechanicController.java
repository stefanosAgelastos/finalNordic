package view;

import databaseConnection.Fleet;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Motorhome;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by ADMIN on 29/05/2017.
 */
public class MechanicController implements Initializable{

    private Fleet fleet = Fleet.getInstance();
    private List<Motorhome> motorhomeList = fleet.getTheFleetList();

    public TableColumn <Motorhome,Integer> motorhomeid;
    public TableColumn <Motorhome,Double> endDate;
    public Button notReturned;
    public Button pickedUp;
    public Button pass;
    public Button fail;
    public TableColumn <Motorhome,Integer> motorhomeid1;
    public TableColumn <Motorhome,Integer> comments;
    public Button pass2;
    public TableView <Motorhome> UnderInspection;
    public TableColumn <Motorhome,Integer> motorhomeid2;
    public TableView <Motorhome> UnderRepair;
    public TableView <Motorhome> dropOffsToday;


    public void initializeRentedOutTable() {

        ObservableList<Motorhome> droppedOffToday = Fleet.getInstance().setRentedOutMotorhomeList();
        motorhomeid.setCellValueFactory(new PropertyValueFactory<>("id"));
        dropOffsToday.setItems(droppedOffToday);


    }

    public void initialize(URL location, ResourceBundle resources) {

        initializeRentedOutTable();


    }


    public void notReturnedButton(ActionEvent event) {
    }

    public void pickedUpButton(ActionEvent event) {
    }

    public void passButton(ActionEvent event) {
    }

    public void failButton(ActionEvent event) {
    }

    public void passButton2(ActionEvent event) {
    }
}
