/**
 * 
 * @author Mohammad Dembele
 *
 */
public class Road implements Comparable<Road> {
	private Town source, destination;
	private int weight;
	private String name;
	
	public Road(Town t1, Town t2, int distance, String name) {
		source=t1;
		destination=t2;
		this.weight = distance;
		this.name=name;
	}
	public Road (Town t1, Town t2, String name) {
		this(t1, t2, 1, name);
	}
	/**
	 * 
	 * @param town
	 * @return true if road contains town
	 */
	public boolean contains(Town town) {
		return (source.equals(town) || destination.equals(town));
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public Town getSource() {
		return source;
	}
	
	 
	public void setSource(Town source) {
		this.source = source;
	}
	public Town getDestination() {
		return destination;
	}
	public void setDestination(Town destinaiton) {
		this.destination = destinaiton;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int distance) {
		this.weight = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param r - road to be compared
	 * @return true if names are equal
	 */
	public boolean equals(Road r) {
		return this.getName().equals(r.getName());
	}
	/**
	 * @returns 0 if equal, else return -1
	 */
	@Override
	public int compareTo(Road o) {
		if (this.name.equals(o.name))
			return 0;
		else 
			return -1;
	}
	
	
}
