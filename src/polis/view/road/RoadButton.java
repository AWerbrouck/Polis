package polis.view.road;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import polis.model.TileModel;
import polis.view.tool.ToolButton;

public class RoadButton extends ToolButton {
	
	public RoadButton(){
		
			setOnAction(this);
			super.cb = new RoadCursorBlock();
			this.tileModel = new TileModel();
			cb.setTileModel(this.tileModel);
		
	}
	@Override
	public void invalidated(Observable o) {
		if (model.getActive() != this) {
			if (active) {
				active = false;
				cb.removeMouseEvent();
			}
		}
	}
	
	@Override
	public void handle(ActionEvent t) {
		active = !active;
		model.setActive(this);
		this.pane = model.getPane();
		cb.setPane(this.pane);
		cb.addMouseEvent();
	}
}
