package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {
	private Node<T> head;
	private Node<T> tail;
	private int count = 0;
	
	public Queue() {
		// TODO 1
		head = null;
		tail = null;
	}
	
	public Queue(Queue<T> other) {
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		Queue<T> temp = other;
		Node<T> curr = other.head;
		while (!(curr == null)){
			this.enqueue(curr.getInfo());
			curr = curr.getLink();
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		return count == 0;
	}

	@Override
	public int size() {
		// TODO 4
		return count;
	}

	@Override
	public void enqueue(T element) {
		Node<T> temp = new Node<T>(element);
		if (isEmpty()){
			head = temp;
			tail = temp;
			count++;
		}
		else{
			tail.setLink(temp);
			tail = temp;
			count++;
		}
		// TODO 5;
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		if (isEmpty())
			throw new NoSuchElementException();
		Node<T> temp = head;
		head = head.getLink();
		count--;
		return temp.getInfo();
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if (isEmpty())
			throw new NoSuchElementException();
		return head.getInfo();
	}

	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		if (!isEmpty()){
			T temp = dequeue();
			reversed();
			enqueue(temp);
		}
		return this;
	}
}
