package polis.tools.road;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import polis.tools.CursorBlock;

public class RoadCursorBlock extends CursorBlock {
	protected RoadModel roadModel;
	EventHandler<MouseEvent> PlaceBuilding = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Road r = new Road(roadModel, pane);
			r.PlaceRoad(event);
			
		}
	};
	
	public void setRoadModel(RoadModel roadModel){
		this.roadModel = roadModel;
	}
	
	@Override
	public void addMouseEvent(){
		
		pane.addEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler);
		pane.addEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
		pane.getChildren().addAll(poly);
		
	}
	@Override
	public void removeMouseEvent(){
		pane.removeEventHandler(MouseEvent.MOUSE_MOVED, CursorBlockHandler );
		pane.removeEventHandler(MouseEvent.MOUSE_CLICKED, PlaceBuilding);
		pane.getChildren().remove(poly);
		
	}
}
