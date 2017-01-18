package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;

public class Game {
	
	private Map<String, Integer> scoreKeep = new HashMap<String, Integer>();
	
	private Scanner scan = new Scanner(System.in);
	
	private int noPlayers;
	
	private int turnPoints;
	
	private List<String> players = new ArrayList<String>();
	
	private List<Integer> farkleCount = new ArrayList<Integer>();
	
	private int winPoints = 1000;
	
	public String rules() {
		return ("\nEach player takes turns rolling the dice. On your turn, you roll all six dice. A 1 or a 5, or three of a kind earn points.\n" + 
		"You must select at least one scoring die.\n" +
		"You can then pass and bank your points, or risk the points earned this turn and roll the remaining dice.\n" +
		"If none of your dice rolled earn points, you get a Farkle. Three Farkles in a row and you lose 1,000 points.\n" +
		"First player to reach 10,000 points wins!\n\n" +
		"1            - 100 pts\n" +
		"5            -  50 pts\n" +
		"Three 1's    - 300 pts\n" +
		"Three 2's    - 200 pts\n" +
		"Three 3's    - 300 pts\n" +
		"Three 4's    - 400 pts\n" +
		"Three 5's    - 500 pts\n" +
		"Three 6's    - 600 pts\n");
	}
	
	public void menu() {
		System.out.println("Choose an option\n\n1. Play\n2. Rules");
		String ans = scan.nextLine();
		if (ans.equals("1")) play();
		else if (ans .equals("2")) {
			System.out.println(rules());
			menu();
		}
		else {
			System.out.println("Please choose 1 or 2\n");
			menu();
		}
	}
	
	public List<Integer> roll(int x){
		List<Integer> dice = new LinkedList<Integer>();
		for (int i = 0; i < x; i++){
			dice.add((int)(Math.random()*6) + 1);
		}
		System.out.println("You got: " + dice.toString());
		return dice;
	}
	
	public boolean triple(List<Integer> dice, int search){
		int count = 0;
		for (int x: dice){
			if (x == search) count ++;
			if (count >= 3)
				return true;
		}
		return false;
	}
	
	public boolean validMove(List<Integer> dice){
		if ((dice.contains(1) == false && dice.contains(5) == false) && (triple(dice, 2) == false
				&& triple(dice, 3) == false && triple(dice, 4) == false && triple(dice, 6) == false))
				return false;
		return true;
	}
	
