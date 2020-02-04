package entity.tour;

import java.math.BigDecimal;

import util.TypeOfTour;

public class Relaxation extends Tour {
	
	private String country = "";

	public Relaxation() {
		super();
	}	

	public Relaxation(TypeOfTour type, int id, int amountOfDays, String transportation, boolean food, BigDecimal price,
			String country) {
		super(type, id, amountOfDays, transportation, food, price);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String receiveSpecificInfo() {		
		return String.format("Сountry of rest - %s", country);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		Relaxation other = (Relaxation) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Relaxation [country=" + country + ", toString()=" + super.toString() + "]";
	}
	
}
