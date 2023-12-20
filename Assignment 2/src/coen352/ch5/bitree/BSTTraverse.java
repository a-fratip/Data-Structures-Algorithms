package coen352.ch5.bitree;

import coen352.ch4.queue.*;

public class BSTTraverse {
	
	
	static private StringBuffer out = new StringBuffer();
	
	public static void clear() {
		//if(!out.isEmpty())
		if (out.length() != 0)
			out.delete(0, out.length());
	}
	// Stick this in to test the preorder routine
	static void visit (BinNode X) 
	{
	  out.append(X.element());
	  out.append(" ");
	}
	
	
	public static void preorderTraverse(BinNode rt)
	{
		  if (rt == null) 
			  return; // Empty subtree

		  visit(rt);
		  preorderTraverse(rt.left());
		  preorderTraverse(rt.right());
		  
	}
	
	
	public static void inorderTraverse(BinNode rt) {
		if (rt == null) 
			  return; // Empty subtree
		
		inorderTraverse(rt.left());
		visit(rt);
		inorderTraverse(rt.right());
		
	}
	
	public static void postorderTraverse(BinNode rt) {
		if (rt == null) 
			  return; // Empty subtree

		postorderTraverse(rt.left());
		  
		postorderTraverse(rt.right());
		  
		visit(rt);
		
	}
	
	
	public static int getHeight(BinNode rt) {
		
		int level =0; 
		if(rt == null)
			return 0; 
		
		if(rt.left()!=null)
			level = getHeight(rt.left());
		
		if(rt.right()!=null) {
			int right = getHeight(rt.right());
			if(level<right)
				level = right;
		}
		
		return ++level;
	}
	
	static int getLeavesCount(BinNode root) 
	{ 
	    if (root == null) 
	    	return 0; 
	  
	    int res = 0; 
	    if (root.left() == null && root.right() == null) 
	    	res++; 
	  
	    res += (getLeavesCount(root.left()) + getLeavesCount(root.right())); 
	    return res; 
	} 
	
	
	public static void levelorder(BinNode rt)
	{
		
		ADTQueue<BinNode> queue = new LQueue<BinNode>();
		queue.enqueue(rt);
	       
	    while (queue.length()>0) {
	        BinNode tempNode = queue.dequeue();
	            visit(tempNode);
	            /*Enqueue left child */
	            if (tempNode.left() != null) {
	                queue.enqueue(tempNode.left());
	            }
	 
	            /*Enqueue right child */
	            if (tempNode.right() != null) {
	                queue.enqueue(tempNode.right());
	            }
	      }
	  }
	
	
	
	public static void depthFirstTraverse(BinNode rt) // rt is the root of the subtree
	{
	  if (rt == null) 
		  return; // Empty subtree
	  
	  depthFirstTraverse(rt.left());
	  visit(rt);
	  depthFirstTraverse(rt.right());
	}
	
	public static void breathFirstTraverse(BinNode rt)
	{
	  
	  visit(rt);
	  if (rt.left() != null) 
		  breathFirstTraverse(rt.left());
	  if (rt.right() != null) 
		  breathFirstTraverse(rt.right());
	}
	
	static int count(BinNode rt) {
	  if (rt == null) 
		  return 0;  // Nothing to count
	  return 1 + count(rt.left()) + count(rt.right());
	}
	
	
	
	
	
	static boolean checkBST(BSTNode root,
	                 Integer low, Integer high) 
	{
	  if (root == null) 
		  return true; // Empty subtree
	  Integer rootkey = (Integer) root.key();
	  
	  if ((rootkey < low) || (rootkey > high))
	    return false; // Out of range
	  
	  if (!checkBST(root.left(), low, rootkey))
	    return false; // Left side failed
	  
	  return checkBST(root.right(), rootkey, high);
	}
	
	public static String print() {
		return out.toString();
	}
	
	
	

	
}
