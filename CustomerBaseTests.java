import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class CustomerBaseTests {
	
	private Customer customer1;
	private Good g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;
	private CustomerWithGoods c1, c2, c3, c4, c5;
	private ArrayList<CustomerWithGoods> allCustomers;
	private CustomerBase customerBase;
	
	@Before
	public void setUp(){
		customer1 = new Customer("Mia", "21 Ford street", "07826514271");
		g1 = new Good("Axe", 1);
		g2 = new Good("Ball", 2);
		g3 = new Good("Cat", 3);
		g4 = new Good("Dragon", 4);
		g5 = new Good("Elf", 5);
		g6 = new Good("Ferret", 6);
		g7 = new Good("Glitter", 7);
		g8 = new Good("House", 8);
		g9 = new Good("Ink", 15);
		g10 = new Good("Jacket", 15);

		
		ArrayList<Good> goodsList1 = new ArrayList<Good>
			(Arrays.asList(g1, g2, g3, g4, g5, g6));
	
		ArrayList<Good> goodsList2 = new ArrayList<Good>
			(Arrays.asList(g6, g7, g8));
	
		ArrayList<Good> goodsList3 = new ArrayList<Good>
			(Arrays.asList(g8, g9, g10));

		ArrayList<Good> goodsList4 = new ArrayList<Good>
			(Arrays.asList(g2, g4, g6, g8));
		
		ArrayList<Good> goodsList5 = new ArrayList<Good>
		(Arrays.asList(g1, g5));
		
		c1 = new CustomerWithGoods("Arya", "45 Lottie road", "07777777777", goodsList1);
		c2 = new CustomerWithGoods("Ben", "1 Ashford Avenue", "07888888888", goodsList2);
		c3 = new CustomerWithGoods("Cara", "32 Clarendon road", "07999999999", goodsList3);
		c4 = new CustomerWithGoods("David", "38 Road road", "07666666666", goodsList4);
		c5 = new CustomerWithGoods("Erin", "67 Campus road", "07555555555", goodsList5);
		
		allCustomers = new ArrayList<CustomerWithGoods>
			(Arrays.asList(c1, c2, c3, c4));
		
		customerBase = new CustomerBase(allCustomers);
		
	}


	@Test
	public void test1() {
		String expected1 = "Mia";
		String expected2 = "Name: Mia\nAddress: 21 Ford street\nTelephone number: 07826514271";
		
		assertEquals(expected1, customer1.getCustomerName());
		assertEquals(expected2, customer1.toString());
	}
	
	
	
	@Test
	public void test2() {
		int expected1 = 4;
		String expected2 = "Dragon: \u00a34";
		
		assertEquals(expected1, g4.getPrice());
		assertEquals(expected2, g4.toString());
	}
	
	
	
	@Test
	public void test3() {
		String expected1 = "Name: Arya\nAddress: 45 Lottie road\nTelephone number: 07777777777\nGoods: "
				+ "[Axe: \u00a31, Ball: \u00a32, Cat: \u00a33, Dragon: \u00a34, Elf: \u00a35, Ferret: \u00a36]";
		
		String expected2 = "Name: Ben\nAddress: 1 Ashford Avenue\nTelephone number: 07888888888\nGoods: "
				+ "[Ferret: \u00a36, Glitter: \u00a37, House: \u00a38]";
		
		assertEquals(expected1, c1.toString());
		assertEquals(expected2, c2.toString());
	}
	
	
	@Test
	public void test4() {
		
		ArrayList<Good> expected1 = new ArrayList<Good>
			(Arrays.asList(g8, g9, g10));
		int expected2 = 38;
		ArrayList<Good> expected3 = new ArrayList<Good>
			(Arrays.asList(g8, g9, g10, g1));

		assertEquals(expected1, c3.getGoods());
		assertEquals(expected2, c3.valueOfGoods());

		c3.buy(g1);
		assertEquals(expected3, c3.getGoods());
		
	}
	
	
	@Test
	public void test5() {
		//customer base test
		int expected1 = 4;
		int expected2 = 5;
		
		assertEquals(expected1, allCustomers.size());
		customerBase.addCustomer(c5);
		assertEquals(expected2, allCustomers.size());

		
			
	}
	
	@Test
	public void test6() {
		//loyal customers test
		ArrayList<CustomerWithGoods> loyalCustomers = new ArrayList<>();
		loyalCustomers = customerBase.filterLoyal();
		
		
		int expected1 = 1;
		
		
		ArrayList<CustomerWithGoods> expected2 = new ArrayList<CustomerWithGoods>
		(Arrays.asList(c1));
		
		assertEquals(expected1, loyalCustomers.size());
		assertEquals(expected2, loyalCustomers);
		
	}
	
	
	@Test
	public void test7() {
		ArrayList<CustomerWithGoods> valuedCustomers = new ArrayList<>();
		valuedCustomers = customerBase.filterValued();
		
		int expected1 = 1;
		
		ArrayList<CustomerWithGoods> expected2 = new ArrayList<CustomerWithGoods>
		(Arrays.asList(c3));
		

		
		assertEquals(expected1, valuedCustomers.size());
		assertEquals(expected2, valuedCustomers);
	}
	

}
