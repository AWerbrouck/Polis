package polis;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class GebruikersInterface {
    private Image residenceImage = new Image("file:resources/polis/buttons/residence.png");
    private ImageView residenceView = new ImageView(residenceImage);
    public GridPane DrawInterface(GridPane grid){
        residenceView.setFitHeight(80);
        residenceView.setPreserveRatio(true);
        Button button = new Button();
        button.setLayoutX(32);
        button.setLayoutY(32);
        button.setPrefSize(80, 80);
        button.setGraphic(residenceView);
        grid.getChildren().add(button);
        return grid;
    }
}
