
public class EmployeeSet {
	
	// instance variable
	int capacity;
	Employee[] emp;
	int numOfEmployee = 0;
	
	public EmployeeSet() {
		capacity =10;
		emp = new Employee[capacity];
	}
	
	public EmployeeSet(Object obj) {
		
		// Copy numOfEmployee
		this.numOfEmployee = obj.numOfEmployee;
		
		
		// Copy constructor
		for(int i = 0; i < obj.emp.length(); i++) {
			
			this.emp[i]= obj.emp[i];
		}
		
		
		
	}
	
	
	public int size() {
		return numOfEmployee;
	}
	
	public int capacity() {
		int a = capacity.length();
		return a;
	}
	
	
	public void add(Employee a) {
		
	}
	
	
	public static void main(String[] args) {
		

	}

}
