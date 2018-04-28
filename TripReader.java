

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripReader {
	
	
	public static List<Trip> ReadTrips() {
		List<Trip> trip = new ArrayList<Trip>();
		Scanner in;
		File file;
		try {
			file = new File("Trips.txt");
			in = new Scanner(file);
			// FileReader reader = new FileReader(file);
			// BufferedReader b1 = new BufferedReader(reader);
			while (in.hasNext()) {
				String s = in.nextLine();
				String[] line = s.split(",");
				trip.add(new Trip(line[0], line[1], line[2], line[3], line[4],
						line[5], line[6], line[7], line[8], line[9], Double
								.parseDouble(line[10]), Double
								.parseDouble(line[11])));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return trip;
	}
}
