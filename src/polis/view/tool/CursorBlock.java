package polis.view.tool;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import polis.model.TileModel;
import polis.util.Calculations;

public class CursorBlock {
	public Pane pane;
	public String img;
	protected int CELL_SIZE = 64;
	protected int size = 1;
	public Polygon poly = new Polygon(0, 0, CELL_SIZE * size, 0.5 * CELL_SIZE * size, 0, CELL_SIZE * size, -CELL_SIZE * size, 0.5 * CELL_SIZE * size);
	protected TileModel tileModel;
	
	protected EventHandler<MouseEvent> CursorBlockHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			
			int[] norm = Calculations.NormalizeXY(pane, CELL_SIZE, event);
			int x = norm[0];
			int y = norm[1];
			poly.setTranslateX(x);
			poly.setTranslateY(y);
			poly.setFill(Color.rgb(22, 240, 90, 0.5));
			poly.setViewOrder(-1000);
			poly.setVisible(true);
		}
	};
	
	public void setTileModel(TileModel tileModel) {
		this.tileModel = tileModel;
	}
	
	EventHandler<MouseEvent> PlaceBuilding = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			int r = Calculations.CalcRowFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
			int k = Calculations.CalcColFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
			if (!tileModel.isTileAt(r, k) && !tileModel.isTileAt(r+1, k) && !tileModel.isTileAt(r+1, k-1)  && !tileModel.isTileAt(r, k-1) ) {
				Tile tile = new Tile(tileModel, pane);
				tile.setImg(img);
				tile.PlaceTile(event);
				System.out.println(r + " " + k);
			}
		}
	};
	
	
	public void setPane(Pane pane) {
		this.pane = pane;
		
	}
	
	public void setImg(String img) {
		this.img = img;
		
	}
	
	public void setSize(int size) {
		this.size = size;
		poly = new Polygon(0, 0, CELL_SIZE * size, 0.5 * CELL_SIZE * size, 0, CELL_SIZE * size, -CELL_SIZE * size, 0.5 * CELL_SIZE * size);
	}
	
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
