

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

public class Manager extends Employee {

	public Manager(String id, String password) {
		super(id, password);

	}

	public void start(Stage stage2) {

		Text text1 = new Text("    MORAL Company  ");
		text1.setFont(Font.font("georgia", FontWeight.BOLD, 50));

		text1.setFill(Color.BLACK);
		text1.setStrokeWidth(2);
		text1.setStroke(Color.PURPLE);
		Button b1 = new Button("Back");
		b1.setOnAction(e -> {
			MyEmployees.start1(stage2);
		});

		b1.setAlignment(Pos.TOP_LEFT);
		b1.setFont(Font.font("arial", FontWeight.BOLD, 15));

		Text text2 = new Text("show");
		text2.setFill(Color.LIGHTPINK);
		text2.setFont(Font.font("verdana", FontWeight.BOLD, 20));
		text2.setUnderline(true);

		Button alltrips = new Button(" all Trips");
		ButtonsEdit(alltrips);
		Button alldrivers = new Button(" all Drivers");
		ButtonsEdit(alldrivers);
		Button allvehicles = new Button(" all Vecihles");
		ButtonsEdit(allvehicles);

		Button add = new Button(" ADD trip");
		ButtonsEdit(add);
		Button remove = new Button(" Remove Trip");
		ButtonsEdit(remove);
		Button edit = new Button(" Edit Trip");
		ButtonsEdit(edit);
		Button searchbydriver = new Button("Search by driver");
		ButtonsEdit(searchbydriver);
		Button searchbyplaces = new Button("Search by source and destination ");
		ButtonsEdit(searchbyplaces);
		Button okay = new Button("Okay ");
		ButtonsEdit(okay);

		List<Trip> list1 = TripReader.ReadTrips();
		ArrayList<String> trip1 = new ArrayList<String>();

		Label showtrip = new Label();
		showtrip.setTextFill(Color.LIGHTPINK);
		showtrip.setStyle("-fx-background:transparent;");

		TextField del = new TextField();
		del.setPromptText("trip ID");
		TextField dr = new TextField();
		TextField sour = new TextField();
		TextField des = new TextField();
		TextField addformat = new TextField();

		Text addtext = new Text();
		Text textstyle = new Text();
		addtext.setFill(Color.LIGHTPINK);
		addtext.setFont(Font.font("verdana", FontWeight.BOLD, 15));

		Text addingdone = new Text();
		addingdone.setFill(Color.PURPLE);
		addingdone.setFont(Font.font("verdana", FontWeight.BOLD, 15));

		textstyle.setFill(Color.BLACK);
		textstyle.setFont(Font.font("verdana", FontWeight.BOLD, 10));
		textstyle.setUnderline(true);

		alltrips.setOnAction(e -> {
			addtext.setText("");
			textstyle.setText("");
			trip1.clear();
			ArrayList<Trip> trips = ViewTrips(trip1, list1);
			showtrip.setText(" MORAL's Trip : \n ");
			showtrip.setFont(Font.font("Cambria", FontWeight.BOLD, 12));
			for (int i = 0; i < trips.size(); i++) {
				showtrip.setText(showtrip.getText() + "\n" + trips.get(i));
			}
		});
		alldrivers.setOnAction(e -> {
			addtext.setText("");
			textstyle.setText("");
			List<Driver> driver = DriversReader.readEmployees();
			showtrip.setText(" MORAL's Driver : \n  ");
			for (Driver d : driver) {
				String s = d.getName();
				showtrip.setText(showtrip.getText() + "\n" + s);
			}
		});

		allvehicles.setOnAction(e -> {
			addtext.setText("");
			textstyle.setText("");
			List<Driver> driver = DriversReader.readEmployees();
			showtrip.setText(" MORAL's Vehicle : \n  ");
			for (Driver d : driver) {
				String s = d.getVeichel();
				showtrip.setText(showtrip.getText() + "\n" + s);
			}
		});

		remove.setOnAction(e -> {
			ArrayList<Trip> trips = RemoveTrip(trip1, list1, del.getText());
		});

		add.setOnAction(e -> {
			addtext.setText(" Enter the information of the trip you want to add below in SMALL letters ");
			textstyle
					.setText("Like this way :  TripId),Source,Destination,internal OR external,day,Hr:00,Vehicle,no-stops OR many-stops OR one-stop,captain name,available places,Single price,Round price");
		});
		okay.setOnAction(e -> {
			AddTrip(addformat.getText(), trip1, list1);
			addingdone.setText("DONE: The Trip is added to the System");
		});

		searchbydriver.setOnAction(e -> {
			addtext.setText("");
			textstyle.setText("");
			trip1.clear();
			ArrayList<Trip> trips = searchTripByDriver(trip1, list1,
					dr.getText());
			showtrip.setText("   Trips of  " + dr.getText() + ": \n  ");
			showtrip.setFont(Font.font("Cambria", FontWeight.BOLD, 12));
			for (int i = 0; i < trips.size(); i++) {
				showtrip.setText(showtrip.getText() + "\n" + trips.get(i));
			}
		});

		searchbyplaces.setOnAction(e -> {
			addtext.setText("");
			textstyle.setText("");
			trip1.clear();
			ArrayList<Trip> trips = searchTripBySourceAndDestination(trip1,
					list1, sour.getText(), des.getText());
			showtrip.setText("   Trips from   " + sour.getText() + "  to  "
					+ des.getText() + ": \n  ");
			showtrip.setFont(Font.font("Cambria", FontWeight.BOLD, 12));
			for (int i = 0; i < trips.size(); i++) {
				showtrip.setText(showtrip.getText() + "\n" + trips.get(i));
			}
		});

		HBox h1 = new HBox(80);
		h1.getChildren().addAll(b1, text1);
		h1.setAlignment(Pos.TOP_LEFT);
		HBox h2 = new HBox(20);
		h2.getChildren().addAll(text2, alltrips, alldrivers, allvehicles);
		HBox h3 = new HBox(20);
		h3.getChildren().addAll(remove, del);
		HBox h4 = new HBox(10);
		h4.getChildren().addAll(searchbydriver, dr);
		HBox h5 = new HBox(10);
		h5.getChildren().addAll(searchbyplaces, sour, des);
		HBox h6 = new HBox(20);
		h6.getChildren().addAll(showtrip);

		// HBox h7 = new HBox(20);
		// h7.getChildren().addAll(addformat, okay);

		// VBox adding = new VBox(20);
		// adding.getChildren().addAll(add, addtext, textstyle, h7);

		VBox v2 = new VBox(20);
		v2.getChildren().addAll(h2, h4, h5, h3, h6);
		// v2.setAlignment(Pos.CENTER);

		BorderPane p1 = new BorderPane();
		p1.setTop(h1);
		p1.setCenter(v2);
		p1.setStyle("-fx-background-image: url('b1.jpg');");
		Scene scene = new Scene(p1, 1000, 700);
		stage2.setTitle("Driver");
		stage2.setScene(scene);
		stage2.show();

	}

