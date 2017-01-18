package hangman;

public class LLCharacterNode {
	 private char info;
	 private LLCharacterNode link;
	 public LLCharacterNode(char info) {
	 this.info = info;
	 link = null;
	 }
	 public char getInfo() { return info; }
	 public LLCharacterNode getLink() { return link;}
	 public void setInfo(char i) { info = i; }
	 public void setLink(LLCharacterNode lk) {
	 link = lk;
	 }
	}
