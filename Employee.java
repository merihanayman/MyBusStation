

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements SearchingAndModification {
	private String Id, Password;

	public Employee(String id, String password) {
		super();
		Id = id;
		Password = password;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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