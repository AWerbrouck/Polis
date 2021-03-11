package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import prog2.util.Viewport;
import test.mousetesting.MouseTest;
import test.ui.UIController;

import java.io.IOException;

public class MainTest extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        KaartTest kaart = new KaartTest();
        Pane mapPane = new Pane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ui/uitest.fxml"));
        AnchorPane ui = loader.load();
        mapPane.setPrefSize(64*2,64);
        MouseTest ms = new MouseTest();
        ms.setPane(mapPane);
        kaart.DrawKaart(mapPane, 64, 1);
        Viewport vp = new Viewport(mapPane, 0.7);
        vp.getChildren().addAll(ui);
        vp.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene (vp,32*64, 32*42);
        vp.requestFocus();
        stage.setScene(scene);
        stage.setTitle("Polis - 2021 © Universiteit Gent");
        stage.show();
        UIController controller = loader.getController();
        controller.setMouse(ms);
    }
}