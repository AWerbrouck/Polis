package polis.tools;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class ToolModel implements Observable {
	protected Pane pane;
	protected ToolButton active;
	
	public void setPane(Pane pane){
		this.pane = pane;
	}
	
	public Pane getPane(){
		return this.pane;
	}
	
	/**
	 * sets de actieve ToolButton
	 * en roept fireInvalidationEvent op
	 */
	public void setActive(ToolButton toolButton){
		this.active = toolButton;
		fireInvalidationEvent();
	}
	
	public ToolButton getActive(){
		return this.active;
	}
	
	/**
	 * Lijst van geregistreerde luisteraars.
	 */
	private final List<InvalidationListener> listenerList = new ArrayList<>();
	
	
	/**
	 * Breng alle luisteraars op de hoogte van een verandering van het model.
	 */
	private void fireInvalidationEvent () {
		for (InvalidationListener listener : listenerList) {
			listener.invalidated(this);
		}
	}
	
	@Override
	public void addListener(InvalidationListener listener) {
		listenerList.add(listener);
	}
	
	@Override
	public void removeListener(InvalidationListener listener) {
		listenerList.remove(listener);
	}
	
}