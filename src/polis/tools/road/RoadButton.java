package polis.tools.road;

import javafx.event.ActionEvent;
import polis.tools.ToolButton;

public class RoadButton extends ToolButton {
	protected RoadModel roadModel;
	protected  RoadCursorBlock rcb;
	
	public RoadButton() {
		setOnAction(this);
		this.roadModel = new RoadModel();
		this.rcb = new RoadCursorBlock();
		rcb.setRoadModel(roadModel);
		
	}
	
	
	@Override
	public  void setSize(int size){
		this.size = size;
		rcb.setSize(size);
	}
	
	
	@Override
	public void handle(ActionEvent t) {
		active = ! active;
		model.setActive(this);
		this.pane = model.getPane();
		rcb.setPane(this.pane);
		addCursorBlock();
	}
	public void addCursorBlock(){
		if(active){
			rcb.addMouseEvent();
		}else{
			rcb.removeMouseEvent();
		}
	}
}
