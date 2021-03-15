package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import prog2.util.Viewport;

import java.io.IOException;

public class MainTest extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        KaartTest kaart = new KaartTest();
        Pane mapPane = new Pane();
        Pane(pan
        mapPane.setPrefSize(64*2,64);
        kaart.DrawKaart(mapPane, 64, 1);
        Viewport vp = new Viewport(mapPane, 0.7);
        vp.setPrefSize(32,32);
        vp.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene (vp,32*64, 32*42);
        vp.requestFocus();
        stage.setScene(scene);
        stage.setTitle("Polis - 2021 © Universiteit Gent");
        stage.show();

    }
}