package polis.view.road;

import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import polis.model.TileModel;
import polis.view.tool.Tile;

public class Road extends Tile {
	
	
	// Fields
	protected String img = "road-0";
	protected int CELL_SIZE = 64;
	protected Image image;
	
	public Road(TileModel tileModel, Pane pane) {
		super(tileModel, pane);
		this.setImg("road-0");
	}

	@Override
	public void invalidated(Observable observable) {
		int imgInt = 0;
		for (Tile or : tileModel.getTiles()) {
			System.out.println(or.getR());
			if (or.getR() == this.r) {
				if (or.getK() + 1 == this.k) {
					imgInt += 8;
					System.out.println("ueeet");
				} else if (or.getK() - 1 == this.k) {
					imgInt += 2;
				}
				
			} else if (or.getK() == this.k) {
				if (or.getR() + 1 == this.r) {
					imgInt++;
				} else if (or.getR() - 1 == this.r) {
					imgInt += 4;
				}
			}
		}
		
		this.img = "road-" + imgInt;
		updateRoad();
	}
	
	
	// past wegen aan
	public void updateRoad() {
		image = new Image("file:resources/polis/tiles/" + img + ".png");
		view.setImage(image);
	}
}
