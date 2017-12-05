import java.util.ArrayList;


/**
 * Ex3 is a class that finds the prime numbers between 1 and n
 * @author exs404
 *
 */
public class Ex3 {
	
	/**
	 * sieve is a method that finds the prime numbers between 1 and a given 
	 * upper limit
	 * @param The upper limit of the range in which to find the prime numbers
	 * @return An array containing the prime numbers between 1 and max
	 */
	public static int[] sieve(int max){
		
		//creates array and of size max+1 and sets all values to true apart from 0 and 1
		boolean[] sieve = new boolean[max+1];
		sieve[0] = false;
		sieve[1] = false;
		for (int i=2; i<max+1; i++){
			sieve[i] = true;
		}
		
		//if a number is a multiple of another number in the array, its value is changed
		//to false
		//can stop when the next prime number in the list is bigger than sqrt(n)
		for (int i=2; i<Math.sqrt(max); i++){
			if (sieve[i] == true){
				for (int j=i+1; j<max+1; j++){
					if (j%i == 0)
						sieve[j] = false;
				}
			}
		}
		
		//creates an array list and adds all positions that say true
		//i.e adds all prime numbers 
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<max+1; i++){
			if (sieve[i] == true)
				list.add(i);
		}
		
		//creates an array that contains all elements of the array list
		int[] array = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			array[i] = list.get(i);
		}
		
		return array;
	}
	
	
	
	public static void main(String[] args){
		
		int max = 50;
		System.out.println("Prime numbers from 1 up to " + max + ":");
		int[] array1 = sieve(max);
		for(int i=0; i<array1.length-1; i++){
			System.out.print(array1[i] + ", ");
		}
		System.out.print(array1[array1.length-1]);
	}

}
