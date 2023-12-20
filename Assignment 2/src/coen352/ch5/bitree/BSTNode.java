package coen352.ch5.bitree;
/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Binary tree node implementation: Pointers to children */
public class BSTNode<K,E> implements BinNode<E> {
  
  private K key;              // Key for this node
  private E element;          // Element for this node
  private BSTNode<K,E> left;  // Pointer to left child
  private BSTNode<K,E> right; // Pointer to right child

  /** Constructors */
  public BSTNode()
  {
	  left = right = null; 
  }
  
  public BSTNode(K k, E val)
  { 
	  left = right = null; 
	  key = k; 
	  element = val; 
  }
  
  public BSTNode(K k, E val, BSTNode<K,E> l, BSTNode<K,E> r) 
  { 
	  left = l; 
	  right = r; 
	  key = k; 
	  element = val; 
  }

  /** Return and set the key value */
  public K key() 
  { return key; }
  
  public void setKey(K k) 
  {   key = k; }

  /** Return and set the element value */
  public E element() 
  {  return element; }
  
  public void setElement(E v) { element = v; }

  /** Return and set the left child */
  public BSTNode<K,E> left() { return left; }
  public void setLeft(BSTNode<K,E> p) { left = p; }

  /** Return and set the right child */
  public BSTNode<K,E> right() { return right; }
  public void setRight(BSTNode<K,E> p) { right = p; }

  /** Return true if this is a leaf node */
  public boolean isLeaf()
  { return (left == null) && (right == null); }

@Override
	public int compareTo(E o) {
		
		return ((Comparable<E>) element).compareTo(o);
	}
}
