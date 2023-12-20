package coen352.ch4.list;

/** Linked list implementation */
public class LList<E> implements ADTList<E> {
	
	private Link<E> head; // Pointer to list header
	
	private Link<E> tail; // Pointer to last element
	
	protected Link<E> curr; // Access to current element
	
	private int cnt; // length of list
	
	/** Constructors */
	public LList(int size) { this(); } // Constructor -- Ignore size
	
	public LList() {
		curr = tail = head = new Link<E>(null); // Create header
		cnt = 0;
	}
	
	/** Remove all elements */
	public void clear() {
		head.setNext(null); // Drop access to links
		curr = tail = head = new Link<E>(null); // Create header
		cnt = 0;
	}
	
	/** Insert "it" at current position */
	public void insert(E it) {
		
		//w/o using freelist
		//curr.setNext(new Link<E>(it, curr.next()));

			
		 //Using freelist support
		curr.setNext(Link.get(it, curr.next()));
		
		if (tail == curr) 
			tail = curr.next(); // New tail
		cnt++;
	}
	
	/** Append "it" to list */
	public void append(E it) {
		tail = tail.setNext(new Link<E>(it, null));
		cnt++;
	}
	
	/** Remove and return current element */
	public E remove() {
		//if (curr.next() == null) 
		if (head.next() ==null)
			return null; // Nothing to remove
		
		E it = curr.next().element(); // Remember value
		
		if (tail == curr.next()) 
			tail = curr; // Removed last
		
	    //Using freelist
		Link<E> tempptr = curr.next();
		curr.setNext(tempptr.next());
		tempptr.release(); 
		
		//Link<E> templink = curr.next().next(); 
		//curr.setNext(templink); // Remove from list
		
		
		cnt--; // Decrement count
		return it; // Return value
	}
	
	/** Set curr at list start */
	public void moveToStart()
	{ curr = head; }
	
	/** Set curr at list end */
	public void moveToEnd()
	{ curr = tail; }
	
	/** Move curr one step left; no change if now at front */
	public void prev() {
		if (curr == head) return; // No previous element
		Link<E> temp = head;
		// March down list until we find the previous element
		while (temp.next() != curr) 
			temp = temp.next();
		curr = temp;
	}
	
	/** Move curr one step right; no change if now at end */
	public void next(){ 
		if (curr != tail) curr = curr.next(); 
	}
	
	/** @return List length */
	public int length() { return cnt; }
	
	/** @return The position of the current element */
	public int currPos() {
		Link<E> temp = head;
		int i;
		for (i=0; curr != temp; i++)
		temp = temp.next();
		return i;
	}
	
	/** Move down list to "pos" position */
	public void moveToPos(int pos) {
		assert (pos>=0) && (pos<=cnt) : "Position out of range";
		curr = head;
		int i = 0;
		while(i<pos) {
			curr = curr.next();
			i++;
		}
		
	}
	
	/** @return Current element value */
	public E getValue() {
		if(curr.next() == null) return null;
		return curr.next().element();
	}
	
	
	@Override
	public void setValue(E val) {
		
		curr.next().setElement(val);
		
	}
	
	// Extra stuff not printed in the book.

	  /**
	   * Generate a human-readable representation of this list's contents
	   * that looks something like this: < 1 2 3 | 4 5 6 >.  The vertical
	   * bar represents the current location of the fence.  This method
	   * uses toString() on the individual elements.
	   * @return The string representation of this list
	   */
	  public String toString()
	  {
	    // Save the current position of the list
	    int oldPos = currPos();
	    int length = length();
	    StringBuffer out = new StringBuffer((length() + 1) * 4);

	    moveToStart();
	    out.append("< ");
	    for (int i = 0; i < oldPos; i++) {
	      out.append(getValue());
	      out.append(" ");
	      next();
	    }
	    out.append("| ");
	    for (int i = oldPos; i < length; i++) {
	      out.append(getValue());
	      out.append(" ");
	      next();
	    }
	    out.append(">");
	    moveToPos(oldPos); // Reset the fence to its original position
	    return out.toString();
	  }

	@Override
	public E getValue(int pos) {
		
		
		int origin = this.currPos();
		this.moveToStart();
		for(int i=0;i<pos;i++) {
			this.next();
		}
		
		E temp = this.getValue();
		this.moveToPos(origin);
		return temp;
		
		
	}

	@Override
	public int find(E e) {
		
		int origin = this.currPos();
		this.moveToStart();
		int pos =0;
		for(; pos<this.length(); pos++) {
			if(this.getValue()==e) {
				break;
			}
			this.next();
		}
		this.moveToPos(origin);
		return pos;
	}


	  


}
