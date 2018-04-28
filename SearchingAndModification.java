

import java.util.ArrayList;
import java.util.List;

public interface SearchingAndModification {

	ArrayList searchTripBySourceAndDestination(ArrayList a1, List<Trip> l2,
			String s, String d);

	void EditTripPrice(ArrayList a1, List<Trip> l2, String id, String single,
			String doubl);

	void AddTrip(String t1, ArrayList trip1, List<Trip> l2);

	ArrayList ViewTrips(ArrayList a1, List<Trip> l1);

	ArrayList RemoveTrip(ArrayList a1, List<Trip> l2, String id);

	ArrayList searchTripByDriver(ArrayList tr1, List<Trip> lis, String name);

}
