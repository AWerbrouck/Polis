package polis.tools;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ToolButton extends Button implements InvalidationListener, EventHandler<ActionEvent> {
	
	protected ToolModel model;
	protected ToolCursor tc;
	protected Pane pane;
	protected boolean active = false;
	protected String img;
	protected int size;
	
	public ToolButton() {
		setOnAction(this);
		this.tc = new ToolCursor();
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
	 * @param img
	 */
	public void setImg(String img){
		System.out.println(img);
		this.img = img;
		tc.setImg(img);
	}
	public  void setSize(int size){
		this.size = size;
		tc.setSize(size);
	}
	
	@Override
	public void invalidated(Observable o) {
		if(model.getActive() != this){
			if(active){
				active = false;
				tc.addCursorBlock();
			}
		}
	}
	
	@Override
	public void handle(ActionEvent t) {
		active = ! active;
		model.setActive(this);
		this.pane = model.getPane();
		tc.setPane(this.pane);
		tc.addCursorBlock();
	}
}
