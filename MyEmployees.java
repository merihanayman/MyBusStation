

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyEmployees {
	public static void start1(Stage stage1) {
//		Text t1 = new Text();
//		t1.setX(100);
//		t1.setY(100);
//		t1.setText("Enter your ID and Password ,please");

		TextField t2 = new TextField();
		t2.setPromptText("YOUR ID");

		PasswordField t3 = new PasswordField();
		t3.setPromptText("YOUR PASSWORD");

		Label lab1 = new Label();
		lab1.setTextFill(Color.RED);
		lab1.setStyle("-fx-background:transparent;");

		CheckBox cb1 = new CheckBox();
		cb1.setText("MANAGER");
		cb1.setStyle("-fx-border-color: lightblue; " + "-fx-font-size: 20;"
				+ "-fx-border-insets: -5; " + "-fx-border-radius: 5;"
				+ "-fx-border-style: dotted;" + "-fx-border-width: 2;");

		CheckBox cb2 = new CheckBox();
		cb2.setText("DRIVER");
		cb2.setStyle("-fx-border-color: lightblue; " + "-fx-font-size: 20;"
				+ "-fx-border-insets: -5; " + "-fx-border-radius: 5;"
				+ "-fx-border-style: dotted;" + "-fx-border-width: 2;");

		cb1.selectedProperty().addListener(e -> {
			if (cb2.isSelected()) {
				cb2.setSelected(false);
			}
		});

		cb2.selectedProperty().addListener(e -> {

			if (cb1.isSelected()) {
				cb1.setSelected(false);
			}
		});
		Button back = new Button("Back");
		back.setOnAction(e -> {
			BusstationGui bs1 = new BusstationGui();
			bs1.start(stage1);
		});

		Button b1 = new Button("ENTER");

		b1.setOnAction(e -> {
			if (cb2.isSelected()) {
				List<Driver> l1 = DriversReader.readEmployees();
				for (Driver d : l1)
					if (d.getId().equals(t2.getText())
							&& d.getPassword().equals(t3.getText()))
						d.start(stage1, d.getName());
				
				
			} else if (cb1.isSelected()) {
				Manager m1 = new Manager("3811", "3107");
				if (m1.getId().equals(t2.getText())
						&& m1.getPassword().equals(t3.getText()))
					m1.start(stage1);
			}
			

			lab1.setText("Enter your Password and ID again");

			lab1.setFont(Font.font("Cambria", FontWeight.BOLD, 32));

		});

		b1.setAlignment(Pos.CENTER_RIGHT);
		HBox h1 = new HBox(30);
		h1.getChildren().addAll(t2, t3);
		h1.setAlignment(Pos.CENTER);

		VBox v1 = new VBox(30);
		v1.getChildren().addAll(h1, cb1, cb2, b1, lab1);
		v1.setAlignment(Pos.CENTER);

		BorderPane p1 = new BorderPane();
		p1.setTop(back);
		p1.setCenter(v1);
		// p1.setStyle("-fx-background:grey;");
		p1.setStyle("-fx-background-image: url('b1.jpg');");
		Scene scene = new Scene(p1, 700, 600);
		stage1.setTitle("Bus Station");
		stage1.setScene(scene);
		stage1.show();

	}

}
