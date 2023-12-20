package coen352.ch07;


import java.io.*;
import java.lang.*;
import java.util.*;
import coen352.ch4.list.*;
 


public class LListMergeSort {
	  // Function to merge sort
	
	static Link mergeSort(Link head)
    {
        if (head.next() == null)
            return head;
 
        Link mid = findMid(head);
        Link head2 = mid.next();
        mid.setNext(null);
        Link newHead1 = mergeSort(head);
        Link newHead2 = mergeSort(head2);
        Link finalHead = merge(newHead1, newHead2);
 
        return finalHead;
    }
	
	
	
    // Function to merge two linked lists
    static Link merge(Link head1, Link head2)
    {
        Link merged = new Link(null);
        Link temp = merged;
       
        // While head1 is not null and head2
        // is not null
        while (head1 != null && head2 != null) {
            if ( ((Comparable<Integer>) head1.element()).compareTo((Integer)head2.element())<0 ) {
                temp.setNext(head1);
                head1 = head1.next();
            }
            else {
                temp.setNext(head2);
                head2 = head2.next();
            }
            temp = temp.next();
        }
       
        // While head1 is not null
        while (head1 != null) {
            temp.setNext(head1);
            head1 = head1.next();
            temp = temp.next();
        }
       
        // While head2 is not null
        while (head2 != null) {
            temp.setNext(head2);
            head2 = head2.next();
            temp = temp.next();
        }
        return merged.next();
    }
	

    // Find mid using The Tortoise and The Hare approach
    static Link findMid(Link head)
    {
        Link slow = head, fast = head.next();
        while (fast != null && fast.next() != null) {
            slow = slow.next();
            fast = fast.next().next();
        }
        return slow;
    }
 

    
    // Function to print list
    static void printList(Link head)
    {
        while (head != null) {
            System.out.print(head.element().toString() + " ");
            head = head.next();
        }
    }
    
    // Function to print list
    static String toString(Link head)
    {
    	 StringBuffer out = new StringBuffer();
    	
    	
        while (head != null) {
            out.append(head.element().toString() + " ");
            head = head.next();
        }
        
        return out.toString();
    }
    
    


    public static void main(String[] args)
    {
        Link head = new Link(7,null);
        Link temp = head;
        temp.setNext(new Link(10,null));
        temp = temp.next();
        temp.setNext(new Link(5,null));
        temp = temp.next();
        temp.setNext(new Link(20,null));
        temp = temp.next();
        temp.setNext (new Link(3,null));
        temp = temp.next();
        temp.setNext(new Link(2,null));
        temp = temp.next();
 
        // Apply merge Sort
        head = mergeSort(head);
        System.out.print("\nSorted Linked List is: \n");
        printList(head);
    }
    
}
