import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author Mohammad Dembele
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{
	private Graph graph = new Graph();
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try {
			Town t1 = new Town (town1);
			Town t2 = new Town (town2);
			
			graph.addEdge(t1, t2, weight, roadName);
		
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town t1 = new Town (town1);
		Town t2 = new Town (town2);
		return graph.getEdge(t1, t2).toString();
	}

	@Override
	public boolean addTown(String v) {
		try {
			return graph.addVertex(new Town(v));
		}
			catch (Exception e) {
				System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Town getTown(String name) {
		return new Town(graph.getVertex(new Town(name)));
		 
		
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		try {
			return graph.containsEdge(new Town(town1), new Town(town2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<Road> temp = graph.getRoads();
		ArrayList<String> a= new ArrayList<String>();
		for (Road r: temp ) {
			a.add(r.getName());
		}
	
		Collections.sort(a);
		return a;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		ArrayList<Road> temp = graph.getRoads();
		for (Road r: temp) {
			if(r.getName().equals(road)) {
				graph.removeEdge(r);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		try {
			ArrayList<Town> t = graph.getTowns();
			for(Town town:t) {
				if (town.getName().equals(v))
					graph.removeVertex(town);
				
			}
			
			return true;
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<Town> temp = graph.getTowns();
		ArrayList<String> a= new ArrayList<String>();
		for (Town t: temp ) {
			a.add(t.getName());
		}
	
		Collections.sort(a);
		return a;
		
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		try {
			ArrayList<String> path = graph.shortestPath(new Town(town1), new Town(town2));
			
			//If the distance is the maximum integer, no path exists and method terminates
			if (graph.getDistance(new Town(town2)) == Integer.MAX_VALUE) return null;
			
			//Because strings are immutable, create a return list and append the word " miles" 
			//to each String to indicate unit of measure
			ArrayList<String> returnPath = new ArrayList<>();
			for (String str : path) {
				returnPath.add(new String (str ));
			}
			
			//Finally, add a String for the total mileage
			String str = String.format("Total miles: %d miles", graph.getDistance(new Town(town2)));
			returnPath.add(str);
			
			return returnPath;
		}
		//If something goes wrong, return null
		catch (Exception e) {
			return null;
		}
	}

}
