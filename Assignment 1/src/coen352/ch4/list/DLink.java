package coen352.ch4.list;

/** Doubly linked list node */
public class DLink<E> {
	
	private E element; // Value for this node	
	private DLink<E> next; // Pointer to next node in list	
	private DLink<E> prev; // Pointer to previous node
	
	/** Constructors */
	public DLink(E it, DLink<E> p, DLink<E> n){ 
		element = it; 
		prev = p; 
		next = n; 
	}
	
	public DLink(DLink<E> p, DLink<E> n) { 
		prev = p; 
		next = n; 
	}
	
	static private DLink pool = null; 
	public static<E> DLink<E> get(E value, DLink<E> pre, DLink<E>next){
		if(pool == null)
			return new DLink<E>(value, pre, next);		
		DLink<E> temp = pool; 
		pool = pool.next();
		temp.setElement(value);
		temp.setPrev(pre);
		temp.setNext(next);
		return temp; 	
	}
	
	
	public void release() {
		this.element = null; 
		this.next = pool; 
		this.prev = null; 
		pool = this; 
		
	}
	
	/** Get and set methods for the data members */
	public DLink<E> next() { return next; }
	
	public DLink<E> setNext(DLink<E> nextval)
	{ return next = nextval; }
	
	public DLink<E> prev() { return prev; }
	
	public DLink<E> setPrev(DLink<E> prevval)
	{ return prev = prevval; }
	
	public E element() { return element; }
	
	public E setElement(E it) { return element = it; }
	
	
}