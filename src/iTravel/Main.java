/**
 * @author Yusra Irfan and Hung Truong
 *
 */
package iTravel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("iTravel.fxml"));

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("iTravel");

        stage.setScene(scene);
        stage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
