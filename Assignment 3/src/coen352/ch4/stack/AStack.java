package coen352.ch4.stack;

import coen352.ch4.list.*;

public class AStack<E> implements ADTStack<E> {


	/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/



  private static final int defaultSize = 10;

  private int maxSize;            // Maximum size of stack
  private int top;                // Index for top Object
  private E [] listArray;         // Array holding stack
  private ADTList<E> list; 

  /** Constructors */
  public AStack() { this(defaultSize); }
  @SuppressWarnings("unchecked") // Generic array allocation

  public
  AStack(int size) {
    maxSize = size;
    top = 0; 
    listArray = (E[])new Object[size];   // Create listArray
    
    list = new DList();
  }

  /** Reinitialize stack */
  public void clear() { top = 0; }

  /** Push "it" onto stack */
  public void push(E it) {
    assert top != maxSize : "Stack is full";
    listArray[top] = it;
    ++top; 
  }

  /** Remove and top element */
  public E pop() {
    assert top != 0 : "Stack is empty";
    E value = listArray[--top];
    
    return value;
  }

  /** @return Top element */
  public E topValue() {
    assert top != 0 : "Stack is empty";
    return listArray[top-1];
  }

  /** @return Stack size */
  public int length() { return top; }

// Extra stuff not printed in the book.

  /**
   * Generate a human-readable representation of this stack's contents
   * that looks something like this: < 1 2 3 >.
   * This method uses toString() on the individual elements.
   * @return The string representation of this stack
   */
  public String toString()
  {
    StringBuffer out = new StringBuffer((length() + 1) * 4);
    out.append("< ");
    for (int i = top-1; i >= 0; i--) {
      out.append(listArray[i]);
      out.append(" ");
    }
    out.append(">");
    return out.toString();
  }
}