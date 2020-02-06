package entity;

import java.math.BigDecimal;

public class Tour{

	protected int id;
	protected TypeOfTour type;	
	protected int amountOfDays;
	protected TypeOfTransportation transportation;
	protected boolean food;
	protected BigDecimal price;
	
	public Tour() {
		super();
	}	
	
	public Tour(int id, TypeOfTour type, int amountOfDays, TypeOfTransportation transportation, boolean food,
			BigDecimal price) {
		super();
		this.id = id;
		this.type = type;
		this.amountOfDays = amountOfDays;
		this.transportation = transportation;
		this.food = food;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		int result = 1;
		result = prime * result + amountOfDays;
		result = prime * result + (food ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transportation == null) ? 0 : transportation.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (amountOfDays != other.amountOfDays)
			return false;
		if (food != other.food)
			return false;
		if (id != other.id)
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
		return "Tour [id=" + id + ", type=" + type + ", amountOfDays=" + amountOfDays + ", transportation="
				+ transportation + ", food=" + food + ", price=" + price + "]";
	}
	
}
