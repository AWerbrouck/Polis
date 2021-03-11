package polis.tiles;

import javafx.scene.layout.Pane;

public class TileController {
	public Pane pane;
	public int CELL_SIZE = 64;
	public int size = 1;
	public StreetBuilder sb;
	public ResidenceBuilder rb;
	public TileController(){
		this.sb = new StreetBuilder();
		this.rb = new ResidenceBuilder();
	
	}
	
	public void placeRoad(){
		sb.placeRoad(this.pane);
	}
	
	public void placeRes(){
		rb.placeBlueprint(this.pane);
	}
	
	public void setPane(Pane pane){
		this.pane = pane;
	}
}
