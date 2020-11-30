package by.womework;

public class Heap {
	private int quantity;
	
	public Heap(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;  
	}
	
	public void getCapacity(int capacity) {
		capacity = this.quantity > capacity ? capacity : Math.min(capacity, this.quantity);
		this.quantity = this.quantity - capacity;		
	}
	
	
	public boolean isEmpty() {
		return this.quantity > 0 ? false : true;
	}
	
	@Override
	public String toString() {
		return "Heep: "+this.quantity;
	}

}
