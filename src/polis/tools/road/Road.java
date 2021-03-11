package polis.tools.road;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Road implements InvalidationListener {
	
	// Fields
	protected RoadModel roadModel;
	protected  String img = "road-0";
	protected int CELL_SIZE = 64;
	protected Pane pane;
	protected ImageView view;
	protected Image image;
	protected int i = 0;
	// constructor
	public Road(RoadModel roadModel, Pane pane){
		this.roadModel = roadModel;
		roadModel.addListener(this);
		this.pane = pane;
	
	}

	
	public void PlaceRoad(MouseEvent event){
		image = new Image("file:Resources/polis/tiles/"+img+".png");
		System.out.println(image.getUrl());
		view = new ImageView(image);
		double width = image.getWidth();
		double height = image.getHeight();
		view.setImage(image);
		view.setX(-0.5 * width);
		view.setY(0.5 * width - height);
		int x = (int) event.getX();
		int y = (int) event.getY();
		int r = (int) (2 * y - x + (pane.getWidth() / 2)) / (2 * CELL_SIZE);
		int k = (int) (2 * y + x - (pane.getWidth() / 2)) / (2 * CELL_SIZE);
		x = CELL_SIZE * (1 - r + k);
		y = (CELL_SIZE * (r + k)) / 2;
		view.setTranslateX(x);
		view.setTranslateY(y);
		view.setViewOrder(-100);
		pane.getChildren().addAll(view);
		roadModel.roadNot();
	}
	
	public void updateRoad(){
		image = new Image("file:Resources/polis/tiles/"+img+".png");
		view.setImage(image);
	}
	
	
	@Override
	public void invalidated(Observable observable) {
		this.img = "road-"+i;
		i++;
		updateRoad();
	}
}