	public void points(List<Integer> dice, int i, int count){
		if (validMove(dice) == false){
			System.out.println("That's a Farkle!\n");
			turnPoints = 0;
			return;
		}
		System.out.println("Enter the number you want to remove or enter pass to pass your turn");
		String point = scan.nextLine();
		if (point.equals("pass") && count == 0){
			System.out.println("You must remove at least one scoring die");
			points(dice, i, count);
		}
		else if(point.equals("pass") && count != 0){
			System.out.println("You passed your turn");
			scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
			turnPoints = 0;
			return;
		}
		else if (point.equals("1")){
			if (dice.remove((Integer)1)){
			turnPoints = turnPoints + 100;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("5")){
			if (dice.remove((Integer)5)){
			turnPoints = turnPoints + 50;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("111")){
			if (triple(dice, 1)){
				dice.remove((Integer)1); dice.remove((Integer)1); dice.remove((Integer)1);
				turnPoints = turnPoints + 300;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("222")){
			if (triple(dice, 2)){
				dice.remove((Integer)2); dice.remove((Integer)2); dice.remove((Integer)2);
				turnPoints = turnPoints + 200;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("333")){
			if (triple(dice, 3)){
				dice.remove((Integer)3); dice.remove((Integer)3); dice.remove((Integer)3);
				turnPoints = turnPoints + 300;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("444")){
			if (triple(dice, 4)){
				dice.remove((Integer)4); dice.remove((Integer)4); dice.remove((Integer)4);
				turnPoints = turnPoints + 400;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("555")){
			if (triple(dice, 5)){
				dice.remove((Integer)5); dice.remove((Integer)5); dice.remove((Integer)5);
				turnPoints = turnPoints + 500;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else if (point.equals("666")){
			if (triple(dice, 6)){
				dice.remove((Integer)6); dice.remove((Integer)6); dice.remove((Integer)6);
				turnPoints = turnPoints + 600;
				if (dice.size() == 0){
					System.out.println("You cleared all dice! Do you want to roll again or pass?");
					String ans = scan.nextLine();
					if (ans.equals("pass")){
						scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
						turnPoints = 0;
						return;
					}
					else{
						points(roll(6), i, 0);
					}
				}
				else{
					if (validMove(dice)){
						points(dice, i, count + 1);
					}
					else{
						System.out.println("Enter roll to roll again or pass to pass your turn");
						String x = scan.nextLine();
						if (x.equals("pass")){
							scoreKeep.put(players.get(i), scoreKeep.get((players.get(i))) + turnPoints);
							turnPoints = 0;
							return;
						}
						else{
							points(roll(dice.size()), i, 0);
						}
					}
				}
			}
			else{
				System.out.println("You did not roll this number. Try again");
				points(dice, i, count);
			}
		}
		else{
			System.out.println("Invalid number. Try again");
			points(dice, i, count);
		}
	}
	
	private void checkFarkle(int index){
		if (farkleCount.get(index) == 3){
			System.out.println("That's your third Farkle in a row. You lose 1000 points");
			scoreKeep.put(players.get(index), scoreKeep.get((players.get(index))) - 1000);
			farkleCount.set(index, 0);
		}
	}
	
//	private boolean checkWinner(){
//		List<String> winners = new ArrayList<String>();
//		for (int i = 0; i < scoreKeep.size(); i++){
//			if (scoreKeep.get(players.get(i)) >= winPoints){
//				winners.add(players.get(i));
//			}
//		}
//	}
	
	public void play() {
		System.out.print("Choose the number of players: ");
		noPlayers = Integer.parseInt(scan.nextLine());
		while (noPlayers > 6 || noPlayers < 2){
			System.out.println("Invalid number. Farkle may be played by 2-6 players.");
			System.out.print("Choose the number of players: ");
			noPlayers = Integer.parseInt(scan.nextLine());
		}
		
		System.out.print("How many points do you need to win? ");
		winPoints = Integer.parseInt(scan.nextLine());
		while (winPoints < 1000){
			System.out.println("Invalid number. Minimum points must be 1000");
			System.out.print("How many points do you need to win? ");
			winPoints = Integer.parseInt(scan.nextLine());
		}
		
		System.out.println("Enter a name for each player");
		for (int i = 1; i <= noPlayers; i++){
			System.out.print("Player " + i + ": ");
			String name = scan.nextLine();
			players.add(name);
			farkleCount.add(0);
			scoreKeep.put(name, 0);
		}
		
		System.out.println("\nLet's start");
		for (int i = 0; i < noPlayers; i++){
			System.out.println(players.get(i) + "'s turn!");
			System.out.println("Type 'roll' to roll the dice");
			String input = scan.nextLine();
			if (input.equals("end")){
				System.out.println("You ended the game");
				break;
			}
			List<Integer> dice = roll(6); 
			if (validMove(dice) == false){
				System.out.println("That's a Farkle!\n");
				farkleCount.set(i, farkleCount.get(i) + 1);
				checkFarkle(i);
				System.out.println(players.get(i) + "'s score: " + scoreKeep.get(players.get(i)) + "\n");
			}
			else{
				points(dice, i, 0);
				System.out.println(players.get(i) + "'s score: " + scoreKeep.get(players.get(i)) + "\n");
				dice = null;
			}
			if (i == noPlayers - 1){
				for (int x = 0; x < players.size(); x++){
					System.out.println(players.get(x) + "'s score: " + scoreKeep.get(players.get(x)));
				}
				System.out.print("\n");
				i = -1;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Farkle!\n\n");
		Game x = new Game();
		x.menu();
	}

}