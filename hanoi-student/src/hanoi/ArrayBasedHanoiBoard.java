package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	
	/**
     * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
     * and {@code n} rings on peg 0.
     */
    private StackBasedHanoiPeg[] board = new StackBasedHanoiPeg[3];
    private StackBasedHanoiPeg fromPeg = new StackBasedHanoiPeg();
    private StackBasedHanoiPeg toPeg = new StackBasedHanoiPeg();
   
    public ArrayBasedHanoiBoard(int n) {
        if(n < 0)throw new IllegalArgumentException();
    	for (int i = 0; i < 3; i++)
    		board[i] = new StackBasedHanoiPeg();
        for(int i = n;i > 0;i--){
            board[0].addRing(new HanoiRing(i));
        }
    }
 
    @Override
    public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
        if (!isLegalMove(move)) {
            throw new IllegalHanoiMoveException("Could not perform illegal move.");
        }
        else{
            HanoiRing temp = fromPeg.remove();
            toPeg.addRing(temp);
        }
    }
 
    @Override
    public boolean isSolved() {
        return (!board[0].hasRings() && !board[1].hasRings());
    }
 
    @Override
    public boolean isLegalMove(HanoiMove move) {
        if(move == null)
        	throw new NullPointerException();
        
        int temp = move.getFromPeg();
        if (temp == 0)
        	fromPeg = board[0];
        else if (temp == 1)
        	fromPeg = board[1];
        else if (temp == 2)
        	fromPeg = board[2];
        
        temp = move.getToPeg();
        if (temp == 0)
        	toPeg = board[0];
        else if (temp == 1)
        	toPeg = board[1];
        else if (temp == 2)
        	toPeg = board[2];
        
        if(!fromPeg.hasRings() || move.getFromPeg()==move.getToPeg())
            return false;
        if(toPeg.hasRings())
            if(fromPeg.getTopRing().getSize()>toPeg.getTopRing().getSize())
                return false;
        return true;
    }
}
