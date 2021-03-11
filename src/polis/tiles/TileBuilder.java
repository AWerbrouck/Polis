package polis.tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class TileBuilder {
	
	
	public Polygon placePolly(Pane pane, Color color, int x, int y, int CELL_SIZE, int size){
		Polygon poly = new Polygon(
				0, 0,
				CELL_SIZE * size, 0.5 * CELL_SIZE * size,
				0, CELL_SIZE * size,
				-CELL_SIZE * size, 0.5 * CELL_SIZE * size
		);
		int r = (int) (2*y - x + (pane.getWidth()/2) )/ (2 * CELL_SIZE);
		int k = (int) (2*y + x - (pane.getWidth()/2) )/ (2 * CELL_SIZE);
		x =  CELL_SIZE * (1 - r + k);
		y = (CELL_SIZE * (r + k)) / 2;
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setFill(color);
		poly.setStroke(Color.TRANSPARENT);
		poly.setStrokeType(StrokeType.INSIDE);
		poly.setViewOrder (- 1000);
		return poly;
	}
	
	
	
	public void placeImage(Pane pane, String img, int x, int y, int CELL_SIZE, int size){
		Image image = new Image("file:resources/polis/tiles/"+img+".png");
		ImageView view = new ImageView(image);
		double width = image.getWidth();
		double height = image.getHeight();
		view.setImage(image);
		view.setX(-0.5 * width);
		view.setY(0.5 * width - height);
		int r = (int) (2 * y - x + (pane.getWidth() / 2)) / (2 * CELL_SIZE);
		int k = (int) (2 * y + x - (pane.getWidth() / 2)) / (2 * CELL_SIZE);
		x = CELL_SIZE * (size - r + k);
		y = (CELL_SIZE * (r + k)) / 2;
		view.setTranslateX(x);
		view.setTranslateY(y);
		view.setViewOrder(-100);
		pane.getChildren().addAll(view);
	}
}
