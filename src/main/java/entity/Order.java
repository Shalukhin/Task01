package entity;

public class Order extends Entity {
		
	private int clientId;
	private int tourId;
	
	public Order() {
		super();		
	}	

	public Order(int id, int clientId, int tourId) {
		super(id);
		this.clientId = clientId;
		this.tourId = tourId;
	}	

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + clientId;
		result = prime * result + tourId;
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
		Order other = (Order) obj;
		if (clientId != other.clientId)
			return false;
		if (tourId != other.tourId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [clientId=" + clientId + ", tourId=" + tourId + ", toString()=" + super.toString() + "]";
	}	
		
}
