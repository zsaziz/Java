package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	
	private LLNode<T> head;
	private int size = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (size() <= 0)
			throw new StackUnderflowException();
		T temp = head.getData();
		head = head.getNext();
		size--;
		return temp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (size() <= 0)
			throw new StackUnderflowException();
		return head.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() <= 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		LLNode<T> temp = new LLNode<T>(elem);
		temp.setNext(head);
		head = temp;
		size++;
		
	}

}
