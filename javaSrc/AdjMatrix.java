import java.io.*;
import java.util.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
    	// Implement me!!
    } // end of AdjMatrix()
    
    
    public void addVertex(T vertLabel) {
        // Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    			boolean[] visited = new boolean[vertices.size()];
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

			if(vertex == vertLabel2){
				return distance;
			}
			
			visited[vertices.indexOf(vertex)] = true;

			for(int i = 0; i < vertices.size(); i++){
				if(matrix.get(vertices.indexOf(vertex)).get(i)){
					if(!visited[i]){		
						vertQueue.add(vertices.get(i));
						distQueue.add(distance + 1);
					}			
				}
			}
		}
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix
