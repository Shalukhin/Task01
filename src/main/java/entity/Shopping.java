package entity;

import java.math.BigDecimal;

public class Shopping extends Tour {	
	
	private String shop;
	
	public Shopping() {
		super();
	}		

	public Shopping(TypeOfTour type, int amountOfDays, TypeOfTransportation transportation, boolean food,
			BigDecimal price, String shop) {
		super(type, amountOfDays, transportation, food, price);
		this.shop = shop;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String receiveSpecificInfo() {		
		return String.format("Shopping in the store - \"%s\"", shop);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
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
		Shopping other = (Shopping) obj;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shopping [shop=" + shop + ", toString()=" + super.toString() + "]";
	}
	
}
