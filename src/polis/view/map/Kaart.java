package polis.view.map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import polis.util.NodeFactory;

public class Kaart {
	public void DrawKaart(Pane pane, int CELL_SIZE, int size) {
		for (int r = -16; r < 16; r++) {
			for (int k = -16 ; k < 16; k++) {
				Polygon poly = NodeFactory.makePoly(r, k);
				if(r == 0 && k == 0){
					poly.setFill(Color.RED);
				}
				pane.getChildren().addAll(poly);
			}
		}
		
	}
}
