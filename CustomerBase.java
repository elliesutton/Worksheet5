import java.util.ArrayList;

public class CustomerBase {
	
	private ArrayList<CustomerWithGoods> allCustomers;
	

	public CustomerBase(ArrayList<CustomerWithGoods> allCustomers){
		this.allCustomers = allCustomers;
	}
	
	
	
	public void addCustomer(CustomerWithGoods customer){
		allCustomers.add(customer);
	}
	
	
	
	/**
	 * filterLoyal is a method that filters the loyal customers from
	 * all customers. These are the customers that have made over the average 
	 * number of orders.
	 * @return The loyal customers.
	 */
	public ArrayList<CustomerWithGoods> filterLoyal(){
		
		ArrayList<CustomerWithGoods> loyalCustomers = new ArrayList<CustomerWithGoods>();
		double total = 0;
		for (int i=0; i<allCustomers.size(); i++){
			total += (allCustomers.get(i)).getGoods().size();
		}
		
		double avg = total/allCustomers.size();
		
		for (int i=0; i < allCustomers.size(); i++){
			if (allCustomers.get(i).getGoods().size() > avg){
				loyalCustomers.add(allCustomers.get(i));
			}
		}
		
		return loyalCustomers;

	}
	
	
	
	/**
	 * filterValued is a method that filters the valued customers from all
	 * customers. These are the customers that have spent over the average 
	 * amount.
	 * @return The valued customers
	 */
	public ArrayList<CustomerWithGoods> filterValued(){
		
		ArrayList<CustomerWithGoods> valuedCustomers = new ArrayList<CustomerWithGoods>();
		double total = 0;
		for (int i=0; i<allCustomers.size(); i++){
				total += allCustomers.get(i).valueOfGoods();
		}
		
		double avg = total/allCustomers.size();
		
		for (int i=0; i < allCustomers.size(); i++){
			if (allCustomers.get(i).valueOfGoods() > avg){
				valuedCustomers.add(allCustomers.get(i));
			}
		}
		
		return valuedCustomers;
	} 
	
}
