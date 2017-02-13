package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	private LinkedStack<HanoiRing> peg = new LinkedStack<HanoiRing>();

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (ring == null)
			throw new NullPointerException();
		if (hasRings()){
			if (ring.getSize() >= getTopRing().getSize())
				throw new IllegalHanoiMoveException("Ring argument is not smaller than current ring");
		}
		peg.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (!hasRings())
			throw new IllegalHanoiMoveException("No rings");
		return peg.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (!hasRings())
			throw new IllegalHanoiMoveException("No rings");
		return peg.peek();
	}

	@Override
	public boolean hasRings() {
		return !peg.isEmpty();
	}
}
