import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Circle circle=new Circle(100, 100, 50);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);

        Button button=new Button("Play");
        button.setTranslateX(125);
        button.setTranslateY(200);

        Button button1=new Button("Pause");
        button1.setTranslateX(175);
        button1.setTranslateY(200);

        TranslateTransition transition=new TranslateTransition();
        transition.setAutoReverse(true);
        transition.setByX(200);
        transition.setCycleCount(100);
        transition.setDuration(Duration.millis(500));
        transition.setNode(circle);

        //Event Handling
        EventHandler<MouseEvent>handler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSource()==button)
                {
                    transition.play();
                }
                if (mouseEvent.getSource()==button1)
                {
                    transition.pause();
                }
                mouseEvent.consume();
            }
        };
        button.setOnMouseClicked(handler);
        button1.setOnMouseClicked(handler);
        Group group=new Group();
        group.getChildren().addAll(circle,button,button1);
        Scene scene=new Scene(group,420,320,Color.WHEAT);
        stage.setScene(scene);
        stage.setTitle("Event Handling");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}