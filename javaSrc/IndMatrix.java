import java.io.*;
import java.util.*;


/**
 * Incidence matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class IndMatrix <T extends Object> implements FriendshipGraph<T>
{
	ArrayList<ArrayList<Boolean>> matrix;
	ArrayList<T> vertices;
	int edgeCount;
		
	/**
	 * Contructs empty graph.
	 */
    public IndMatrix() {
		matrix = new ArrayList<ArrayList<Boolean>>();
		vertices = new ArrayList<T>();
		edgeCount = 0;
    	// Implement me!
    } // end of IndMatrix()
    
    
    public void addVertex(T vertLabel) {
		if(vertices.indexOf(vertLabel) != -1){
			return;
		}

		for(int i = 0; i < edgeCount; i++){
			matrix.get(i).add(false);
		}

		vertices.add(vertLabel);
        // Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
		if(vertices.indexOf(srcLabel) == -1){
			System.err.println(srcLabel + " does not exist");
			return;
		}
	
		if(vertices.indexOf(tarLabel) == -1){
			System.err.println(tarLabel + " does not exist");
			return;
		}

		matrix.add(new ArrayList<Boolean>());

		for(int i = 0; i < vertices.size(); i++){
			if((vertices.get(i).equals(srcLabel)) || (vertices.get(i).equals(tarLabel))){
				matrix.get(edgeCount).add(true);
			}else{
				matrix.get(edgeCount).add(false);
			}
		}

		edgeCount++;
			
        // Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
		boolean[] connection = new boolean[edgeCount];
		
		if(vertices.indexOf(vertLabel) == -1){
			System.err.println(vertLabel + " does not exist");
			return neighbours;
		}

		for(int i = 0; i < edgeCount; i++){
			if(matrix.get(i).get(vertices.indexOf(vertLabel))){
				connection[i] = true;
			}else{
				connection[i] = false;
			}
		}	
	
		for(int i = 0; i < edgeCount; i++){
			if(connection[i]){
				for(int j = 0; j < vertices.size(); j++){
					if(matrix.get(i).get(j) && !(vertices.get(j).equals(vertLabel))){
						neighbours.add(vertices.get(j));
						j = vertices.size();
					}
				}
			}
		}
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
		if(vertices.indexOf(vertLabel) == -1){
			System.err.println(vertLabel + " does not exist");
			return;
		}

		for(int i = 0; i < edgeCount; i++){
			if(matrix.get(i).get(vertices.indexOf(vertLabel))){
				matrix.remove(i);
				edgeCount--;
				i--;
			}else{
				matrix.get(i).remove(vertices.indexOf(vertLabel));
			}
		}

		vertices.remove(vertLabel);

		
        // Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {

		if(vertices.indexOf(srcLabel) == -1){
			System.err.println(srcLabel + " does not exist");
			return;
		}

		if(vertices.indexOf(tarLabel) == -1){
			System.err.println(tarLabel + " does not exist");
			return;
		}

		for(int i = 0; i < edgeCount; i++){
			if(matrix.get(i).get(vertices.indexOf(srcLabel))){
				if(matrix.get(i).get(vertices.indexOf(tarLabel))){
					matrix.remove(i);
					edgeCount--;
					return;
				}
			}
		}	
		
        // Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
		for(int i = 0; i < vertices.size(); i++){
			os.print(vertices.get(i) + " ");
		}
		os.println();
        // Implement me!
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
		boolean first = true;
		int temp = 0;
		
		for(int i = 0; i < edgeCount; i++){
			for(int j = 0; j < vertices.size(); j++){
				if(matrix.get(i).get(j)){
					if(first){
						first = false;
						temp = j;
					}else{
						os.println(vertices.get(temp) + " " + vertices.get(j));
						os.println(vertices.get(j) + " " + vertices.get(temp));
						first = true;
						j = vertices.size();
					}
				}
			}
		}
        // Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
	boolean[] visited = new boolean[vertices.size()];
	boolean[] connection = new boolean[edgeCount];
	Queue<T> vertQueue = new LinkedList<T>();
	Queue<Integer> distQueue = new LinkedList<Integer>();
	T vertex;
	int distance;

	for(int i = 0; i < vertices.size(); i++){
		visited[i] = false;
	}

	vertQueue.add(vertLabel1);
	distQueue.add(0);

	while(vertQueue.peek() != null){
		vertex = vertQueue.remove();
		distance = distQueue.remove();

		if(vertex.equals(vertLabel2)){
			return distance;
		}

		visited[vertices.indexOf(vertex)] = true;

		for(int i = 0; i < edgeCount; i++){
			if(matrix.get(i).get(vertices.indexOf(vertex))){
				connection[i] = true;
			}else{
				connection[i] = false;
			}
		}	
	
		for(int i = 0; i < edgeCount; i++){
			if(connection[i]){
				for(int j = 0; j < vertices.size(); j++){
					if(matrix.get(i).get(j) && !(vertices.get(j).equals(vertex))){
						if(!visited[j]){
							vertQueue.add(vertices.get(j));
							distQueue.add(distance + 1);
							j = vertices.size();
							
						}
					}
				}
			}
		}
	}
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix
