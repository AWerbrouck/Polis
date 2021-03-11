package polis.tiles;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StreetBuilder extends TileBuilder{
	
	public void placeRoad(Pane pane) {
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				placeImage(pane, "road-0", (int) event.getX(), (int) event.getY(), 64, 1);
			}
		});
	}
}
