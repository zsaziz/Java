package search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	
	private List<T> path;
	
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		path = new LinkedList<T>();
	}

	@Override
	public List<T> findSolution() {
		// TODO
		SearchProblem<T> searchProblem = super.searchProblem;
        Queue<T> runtimeQueue = new LinkedList<T>();
        T current = searchProblem.getInitialState();
       
        runtimeQueue.add(current);
        while (!runtimeQueue.isEmpty()) {
        	current = runtimeQueue.remove();
        	path.add(current);
        	visited.add(current);
       
        	List<T> neighbors = searchProblem.getSuccessors(current);
        	int i = 0;
        	int count = 0;
        	while (i != neighbors.size()) {
                T temp = neighbors.get(i);
                if (!visited.contains(temp) && !runtimeQueue.contains(temp)) {
                	runtimeQueue.add(temp);
                	count++;
                	}
                i++;
        	}
        if(neighbors.isEmpty() || count == 0)
        	path.remove(current);
        if(searchProblem.isGoal(current))
        	return path;
        }

        if(!searchProblem.isGoal(runtimeQueue.peek()))
        	return new LinkedList<T>();

        if (path.size() > 0) {
        	if (!isValidSolution(path))
            throw new RuntimeException("searcher should never find an invalid solution!");
        }

        return path;
	}
}
