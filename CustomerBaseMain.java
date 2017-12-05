import java.util.ArrayList;
import java.util.Arrays;

public class CustomerBaseMain {
	
	public static void main(String[] args){
		
		//create goods
		Good g1 = new Good("Axe", 1);
		Good g2 = new Good("Ball", 2);
		Good g3 = new Good("Cat", 3);
		Good g4 = new Good("Dragon", 4);
		Good g5 = new Good("Elf", 5);
		Good g6 = new Good("Ferret", 6);
		Good g7 = new Good("Glitter", 7);
		Good g8 = new Good("House", 8);
		Good g9 = new Good("Ink", 15);
		Good g10 = new Good("Jacket", 15);
		
		//create array lists for goods
		ArrayList<Good> goodsList1 = new ArrayList<Good>
			(Arrays.asList(g1, g2, g3, g4, g5));
		
		ArrayList<Good> goodsList2 = new ArrayList<Good>
			(Arrays.asList(g6, g7, g8));
		
		ArrayList<Good> goodsList3 = new ArrayList<Good>
			(Arrays.asList(g8, g9, g10));
	
		ArrayList<Good> goodsList4 = new ArrayList<Good>
			(Arrays.asList(g2, g4, g6, g8));
		
		
		//create customer with goods objects
		CustomerWithGoods customer1 = new CustomerWithGoods("Arya", 
				"45 Lottie road", "07777777777", goodsList1);
		CustomerWithGoods customer2 = new CustomerWithGoods("Ben",
				"1 Ashford Avenue", "07888888888", goodsList2);
		CustomerWithGoods customer3 = new CustomerWithGoods("Cara",
				"32 Clarendon road", "07999999999", goodsList3);
		CustomerWithGoods customer4 = new CustomerWithGoods("David",
				"38 Road road", "07666666666", goodsList4);
		
		ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>
		(Arrays.asList(customer1, customer2, customer3));
	
		//creates customer base
		CustomerBase customerBase = new CustomerBase(allCustomers);
		
		
		//prints all customers names, adds customer, prints all names 
		System.out.println("All customers: ");
		for (int i=0; i<allCustomers.size(); i++){
			System.out.println(allCustomers.get(i).getCustomerName());
		}
		
		System.out.println("\nAdd new customer, David.\n\n");
		allCustomers.add(customer4);
		
		System.out.println("All customers: ");
		for (int i=0; i<allCustomers.size(); i++){
			System.out.println(allCustomers.get(i).getCustomerName());
		}
		
		System.out.println("\n\n");
		
		
		//shows a customer buying a new good
		System.out.println(customer1.toString() + "\n");

		System.out.println(customer1.getCustomerName() + " has spent \u00A3" + customer1.valueOfGoods() + 
				" in total.");
		System.out.println(customer1.getCustomerName() + " buys a Ferret for \u00A3" + g6.getPrice() + "\n");
		customer1.buy(g6);
		System.out.println(customer1.toString());
		System.out.println(customer1.getCustomerName() + " has spent \u00A3" + customer1.valueOfGoods() + 
				" in total.\n\n");
		
		
		

		
		
		//prints customer base
		System.out.println("Customer base: ");
		for (int i=0; i<allCustomers.size(); i++){
			System.out.println(allCustomers.get(i) + "\n");
		}

		
		
		
		System.out.println("\n\n");
		
		//prints loyal customers
		System.out.println("Loyal customers:");
		System.out.println(customerBase.filterLoyal());


		System.out.println("\n\n");
		
		
		//prints valued customers
		System.out.println("Valued customers:");
		System.out.println(customerBase.filterValued());


	
		
	}

}
