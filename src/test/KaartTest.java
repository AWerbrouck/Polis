package test;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class KaartTest {
    public void DrawKaart(Pane pane, int CELL_SIZE, int size){
        for (int r = 0; r < 32; r++){
            for (int k = 0; k < 32; k++){
                Polygon poly = new Polygon(
                        0, 0,
                        CELL_SIZE * size, 0.5 * CELL_SIZE * size,
                        0, CELL_SIZE * size,
                        -CELL_SIZE * size, 0.5 * CELL_SIZE * size
                );
                int x = CELL_SIZE * (1 - r + k);
                int y = (CELL_SIZE * (r + k)) / 2;
                poly.setTranslateX(x);
                poly.setTranslateY(y);
                poly.setFill(Color.rgb(204, 249, 170));
                poly.setStroke(Color.rgb(160, 230, 160));
                poly.setStrokeType(StrokeType.INSIDE);
                poly.setViewOrder (- r - k - 1.0);
                pane.getChildren().addAll(poly);
            }
        }
    }
}
