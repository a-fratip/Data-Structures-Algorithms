package coen352.ch4.dictionary;

/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Container class for a key-value pair */
class KVpair<Key, E> implements Comparable<KVpair>{
	private Key k;
	private E e;
	
	/** Constructors */
	KVpair() { 
		k = null; 
		e = null;
	}
	
	KVpair(Key kval, E eval) { 
		k = kval; 
		e = eval; 
	}
	
	/** Data member access functions */
	public Key key() { return k; }
	
	public E value() { return e; }

	@Override
	public int compareTo(KVpair o) {
		// define the compareTo behavior according to the 
	    // return  this.value().toString().compareTo(o.value().toString());
		//return 0;
		if (this.value() instanceof Comparable && o.value() instanceof Comparable) {
			// Both values are of a Comparable type (e.g., Integer, Double, String)
			return ((Comparable<E>) this.value()).compareTo((E) o.value());
		}
		else if (this.value().getClass() == o.value().getClass()) {
			// Both values are of the same non-Comparable type (custom objects)
			return this.value().toString().compareTo(o.value().toString());
		}
		else {
			// Values are of different types, and we cannot directly compare them
			// order them based on their type names.
			return this.value().getClass().getName().compareTo(o.value().getClass().getName());
		}
	}

	public String toString(){
		return(k.toString() + ": " + e.toString() + ", ");
	}


}