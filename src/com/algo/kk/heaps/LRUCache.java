package com.algo.kk.heaps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class DLLNode {
		int key;
		int value;
		DLLNode prev;
		DLLNode next;
		public DLLNode(int key, int value){
	        this.key = key;
	        this.value = value;
	    }
	}
	
	
	
	int capacity;
	Map<Integer,DLLNode> map = new HashMap<Integer, DLLNode>();
	DLLNode head = null, tail= null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
    }
	
	public void remove(DLLNode n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
 
    }
	
	public void setHead(DLLNode n){
        n.next = head;
        n.prev = null;
 
        if(head!=null)
            head.prev = n;
 
        head = n;
 
        if(tail ==null)
            tail = head;
    }
	
    public int get(int key) {
    	if(map.containsKey(key)){
            DLLNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)) {
    		DLLNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
    	} else {
    		DLLNode created = new DLLNode(key, value);
    		if(map.size()==this.capacity){
    			DLLNode deleted = map.remove(tail.key);
    			remove(deleted);
    		}   			
    		setHead(created);
    		map.put(key, created);
    	}
    }
    
	public static void main(String[] args) {
		

	}

}
