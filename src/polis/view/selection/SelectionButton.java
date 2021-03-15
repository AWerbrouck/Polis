package polis.view.selection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import polis.util.Calculations;

public class SelectionButton extends Button implements EventHandler<ActionEvent> {
	protected boolean active = false;
	public Pane pane;
	public int size = 1;
	public Polygon poly = new Polygon(0, 0, 64 * size, 0.5 * 64 * size, 0, 64 * size, -64 * size, 0.5 * 64 * size);
	
	public SelectionButton(){
		setOnAction(this);
	}
	
	protected EventHandler<MouseEvent> CursorBlockHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			
			int[] norm = Calculations.NormalizeXY(pane, 64, event);
			int x = norm[0];
			int y = norm[1];
			poly.setTranslateX(x);
			poly.setTranslateY(y);
			poly.setFill(Color.rgb(22, 240, 90, 0.5));
			poly.setViewOrder(-1000);
			poly.setVisible(true);
		}
	};
	
	EventHandler<MouseEvent> PlaceBuilding = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			int r = Calculations.CalcRowFromXY(pane, 64, (int) event.getX(), (int) event.getY());
			int k = Calculations.CalcColFromXY(pane, 64, (int) event.getX(), (int) event.getY());
			System.out.println("r = " + r + ", k = " + k);
		}
	};
	public void setPane(Pane pane){
		this.pane = pane;
	}
	@Override
	public void handle(ActionEvent t) {
		active = !active;
		if(active){
			pane.addEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
			pane.addEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
			pane.getChildren().addAll(poly);
		}else{
			pane.removeEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
			pane.removeEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
			pane.getChildren().remove(poly);
		}
	}
}
