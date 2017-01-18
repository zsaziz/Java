package stacks;

public class LinkedListStack<T> implements Stack<T> {
    LLNode<T> head;

    public LinkedListStack() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;






	


	
	
    }
    
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty())
        	throw new StackUnderflowException();
    	T temp = head.getInfo();
        head = head.getLink();
        return temp;





	


	

	
    }

    @Override
    public T peek() throws StackUnderflowException {
        return head.getInfo();





	



	


	
    }

    @Override
    public void push(T element) {
    	LLNode<T> temp = new LLNode<T>(element);
    	temp.setLink(head);
    	head = temp;


	






	
    }


}
