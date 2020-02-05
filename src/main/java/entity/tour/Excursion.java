package entity.tour;

import java.math.BigDecimal;

public class Excursion extends Tour {
	
	String city = "";
	
	public Excursion() {
		super();		
	}			

	public Excursion(int id, TypeOfTour type, int amountOfDays, TypeOfTransportation transportation, boolean food,
			BigDecimal price, String city) {
		super(id, type, amountOfDays, transportation, food, price);
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String receiveSpecificInfo() {		
		return String.format("The excursion will be in the %s city.", city);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		Excursion other = (Excursion) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Excursion [city=" + city + ", toString()=" + super.toString() + "]";
	}	

}
