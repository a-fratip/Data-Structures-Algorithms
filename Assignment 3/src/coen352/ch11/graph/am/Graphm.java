package coen352.ch11.graph.am;
import coen352.ch4.list.AList;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

class Graphm implements Graph { // Graph: Adjacency matrix
  private int[][] matrix;                // The edge matrix
  private int numEdge;                   // Number of edges
  public int[] Mark;                     // reflecting visited or not
  public int[] Count;					// count the nubmer of visits 
  public int[] Colors;					// color for different colors of a node
  
  public Graphm() {}
  public Graphm(int n) {                 // Constructor
    Init(n);
  }

  public void Init(int n) {
    Mark = new int[n];
    Count = new int[n];
    matrix = new int[n][n];
    numEdge = 0;
  }

  public int n() { return Mark.length; } // # of vertices

  public int e() { return numEdge; }     // # of edges
  
  
  public Integer[] getFanIn(int v) {
	
	 AList<Integer> fanInArray = new AList<Integer>();
	  
	 // needs to initalize the fanin elements with -1; 
	 for(int i=0;i<n();i++) {
		 if( matrix[i][v]==1) { // find one fan-in vertex; 
			 fanInArray.append(Integer.valueOf(i));
		 
		 }
	 }
	 
	 int size = fanInArray.length();
	 if(size != 0) {
		 Integer[] array =new Integer[size];
		 for(int i=0;i<fanInArray.length();i++) {
		 	 fanInArray.moveToPos(i);
			 array[i] = Integer.valueOf(fanInArray.getValue());
		 }
		 return array;
	 }
	 else
		 return null;
	  
  }

  public int first(int v) { // Get v's first neighbor
    for (int i=0; i<Mark.length; i++)
      if (matrix[v][i] != 0) return i;
    return Mark.length;  // No edge for this vertex
  }

  public int next(int v, int w) { // Get v's next edge
    for (int i=w+1; i<Mark.length; i++)
      if (matrix[v][i] != 0)
        return i;
    return Mark.length;  // No next edge;
  }
  
  @Override
  public int last(int v) {
  	for (int i=Mark.length-1; i>=0; i--)
  	      if (matrix[v][i] != 0) return i;
  	    return -1;  // No edge for this vertex
  }
  @Override
  public int rnext(int v, int w) {
	  for (int i=w-1; i>=0; i--)
	      if (matrix[v][i] != 0)
	        return i;
	    return -1;  // No next edge;
  }
  
  
  
  

  public boolean isEdge(int i, int j) // Is (i, j) an edge?
    { return matrix[i][j] != 0; }
  
  // Set edge weight
  public void setEdge(int i, int j, int wt) {
    assert wt!=0 : "Cannot set weight to 0";
    if (matrix[i][j] == 0) numEdge++;
    matrix[i][j] = wt;
  }

  public void delEdge(int i, int j) { // Delete edge (i, j)
    if (matrix[i][j] != 0) {
      matrix[i][j] = 0;
      numEdge--;
    }
  }

  public int weight(int i, int j) { // Return edge weight
    if (i == j) return 0;
    if (matrix[i][j] == 0) return Integer.MAX_VALUE;
    return matrix[i][j];
  }

 // Get and set marks
  public void setMark(int v, int val) { Mark[v] = val; }
  public int getMark(int v) { return Mark[v]; }
  
  public int incrCount(int w) {return ++Count[w];}
  
  public int getCount(int w) {return Count[w];}

}
