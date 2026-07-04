
import java.util.TreeSet;

class ProductManagement implements Comparable<ProductManagement>{
	private int productId;
	private String productName;
	private String category;
	private String brand;
	private float price;
	private float rating;
	
	
	public ProductManagement(int productId, String productName, String category, String brand, float price,
			float rating) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.rating = rating;
	}

    public int compareTo(ProductManagement p2) {
    	ProductManagement p1 = this;
    	String category1 = p1.category;
    	String category2 = p2.category;
    	
    	if(category1.equals(category2)) {
    		String brand1 = p1.brand;
    		String brand2 = p2.brand;
    		
    		if(brand1.equals(brand2)) {
    			Float price1 = p1.price;
    			Float price2 = p2.price;
    			
    			if(price1.equals(price2)) {
    				String productName1 = p1.productName;
    				String productName2 = p2.productName;
    				
    				if(productName1.equals(productName2)) {
    					Integer productId1 = p1.productId;
    					Integer productId2 = p2.productId;
    					
    					return productId1.compareTo(productId2);
    				}
    				return productName1.compareTo(productName2);
    			}
    			return price1.compareTo(price2);
    		}
    		return brand1.compareTo(brand2);
    	}
    	return category1.compareTo(category2);
    }
	
	@Override
	public String toString() {
		return "ProductManagement [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
}
public class comparable3 {

	public static void main(String[] args) {
		
		TreeSet<ProductManagement> products = new TreeSet<ProductManagement>();
		
		ProductManagement p1 = new ProductManagement(101, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p2 = new ProductManagement(102, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p3 = new ProductManagement(103, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p4 = new ProductManagement(104, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p5 = new ProductManagement(105, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p6 = new ProductManagement(106, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		ProductManagement p7 = new ProductManagement(107, "Chocolate" , "Essentials" , "Nestle" , 454.59f , 3.5f);
		
		products.add(p7);
		products.add(p6);
		products.add(p5);
		products.add(p4);
		products.add(p3);
		products.add(p2);
		products.add(p1);
		
		System.out.println("Product Details after sorting\n");
		
		for(ProductManagement product : products) {
			System.out.println(product);
		}

	}

}
