import java.util.*;
import java.util.ArrayList;
/**
 * 
 * @author Mohammad Dembele
 *
 */
public class Graph implements GraphInterface<Town,Road> {
	
	
	private ArrayList<Town> Towns;
	private ArrayList<Road> Roads;
	
	private Town[] townArray;
	private int[] totalDistance;
	private int[][] roadArray;
	
	
	
	/**
	 * default constructor
	 */
	public Graph() {
		 Towns = new ArrayList<Town>();
		 Roads = new ArrayList<Road>();
	}
	/**
	 * @param sourceVertec - beginnign of edge
	 * @param destinationVertex - end of edge
	 * @return corresponding road
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		for (Road r: Roads) {
			if (r.getSource().compareTo(sourceVertex)==0 || r.getDestination().compareTo(sourceVertex)==0)
				if (r.getDestination().compareTo(destinationVertex)==0||r.getSource().compareTo(destinationVertex)==0)
				return r;
			
		}
        
        return null;
	}
	
	/**
	 * @param sourceVertec - beginnign of edge
	 * @param destinationVertex - end of edge
	 * @param weight - cost 
	 * @param description - name
	 * @return corresponding road
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws NullPointerException, IllegalArgumentException{
		/*Road r = new Road( sourceVertex, destinationVertex, weight, description);
		Road r1 =new Road(destinationVertex, sourceVertex, weight, description);
		if (!map.containsKey(sourceVertex)) {
			this.addVertex(sourceVertex);
		}
		if (!map.containsKey(destinationVertex)) {
			this.addVertex(destinationVertex);
		}
		map.get((Town)sourceVertex).add(r);
		map.get((Town)destinationVertex).add(r1);
		roads[verticies.indexOf(sourceVertex)][verticies.indexOf(destinationVertex)]= r;
		edges.add(r);
		addE(edges.indexOf(sourceVertex),edges.indexOf(destinationVertex),weight);
		
		return r;*/
		if (this.containsEdge(sourceVertex, destinationVertex)) throw new IllegalArgumentException(description + " already exists.");
		 if (sourceVertex.equals(destinationVertex)) throw new IllegalArgumentException("Source and destination can't be equal");
		 else if (sourceVertex == null || destinationVertex == null) throw new NullPointerException();
		 
