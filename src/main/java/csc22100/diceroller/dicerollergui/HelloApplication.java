package csc22100.diceroller.dicerollergui;

import csc22100.diceroller.DiceRollingService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final String MAIN_WINDOW_FXML = "hello-view.fxml";

    // We need the dice rolling service to be a singleton -- the one that main window calls has to be
    // the one the settings window updates
    private DiceRollingService diceRollingService = null;

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize the service
        diceRollingService = new DiceRollingService();
        DiceRollerViewModel viewModel = new DiceRollerViewModel(diceRollingService); // dependency injection

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(MAIN_WINDOW_FXML));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        HelloController controller = fxmlLoader.getController();
        controller.init(viewModel, this);

        stage.setTitle("Dice Roller");
        stage.setScene(scene);
        stage.show();
    }

    public void openSettingsWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        try {
            Scene settingsScene = new Scene(loader.load());
            SettingsController controller = loader.getController();
            SettingsViewModel viewModel = new SettingsViewModel(diceRollingService);
            controller.init(viewModel);
            Stage settingsStage = new Stage();
            settingsStage.setTitle("Settings");
            settingsStage.setScene(settingsScene);
            settingsStage.sizeToScene();
            settingsStage.showAndWait(); // TODO: Why doesn't this stop us rolling the dice?
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}