import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class BuildClassTest {

	private Var variable1;
	private Var variable2;
	private Var variable3;
	private Var variable4;
	private String className;
	private ArrayList<Var> variableList;
	private BuildClass hello;
	
	
	@Before
	public void setUp(){
		
		
		className = "Patient";
		
		variable1 = new Var("String","name");
		variable2 = new Var("int", "age");
		variable3 = new Var("double", "height");
		variable4 = new Var("double", "weight");
		
		variableList = new ArrayList<Var>
			(Arrays.asList(variable1, variable2, variable3, variable4));
		
		hello = new BuildClass(className, variableList);
	}
	
	@Test
	public void test1() {
		String expected1 = "String";
		String expected2 = "name";
		
		assertEquals(expected1, variable1.getTypeOfVar());
		assertEquals(expected2, variable1.getNameOfVar());
	}
	
	@Test
	public void test2() {
		//test field variables
		String expected1 = "\tprivate String name;\n\tprivate int age;"
				+ "\n\tprivate double height;\n\tprivate double weight;\n";

		assertEquals(expected1, hello.makeFields());
	}
	
	@Test
	public void test3() {
		//test constructor
		String expected1 = "\tpublic Patient(String name, int age, double height, double weight) "
				+ "{\n\t\tthis.name = name;\n\t\tthis.age = age;\n\t\tthis.height = height;\n\t\tthis.weight"
				+ " = weight;\n\t}";
		
		assertEquals(expected1, hello.makeConstructor());
	}
	
	@Test
	public void test4() {
		//test getters
		String expected1 = "\tpublic String getName() {\n\t\treturn name;\n\t}\n\n"
				+ "\tpublic int getAge() {\n\t\treturn age;\n\t}\n\n"
				+ "\tpublic double getHeight() {\n\t\treturn height;\n\t}\n\n"
				+ "\tpublic double getWeight() {\n\t\treturn weight;\n\t}\n\n";
		
		assertEquals(expected1, hello.makeGetters());
	}
	
	@Test
	public void test5() {
		//test setters
		String expected1 = "\tpublic void setName(String name) {\n\t\tthis.name = name;\n\t}\n\n"
				+ "\tpublic void setAge(int age) {\n\t\tthis.age = age;\n\t}\n\n"
				+ "\tpublic void setHeight(double height) {\n\t\tthis.height = height;\n\t}\n\n"
				+ "\tpublic void setWeight(double weight) {\n\t\tthis.weight = weight;\n\t}\n\n";
		
		assertEquals(expected1, hello.makeSetters());
	}
	
	@Test
	public void test6() {
		//test build class
		String expected1 = "public class Patient {\n\n"
				+ "\tprivate String name;\n"
				+ "\tprivate int age;\n"
				+ "\tprivate double height;\n"
				+ "\tprivate double weight;\n\n"
				+ "\tpublic Patient(String name, int age, double height, double weight) {\n"
				+ "\t\tthis.name = name;\n"
				+ "\t\tthis.age = age;\n"
				+ "\t\tthis.height = height;\n"
				+ "\t\tthis.weight = weight;\n"
				+ "\t}\n\n"
				+ "\tpublic String getName() {\n"
				+ "\t\treturn name;\n"
				+ "\t}\n\n"
				+ "\tpublic int getAge() {\n"
				+ "\t\treturn age;\n"
				+ "\t}\n\n"
				+ "\tpublic double getHeight() {\n"
				+ "\t\treturn height;\n"
				+ "\t}\n\n"
				+ "\tpublic double getWeight() {\n"
				+ "\t\treturn weight;\n"
				+ "\t}\n\n"
				+ "\tpublic void setName(String name) {\n"
				+ "\t\tthis.name = name;\n"
				+ "\t}\n\n"
				+ "\tpublic void setAge(int age) {\n"
				+ "\t\tthis.age = age;\n"
				+ "\t}\n\n"
				+ "\tpublic void setHeight(double height) {\n"
				+ "\t\tthis.height = height;\n"
				+ "\t}\n\n"
				+ "\tpublic void setWeight(double weight) {\n"
				+ "\t\tthis.weight = weight;\n"
				+ "\t}\n\n"
				+ "\n}";
		
		assertEquals(expected1, hello.buildClass());
	}

}