		 else if (!(this.containsVertex(sourceVertex) && this.containsVertex(destinationVertex))) {
				throw new IllegalArgumentException("Town(s) not found in the graph");
			}
		 Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		 Road temp2 = new Road(sourceVertex, destinationVertex, weight, description);
		 Roads.add(temp);
		 return temp;
	}

	/**
	 * @param v - Vertex to be added
	 * @return true if successfully added, else false
	 */
	@Override
	public boolean addVertex(Town v) throws NullPointerException{
		if (v == null) throw new NullPointerException();
		if (this.containsVertex(v)) 
			return false;
		try {
			Towns.add(v);
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * @param sourceVertex - beginning of edge
	 * @param destinationVertex - end of edge
	 * @return true if endge is found 
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r : Roads) {
			if (r.equals(new Road(sourceVertex, destinationVertex, "name")))
				return true;
		}
		
		return false;
	}

	@Override
	/**
	 * @param v - vertex 
	 * @return true if vertex is found
	 */
	public boolean containsVertex(Town v) {
		//return Towns.contains(v);
		for (Town t: Towns) 
			if (t.equals(v))
				return true;
		
		return false;
	}

	/**
	 * @return set of edges in graph
	 */
	@Override
	public Set edgeSet() {
		//return  (Set)Roads;
		return new HashSet<Road>(Roads);
	}

	/**
	 * @param vertex 
	 * @return set of edges of vertex
	 */
	@Override
	public Set edgesOf(Town vertex) {
		if (!this.containsVertex(vertex)) 
			return null;
		Set temp = new HashSet<Road>();
		for (Road r:Roads)
			if (r.contains(vertex))
				temp.add(r);
		return temp;
	}

	/**
	 * @param sourceVertex
	 * @param destinationVertex
	 * @param weight - cost
	 * @param description - name
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		if (!(this.containsVertex(sourceVertex) || this.containsVertex(destinationVertex))) 
			return null;
		if (!this.containsEdge(sourceVertex, destinationVertex)) 
			return null;
		Road temp = null;
		for (Road r: Roads) {
        	if (r.getSource().equals(sourceVertex) &&r.getDestination().equals(destinationVertex)) {
        		temp =r;
        		
        	}
        }
		Roads.remove(temp);
		return temp;
    }

	/**removes a vertex v
	 * @param v - vertex to be removed
	 * @returns true if successfully removed
	 * 
	 */
	@Override
	public boolean removeVertex(Town v) {
		if (!this.containsVertex(v)) 
			return false;

		Set<Road> roadsOfV = edgesOf(v);
		
		Towns.remove(v);
		
		for (Road r : roadsOfV) {
			Roads.remove(r);
		}
		
		return true;
	}

	/**
	 * @returns a set of all vertices in graph
	 */
	@Override
	public Set vertexSet() {
		return new HashSet<Town>(Towns);
	}

	/**
	 * uses dijkstra algorithm to find shortest path (from destinaiton to source)
	 * @param sourceVertex
	 * @param destinationVertex
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
		//find path from destination
		ArrayList<Town> fromDestination = new ArrayList<>();
		ArrayList<String> reversePath = new ArrayList<String>();
		this.dijkstraShortestPath(sourceVertex);
		
		Town destination = getVertex(destinationVertex);
		fromDestination.add(destination);
		
		Town previousTown = destination.getPrevious();
		
		while (previousTown!=null) {
			fromDestination.add(previousTown);
			previousTown=previousTown.getPrevious();
		}
		for (int i=0; i<fromDestination.size()-1;i++) {
			reversePath.add(fromDestination.get(i).getPrevious().toString() + " via " + getEdge(fromDestination.get(i), fromDestination.get(i).getPrevious())
			+ " to " + fromDestination.get(i).toString() + " " 
			+ getEdge(fromDestination.get(i), fromDestination.get(i).getPrevious()).getWeight()+ " mi");
		}
		ArrayList<String> path = new ArrayList<String>();
		//flip path
	/*	for (int i = reversePath.size() - 1; i >= 0; i--) { 
            path.add(reversePath.get(i));
		}*/
		Collections.reverse(reversePath);
		return reversePath;
	}

	/**dijkstra algorithm   
	 * @param sourceVertex
	 * 
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		ArrayList<Town> visited = new ArrayList<>();
		ArrayList<Town> unvisited = new ArrayList<>(Towns);
		
		totalDistance = new int[Towns.size()];
		
		makeAdjacencyMatrix();
		int srcIndex=0;
		
		for (int i = 0; i < Towns.size(); i++) 
			totalDistance[i] = 123456;
		for (Town t: Towns)
			t.setPrevious(null);
		
		for (int i=0;i<Towns.size();i++)
			if (sourceVertex.equals(Towns.get(i)))
				srcIndex=i;
		totalDistance[srcIndex] = 0;
		
		for (int i = 0; i < townArray.length-1; i++) {
			int minIndex = getNextRoad(totalDistance, unvisited);
			visited.add(townArray[minIndex]);
			unvisited.remove(townArray[minIndex]);
			
			//Update distance array to reflect the added edge
			//If the distance array's value is still equal to MAX_VALUE, it will be updated
			//Otherwise, if this vertex's distance is less than the distance to the existing edge from source,
			//it will be updated
			// (note: this checks for existing edges before updating, so edges of 0 will not be overwritten)
			for (int j = 0; j < townArray.length; j++) {
				if (unvisited.contains(townArray[j]) && roadArray[minIndex][j] != 123456) {
					if (roadArray[minIndex][j] != 0) {
						if (totalDistance[minIndex] + roadArray[minIndex][j] < totalDistance[j]) {
							totalDistance[j] = totalDistance[minIndex] + roadArray[minIndex][j];
							
							//Set the Town's predecessor
							townArray[j].setPrevious(townArray[minIndex]);
						}
					}
				}
			}
			
		}
		}
	/**
	 * used in dijkstra to find next path w/ smallest cost
	 * @param distance
	 * @param unvisited
	 * @return
	 */
	private int getNextRoad(int[] distance, ArrayList<Town> unvisited) {
		if (unvisited.isEmpty()) 
			return -1; 
		
		int minDistance = 123456;
		int minIndex = -1;
		
		
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] < minDistance && unvisited.contains(townArray[i])) {
					minDistance = distance[i];
					minIndex = i;
			}
		}
	
		return minIndex;
		
	}
	
	
	private void makeAdjacencyMatrix(){
		townArray = Towns.toArray(new Town[Towns.size()]);
		roadArray = new int[townArray.length][townArray.length];
		
		for (Road r : Roads) {
			int i = -1;
			boolean found = false;
			while (!found && i < townArray.length) {
				i++;
				if (r.getSource().equals(townArray[i])) {
					found = true;
				}
			}
			int i1 = -1;
			found = false;
			while (!found && i < townArray.length) {
				i1++;
				if (r.getDestination().equals(townArray[i1])) {
					found = true;
				}
			}
			roadArray[i][i1] = r.getWeight();
			roadArray[i1][i] = r.getWeight();
		}
	}
	
public Town getVertex(Town v) {
		
		for (Town t : Towns) {
			if (t.equals(v)) 
				return t;
		}
		
		return null;
	}
public Road removeEdge(Town sourceVertex, Town destinationVertex, String description) {
	Road toRemove=null;
	for (Road r: Roads) {
		if (r.getName().equals(description))
			 toRemove = r;
			Roads.remove(r);
	}
	
	return toRemove;
}
public int getDistance(Town destination) {
		for (int i = 0; i < Towns.size(); i++) {
		if (Towns.get(i).equals(destination)){
			return totalDistance[i];
		}
	}
	return -1;
}
public ArrayList getTowns()
{	
	return Towns;
}
public ArrayList getRoads()
{	
	return Roads;
}
public boolean removeEdge (Road road) {
	
	if (!this.containsEdge(road.getSource(), road.getDestination()))
		return false;
	Roads.remove(road);
	return true;
}

	
}
