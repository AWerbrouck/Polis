package polis.view.road;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import polis.util.Calculations;
import polis.view.tool.CursorBlock;
import polis.view.tool.Tile;

public class RoadCursorBlock extends CursorBlock {
	
	
	EventHandler<MouseEvent> PlaceBuilding = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			
			int r = Calculations.CalcRowFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
			int k = Calculations.CalcColFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
			if (!tileModel.isTileAt(r, k)) {
				Tile tile = new Road(tileModel, pane);
				tile.setImg(img);
				tile.PlaceTile(event);
				
			}
		}
	};
	
	public void addMouseEvent() {
		
		pane.addEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
		pane.getChildren().addAll(poly);
		
	}
	
	public void removeMouseEvent() {
		pane.removeEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
		pane.removeEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
		pane.getChildren().remove(poly);
		
		
	}
}
