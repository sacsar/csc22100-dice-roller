package csc22100.diceroller.dicerollergui;

import csc22100.diceroller.DiceRollingService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Initialize the service
        DiceRollingService service = new DiceRollingService();
        DiceRollerViewModel viewModel = new DiceRollerViewModel(service); // dependency injection

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        HelloController controller = fxmlLoader.getController();
        controller.init(viewModel);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}