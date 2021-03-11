package polis.tools.road;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public class RoadModel implements Observable {
	
	private final List<Road> roads = new ArrayList<>();
	
	public void addRoad(Road road){
	}
	
	
	
	private final List<InvalidationListener> listenerList = new ArrayList<>();
	public void roadNot(){
		fireInvalidationEvent();
	}
	
	/**
	 * Breng alle luisteraars op de hoogte van een verandering van het model.
	 */
	private void fireInvalidationEvent () {
		for (InvalidationListener listener : listenerList) {
			listener.invalidated(this);
		}
	}
	@Override
	public void addListener(InvalidationListener invalidationListener) {
		listenerList.add(invalidationListener);
	}
	
	@Override
	public void removeListener(InvalidationListener invalidationListener) {
		listenerList.remove(invalidationListener);
	}
}
