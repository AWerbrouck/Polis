package test.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import test.mousetesting.MouseTest;

import java.net.URL;
import java.util.ResourceBundle;

public class UIController implements Initializable {
	@FXML
	Button road;
	public boolean placer = false;
	private MouseTest ms;
	
	
	public void placeResidence(){
		if(! placer){
			placer = true;
			ms.addMouseEvent();
		}else{
			System.out.println("A");
			placer = false;
			ms.removeMouseEvent();
		}
		
	}
	
	public void setMouse(MouseTest ms){
		this.ms = ms;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
}
