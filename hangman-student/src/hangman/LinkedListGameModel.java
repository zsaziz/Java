package hangman;

public class LinkedListGameModel implements GameModel {
    int state = 0;
    int count = 0;
    private String word;
    private char guess;
    LLCharacterNode guessList;
    LLCharacterNode board;
    LLCharacterNode last;
   
    public LinkedListGameModel(String guessWord){
        word = guessWord;
        LLCharacterNode newBoard = new LLCharacterNode('_');
        for(int i=0; i < guessWord.length(); i++){ 
            newBoard.setLink(newBoard);
            board = newBoard;
        }
       
       
    }

    public boolean isPriorGuess(char guess) {
        boolean guessCheck = false;
        if(guessList != null){
            for(int i = 0; i < word.length(); i++){
                if(guess == guessList.getInfo()){
                    guessCheck = true;
                }
                else {
                    guessList.getLink();
                }
            }
        }
        else {
            guessCheck = false;
        }
        return guessCheck;
    }
 
    public int numberOfGuesses() {
        return count;
    }
 
    public boolean isCorrectGuess(char guess) {
        for(int i = 0; i < word.length(); i ++){
            if(guess == word.charAt(i)){
                return true;
            }
        }      
       
        return false;
    }

    public boolean doMove(char guess) {
        boolean moveCheck = false;
        if(isPriorGuess(guess) == true){
            return false;
        }
        if(isPriorGuess(guess) == false){
            addToPrevious(guess);
            moveCheck = true;
        }
        if(isCorrectGuess(guess) == false){
            count++;
            state += 1;
            return false;
        }
        if(isCorrectGuess(guess) == true){
            count++;
            addToBoard(guess);
            moveCheck = true;
        }
       
        return moveCheck;
    }
 
    public boolean inWinningState() {
        if(board != null){
            for(int i = 0; i < word.length(); i++){
                if(board.getInfo() != word.charAt(i)){
                    return false;
                }
                else {
                    board.getLink();
                }
            }
        }
        return true;
    }

    public boolean inLosingState() {
        if(state == 10){
            return true;
        }
        else {
            return false;
        }
       
    }

    public String toString() {
        LLCharacterNode temp = board;
        String s = "";
        for(int i = 0; i < word.length(); i++){
            s += temp.getInfo() + " ";
            temp = temp.getLink();
        }
       
        return s;
    }
   
    public int getState() {
        return state;
    }

    public String previousGuessString() {
        String s = "";
        String y = "";
        LLCharacterNode temp = guessList;
        if(guessList != null){ 
            for(int i = 0; i < count; i++){
                    s += " ," + temp.getInfo();
                    temp = temp.getLink();
            }  
        }
        s = s.substring(1, (s.length()));
        for(int j= s.length()-1; j >0; j--){
            y = y + s.charAt(j);
        }
        y = "[" + y + "]";
               
        return y;
    }
 
    public String getWord() {
        return word;
    }
   
    public void addToBoard(char guess){
        //adds guess to board if correct, points from doMove
        LLCharacterNode temp = board;
        LLCharacterNode temp2 = board;
        if(temp.getInfo() == '_'){ 
            for(int i = 0; i < word.length(); i++){
                if(guess == word.charAt(i)){
                    temp.setInfo(word.charAt(i));
                    break;
                }
                break;
            }          
        }
        if(temp != null){
            for(int i = 0; i < count; i++){
                if(temp.getInfo() == ' '){
                    board.setInfo('_');
                }
            }
        }
    }
   
    public void addToPrevious(char guess){
        LLCharacterNode temp = new LLCharacterNode(guess);
        if(guessList == null){
            guessList = temp;
        }
        if(guessList != null){
            temp.setLink(guessList);
            guessList = temp;
        }
    }
   
}