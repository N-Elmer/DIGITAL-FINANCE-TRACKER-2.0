package ewallet;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author N.Elmer
 */
public class Data {    
    private SimpleStringProperty amount, type, remarks;
    private LocalDate date;

    public Data(String amount, String type, String remarks, LocalDate date) {
        this.amount = new SimpleStringProperty (amount);
        this.type = new SimpleStringProperty (type);
        this.remarks = new SimpleStringProperty (remarks);
        this.date = date;
    }

    Data(String string, String income, String from_Salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAmount() {
        return amount.get();
    }

    public void setAmount(String amount) {
        this.amount = new SimpleStringProperty (amount);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty (type);
    }

    public String getRemarks() {
        return remarks.get();
    }

    public void setRemarks(String remarks) {
        this.remarks = new SimpleStringProperty (remarks);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}