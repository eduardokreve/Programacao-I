
public class ProductReview extends Post implements Evaluable {
	private String brand;
	private int stars;
	
	//métodos get e set
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getStars() {
		return stars;
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public void evaluate(int value) { //pertence a classe Evaluable
		setStars(value);
		
	}

	@Override
	public void show() {
		super.show();
		System.out.println("Estrelas: " +stars+ "\nMarca do produto: " +brand);	
	}
}











