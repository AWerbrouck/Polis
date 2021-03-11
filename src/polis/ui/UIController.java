package polis.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import polis.tiles.TileController;

import java.net.URL;
import java.util.ResourceBundle;

public class UIController implements Initializable {
	@FXML
	Button road;
	public TileController tl;
	
	public void placeRoad(){
		tl.placeRoad();
	}
	
	public void placeResidence(){
		tl.placeRes();
	}
	
	
	
	public void setTilePane(TileController tl){
		this.tl = tl;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
}
