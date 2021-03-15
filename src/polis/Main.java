package polis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import polis.view.map.Kaart;

import java.io.IOException;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		Kaart kaart = new Kaart();
		Pane mapPane = new Pane();
		Pane root = new Pane();
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("controller/UI.fxml"));
//		kaart.DrawKaart(mapPane, 64, 1);
//		Viewport vp = new Viewport(mapPane, 0.5);
//		root.getChildren().addAll(vp);
//		vp.setTranslateX(16*60);
//		vp.setTranslateY(16 * 33);
		Pane pane = new Pane(new Rectangle(100,100));
		pane.setTranslateX(16*60);
		pane.setTranslateY(16 * 33);
		pane.setBorder(new Border(new BorderStroke(Color.RED,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.FULL)));
		root.getChildren().addAll(pane);
		pane.setManaged(false);
//		System.out.println(vp.getLayoutBounds().toString());
		root.setPrefSize(32 * 60, 32 * 33);
//		AnchorPane.clearConstraints(vp);
//		root.getChildren().addAll(ui);
//		root.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene scene = new Scene(root);
//		vp.requestFocus();
		stage.setScene(scene);
		stage.setTitle("Polis - 2021 © Universiteit Gent");
		stage.show();
//		UICompanion companion = loader.getController();
//		companion.setPane(mapPane);
	}
}