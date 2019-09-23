

// The file "core_dataset.csv" should be in the same directory
// CS272
// Lab1 
// Author : Junyong Lee
// This program is to read file and write .csv file which has young employee under 30


import java.io.*;
import java.util.*;
public class EmployeeFileOp {


	
	public static ArrayList<String> alist = new ArrayList<String>();  // Using ArrayList
	
	public static void read(String fname){
		int no = 0;
		int age = 0;
		try {
			
			File csv = new File("core_dataset.csv");
            // FileReader reads text files in the default encoding.
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader br = new BufferedReader(new FileReader(csv));
            
            String line ="";
            
            
            // Header Case
            
            
            
            
            
            while((line = br.readLine()) != null) {
 
                	String[] token = line.split(",", -1);
                	//Header Case
                	if(no==0) {
                		System.out.println(token[0]+","+token[1] + "," + token[2] + "," + token[3] + "," + token[5] + "," + token[6]);
                		alist.add("");
                		alist.add(token[0]);
                		alist.add(token[1]);
                		alist.add(token[2]);
                		alist.add(token[3]);
                		alist.add(token[5]);
                		alist.add(token[6]);
                		
                		alist.add("\n");
                		no++;
                		continue;
                	}
                		
                	if(no>0) {
                		System.out.println(token[0]+","+token[1] + "," + token[2] + "," + token[3] + "," + token[4] + "," + token[6] + "," + token[7]);
                	
                			
                		 	age = Integer.parseInt(token[6]); // Parsing the age
                		 	
                		 	
                		 	if(age<=30) { // check the age with condition ( Under 30 )
	                		alist.add(token[0]);
	                		alist.add(token[1]);
	                		alist.add(token[2]);
	                		alist.add(token[3]);
	                		alist.add(token[4]);
	                		alist.add(token[6]);
	                		alist.add(token[7]);
	                		alist.add("\n");
	                	
                		 }else {
                			 continue;
                		 }
                		
	                }
                }
      
            br.close(); // Always close files.         
        }
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }
		catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
		System.out.println("Finish reading employee information from file "+ fname);
	}
	
	
	
	public static void write(String fname){
		try {
			
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			

			
			bw.write(alist+"\n");

			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing young_employee to file "+ fname);
	}
	
	public static void main(String[] args) {
		

		read("core_dataset.csv");		//read original dataset
		write("young_employee.csv"); //write csv file
	}

}

