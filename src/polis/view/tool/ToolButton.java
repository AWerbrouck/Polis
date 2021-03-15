package polis.view.tool;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import polis.model.TileModel;
import polis.model.ToolModel;

public class ToolButton extends Button implements InvalidationListener, EventHandler<ActionEvent> {
	
	protected ToolModel model;
	protected TileModel tileModel;
	protected Pane pane;
	protected boolean active = false;
	protected String img;
	protected int size;
	protected CursorBlock cb;
	
	public ToolButton() {
		setOnAction(this);
		this.cb = new CursorBlock();
		this.tileModel = new TileModel();
		cb.setTileModel(this.tileModel);
	}
	
	
	public ToolModel getModel() {
		return model;
	}
	
	public void setModel(ToolModel model) {
		this.model = model;
		model.addListener(this);
	}
	
	
	/**
	 * Stelt de afbeelding in voor het te plaatsen tile
	 * img van de vorm "type-index"
	 * voorbeeld "road-11"
	 *
	 * @param img
	 */
	public void setImg(String img) {
		this.img = img;
		cb.setImg(img);
	}
	
	public void setSize(int size) {
		this.size = size;
		cb.setSize(size);
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
