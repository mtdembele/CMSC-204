import java.util.*;

public class Town implements Comparable<Town> {
	private String name;
	private ArrayList<Town> adjacent;
	private Town previous;
	
	public Town(String s) {
		name =s;
		
	}
	public Town (Town t) {
		this.name=t.getName();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(Town o) {
		if (this.name==o.name)
		return 0;
		
		return -1;
	}
	public boolean equals(Town t) {
		return this.name.equals(t.getName());
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	public Town getPrevious() {
		return previous;
	}
	public void setPrevious(Town t) {
		this.previous=t;
	}
	
	
	
	
}
