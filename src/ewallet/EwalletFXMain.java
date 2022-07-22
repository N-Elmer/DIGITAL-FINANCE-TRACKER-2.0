package ewallet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author N.Elmer
 */

public class EwalletFXMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EwalletFXML.fxml"));
        Scene scene = new Scene(root);
        Image image = new Image("/images/CreditCard.png");
        stage.getIcons().add(image);    
        stage.setTitle("E-WALLET || N.ELMER");
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