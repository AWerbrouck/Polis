package polis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import polis.ui.UICompanion;
import prog2.util.Viewport;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Kaart kaart = new Kaart();
        Pane mapPane = new Pane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ui/UI.fxml"));
        kaart.DrawKaart(mapPane, 64, 1);
        Viewport vp = new Viewport(mapPane, 0.5);
        AnchorPane ui = loader.load();
        vp.getChildren().addAll(ui);
        vp.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene (vp,32*60, 32*33);
        vp.requestFocus();
        stage.setScene(scene);
        stage.setTitle("Polis - 2021 © Universiteit Gent");
        stage.show();
        UICompanion companion = loader.getController();
        companion.setPane(mapPane);
    }
}