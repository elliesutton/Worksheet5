import java.util.ArrayList;

public class CustomerWithGoods extends Customer {

	private ArrayList<Good> goods;
	
	/**
	 * CustomerWithGoods constructs a customer with goods
	 * @param customerName The customer's name
	 * @param address The customer's address
	 * @param telephoneNumber The customer's telephone number
	 * @param goods The customer's goods
	 */
	public CustomerWithGoods(String customerName, String address,
                     String telephoneNumber, ArrayList<Good> goods){
		super(customerName, address, telephoneNumber);
		this.goods = goods;
	}
	
	/**
	 * getter for a customer's goods
	 * @return The customer's goods
	 */
	public ArrayList<Good> getGoods() {
		return goods;
	}
	
	/**
	 * Adds a good to a customer's goods list
	 * @param good The good
	 */
	public void buy(Good good){
		goods.add(good);
	}
	
	/**
	 * method valueOfGoods computes the total value of all goods
	 * that the customer has ever bought.
	 * @return The total value of goods
	 */
	public int valueOfGoods(){
		int totalValue = 0;
		for (int i=0; i<goods.size(); i++){
			totalValue += goods.get(i).getPrice();
		}
		return totalValue;
	}
	
	/**
	 * toString method
	 * @return The customer's name, address, telephone number and goods
	 */
	public String toString(){
		return super.toString() + "\nGoods: " + goods;
	}
	
}
