package core;

import java.util.*;


public class Rummikub {
	public static void main(String[] args) {
		
		//Start the Game
		System.out.println("hey man welcome to Rummikub");
		
		//-------------------------------------------------------------
		//FOR TESTING ONLY
		Table table = new Table();
		Player player = new Player();
		Player bot1 = new AI(1);
		Player bot2 = new AI(2);
		Player bot3 = new AI(3);
		
		table.registerObserver(player);
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		
		table.getPile().populate();
		table.getPile().shuffle();
		
		table.notifyObservers();
		
		player.drawHand();
		player.sortHand();
		bot1.drawHand();
		bot1.sortHand();
		bot2.drawHand();
		bot2.sortHand();
		bot3.drawHand();
		bot3.sortHand();
		
		
		while(table.getGameOver() == false) {

			player.doTurn();
			
			if(player.endTurn()) {
				player.pushToTable(table);
			}
			else {
				System.out.println("Invalid melds played.\n");
			}
			
			if(!table.getGameOver()) {
				((AI)bot1).doTurn();
				bot1.pushToTable(table);
			}
			
			if(!table.getGameOver()) {
				((AI)bot2).doTurn();
				bot2.pushToTable(table);
			}
			
			if(!table.getGameOver()) {
				((AI)bot3).doTurn();
				bot3.pushToTable(table);
			}
		}
		System.out.println("Game Over.");
	}
		
	
	public static int promptNumBotChoice(Scanner sc) {
	
		System.out.println("Choose number of bots: ");
		if(sc.hasNextLine()) {
			int userSelection = Integer.parseInt(sc.nextLine());
			return userSelection;
			}
			
			return -1;
	}
	
	public static int promptRunOrSetChoice() {
		System.out.println("Choose Run(1) or Set(2): ");
		Scanner runOrSet = new Scanner(System.in);
		int n = runOrSet.nextInt();
		runOrSet.close();
		return n;

	}
	
}
