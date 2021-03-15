package polis.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import polis.view.tool.Tile;

import java.util.ArrayList;
import java.util.List;

public class TileModel implements Observable {
	private final List<Tile> tiles = new ArrayList<>();
	private final List<InvalidationListener> listenerList = new ArrayList<>();
	
	
	public void addTile(Tile tile) {
		tiles.add(tile);
	}

	public List<Tile> getTiles() {
		return this.tiles;
	}
	
	public boolean isTileAt(int r, int k) {
		boolean ret = false;
		for (Tile T : this.tiles) {
			if (T.getR() == r && T.getK() == k) {
				ret = true;
			}
		}
		return ret;
	}
	
	public void tilePlaced() {
		fireInvalidationEvent();
	}
	
	private void fireInvalidationEvent() {
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
