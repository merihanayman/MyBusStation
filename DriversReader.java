
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DriversReader {
	String content = null;

	public static List<Driver> readEmployees() {
		List<Driver> driver = new ArrayList<Driver>();
		try {
			File file = new File("driver.txt");
			FileReader reader = new FileReader(file);
			BufferedReader b1 = new BufferedReader(reader);
			while (b1.ready()) {
				String[] line = b1.readLine().split(",");
				driver.add(new Driver(line[0], line[1], line[2], line[3],
						line[4]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
}