
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Customer {
	public void start(Stage stage2) {
		List<Trip> list1 = TripReader.ReadTrips();
		ArrayList<String> trip1 = new ArrayList<String>();

		Text text1 = new Text(" Welcome to MORAL Company \n \n ");

		text1.setFont(Font.font("georgia", FontWeight.BOLD, 50));

		text1.setFill(Color.BLACK);
		text1.setStrokeWidth(2);
		text1.setStroke(Color.PURPLE);
		Button back = new Button("Back");
		back.setOnAction(e -> {
			BusstationGui g1 = new BusstationGui();
			g1.start(stage2);
		});

		Text text2 = new Text("    The Destinaton of the trip , please   ");
		text2.setFont(Font.font("verdana", FontWeight.BOLD, 25));
		text2.setUnderline(true);
		text2.setFill(Color.LIGHTPINK);

		Label showtrip = new Label();
		showtrip.setTextFill(Color.LIGHTYELLOW);
		showtrip.setFont(Font.font("Cambria", FontWeight.BOLD, 12));

		showtrip.setStyle("-fx-background:transparent;");

		TextField des = new TextField();
		des.setPromptText("Destination");
		des.setStyle("-fx-background:transparent;");

		TextField ID = new TextField();
		ID.setStyle("-fx-background:transparent;");
		TextField type = new TextField();
		type.setStyle("-fx-background:transparent;");

		Text text3 = new Text();
		text3.setStyle("-fx-background:transparent;");
		text3.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		Text text4 = new Text();
		text4.setStyle("-fx-background:transparent;");
		text4.setFont(Font.font("verdana", FontWeight.BOLD, 25));

		Button b1 = new Button("Enter");

		Button b2 = new Button("Save");
		b2.setAlignment(Pos.BOTTOM_RIGHT);

		b2.setOnAction(e -> {
			EditPlaces(ID.getText(), trip1, list1);
			EditFile(trip1, list1);
			text4.setText("    Your Trip is Booked , Thanks ..  ");
			text4.setFill(Color.YELLOW);
		});

		b1.setOnAction(e -> {

			ArrayList<Trip> trips = ViewTrips(trip1, list1, des.getText());
			showtrip.setText(" VAILD Trip : \n ");
			for (int i = 0; i < trips.size(); i++) {
				showtrip.setText(showtrip.getText() + "\n" + trips.get(i));
			}
			text3.setText("    Please Enter the ID of the Trip you want to book  ");
			text3.setUnderline(true);
			text3.setFill(Color.LIGHTPINK);
			ID.setPromptText("Trip ID");
			type.setPromptText(" Single or Round  ");

		});

		HBox h1 = new HBox(20);
		h1.getChildren().addAll(back, text1);
		HBox h2 = new HBox(20);
		h2.getChildren().addAll(des, b1);
		HBox h3 = new HBox(20);
		h3.getChildren().addAll(ID, type);
		HBox h4 = new HBox(20);
		h4.getChildren().addAll(b2, text4);
		VBox v1 = new VBox(20);
		v1.getChildren().addAll(text2, h2, showtrip, text3, h3, h4);

		BorderPane p1 = new BorderPane();
		p1.setTop(h1);
		p1.setCenter(v1);
		p1.setStyle("-fx-background-image: url('b1.jpg');");
		Scene scene = new Scene(p1, 1000, 650);
		stage2.setTitle("Driver");
		stage2.setScene(scene);
		stage2.show();

	}

	public ArrayList ViewTrips(ArrayList trip1, List<Trip> l2, String des) {

		for (Trip t : l2) {
			if (t.getDestination().equals(des)) {

				trip1.add(t.getTripId() + "       From:  " + t.getSource()
						+ "         " + t.getType() + "      \t time :   "
						+ t.getDay() + "          At :   "
						+ t.getDepartualtime() + "            "
						+ t.getVehicle() + "          " + t.getFlavor()
						+ "\t    captain/  " + t.getCaptainName()
						+ " \t          single price : "
						+ Double.toString(t.getSinglePrice())
						+ " LE   \t   Round price: "
						+ Double.toString(t.getRoundPrice()) + " LE");
			}

		}
		return trip1;
	}

	public void EditPlaces(String id, ArrayList trip1, List<Trip> l2)

	{
		id = id + ")";
		for (Trip t : l2) {
			if (t.getTripId().equals(id)) {
			
				int x = Integer.parseInt(t.getPlaces());
				x = x - 1;
				String y = Integer.toString(x);

				t.setPlaces(y);
			}
		}

	}

	public void EditFile(ArrayList trip1, List<Trip> l2) {
		try {
			File f = new File("Trips.txt");
			FileWriter f1 = new FileWriter(f, false);
			BufferedWriter b1 = new BufferedWriter(f1);
			String s;
			for (Trip t : l2) {
				s = t.getTripId() + "," + t.getSource() + ","
						+ t.getDestination() + "," + t.getType() + ","
						+ t.getDay() + "," + t.getDepartualtime() + ","
						+ t.getVehicle() + "," + t.getFlavor() + ","
						+ t.getCaptainName() + "," + t.getPlaces() + ","
						+ t.getSinglePrice() + "," + t.getRoundPrice();
				b1.write(s);
				b1.newLine();
			}

			b1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
