package by.womework;

import java.util.ArrayList;
import java.util.List;

public class Shelf<T extends Product> {
	private List<T> products;
	
	public Shelf() {
        products = new ArrayList<>();
    }
	
	public void save(T product) {
        products.add(product);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		for (T product : products) {
			builder.append(product.showProduct() + "\n");
		}		
		return builder.toString();
	}

}
