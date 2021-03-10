package polis.controls;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MouseController {


		public void createMonitoredLabel(final Label reporter, Pane pane) {
			
			

			pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					String msg =
							"(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
									"(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
									"(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";
					
					System.out.println(msg);
				}
			});

			pane.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent event) {
					reporter.setText("OUTSIDE_TEXT");
				}
			});
		}
}