	public void ButtonsEdit(Button bt) {
		bt.setStyle("-fx-background-color:lightgrey;");
		bt.setTextFill(Color.PURPLE);
		bt.setFont(Font.font("arial", FontWeight.BOLD, 20));

	}

	@Override
	public ArrayList ViewTrips(ArrayList trip1, List<Trip> l2) {

		for (Trip t : l2) {

			trip1.add(t.getTripId() + "       From:  " + t.getSource()
					+ "  to: " + t.getDestination() + "         " + t.getType()
					+ "      \t time :   " + t.getDay() + "          At :   "
					+ t.getDepartualtime() + "            " + t.getVehicle()
					+ "          " + t.getFlavor() + "\t    captain/  "
					+ t.getCaptainName() + " \t          single price : "
					+ Double.toString(t.getSinglePrice())
					+ " LE   \t   Round price: "
					+ Double.toString(t.getRoundPrice()) + " LE");
		}

		return trip1;
	}

	@Override
	public ArrayList searchTripBySourceAndDestination(ArrayList trip1,
			List<Trip> l2, String s, String d) {
		int i = 0;
		for (Trip t : l2) {
			if (t.getSource().equals(s) && t.getDestination().equals(d)) {
				trip1.add(t.getTripId() + "      " + t.getType()
						+ "      \t time :   " + t.getDay()
						+ "          At :   " + t.getDepartualtime()
						+ "            " + t.getVehicle() + "          "
						+ t.getFlavor() + "\t    captain/  "
						+ t.getCaptainName() + " \t          single price : "
						+ Double.toString(t.getSinglePrice())
						+ " LE   \t   Round price: "
						+ Double.toString(t.getRoundPrice()) + " LE");
			}
		}
		return trip1;
	}

	@Override
	public ArrayList searchTripByDriver(ArrayList trip1, List<Trip> l2,
			String name) {
		int i = 0;
		for (Trip t : l2) {
			if (t.getCaptainName().equals(name)) {
				trip1.add(t.getTripId() + "       From:  " + t.getSource()
						+ "  to: " + t.getDestination() + "         "
						+ t.getType() + "      \t time :   " + t.getDay()
						+ "          At :   " + t.getDepartualtime()
						+ "            " + t.getVehicle() + "          "
						+ t.getFlavor() + "       \t          single price : "
						+ Double.toString(t.getSinglePrice())
						+ " LE   \t   Round price: "
						+ Double.toString(t.getRoundPrice()) + " LE");
			}
		}
		return trip1;
	}

	@Override
	public ArrayList RemoveTrip(ArrayList trip1, List<Trip> l2, String id) {
		int x = Integer.parseInt(id);
		//System.out.println(trip1.get(x - 1));
		trip1.remove(x - 1);
		l2.remove(x - 1);
		EditFile(trip1, l2);
		return trip1;
	}

	@Override
	public void AddTrip(String t1, ArrayList trip1, List<Trip> l2) {

		String[] line = t1.split(",");
		 trip1.add(new Trip(line[0], line[1], line[2], line[3], line[4],
		 line[5], line[6], line[7], line[8], line[9], Double
		 .parseDouble(line[10]), Double.parseDouble(line[11])));
		 
//		trip1.add(new Trip("8)", "Alexandria", "Cairo", "internal", "saturday",
//				"13:00", "minibus", "no-stops", "Wael Hassan", "7", 100, 150));
		EditFile(trip1, l2);
	}

	@Override
	public void EditTripPrice(ArrayList a1, List l2, String id, String single,
			String doubl) {
		// TODO Auto-generated method stub

	}
}