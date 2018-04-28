

public class Trip {
	String tripId;
	String source, destination, type, departualtime, vehicle, flavor,
			captainName, day, places;
	double SinglePrice;
	double RoundPrice;

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartualtime() {
		return departualtime;
	}

	public void setDepartualtime(String departualtime) {
		this.departualtime = departualtime;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public double getSinglePrice() {
		return SinglePrice;
	}

	public void setSinglePrice(double singlePrice) {
		SinglePrice = singlePrice;
	}

	public double getRoundPrice() {
		return RoundPrice;
	}

	public void setRoundPrice(double roundPrice) {
		RoundPrice = roundPrice;
	}

	public Trip(String tripId, String source, String destination, String type,
			String day, String departualtime, String vehicle, String flavor,
			String captainName, String places, double singlePrice,
			double roundPrice) {
		super();
		this.tripId = tripId;
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.departualtime = departualtime;
		this.vehicle = vehicle;
		this.flavor = flavor;
		this.places = places;
		this.day = day;
		this.captainName = captainName;
		this.SinglePrice = singlePrice;
		this.RoundPrice = roundPrice;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

}
