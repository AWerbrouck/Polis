package polis.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import polis.model.ToolModel;
import polis.view.bulldozer.BulldozerButton;
import polis.view.road.RoadButton;
import polis.view.selection.SelectionButton;
import polis.view.tool.ToolButton;

import java.net.URL;
import java.util.ResourceBundle;

public class UICompanion implements Initializable {
	public ToolModel model;
	protected Pane pane;
	@FXML
	ToolButton residence;
	@FXML
	ToolButton industry;
	@FXML
	ToolButton commerce;
	@FXML
	RoadButton roadB;
	@FXML
	BulldozerButton bulldozer;
	@FXML
	SelectionButton selection;
	
	public void setPane(Pane pane) {
		this.pane = pane;
		model.setPane(this.pane);
		selection.setPane(pane);
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
		bulldozer.setModel(model);
		
	}
	
}
