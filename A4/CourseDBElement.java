/**
 * 
 * @author Mohammad Dembele
 *
 */
 class CourseDBElement implements Comparable {

	String cid="";
	int crn;
	int credits;
	String roomNumber="";
	String instructor="";
	/**
	 * Constructor
	 * @param cid
	 * @param crn
	 * @param credits
	 * @param roomNumber
	 * @param instructor
	 */
	public CourseDBElement(String cid, int crn, int credits,String roomNumber, String instructor) {
		this.cid=cid;
		this.crn=crn;
		this.credits=credits;
		this.roomNumber=roomNumber;
		this.instructor=instructor;
	}
	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		this("",0,0,"","");
	}

	@Override
	public int compareTo(CourseDBElement element) {
	
		return this.crn-element.crn;
	}
	/**
	 * hashcode of crn
	 */
	@Override
	public int hashCode(){
		String tempString = Integer.toString(this.crn); // turns crn to string, 
		int hash = tempString.hashCode(); //takes hashcode of tempstring and 
		
		
		return hash;
	}
	/**sets crn
	 * 
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn=crn;	
	}
	/**
	 * 
	 * @return crn
	 */
	public int getCRN() {
		return this.crn;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Course:"+cid+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructor+" Room:"+roomNumber;
	}
	
	
 }
