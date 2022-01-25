import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * 
 * @author Mohammad Dembele
 *
 */
 class CourseDBStructure implements CourseDBStructureInterface {

	private int size;
	LinkedList<CourseDBElement>[] hashTable;
	/**
	 * Default Constructor
	 */
	public CourseDBStructure() {
		size=15;
		hashTable = new LinkedList[size]; 
	}
	/**
	 * Constructor
	 * @param name
	 * @param size
	 */
	public CourseDBStructure(String name, int size) {
		this.size=size;
		hashTable = new LinkedList[size];
	}

	public CourseDBStructure(int size) {
		this.size=size;
		hashTable = new LinkedList[size];
	}
	/**
	 * @param element -  a CDE
	 */
	@Override
	public void add(CourseDBElement element) {
		
		if (hashTable[element.hashCode()%this.getTableSize()] == null) {
			hashTable[element.hashCode()%this.getTableSize()] = new LinkedList<CourseDBElement>();
		}
			hashTable[element.hashCode()%this.getTableSize()].add(element);
		
	}
	/**
	 * @param crn
	 * @return CourseDBElement
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		CourseDBElement temp = new CourseDBElement();
		temp.setCRN(crn);
		
		
			if (hashTable[temp.hashCode()]==null)
				return null;
			else {
				for (int i=0;i<hashTable[temp.hashCode()].size();i++) {
					if (hashTable[temp.hashCode()].get(i).getCRN()==crn)
						return hashTable[temp.hashCode()].get(i);
					
				}
			}
		
		return null;
	}

	/**
	 *@return TableSize
	 */
	@Override
	public int getTableSize() {
		return this.size;
		
	}

}
