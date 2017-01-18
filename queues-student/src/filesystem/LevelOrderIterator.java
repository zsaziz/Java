package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.Arrays;
import structures.Queue;
import structures.UnboundedQueueInterface;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	
	private UnboundedQueueInterface<File> queue = new Queue<File>();
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		if (!rootNode.exists())
			throw new FileNotFoundException();
		queue.enqueue(rootNode);
	}
	
	@Override
	public boolean hasNext() {
		// TODO 2
		return !queue.isEmpty();
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		File [] arr;
		if (!hasNext())
			throw new NoSuchElementException();
		File temp = queue.dequeue();
		if (temp.isDirectory()){
			arr = temp.listFiles();
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++)
				queue.enqueue(arr[i]);
		}
		return temp;
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
