package by.womework;

public class WeightColorProduct extends WeightProduct {
	private String color;

	public WeightColorProduct(String name, float price, float weight, String color) {
		super(name, price, weight);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return super.toString() + ", color="+getColor();
	}
	
}
