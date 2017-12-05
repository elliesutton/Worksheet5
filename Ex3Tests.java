import static org.junit.Assert.*;

import org.junit.Test;

public class Ex3Tests {
	


	@Test
	public void test1() {
		int[] array = Ex3.sieve(13);
		int[] expected = {2, 3, 5, 7, 11, 13};
		
		assertArrayEquals(expected, array);
		
	}
	
	@Test
	public void test2() {
		int[] array = Ex3.sieve(20);
		int[] expected = {2, 3, 5, 7, 11, 13, 17, 19};
		
		assertArrayEquals(expected, array);
		
	}
	
	@Test
	public void test3() {
		int[] array = Ex3.sieve(50);
		int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23,
				29, 31, 37, 41, 43, 47}; 
		
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void test4() {
		int[] array = Ex3.sieve(100);
		int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23,
				29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
				73, 79, 83, 89, 97};
		
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void test5() {
		int[] array = Ex3.sieve(150);
		int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23,
				29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
				73, 79, 83, 89, 97, 101, 103, 107, 109, 
				113, 127, 131, 137, 139, 149};
		
		assertArrayEquals(expected, array);
	}

}
