package coen352.ch4.queue;

import coen352.ch4.list.*;

public class DQueue<E> implements ADTQueue<E> {
	
	private DLink<E> front;    // Pointer to front queue node
	private DLink<E> rear;     // Pointer to rear queuenode
	int size;		    // Number of elements in queue
	
	/** Constructors */
	public DQueue() { init(); }
	
	
	/** Initialize queue */
	private void init() {
		
		front = new DLink<E>(null, null); // Create header node
		rear = new DLink<E>(front, null);
		front.setNext(rear);
		
	}
	
	/** Reinitialize queue */
	public void clear() { init(); }



	@Override
	public void enqueue(E it) {
		rear.prev().setNext(new DLink<E>(it,rear.prev(),rear ));
		rear.setPrev(rear.prev().next());
		++size;
		
	}

	@Override
	public E dequeue() {
		DLink<E> temp = front.next();
		E value = temp.element();
		front.next().next().setPrev(front);
		front.setNext(front.next().next());
		temp.setPrev(null);
		temp.setNext(null);
		--size;
		return value; 
	}

	@Override
	public E frontValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		
		return size;
	}
	
	/**
	* Generate a human-readable representation of this queue's contents
	* that looks something like this: < 1 2 3 >.
	* This method uses toString() on the individual elements.
	* @return The string representation of this queue
	*/
	public String toString()
	{
		StringBuffer out = new StringBuffer((length() + 1) * 4);
		out.append("< ");
		for (DLink<E> i = front.next(); i != rear; i = i.next()) {
		  out.append(i.element());
		  out.append(" ");
		}
		out.append(">");
		return out.toString();
	}
	
	
	

}
