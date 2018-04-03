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
	ArrayList<ArrayList<Boolean>> matrix;
	ArrayList<T> vertices;

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
		matrix = new ArrayList<ArrayList<Boolean>>();
		vertices = new ArrayList<T>();
    	// Implement me!!
    } // end of AdjMatrix()
    
    
    public void addVertex(T vertLabel) {
		if(vertices.indexOf(vertLabel) != -1){
			return; //yeah yeah	
		}
			
		matrix.add(new ArrayList<Boolean>());

		for(int i = 0; i < vertices.size(); i++){
			matrix.get(i).add(false);
		}

		for(int i = 0; i <= vertices.size(); i++){
			matrix.get(vertices.size()).add(false);
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
		
		matrix.get(vertices.indexOf(srcLabel)).set(vertices.indexOf(tarLabel), true);		
		matrix.get(vertices.indexOf(tarLabel)).set(vertices.indexOf(srcLabel), true);
		
        // Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
		
		if(vertices.indexOf(vertLabel) == -1){
			System.err.println(vertLabel + " does not exist");
			return neighbours;		
		}

		for(int i = 0; i < vertices.size(); i++){
			if(matrix.get(vertices.indexOf(vertLabel)).get(i)){
				neighbours.add(vertices.get(i));
			}        
        }
		// Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
		if(vertices.indexOf(vertLabel) == -1){
			System.err.println(vertLabel + "does not exist");
			return;
		}
		
		for(int i = 0; i < vertices.size(); i++){
			matrix.get(i).remove(vertices.indexOf(vertLabel));
		}

		matrix.remove(vertices.indexOf(vertLabel));

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
		
		matrix.get(vertices.indexOf(srcLabel)).set(vertices.indexOf(tarLabel), false);		
		matrix.get(vertices.indexOf(tarLabel)).set(vertices.indexOf(srcLabel), false);
     // Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        
        for(int i = 0; i < vertices.size(); i++)
        {
        	os.print(vertices.indexOf(i) + " ");
        }
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix
