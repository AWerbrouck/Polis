package polis.tiles;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.HashMap;

public class ResidenceBuilder extends  TileBuilder{
	
	public HashMap<String, Polygon> polies = new HashMap<>();
	
	public void placeBlueprint(Pane pane) {
		pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int r = (int) (2*event.getY() - event.getX() + (pane.getWidth()/2) )/ (2 * 64);
				int k = (int) (2* event.getX() + event.getX() - (pane.getWidth()/2) )/ (2 * 64);
				int x =  64 * (1 - r + k);
				int y = (64 * (r + k)) / 2;
				String key = "" + x + "" + y;
				if(! polies.containsKey(key)) {
					
					
					Polygon poly = placePolly(pane, Color.rgb(100, 100, 100, 0.1), (int) event.getX(), (int) event.getY(), 64, 2);
//					poly.mouse(new EventHandler<MouseEvent>() {
//						@Override
//						public void handle(MouseEvent event) {
////							pane.getChildren().remove(poly);
//							poly.setVisible(false);
//
//						}
//					});
					pane.getChildren().addAll(poly);
					polies.put(key, poly);
				}
			}
		});
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				placeImage(pane, "residence-0", (int) event.getX(), (int) event.getY(), 64, 1);
			}
		});

	}
}
