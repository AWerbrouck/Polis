package polis.view.tool;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import polis.model.TileModel;
import polis.util.Calculations;
import polis.util.NodeFactory;

public class Tile implements InvalidationListener {
	protected int CELL_SIZE = 64;
	protected Pane pane;
	protected ImageView view;
	protected String img;
	protected int r;
	protected int k;
	protected TileModel tileModel;
	
	public Tile(TileModel tileModel, Pane pane) {
		this.tileModel = tileModel;
		tileModel.addListener(this);
		tileModel.addTile(this);
		this.pane = pane;
	}
	
	
	public void PlaceTile(MouseEvent event) {
		this.view = NodeFactory.makeImage("file:resources/polis/tiles/" + img + ".png");
		this.r = Calculations.CalcRowFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
		this.k = Calculations.CalcColFromXY(pane, CELL_SIZE, (int) event.getX(), (int) event.getY());
		int x = Calculations.CalcXFromRowCol(CELL_SIZE, r, k);
		int y = Calculations.CalcYFromRowCol(CELL_SIZE, r, k);
		view.setTranslateX(x);
		view.setTranslateY(y);
		view.setViewOrder(-100);
		pane.getChildren().addAll(view);
		tileModel.tilePlaced();
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public int getR() {
		return this.r;
	}
	
	// getters
	public int getK() {
		return this.k;
	}
	
	@Override
	public void invalidated(Observable observable) {
	
	}
}
