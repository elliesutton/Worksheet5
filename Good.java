/**
 * Good is a class that creates a good
 * @author Ellie Sutton
 *
 */
public class Good {
	
	private String name;
	private int price;
	
	/**
	 * Good is a constructor that creates a good
	 * @param name The name of the good
	 * @param price The price of the good
	 */
	public Good(String name, int price){
		this.name = name;
		this.price = price;
	}

	/**
	 * getter for the price of the good
	 * @return The price of the good
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * toString method
	 * @return the name of the good and its price
	 */
	public String toString(){
		return name + ": \u00A3" + price;
	}

}
