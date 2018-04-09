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

		for(int i = vertices.size(); i > 0; i--){
			if((vertices.get(i) == srcLabel) || (vertices.get(i) == tarLabel)){
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
			System.err.println(vertLabel + " does not exist);
			return neighbours;
		}

		for(int i = 0; i < edgeCount; i++){
			if(matrix.get(i).get(vertices.indexOf(vertLabel)){
				connection[i] = true;
			}else{
				connection[i] = false;
			}
		}	

		for(int i = 0; i < edgeCount; i++){
			if(connection[i]){
				for(int j = 0; j < vertices.size(); j++){
					if(matrix.get(i).get(j) && vertices.get(j) != vertLabel){
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
			if(matrix.get(i).get(vertices.indexOf(vertLabel)))
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
			if(matrix.get(i).get(vertices.indexOf(srcLabel)){
				if(matrix.get(i).get(vertices.indexOf(tarLabel)){
					matrix.remove(i)
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

		for(int i = 0; i < edgeCount; i++){
			for(int j = 0; j < vertices.size(); j++){
				if(matrix.get(i).get(j)){
					if(first){
						os.print(vertices.get(i) + " ");
						first = false;
					}else{
						os.println(vertices.get(i));
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
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix
