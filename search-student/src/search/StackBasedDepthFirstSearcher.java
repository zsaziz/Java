package search;

import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> findSolution() {
		// TODO
		SearchProblem<T> searchProblem = super.searchProblem;
        T current = searchProblem.getInitialState();
        Stack<T> runtimeStack = new Stack<T>();
        runtimeStack.push(current);
        while (!runtimeStack.isEmpty()) {
                visited.add(runtimeStack.peek());
            boolean deadend = true;
            for (T elem : searchProblem.getSuccessors(runtimeStack.peek())) {
                if (!visited.contains(elem)) {
                        runtimeStack.push(elem);
                    deadend = false;
                    break;
                    }
                }
           
                if (deadend)
                        runtimeStack.pop();
                       
                if (searchProblem.isGoal(runtimeStack.peek())) {
                         if (!isValidSolution(runtimeStack)) {
                                 throw new RuntimeException("searcher should never find an invalid solution!");
                         }
                         return runtimeStack;
                 }
 
         }
         return runtimeStack;
        
	}
}
