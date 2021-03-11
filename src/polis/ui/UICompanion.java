package polis.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import polis.tools.road.RoadButton;
import polis.tools.ToolButton;
import polis.tools.ToolModel;

import java.net.URL;
import java.util.ResourceBundle;

public class UICompanion implements Initializable {
	@FXML
	ToolButton residence;
	@FXML
	ToolButton industry;
	@FXML
	ToolButton commerce;
	@FXML
	RoadButton roadB;
	public ToolModel model;
	
	protected Pane pane;
	
	public void setPane(Pane pane){
		this.pane = pane;
		model.setPane(this.pane);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ToolModel();
		roadB.setModel(model);
		roadB.setImg("road-0");
		residence.setModel(model);
		residence.setImg("residence-0");
		residence.setSize(2);
		industry.setModel(model);
		industry.setImg("industry-0");
		industry.setSize(2);
		commerce.setModel(model);
		commerce.setImg("commerce-0");
		commerce.setSize(2);
	}
	
}
