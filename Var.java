/**
 * Var is a class that creates a variable.
 * @author Ellie Sutton
 *
 */
public class Var {

	private String typeOfVar;
	private String nameOfVar;
	
	/**
	* Constructor for the variable
	* @param typeOfVar The type of variable
	* @param nameOfVar The name of the variable
	*/
	public Var(String typeOfVar, String nameOfVar) {
		this.typeOfVar = typeOfVar;
		this.nameOfVar = nameOfVar;
	}
	
	/**
	* getter for the type of variable
	* @return The type of variable
	*/
	public String getTypeOfVar() {
		return typeOfVar;
	}
	
	/**
	* getter for the name of the variable
	* @return The name of the variable
	*/
	public String getNameOfVar() {
		return nameOfVar;
	}
	
}