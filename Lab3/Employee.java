
// CS 272 Lab2
// Junyong Lee
// 800623507


public class Employee {
	
	// instance variables
	String name;
	int no;
	int age;
	String state;
	int zipcode;
	Integer[] advisors = new Integer[3];
	
	
	// Constructor
	public Employee() {
		System.out.println("Constructor called");
		this.no = 0;
		this.age = 0;
		this.zipcode = 0;
		this.state = null;
		for(int i = 0; i < 3; i++) {
			advisors[i] = null;
		}

		
		
	}
	
	// Copy Constructor
	public Employee(Employee obj){
		System.out.println("Copy constructor called");
		name = new String(obj.name);
		no = obj.no;
		age = obj.age;
		state = new String(obj.state);
		zipcode = obj.zipcode;
		advisors = obj.advisors; // can't be null
	}
	
	// Name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	// No
	public void setNo(int number) {
		this.no = number;
	}
	public int getNo() {
		return no;
	}
	
	// Age
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	// State 
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	
	// Zip code
	public void setZip(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getZip() {
		return zipcode;
	}
	
	// Advisors
	public void setAdvisors(Integer[] advisors2) {
		
		for(int i = 0; i < 3; i++) {
			advisors[i] = advisors2[i];
		}
		
	}
	public Integer[] getAdvisors() {
		return advisors;
	}
	

	// toString()
	public String toString() {
		return name + " " + no + " " + age + " " + state + " " + zipcode + " " + advisors[0] + ", " + advisors[1] + ", " + advisors[2];
	}
	
	// equals()
	public boolean equals(Employee obj) {
		
		if( (this.no) == obj.no) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// getAllAdvisors()
	public static int[] getAllAdvisors(Employee o1, Employee o2) {
		
		// Make array Distinct which has 6 size for storing 6 elements from o1 and o2
		int[] Distinct = new int[6];
		
		// Store 3 elements of o1 into Distinct [0] ~ [2]
		for(int i = 0; i < 3; i++) {
			Distinct[i] = o1.getAdvisors()[i];
		}
		// Store 3 elements of o2 into Distinct [3] ~ [5]
		for(int a = 3; a < 6; a++) {
			Distinct[a] = o2.getAdvisors()[a-3];
		}


		//Check if all elements are distinct
		for(int c = 0; c < 6; c++) {
			
			for(int f = c+1; f < 6; f++) {
				if(Distinct[c] == Distinct[f]) {
						
				System.out.println("Elements are not distinct try it again!");
				break;
				}
			}
		}
		
		return Distinct;
	}
	
	
	public static void main(String[] args) {
		
		// Test with object e1
		Employee e1 = new Employee();
		
		//**************Set Test***************************************
		e1.setName("Junyong");
		e1.setNo(100);
		e1.setAge(25);
		e1.setState("NM");
		e1.setZip(88001);
		// advisor Integer array 'test'
		Integer[] test = {5, 10, 15};
		e1.setAdvisors(test);
		
		// Print e1
		System.out.println("\n**********Print e1***********");
		System.out.println(e1);
		
		// Copy Constructor test
		
		System.out.println("\n**********Print e2***********");
		Employee e2 = new Employee(e1);
		System.out.println(e2);
		
		
		

		
		//*************Get Test*****************************************
		System.out.println("\n*************SET & Get Test*****************************************");
		System.out.print("Name is " + e1.getName() + "\n" + "no is " + e1.getNo() + "\n"
						+ "Age is " + e1.getAge() + "\n" + "State is " + e1.getState() + "\n"
						+ "Zipcode is " + e1.getZip() + "\n" + "Advisor nos are " + e1.getAdvisors()[0] + ", " + e1.getAdvisors()[1] + ", " + e1.getAdvisors()[2]);
		
		//************* equals() Test*****************************************
		System.out.println("\n************* equals() Test*****************************************");
		
		// True case test
		e1.setNo(10);
		e2.setNo(10);
		System.out.println("True case test");
		System.out.println(e1.equals(e2));
		
		
		// False case test
		
		e2.setNo(20);
		System.out.println("False case test");
		System.out.println(e1.equals(e2));
		
		
		//*************getAllAdvisors equals() Test*****************************************
		
		System.out.println("\n*************getAllAdvisors Test*****************************************");
		
		Employee e3 = new Employee();
		
		
		
		Integer[] advisorsame = {5, 10, 15};
		Integer[] advisordistinct = { 1, 6, 9 };
		
		// e1's advisor is already set as {5, 10 15} above.
		
		
		
		// When we DON'T have a distinct case
		System.out.println("\n*************** When we DON'T have a distinct case********");
		e3.setAdvisors(advisorsame); // e1 = {5, 10, 15} e3 = {5, 10, 15}  
		getAllAdvisors(e1, e3);
		
		
		
		// When we have a distinct case
		System.out.println("***************** When we have a distinct case*************");
		e3.setAdvisors(advisordistinct); // e1 = {5, 10, 15} e3 = {1, 6, 9}  
		getAllAdvisors(e1, e3);
		System.out.println("Good. Elements are distinct.\n Distinct elemnts are : ");
		
		for(int p = 0; p < 6; p++) {
			System.out.println(getAllAdvisors(e1,e3)[p]);
		}
	}
}


