package com.ade.estructures;

public class LinkedList<T> implements LinkedListOperations<T>{
	
	private Node<T> firstElement;
	private int weight;
	
	public LinkedList() {
		this.firstElement = null;
		this.weight = 0;
	}

	public Node<T> getFirstElement() {
		return firstElement;
	}

	public int getWeight() {
		return weight;
	}
	
	public boolean isEmpty() {
		if(firstElement == null) {
			return true;
		}else {
			return false;
		}
	}

	public void addLast(T element) {
		if(firstElement == null) {
			firstElement = new Node<T>(element, null);
			weight++;
		}else {
			Node<T> head = firstElement;
			Node<T> currentLast = head;
			while(head!=null) {
				currentLast = head;
				head = head.getNext();
			}
			Node<T> newNode = new Node<T>(element, currentLast);
			currentLast.setNext(newNode);
			weight++;
		}
	}

	public void remove(T element) {
		if(!isEmpty()) {
			
		}
	}

}
