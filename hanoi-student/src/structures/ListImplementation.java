package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T>{
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	public ListImplementation(){
	}
	
	public ListImplementation(Node<T> head){
		this.head = head;
	}

	public ListImplementation(T elem){
		this.head = new Node<T>(elem, null);
		tail = head;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public T get(int n) throws NoSuchElementException {
		// TODO Auto-generated method stub
		T element = null;
		if (n >= size())
			throw new NoSuchElementException();
		if (n < 0)
			throw new NoSuchElementException();
		int count = 0;
		Iterator<T> iter = iterator();
		while (iter.hasNext()){
			if (count == n)
				return iter.next();
			iter.next();
			count++;
		}
		return element;
	}

	@Override
	public ListInterface<T> append(T elem) {
		// TODO Auto-generated method stub
		if (elem == null)
			throw new NullPointerException();
		Node<T> temp = new Node<T>(elem,null);
		if (isEmpty()){
			head = temp;
			tail = temp;
			size++;
			return this;
		}
		tail.setNext(temp);
		tail = temp;
		size++;
		return this;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>(this.head);
	}
	
}
