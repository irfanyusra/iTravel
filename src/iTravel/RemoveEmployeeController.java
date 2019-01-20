package iTravel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RemoveEmployeeController implements Initializable {

    @FXML
    ComboBox<String> idBox;

    @FXML
    Button cancelBtn;

    @FXML
    Button removeBtn;

    final ObservableList<String> data = FXCollections.observableArrayList();

    private EmployeesAdapter employeesAdapter;

    public void setModel(EmployeesAdapter employees) {
        employeesAdapter = employees;
        buildComboBoxData();
    }

    public void buildComboBoxData() {
        try {
            data.addAll(employeesAdapter.getIds());
        } catch(SQLException ex) {
            System.out.print("error: " + ex);
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void remove() {
        try {
            employeesAdapter.removeEmployee(idBox.getValue());
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }

        cancel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idBox.setItems(data);
    }

}
