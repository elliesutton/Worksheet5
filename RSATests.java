import static org.junit.Assert.*;

import org.junit.Test;

public class RSATests {

	@Test
	public void test1() {
		
		long plainNumber = 11;
		RSA rsa = new RSA(61, 53, 17, plainNumber);
		
		long expected = 3061;
		
		assertEquals(expected, rsa.encrypt());
		
	}
	
	@Test
	public void test2() {
		
		long plainNumber = 11;
		RSA rsa = new RSA(61, 53, 17, plainNumber);
		
		long expected = plainNumber;
		
		assertEquals(expected, rsa.decrypt());
		
	}
	
	@Test
	public void test3() {
		
		long plainNumber = 23;
		RSA rsa = new RSA(293, 317, 97, plainNumber);
		
		long expected = 91259;
		
		assertEquals(expected, rsa.encrypt());
		
	}
	
	@Test
	public void test4() {
		
		long plainNumber = 23;
		RSA rsa = new RSA(293, 317, 97, plainNumber);
		
		long expected = plainNumber;
		
		assertEquals(expected, rsa.decrypt());
		
	}
	
	@Test
	public void test5() {
		
		long plainNumber = 44;
		RSA rsa = new RSA(61, 53, 17, plainNumber);
		
		long expected = 678;
		
		assertEquals(expected, rsa.encrypt());
		
	}
	
	@Test
	public void test6() {
		
		long plainNumber = 44;
		RSA rsa = new RSA(61, 53, 17, plainNumber);
		
		long expected = plainNumber;
		
		assertEquals(expected, rsa.decrypt());
		
	}
	
	

}
