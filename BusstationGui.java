

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BusstationGui extends Application {
	@Override
	public void start(Stage stage) {

		Image im = new Image("bus.png");
		ImageView v = new ImageView(im);
		Text text1 = new Text("    MORAL Company  ");
		text1.setFont(Font.font("georgia", FontWeight.BOLD, 50));

		text1.setFill(Color.BLACK);
		text1.setStrokeWidth(2);
		text1.setStroke(Color.PURPLE);

		Button emp = new Button("EMPLOYEES");
		Button client = new Button("CLIENTS");

		emp.setStyle("-fx-background-color:purple;");
		client.setStyle("-fx-background-color:purple;");
		emp.setFont(Font.font("arial", FontWeight.BOLD, 20));
		emp.setMinSize(100, 100);
		client.setFont(Font.font("arial", FontWeight.BOLD, 20));
		client.setMinSize(100, 100);

		emp.setOnAction(e -> {
			MyEmployees emp1 = new MyEmployees();
			emp1.start1(stage);

		});
		client.setOnAction(e -> {
			Customer c1 = new Customer();
			c1.start(stage);
		});
		VBox v1 = new VBox(20);
		v1.getChildren().addAll(text1, v, emp, client);
		v1.setStyle("-fx-background:black;-fx-border-color:black;");
		v1.setAlignment(Pos.CENTER);

		BorderPane p1 = new BorderPane();

		p1.setCenter(v1);

		Scene scene = new Scene(p1, 700, 600);
		p1.setStyle("-fx-background-image: url('b1.jpg');");
		stage.setTitle("Bus Station");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Manager m1 = new Manager("3811", "3107");
		TripReader.ReadTrips();
		Application.launch(args);

	}

}
