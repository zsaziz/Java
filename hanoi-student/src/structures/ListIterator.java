package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListIterator<T> implements Iterator<T>{
	private Node<T> node;

	  public ListIterator(Node<T> node){
		  this.node = node;
	  }
  
	  public boolean hasNext() {
		 return node != null;
	  }

	  public T next() {
		  if(!hasNext())
			  throw new NoSuchElementException();
		  T value = node.getData();
		  node = node.getNext();
		  return value;
	  }

}
