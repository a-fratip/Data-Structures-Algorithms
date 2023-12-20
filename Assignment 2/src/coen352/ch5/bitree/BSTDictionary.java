package coen352.ch5.bitree;
/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.lang.Comparable;

/** Binary Search Tree implementation for Dictionary ADT */
public class BSTDictionary<K extends Comparable<? super K>, E>
         implements ADTDictionary<K, E> {
  
  private BSTNode<K,E> root; // Root of the BST
  int nodecount;             // Number of nodes in the BST

  /** Constructor */
  public BSTDictionary() {
	  root = null; 
	  nodecount = 0;
  }
  
  public BSTNode<K,E> getRoot(){
	  return root;
  }

  /** Reinitialize tree */
  public void clear() { 
	  root = null; 
	  nodecount = 0; 
  }

  /** Insert a record into the tree.
      @param k Key value of the record.
      @param e The record to insert. */
  public void insert(K k, E e) {
    root = inserthelp(root, k, e);
    nodecount++;
  }
  private BSTNode<K,E> inserthelp(BSTNode<K,E> rt, K k, E e) {
	  if (rt == null) 
		  return new BSTNode<K,E>(k, e);
	  
	  if (rt.key().compareTo(k) > 0)
	    rt.setLeft(inserthelp(rt.left(), k, e)); // set of the left is to set to the root of the left subtree
	  else
	    rt.setRight(inserthelp(rt.right(), k, e));// set of the right is to set to the root of the right subtree
	  return rt;
	}

  /** Remove a record from the tree.
      @param k Key value of record to remove.
      @return Record removed, or null if there is none. */
  public E remove(K k) {
    E temp = findhelp(root, k);   // First find it
    if (temp != null) {
      root = removehelp(root, k); // Now remove it
      nodecount--;
    }
    return temp;
  }
  private E findhelp(BSTNode<K,E> rt, K k) {
	  
	  if (rt == null) 
		  return null;
	  if (rt.key().compareTo(k) > 0)
	    return findhelp(rt.left(), k);
	  else if (rt.key().compareTo(k) == 0) 
		  return rt.element();
	  else 
		  return findhelp(rt.right(), k);
	}


/** Remove a node with key value k
    @return The tree with the node removed */
private BSTNode<K,E> removehelp(BSTNode<K,E> rt, K k) {
  if (rt == null) 
	  return null;
  
  if (rt.key().compareTo(k) > 0)
    rt.setLeft(removehelp(rt.left(), k));
  else if (rt.key().compareTo(k) < 0)
    rt.setRight(removehelp(rt.right(), k));
  else { 
	  // Found it
    if (rt.left() == null)
      return rt.right();
    else if (rt.right() == null)
      return rt.left();
    else { // Two children
      BSTNode<K,E> temp = getmin(rt.right());
      rt.setElement(temp.element());
      rt.setKey(temp.key());
      rt.setRight(deletemin(rt.right()));
    }
  }
  return rt;
}

private BSTNode<K,E> deletemin(BSTNode<K,E> rt) {
	
	  //To remove a node, simple have the parent of the node to change
	  // its pointer to the point to the right child of the node; 
	  if (rt.left() == null)
	    return rt.right();
	  else {
	    rt.setLeft(deletemin(rt.left()));
	    return rt;
	  }
	}
private BSTNode<K,E> getmin(BSTNode<K,E> rt) {
  // The minimal must be at the left most of  BST, as the property of 
 // a BST. 
	
 /*
  *  This is the recursive version;
  */
 //	if (rt.left() == null)
 //     return rt;
 // else 
 //	  return getmin(rt.left());
	
	
	/*
	 * This is the non-recursive version; 
	 */
	BSTNode<K,E> temp = rt;
	
	while(temp.left()!=null)
		temp = temp.left();
	return temp;
  
}

private BSTNode<K,E> getmax(BSTNode<K,E> rt) {
	  // The minimal must be at the right most of  BST, as the property of 
	 // a BST. 
		
	  if (rt.right() == null)
	      return rt;
	  else 
		  return getmax(rt.right());
	  
	}


  private void printhelp(BSTNode<K,E> rt) {
    if (rt == null) return;
    
    printhelp(rt.left());
    
    printVisit(rt.element());
   
    printhelp(rt.right());
    
    
  }

  private StringBuffer out;

  public String toString() {
    out = new StringBuffer(100);
    printhelp(root);
    return out.toString();
  }
  private void printVisit(E it) {
    out.append(it + " ");
  }


  /** Remove and return the root node from the dictionary.
      @return The record removed, null if tree is empty. */
  public E removeAny() {
    if (root != null) {
      E temp = root.element();
      root = removehelp(root, root.key());
      nodecount--;
      return temp;
    }
    else return null;
  }

  /** @return Record with key value k, null if none exist.
      @param k The key value to find. */
  public E find(K k) { return findhelp(root, k); }

  /** @return The number of records in the dictionary. */
  public int size() { return nodecount; }

}
