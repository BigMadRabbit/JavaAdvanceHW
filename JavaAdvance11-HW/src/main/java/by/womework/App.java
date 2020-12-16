package by.womework;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	Shelf<Product> shelf = new Shelf<>();
    	shelf.save(new Product("Book P", 200));
        shelf.save(new WeightProduct("Book WP", 200, 0.5f));
        shelf.save(new WeightColorProduct("Book WCP", 200, 0.5f, "Red"));
        
        System.out.println("shelf:");
        System.out.println(shelf);
    }
}
