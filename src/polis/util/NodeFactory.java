package polis.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class NodeFactory {
	
	public static ImageView makeImage(String source) {
		Image image = new Image(source);
		ImageView view = new ImageView(image);
		double width = image.getWidth();
		double height = image.getHeight();
		view.setImage(image);
		view.setX(-0.5 * width);
		view.setY(0.5 * width - height);
		return view;
	}
	
	public static Polygon makePoly(int r, int k, Color color, int CELL_SIZE, int size){
		Polygon poly = new Polygon(0, 0, CELL_SIZE * size, 0.5 * CELL_SIZE * size, 0, CELL_SIZE * size, -CELL_SIZE * size, 0.5 * CELL_SIZE * size);
		int x = CELL_SIZE * (size - r + k);
		int y = (CELL_SIZE * (r + k)) / 2;
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setFill(color);
		poly.setStrokeType(StrokeType.INSIDE);
		poly.setViewOrder(-r - k - 1.0);
		return poly;
	}
	
	public static Polygon makePoly(int r, int k, Color color1, Color color2, int CELL_SIZE, int size){
		Polygon poly = new Polygon(0, 0, CELL_SIZE * size, 0.5 * CELL_SIZE * size, 0, CELL_SIZE * size, -CELL_SIZE * size, 0.5 * CELL_SIZE * size);
		int x = CELL_SIZE * (size - r + k);
		int y = (CELL_SIZE * (r + k)) / 2;
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setFill(color1);
		poly.setStroke(color2);
		poly.setStrokeType(StrokeType.INSIDE);
		poly.setViewOrder(-r - k - 1.0);
		return poly;
	
	}
	
	
	public static Polygon makePoly(int r, int k){
		Polygon poly = new Polygon(0, 0, 64, 0.5 * 64, 0, 64, -64, 0.5 * 64);
		int x = 64 * (1 - r + k);
		int y = (64 * (r + k)) / 2;
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setFill(Color.rgb(204, 249, 170));
		poly.setStroke(Color.rgb(170, 230, 120));
		poly.setStrokeType(StrokeType.INSIDE);
		poly.setViewOrder(-r - k - 1.0);
		return poly;
	}
}
