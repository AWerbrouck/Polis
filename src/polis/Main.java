package polis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import polis.controls.MouseController;
import polis.tiles.TileController;
import polis.ui.UIController;
import prog2.util.Viewport;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Kaart kaart = new Kaart();
        MouseController mouseController = new MouseController();
        Pane mapPane = new Pane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ui/UI.fxml"));
        kaart.DrawKaart(mapPane, 64, 1);
        AnchorPane ui = loader.load();
        Viewport vp = new Viewport(mapPane, 0.7);
        vp.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        vp.getChildren().addAll((ui));
        Scene scene = new Scene (vp,32*64, 32*42);
        vp.requestFocus();
        stage.setScene(scene);
        stage.setTitle("Polis - 2021 © Universiteit Gent");
        stage.show();
        UIController controller = loader.getController();
        controller.setTilePane(new TileController());
        controller.tl.setPane(mapPane);
    }
}