package polis.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.Pane;
import polis.view.tool.ToolButton;

import java.util.ArrayList;
import java.util.List;

public class ToolModel implements Observable {
	/**
	 * Lijst van geregistreerde luisteraars.
	 */
	private final List<InvalidationListener> listenerList = new ArrayList<>();
	protected Pane pane;
	protected ToolButton active;
	

	
	
	public Pane getPane() {
		return this.pane;
	}
	
	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	public ToolButton getActive() {
		return this.active;
	}
	
	/**
	 * sets de actieve ToolButton
	 * en roept fireInvalidationEvent op
	 */
	public void setActive(ToolButton toolButton) {
		this.active = toolButton;
		fireInvalidationEvent();
	}
	
	/**
	 * Breng alle luisteraars op de hoogte van een verandering van het model.
	 */
	private void fireInvalidationEvent() {
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