package polis;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Kaart {
    public void DrawKaart(Pane pane, int CELL_SIZE, int size){
        for (int r = 5; r < 32 -5 ; r++){
            for (int k = 5; k < 32 -5 ; k++){
                Polygon poly = new Polygon(
                        0, 0,
                        CELL_SIZE * size, 0.5 * CELL_SIZE * size,
                        0, CELL_SIZE * size,
                        -CELL_SIZE * size, 0.5 * CELL_SIZE * size
                );
                int x = CELL_SIZE * (size - r + k);
                int y = (CELL_SIZE * (r + k)) / 2;
                poly.setTranslateX(x);
                poly.setTranslateY(y);
                poly.setFill(Color.rgb(204, 249, 170));
                poly.setStroke(Color.TRANSPARENT);
                onSelected(poly);
                poly.setViewOrder (- r - k - 1.0); // voor een 1 x 1 tegel.setViewOrder (- row - column - 1.0) // voor een 1 x 1 tegel
                pane.getChildren().addAll(poly);
            }
        }
    }
    
    public void onSelected(Polygon poly){
        poly.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
//                poly.setStroke(Color.rgb(255,255,255,0.75));
                poly.setStroke(Color.RED);
//                poly.setStrokeWidth(5);
            }
        });
    
        poly.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                poly.setStroke(Color.rgb(204, 249, 170));
            }
        });
        
        poly.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if(poly.getFill() == Color.BLACK){
                    poly.setFill(Color.rgb(204, 249, 170));
                }else {
                    poly.setFill(Color.BLACK);
                }
            }
        });
    }
}
