package entity.tour;

import java.math.BigDecimal;

import entity.Entity;

public class Tour extends Entity {

	private TypeOfTour type;
	
	private int amountOfDays;
	private TypeOfTransportation transportation;
	private boolean food;
	private BigDecimal price;
	
	public Tour() {
		super();
	}	
	
	public Tour(int id, TypeOfTour type, int amountOfDays, TypeOfTransportation transportation, boolean food,
			BigDecimal price) {
		super(id);
		this.type = type;
		this.amountOfDays = amountOfDays;
		this.transportation = transportation;
		this.food = food;
		this.price = price;
	}

	public TypeOfTour getType() {
		return type;
	}


	public void setType(TypeOfTour type) {
		this.type = type;
	}

	public int getAmountOfDays() {
		return amountOfDays;
	}


	public void setAmountOfDays(int amountOfDays) {
		this.amountOfDays = amountOfDays;
	}


	public TypeOfTransportation getTransportation() {
		return transportation;
	}


	public void setTransportation(TypeOfTransportation transportation) {
		this.transportation = transportation;
	}


	public boolean isFood() {
		return food;
	}


	public void setFood(boolean food) {
		this.food = food;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String receiveSpecificInfo() {
		return "No specific info";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + amountOfDays;
		result = prime * result + (food ? 1231 : 1237);
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transportation == null) ? 0 : transportation.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Tour other = (Tour) obj;
		if (amountOfDays != other.amountOfDays)
			return false;
		if (food != other.food)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (transportation != other.transportation)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tour [type=" + type + ", amountOfDays=" + amountOfDays + ", transportation=" + transportation
				+ ", food=" + food + ", price=" + price + ", toString()=" + super.toString() + "]";
	}	

}
