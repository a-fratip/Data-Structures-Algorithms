package coen352.ch4.list;

/** Singly linked list node */
public class Link<E> {
	
	private E element; // Value for this node
	
	private Link<E> next; // Pointer to next node in list
	
	// Constructors
	public Link(E it, Link<E> nextval) { 
		element = it; 
		next = nextval; 
	}
	
	public Link(Link<E> nextval) { next = nextval; }
	
	
	//get /set values and link to the next node; 
	public Link<E> next() { return next; } // Return next field
	
	public Link<E> setNext(Link<E> nextval) // Set next field
	{ return next = nextval; } // Return element field
	
	public E element() { return element; } // Set element field
	
	public E setElement(E it) { return element = it; }
	
	
	
	/** Extensions to support freelists */
	static Link freelist = null; // Freelist for the class
	
	/** @return A new link */
	static <E> Link<E> get(E it, Link<E> nextval) {
		
		if (freelist == null)
			return new Link<E>(it, nextval); // Get from "new"
		
		Link<E> temp = freelist; // Get from freelist
		
		freelist = freelist.next();
		
		temp.setElement(it);
		temp.setNext(nextval);
		
		return temp;
	}
	
	
	/** Return a link to the freelist */
	void release() {
		element = null; // Drop reference to the element
		next = freelist;
		freelist = this;
	}
	
	
}
