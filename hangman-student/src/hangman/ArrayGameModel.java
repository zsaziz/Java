package hangman;

/**
 * The Array implementation of the GameModel interface.
 */
public class ArrayGameModel implements GameModel {
	/** The number of characters (lower/upper). */
	private static final int ALPHABET_COUNT = 26*2;
	
	private String word;
	
	private char [] guesses = new char[ALPHABET_COUNT];
	private int guessesCount = 0;
	public char [] correctGuesses;
	
	public int count = 0;
	
	/** hung state */
	private int		state;
	
	/**
	 * Creates a new ArrayGameModel object.
	 * 
	 *  guessWord the word to guess
	 */
	public ArrayGameModel(String guessWord) {
		// TODO (1)
		state    = STARTING_STATE;
		word = guessWord;
		correctGuesses = new char[word.length()];
	}
		
	public boolean isPriorGuess(char guess) {
		// TODO (2)
		
		for (int i = 0; i < guesses.length; i++){
			if (guesses[i] == guess)
				return true;
		}
		
		return false;
	}
	
	public int numberOfGuesses() {
		// TODO (3)
		return count;
	}
	
	public boolean isCorrectGuess(char guess) {
		// TODO (4)
		boolean found = false;
		for (int i = 0; i < word.length(); i++){
			if (guess == word.charAt(i)){
				correctGuesses[i] = guess;
				found = true;
			}
		}
		if(found == false)
			state++;
		return found;
	}
	
	public boolean doMove(char guess) {
		// TODO (5)
		if (isPriorGuess(guess) == true){
			return false;
		}
		
		if ((guess >= 'a' && guess <= 'z') || (guess >= 'A' && guess <= 'Z')){
			guesses[guessesCount] = guess;
			guessesCount++;
			count++;
			return (isCorrectGuess(guess));
		}
		return false;
	}

	public boolean inWinningState() {
		// TODO (6)
		for (int i = 0; i < word.length();i++){
			if (correctGuesses[i] != word.charAt(i))
				return false;
		}
		return true;
	}

	public boolean inLosingState() {
		// TODO(7)
		
		if(state == NUMBER_OF_STATES)
			return true;
		return false;
	}
	
	public String toString() {
		char [] words = new char[(word.length()*2) - 1];
		int j = 1;
		for (int i = 0; i < words.length; i+=2){
			words[i] = '_';
			if (j < words.length)
				words[j] = ' ';
			j+=2;
		}
		int k = 0;
		for (int i = 0;i<words.length;i+=2){
			if (correctGuesses[k] != 0){
				words[i] = correctGuesses[k];
			}
			k++;
		}
		String s = new String(words);
		return s;
	}

	public String previousGuessString() {
		String s = "";
		s = "[";
		if (guesses[0] != 0){
			int i = 0;
			while (guesses[i] != 0){
				s = s + guesses[i] + ", ";
				i++;
			}
		}
		String newString = "";
		if (s.length() == 1)
			newString = s + "]";
		else{
			newString = s.substring(0, (s.length() - 2));
			newString = newString + "]";
			
		}
		 
		// TODO (9)
		
		return newString;
	}
	
	public int getState() {
		return state;
	}

	public String getWord() {

		// TODO (10)

		return word;
	}
  
}
