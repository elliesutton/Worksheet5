/**
 * RSA is a class that implements the RSA method of encryption.
 * @author Ellie Sutton
 *
 */
public class RSA {

	private long p;
	private long q;
	private long e; //public key
	private long plainNumber;
	
	/**
	 * RSA constructor
	 * @param p A prime number
	 * @param q A prime number
	 * @param e A random number
	 * @param plainNumber The number to be encrypted
	 */
	public RSA(long p, long q, long e, long plainNumber){
		if (p * q < Long.MAX_VALUE) {
			this.p = p;
			this.q = q;
			this.e = e;
			this.plainNumber = plainNumber;
		} else {
			throw new IllegalStateException("Please choose smaller values for p and q.");
		}
	}
		
	/**
	 * getter for prime p
	 * @return p
	 */
	public long getP() {
		return p;
	}

	/**
	 * getter for prime q
	 * @return q
	 */
	public long getQ() {
		return q;
	}
	
	/**
	 * getter for e
	 * @return e
	 */
	public long getE() {
		return e;
	}

	
	/**
	 * Finds n by multiplying primes p and q
	 * @return n
	 */
	public long getN() {
		return p*q;
	}
		
	
	/**
	 * getLambda finds the lowest common multiple of p-1 and q-1
	 * by finding the greatest common divisor of p-1 and q-1 and then
	 * dividing their product by their gcd. 
	 */
	public long getLambda(){ 
		long a = p-1;
		long b = q-1;
		if (a < b){
			long temp = b;
			b = a;
			a = temp;
		}

		
		long remainder;
		while (b != 0){
			remainder = a%b;
			a = b;
			b = remainder;
		}
		
		//a = hcf(p-1,q-1)
		return (p-1)*(q-1)/a;
			
	}
		

	/**
	 * getD uses the extended euclidean algorithm to find d,
	 * the modular multiplicative inverse of e modulo lambda.
	 * (Used the pseudocode available on the wikipedia page
	 * for the extended euclidean algorithm).
	 * @return the modular multiplicative inverse of e modulo lambda
	 */
	public long getD() {
		long r = getLambda();
		long rNew = e;
		long t = 0;
		long tNew = 1;
		
		while (rNew != 0){
			long quotient = r/rNew;
			long temp1 = t;
			t = tNew;
			tNew = temp1 - quotient * tNew;
			long temp2 = r;
			r = rNew;
			rNew = temp2 - quotient * rNew;
		}
		
		if (t < 0) 
			t += getLambda();
		
		return t;
		
	}
	

	
	
	
	/**
	 * power calculates x^a mod modulus
	 * @param x 
	 * @param a
	 * @param modulus
	 * @return x^a mod modulus
	 */
	public long power(long x, long a, long modulus){
		
		if (a==0){
			return 1; //x^0=1
		}
		else if (a==1){
			return x%modulus; //x^1=x
		}
		else if (a%2 == 0){
			return ((power(x, a/2, modulus)%modulus)*(power(x, a/2, modulus)%modulus))%modulus;
		}
		else //if (a%2 == 1){
			return ((x%modulus)*power(x, a-1, modulus))%modulus;	
	} 
	
	
	/**
	 * encrypt uses the method power(x,y,z) to encrypt the plain number
	 * @return the encrypted number
	 */
	public long encrypt() {
		System.out.println("Plain number: " + plainNumber);
		System.out.println("Public key: " + getE() + "\n");
		

		long encryptedNumber = power(plainNumber, e, getN());
		
		System.out.println("Encrypted number: " + encryptedNumber + "\n");
		
		return encryptedNumber;
		
	}
	
	
	
	/**
	 * decrypt uses the method power(x,y,z) to decrypt the encrypted number
	 * @return the plain number
	 */
	public long decrypt() {
		
		
		long encryptedNumber = encrypt();
		
		System.out.println("Encrypted number: " + encryptedNumber);
		System.out.println("Private key: " + getD() + "\n");
		long decryptedNumber = power(encryptedNumber, getD(), getN());
		System.out.println("Decrypted number: " + decryptedNumber);
		return decryptedNumber;
		
	}
	
	
	
	/**
	 * gcd uses the euclidean algorithm to find the greatest
	 * common divisor of two numbers
	 * @param a The first number
	 * @param b The second number
	 * @return gcd(a,b)
	 */
	public long gcd(long a, long b) {
		if (a < b){
			long temp = b;
			b = a;
			a = temp;
		}

		long remainder;
		while (b != 0){
			remainder = a%b;
			a = b;
			b = remainder;
		}
		return a;
	}
	
	
	/**
	 * generateRandomE generates a random number e such that
	 * 1<e<lambda and gcd(e,lambda)=1.
	 * @return A random number with the specified properties
	 */
	public long generateRandomE() {
		long randomE = (long) (Math.random() * getLambda());
		while (gcd(randomE, getLambda()) != 1){
			randomE = (long) (Math.random() * getLambda());
		}	
		return randomE;
	} 
	
	
	
	public static void main(String[] args){
		long p = 99991;
		long q = 8999;
		long e = 14983;
		long plainNumber = 12;
		
		RSA encryption = new RSA(p, q, e, plainNumber);
		

		encryption.encrypt();
		
		encryption.decrypt();
		
	}
	

	
}
