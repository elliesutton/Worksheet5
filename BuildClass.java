import java.util.ArrayList;
import java.util.Arrays;


/**
 * BuildClass is a class that generates field variables,
 * a constructor, getters and setters and puts them together
 * to build a class.
 * @author Ellie Sutton
 *
 */
public class BuildClass{

	private String className;
	private ArrayList<Var> fields;
	
	/**
	 * BuildClass is a constructor that makes a class 
	 * @param className The name of the class
	 * @param fields The field variables of the class
	 */
	public BuildClass(String className, ArrayList<Var> fields){
		this.className = className;
		this.fields = fields;
	}
	
	/**
	 * makeFields is a method that creates the field variables in the
	 * appropriate format.
	 * @return The field variables
	 */
	public String makeFields() {
		String fieldVariables = "";
		for (int i=0; i<fields.size(); i++) {
			fieldVariables += ("\tprivate " + fields.get(i).getTypeOfVar() 
					+ " " + fields.get(i).getNameOfVar() + ";\n");
		}
		return fieldVariables;
	}
	
	/**
	* makeConstructor is a method that creates a constructor
	* for the class.
	* @return The constructor
	*/
	public String makeConstructor() {
		String constructor = ("\tpublic " + className + "(");
		for (int i=0; i<fields.size()-1; i++) {
			constructor += (fields.get(i).getTypeOfVar() + " " 
					+ fields.get(i).getNameOfVar() + ", ");
		}
		constructor += (fields.get(fields.size()-1).getTypeOfVar() + " " 
				+ fields.get(fields.size()-1).getNameOfVar() +") {\n");
		for (int i=0; i<fields.size(); i++) {
			constructor += "\t\tthis." + fields.get(i).getNameOfVar() 
					+ " = " + fields.get(i).getNameOfVar() + ";\n";
		}
		constructor += "\t}";
		return constructor;
	}
	
	/**
	* makeGetters is a method that creates the getters for the class
	* @return The getters
	*/
	public String makeGetters() {
		String getters = "";
		for (int i=0; i<fields.size(); i++) {
			getters += ("\tpublic " + fields.get(i).getTypeOfVar() + " get" 
					+ fields.get(i).getNameOfVar().substring(0,1).toUpperCase() 
					+ fields.get(i).getNameOfVar().substring(1) + "() {\n");
			getters += ("\t\treturn " + fields.get(i).getNameOfVar() + ";\n\t}\n\n");
		}
		return getters;	
	}
	
	/**
	* makeSetters is a method that creates the setters for the class
	* @return The setters
	*/
	public String makeSetters() {
		String setters = "";
		for (int i=0; i<fields.size(); i++) {
			setters += ("\tpublic void set" + fields.get(i).getNameOfVar().substring(0,1).toUpperCase()
					+ fields.get(i).getNameOfVar().substring(1) + "(" + fields.get(i).getTypeOfVar() 
					+ " " + fields.get(i).getNameOfVar() + ") {\n");
			setters += ("\t\tthis." + fields.get(i).getNameOfVar() + " = " + fields.get(i).getNameOfVar() 
					+ ";\n\t}\n\n");
		}
		return setters;
		
	}
	
	/**
	* buildClass is a method that puts together the field variables, the constructor,
	* the getters and the setters to form the class.
	* @return The class
	*/
	public String buildClass() {
		String wholeClass = ("public class " + className + " {\n\n");
		wholeClass += (makeFields() + "\n" + makeConstructor() + "\n\n" 
				+ makeGetters() + makeSetters() + "\n}");
		return wholeClass;
		
	}
	
	public static void main(String[] args){
		String className = "Patient";
		
		Var variable1 = new Var("String","name");
		Var variable2 = new Var("int", "age");
		Var variable3 = new Var("double", "height");
		Var variable4 = new Var("double", "weight");
		
		ArrayList<Var >variableList = new ArrayList<Var>
			(Arrays.asList(variable1, variable2, variable3, variable4));
		
		BuildClass hello = new BuildClass(className, variableList);
		
		System.out.println("Field variables: ");
		System.out.println(hello.makeFields());
		
		System.out.println("\nConstructor: ");
		System.out.println(hello.makeConstructor());
		
		System.out.println("\nGetters: ");
		System.out.println(hello.makeGetters());
		
		System.out.println("\nSetters: ");
		System.out.println(hello.makeSetters());
		
		System.out.println("\nWhole class: ");
		System.out.println(hello.buildClass());
		
		
		
	}

}