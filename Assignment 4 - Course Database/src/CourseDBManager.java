
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 * 
 * @author Mohammad Dembele
 *
 */
 class CourseDBManager implements CourseDBManagerInterface{
	
	 CourseDBStructure dbs;
	  /**
	   * Default Constructor
	   */
	 public CourseDBManager() {
		 dbs = new CourseDBStructure();
	 }
	/**
	 * adds element to data structure
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newDBE = new CourseDBElement(id,crn,credits,roomNum,instructor);
		dbs.add(newDBE);
		
	}

	/**@param crn
	 * @return A CDE
	 * returns element, looks up dabsed on crn
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return dbs.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**@param input - file input
	 * reads and adds elements from file
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		
		ArrayList<String> temp = new ArrayList<>();
		 
		try (Scanner s = new Scanner(input)) {
		    while (s.hasNext()) {
		        temp.add(s.nextLine());
		    }
		    
		}
		String [] id = new String[temp.size()];
		int [] crn = new int [temp.size()];
		int [] credits = new int[temp.size()];
		String [] room = new String[temp.size()];
		String [] instructor = new String[temp.size()];
	  
		for (int i=0;i<temp.size();i++) {
			Scanner s1 = new Scanner(temp.get(i));
			id[i] = s1.next();
			crn[i]=Integer.parseInt(s1.next());
			credits[i]=Integer.parseInt(s1.next());
			room[i] = s1.next();
			while(s1.hasNext())
				instructor[i]+=s1.next()+" ";
		}
	}
		
	
	/**
	 * @return arraylist of string representation of all CDE's 
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> temp = new ArrayList<String>();
		
		for (LinkedList l:dbs.hashTable) {
			if(l!=null)
			for (int i=0; i<l.size();i++) {
				temp.add("\n"+l.get(i).toString());
			}
		}
		Collections.sort(temp);
		return temp;
	}
	
	
 }
