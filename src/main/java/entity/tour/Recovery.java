package entity.tour;

import java.math.BigDecimal;

public class Recovery extends Tour {
	
	private String illness = "";

	public Recovery() {
		super();
	}	
		
	public Recovery(TypeOfTour type, int id, int amountOfDays, TypeOfTransportation transportation, boolean food, BigDecimal price,
			String illness) {
		super(type, id, amountOfDays, transportation, food, price);
		this.illness = illness;
	}	
	
	@Override
	public String receiveSpecificInfo() {		
		return String.format("This tour is recommended for illness \"%s\"", illness);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((illness == null) ? 0 : illness.hashCode());
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
		Recovery other = (Recovery) obj;
		if (illness == null) {
			if (other.illness != null)
				return false;
		} else if (!illness.equals(other.illness))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recovery [illness=" + illness + ", toString()=" + super.toString() + "]";
	}	
}
