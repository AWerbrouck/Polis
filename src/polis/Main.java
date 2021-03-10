package polis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import prog2.util.Viewport;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Kaart kaart = new Kaart();

        
        Pane pane = new Pane();
        kaart.DrawKaart(pane, 64, 1);
        Viewport vp = new Viewport(pane, 0.6);
        
        Scene scene = new Scene (vp,32*64, 32*64);
        vp.requestFocus();
        stage.setScene(scene);
        stage.setTitle("Polis - 2021 © Universiteit Gent");
        stage.show();
    }

}


//        final Label reporter = new Label("OUTSIDE_TEXT");
//        mouseController.createMonitoredLabel(reporter, pane);
//        pane.getChildren().addAll(reporter);
//         MouseController mouseController = new MouseController();