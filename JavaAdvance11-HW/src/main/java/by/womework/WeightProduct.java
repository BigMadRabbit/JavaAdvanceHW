package by.womework;

public class WeightProduct extends Product {
	private float weight;
	
	
	public WeightProduct(String name, float price, float weight) {
		super(name, price);
		this.weight = weight;
	}
	
	public float getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", weight=" + getWeight();
	}

}
