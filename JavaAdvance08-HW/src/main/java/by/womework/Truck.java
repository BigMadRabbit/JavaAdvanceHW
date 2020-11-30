package by.womework;

public class Truck {
	private int maxCapacity;
	private int currCapacity;
	private String currOvner;

	public Truck( int maxCapacity) {
		this.currCapacity = 0;
		this.maxCapacity = maxCapacity;
	}
	
	public String getCurrOvner() {
		return currOvner;
	}

	public void setCurrOvner(String currOvner) {
		this.currOvner = currOvner;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int getCurrCapacity() {
		return currCapacity;
	}
	
	public int getCapacity(int capacity) {
		capacity = getCurrCapacity() > capacity ? capacity : Math.min(capacity, currCapacity);
		currCapacity = currCapacity - capacity;		
		return currCapacity;
	}
	
	public int putCapacity(int capacity) {
		capacity = getCurrCapacity() + capacity > getMaxCapacity() - getCurrCapacity() ? capacity : capacity;
		currCapacity = this.currCapacity + capacity;		
   	    return currCapacity;
	}
	
	public boolean isEmpty() {
		return currCapacity == 0 ? true : false;
	}
	
	public boolean isFull() {
		return currCapacity == maxCapacity ? true : false;
	}
	
	@Override
	public String toString() {
		return currOvner + " : " + currCapacity + " / " + maxCapacity;
	}
}
