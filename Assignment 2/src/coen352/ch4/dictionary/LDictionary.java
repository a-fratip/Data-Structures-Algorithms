package coen352.ch4.dictionary;

import org.junit.jupiter.api.Test;

import coen352.ch4.list.ADTList;
import coen352.ch4.list.*;

/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/



/** Dictionary implemented by unsorted list. */
public class LDictionary<Key, E> implements ADTDictionary<Key, E> {
	
	private static final int defaultSize = 100; // Default size
	
	private ADTList<Key> klist;
	private ADTList<E> vlist;
	
	
	/** Constructors */
	LDictionary() { 
		this(defaultSize); 
	}
	
	LDictionary(int sz){ 
		klist = new LList<Key>(sz);
		vlist = new LList<E>(sz);
	}
	
	/** Reinitialize */
	public void clear() { 
		klist.clear(); 
		vlist.clear();
	}
	
	
	
	public E find(Key k) {
		
		int currKeyPos = klist.currPos();
		int currValPos = vlist.currPos();
		
		int index = 0;
		E value;
		
		for (klist.moveToStart(); klist.currPos()<klist.length(); klist.next(),index++) {
		    if (k == klist.getValue()) {
		    	
		    	vlist.moveToPos(index);
		    	value = vlist.getValue();
		    	
		    	klist.moveToPos(currKeyPos);
				vlist.moveToPos(currValPos);
				
				return value;
		    }
		    	
		    
		}   	
		klist.moveToPos(currKeyPos);
		vlist.moveToPos(currValPos);
		return null;
	}
	
	public int findByKey(Key k) {
		int currKeyPos = klist.currPos();
		int currValPos = vlist.currPos();
		
		int index = 0;

		
		for (klist.moveToStart(); klist.currPos()<klist.length(); klist.next(),index++) {
		    if (k == klist.getValue()) {
		    	vlist.moveToPos(index);
		    	
		    	klist.moveToPos(currKeyPos);
				vlist.moveToPos(currValPos);
				return index;
		    }
		    	
		    
		}   	
		klist.moveToPos(currKeyPos);
		vlist.moveToPos(currValPos);
		return -1;
		
	}
	
	/** Find k using sequential search
	  @return Record with key value k 
	public E find(Key k) {
		
		int pos = klist.findByKey(k);
		
		if(pos<vlist.length()&&pos>=0) {
			vlist.moveToPos(pos);
			return vlist.getValue();
		}
		return null;
	}
	*/
	
	/** Insert an element: append to list */
	public void insert(Key k, E e) {
		
		//assert (find(k)!=null):"The dictionary has the key exists!";
		if(find(k)!=null) 
			return;
		klist.append(k);
		vlist.append(e);
	
			
	}
	
	/** Use sequential search to find the element to remove */
	public E remove(Key k) {
		E temp = find(k);
		int origin = klist.currPos();
		
		if (temp != null) {
			int pos = findByKey(k);
			
			klist.moveToPos(pos);
			vlist.moveToPos(pos);
			
			
			klist.remove();
			vlist.remove();
		}
		
		klist.moveToPos(origin);
		vlist.moveToPos(origin);
		return temp;
	}
	
	/** Remove the current element */
	public E removeAny() {
		
		if (size() != 0) {
		  klist.remove();
		  E temp = vlist.getValue();
		  vlist.remove();
		  return temp;
		}
		else 
			return null;
	}
	

	
	
	/** @return dictionary item size */
	public int size() { 
		return klist.length(); 
	}
	
	
	

	/** @return string representation of each item <key, value> per line or by tab space; */
	public String toString() {
		int origin = klist.currPos();
		StringBuffer out = new StringBuffer();
		assert (vlist.length()==klist.length()): "the dict is inconsistent";
		for(int i=0;i<klist.length();i++) {
			
			out.append(klist.getValue().toString());
			klist.next();
			
			out.append(":");
			
			out.append(vlist.getValue().toString());
			out.append(" , ");
			vlist.next();
		}
		
		klist.moveToPos(origin);
		vlist.moveToPos(origin);
		return out.toString().trim();
		
	}

	// Add a method to get all keys as an array
	@Override
	public ADTList<Key> getKeyList() { return klist; }
	@Override
	public ADTList<E> getValueList() { return vlist; }

	  /**
	  public int[] createDesendingIndex() {
			index = new int [klist.length()];
			// revise sorting algorithm to solve the right position of each record
			// according to if it is a ascending or descending order. 
			// the original record order must be reserved without any swap. 
			
			
			return index; 
			
			
		}
		*/
	
}