package ewallet;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author N.Elmer
 */
public class EwalletFXMLController implements Initializable {

    @FXML
    private TableView<Data> tableView;
    @FXML
    private TableColumn<Data, LocalDate> dateColumn;
    @FXML
    private TableColumn<Data, String> amountColumn;
    @FXML
    private TableColumn<Data, String> typeColumn;
    @FXML
    private TableColumn<Data, String> remarksColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField amountTxt;
    @FXML
    private TextField typeTxt;
    @FXML
    private TextField remarksTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sets up columns
        dateColumn.setCellValueFactory(new PropertyValueFactory<Data, LocalDate>("date"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("amount"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("type"));
        remarksColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("remarks"));
        
        //load dummy data
        tableView.setItems(getDatas());
        
        //Update the table to allow for amount, type and remarks columns to be editable
        tableView.setEditable(true);
        amountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        remarksColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
    //observable list
    public ObservableList<Data> getDatas(){
        
        ObservableList<Data> datas = FXCollections.observableArrayList();
        datas.add(new Data("50000 FCFA", "Income", "From Salary", LocalDate.of(2015, Month.JANUARY, 15)));
        datas.add(new Data("75000 FCFA", "Income", "From Salary", LocalDate.of(2015, Month.FEBRUARY, 15)));
        datas.add(new Data("25000 FCFA", "Expenditure", "Bills Payed", LocalDate.of(2015, Month.MARCH, 28)));
        datas.add(new Data("15000 FCFA", "Expenditure", "Borrowed", LocalDate.of(2015, Month.APRIL, 12)));
        
        return datas;
    }
    
    //allow user to double click and edit cell
    @FXML
    public void changeAmount(CellEditEvent edittedCell)
    {
        Data dataSelected =  tableView.getSelectionModel().getSelectedItem();
        dataSelected.setAmount(edittedCell.getNewValue().toString());
    }
    
    @FXML
    public void changeType(CellEditEvent edittedCell)
    {
        Data dataSelected =  tableView.getSelectionModel().getSelectedItem();
        dataSelected.setType(edittedCell.getNewValue().toString());
    }
    
    @FXML
    public void changeRemarks(CellEditEvent edittedCell)
    {
        Data dataSelected =  tableView.getSelectionModel().getSelectedItem();
        dataSelected.setType(edittedCell.getNewValue().toString());
    }

    @FXML
    private void addData(ActionEvent event) {
        
        Data newData = new Data(amountTxt.getText(),
                                typeTxt.getText(),
                                remarksTxt.getText(),
                                datePicker.getValue());
        
        //Get all the items from the table as a list, then add the new data to
        //the list
        tableView.getItems().add(newData);
    }

    @FXML
    private void deleteData(ActionEvent event) {
        
        ObservableList<Data> selectedRows, allDatas;
        allDatas = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Data data: selectedRows)
        {
            allDatas.remove(data);
        }
    }

    @FXML
    private void addDate(ActionEvent event) {
    }
      
}