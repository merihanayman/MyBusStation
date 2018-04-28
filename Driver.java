

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Employee {

	public Driver(String id, String password, String name, String veichel,
			String license) {
		super(id, password);
		this.name = name;
		this.license = license;
		this.veichel = veichel;
	}

	public String getVeichel() {
		return veichel;
	}

	public void setVeichel(String veichel) {
		this.veichel = veichel;
	}

	private String name, license, veichel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void start(Stage stage2, String name) {

		List<Trip> lis = TripReader.ReadTrips();
		ArrayList<String> trip1 = new ArrayList<String>();

		Label l2 = new Label("                 Captain  /  " + name);
		l2.setFont(Font.font("georgia", FontWeight.BOLD, 35));
		l2.setMinWidth(200);
		l2.setTextFill(Color.PURPLE);

		Text text1 = new Text("Your Trips");
		text1.setFont(Font.font("georgia", FontWeight.BOLD, 25));
		text1.setStroke(Color.LIGHTPINK);
		text1.setUnderline(true);

		ArrayList<Trip> trips = searchTripByDriver(trip1, lis, name);
		Label l1 = new Label();
		l1.setText("   ");
		for (int i = 0; i < trips.size(); i++) {
			l1.setText(l1.getText() + "\n" + trips.get(i));
		}

		Button b1 = new Button("Back");
		b1.setOnAction(e -> {
			MyEmployees.start1(stage2);
		});
		b1.setAlignment(Pos.TOP_LEFT);

		l1.setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, 20));
		l1.setMinWidth(200);
		l1.setTextFill(Color.YELLOW);

		VBox h1 = new VBox(10);
		h1.getChildren().addAll(l2, text1, l1);

		BorderPane p1 = new BorderPane();
		p1.setCenter(h1);
		p1.setTop(b1);
		p1.setStyle("-fx-background-image: url('b1.jpg');");
		Scene scene = new Scene(p1, 800, 600);
		stage2.setTitle("Driver");
		stage2.setScene(scene);
		stage2.show();

	}

	@Override
	public ArrayList searchTripByDriver(ArrayList trip1, List<Trip> lis,
			String name) {
		int i = 0;
		for (Trip t : lis) {
			if (t.getCaptainName().equals(name)) {
				trip1.add(t.getTripId() + "  " + t.getSource() + "   "
						+ t.getDestination() + "   " + t.getType() + "    "
						+ t.getDepartualtime() + "   " + t.getVehicle() + "  "
						+ t.getFlavor());
				i++;
			}
		}
		// System.out.println(trip1);
		return trip1;
	}

	@Override
	public ArrayList searchTripBySourceAndDestination(ArrayList a1,
			List<Trip> l2, String s, String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EditTripPrice(ArrayList a1, List<Trip> l2, String id,
			String single, String doubl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddTrip(String t1, ArrayList trip1, List<Trip> l2) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList ViewTrips(ArrayList a1, List<Trip> l1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList RemoveTrip(ArrayList a1, List<Trip> l2, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
