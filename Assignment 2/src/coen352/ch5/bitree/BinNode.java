/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

package coen352.ch5.bitree; 

/** ADT for binary tree nodes */
public interface BinNode<E> extends Comparable<E>{
  /** Return and set the element value */
  public E element();
  public void setElement(E v);

  /** Return the left child */
  public BinNode<E> left();

  /** Return the right child */
  public BinNode<E> right();

  /** Return true if this is a leaf node */
  public boolean isLeaf();
}
