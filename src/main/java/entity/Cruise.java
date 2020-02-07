package entity;

import java.math.BigDecimal;

public class Cruise extends Tour {
	
	private String routeOfCruise;

	public Cruise() {
		super();		
	}	

	public Cruise(int amountOfDays, TypeOfTransportation transportation, boolean food,
			BigDecimal price, String routeOfCruise) {
		super(TypeOfTour.CRUISE, amountOfDays, transportation, food, price);
		this.routeOfCruise = routeOfCruise;
	}

	public String getRouteOfCruise() {
		return routeOfCruise;
	}

	public void setRouteOfCruise(String routeOfCruise) {
		this.routeOfCruise = routeOfCruise;
	}

	@Override
	public String receiveSpecificInfo() {
				
		return String.format("Route of cruise: %s", routeOfCruise);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((routeOfCruise == null) ? 0 : routeOfCruise.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cruise other = (Cruise) obj;
		if (routeOfCruise == null) {
			if (other.routeOfCruise != null)
				return false;
		} else if (!routeOfCruise.equals(other.routeOfCruise))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cruise [routeOfCruise=" + routeOfCruise + ", toString()=" + super.toString() + "]";
	}
	

}
