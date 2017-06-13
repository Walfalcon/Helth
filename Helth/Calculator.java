import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
*WriteadescriptionofclassCalculatorhere.
*
*@author(yourname)
*@version(aversionnumberoradate)
*/
public class Calculator extends Application {
    public static void main(String[] args) {
        Calculator calc = new Application();
        calc.start(new Stage());
    }

    public void start (Stage stage) {
        StackPane pane = new StackPane();

        stage.setTitle("Calculator");
        stage.setScene(new Scene(pane, 250, 250));
        stage.show();
    }
}