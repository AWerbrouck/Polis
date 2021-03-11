package test.mousetesting;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MouseTest {
	protected int CELL_SIZE = 64;
	protected  int size = 1;
	public Pane pane;
	public MouseEvent eventt;
	public Polygon poly = new Polygon(
			0, 0,
			CELL_SIZE * size, 0.5 * CELL_SIZE * size,
			0, CELL_SIZE * size,
			-CELL_SIZE * size, 0.5 * CELL_SIZE * size
	);
	EventHandler<MouseEvent> CursorBlockHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			
			int x = (int) event.getX();
			int y = (int) event.getY();
			int r = (int) (2 * y - x + (pane.getWidth() / 2)) / (2 * CELL_SIZE);
			int k = (int) (2 * y + x - (pane.getWidth() / 2)) / (2 * CELL_SIZE);
			x = CELL_SIZE * (1 - r + k);
			y = (CELL_SIZE * (r + k)) / 2;
			poly.setTranslateX(x);
			poly.setTranslateY(y);
			poly.setFill(Color.rgb(22, 240, 90, 0.5));
//				poly.setStroke(Color.);
//				poly.setStrokeType(StrokeType.INSIDE);
			poly.setViewOrder(-1000);
			poly.setVisible(true);
		}
	};
	public void setPane(Pane pane){
		this.pane = pane;
	}
	public void addMouseEvent(){
		
		pane.addEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
		pane.getChildren().addAll(poly);
		
	}
	
	public void removeMouseEvent(){
		pane.removeEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler );
		pane.getChildren().remove(poly);

		
	}
	
}
