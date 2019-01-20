package iTravel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    private EmployeesAdapter employeesAdapter;

    @FXML
    TextField nameText;

    @FXML
    TextField idText;

    @FXML
    TextField emailText;

    @FXML
    TextField roleText;

    @FXML
    TextField usernameText;

    @FXML
    PasswordField passwordText;

    @FXML
    Button submitBtn;

    @FXML
    Button cancelBtn;

    public void setModel(EmployeesAdapter employees) { employeesAdapter = employees; }

    @FXML
    public void submit() {
        try {
            employeesAdapter.insertEmployee("ActiveEmployees", idText.getText(), nameText.getText(), emailText.getText(), roleText.getText(), usernameText.getText(), passwordText.getText());
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }

        cancel();
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
