package core;

import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.TestCase;

public class TestPlan extends TestCase{
	public static void main(String[] args) {
		System.out.println("Select Requirement: ");
		Scanner choice = new Scanner(System.in);
		int userSelection = -1;
		if(choice.hasNextInt()) {
			userSelection = choice.nextInt();
			}
		switch(userSelection) {
			case 1: R1();
			case 2: R2();
			case 3: R3();
			case 4: R4();
			case 5: R5();
			case 6: R6();
			case 7: R7();
			case 8: R8();
			case 9: R9();
			case 11: R10();
			case 10: R11();
			case 12: R12();
			case 13: R13();
			case 14: R14();
			case 15: R15();
			case 16: R16();
			case 17: R17();
			case 18: R18();
			case 19: R19();
			case 20: R20();
		}
		choice.close();
	}

	public static void test() {
		Table table = new Table();
		Player player = new Player();
		AI bot1 = new AI(1);
		AI bot2 = new AI(2);
		AI bot3 = new AI(3);
		
		table.registerObserver(player);
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();

		player.drawHand();
		
		bot1.drawHand();
		
		bot2.drawHand();
	
		bot3.drawHand();
			
			
			//6
			player.drawHand();
			int sizeBefore = player.getHand().size();
			player.pushToTable(table);
			int sizeAfter = player.getHand().size();
			assertTrue(sizeBefore + 1 == sizeAfter);
			
			//7
			bot1.addTile(new Tile(1,10));
			bot1.addTile(new Tile(1,11));
			bot1.addTile(new Tile(1,12));
			bot1.doTurn();
			
			//8
			
	}
	public static void R1() {
		Table table = new Table();
		Player player = new Player();
		AI bot1 = new AI(1);
		AI bot2 = new AI(2);
		AI bot3 = new AI(3);
		
		table.registerObserver(player);
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();

		player.drawHand();
		
		bot1.drawHand();
		
		bot2.drawHand();
	
		bot3.drawHand();
		
	}
	public static void R2() {
		Table table = new Table();
		Player player = new Player();
		AI bot1 = new AI(1);
		AI bot2 = new AI(1);
		AI bot3 = new AI(1);
		
		table.registerObserver(player);
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		player.drawHand();
		bot1.drawHand();
		bot2.drawHand();
		bot3.drawHand();
		
		player.doTurn();
		bot1.doTurn();
		bot2.doTurn();
		bot3.doTurn();
		
	}
	public static void R3() {}
	public static void R4() {
		
		Table table = new Table();
		Player player = new Player();
		AI bot1 = new AI(1);
		AI bot2 = new AI(2);
		AI bot3 = new AI(3);
		
		table.registerObserver(player);
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();

		player.drawHand();
		
		bot1.drawHand();
		
		bot2.drawHand();
	
		bot3.drawHand();
			
			//4a1
			assertTrue(!player.getStatus());
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,10));
				add(new Tile(2,10));
				add(new Tile(3,10));
				}}));
			assertTrue(player.getStatus());
			
			//4a2
			player.setStatus(false);
			assertTrue(!player.getStatus());
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,11));
				add(new Tile(2,11));
				add(new Tile(3,11));
				}}));
			assertTrue(player.getStatus());
			
			//4b1
			player.setStatus(false);
			assertTrue(!player.getStatus());
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,5));
				add(new Tile(2,5));
				add(new Tile(3,5));
				}}));
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,5));
				add(new Tile(2,5));
				add(new Tile(3,5));
				}}));
			assertTrue(player.getStatus());

			//4b2
			player.setStatus(false);
			assertTrue(!player.getStatus());
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,10));
				add(new Tile(2,10));
				add(new Tile(3,10));
				}}));
			player.playMeld(new Set(new ArrayList<Tile>() {{
				add(new Tile(1,10));
				add(new Tile(2,10));
				add(new Tile(3,10));
				}}));
			assertTrue(player.getStatus());
			
			//4c
			player.doTurn();
			player.hand.clear();
			player.pushToTable(table);
			assertTrue(table.getGameOver());
			player.setGameOver(false);
	}
	
	public static void R5() {}
	public static void R6() {}
	public static void R7() {
		Table table = new Table();
		Player player = new Player();
		
		table.registerObserver(player);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		player.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(1,11));
			add(new Tile(1,12));
			}}));
		
	}
	public static void R8() {
		Table table = new Table();
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		Player player5 = new Player();
		
		int tableSize = table.getMelds().size();
		
		table.registerObserver(player1);
		table.registerObserver(player2);
		table.registerObserver(player3);
		table.registerObserver(player4);
		table.registerObserver(player5);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		//Run
		player1.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(1,11));
			add(new Tile(1,12));
			}}));
		
		player1.pushToTable(table);
		
		assertTrue(table.getMelds().size() == tableSize + 1);
		
		//Set
		tableSize = table.getMelds().size();
		player2.playMeld(new Set(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(2,10));
			add(new Tile(3,10));
			}}));
		
		player2.pushToTable(table);
		assertTrue(table.getMelds().size() == tableSize +1);
		
		//Several Runs
		tableSize = table.getMelds().size();
		player3.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(1,11));
			add(new Tile(1,12));
			}}));
		
		player3.playMeld(new Run(new ArrayList<Tile>() {{			
			add(new Tile(2,10));
			add(new Tile(2,11));
			add(new Tile(2,12));
			}}));
		
		player3.pushToTable(table);
		assertTrue(table.getMelds().size() == tableSize +2);
		
		//Several Sets
		tableSize = table.getMelds().size();
		player4.playMeld(new Set(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(2,10));
			add(new Tile(3,10));
			}}));
		
		player4.playMeld(new Set(new ArrayList<Tile>() {{
			add(new Tile(2,11));
			add(new Tile(3,11));
			add(new Tile(4,11));
			}}));
		
		player4.pushToTable(table);
		assertTrue(table.getMelds().size() == tableSize +2);
		
		//A mix of Runs & Sets
		tableSize = table.getMelds().size();
		player5.playMeld(new Set(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(2,10));
			add(new Tile(3,10));
			}}));
		
		player5.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(2,10));
			add(new Tile(2,11));
			add(new Tile(2,12));
			}}));
		
		player5.pushToTable(table);
		assertTrue(table.getMelds().size() == tableSize +2);


	}
	public static void R9() {
		Table table = new Table();
		
		Player player = new Player();
		
		table.registerObserver(player);
	
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		player.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(2,11));
			add(new Tile(3,12));
			}}));
		
		player.playMeld(new Run(new ArrayList<Tile>() {{
			add(new Tile(1,10));
			add(new Tile(2,11));
			add(new Tile(3,12));
			}}));
		
	}
	
	public static void R10() {
		Table table = new Table();
		
		AI bot1 = new AI(1);
		AI bot2 = new AI(1);
		AI bot3 = new AI(1);
		
		table.registerObserver(bot1);
		table.registerObserver(bot2);
		table.registerObserver(bot3);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		bot1.addTile(new Tile(4,1));
		bot2.addTile(new Tile(4,1));
		bot3.addTile(new Tile(4,1));
		
		int tableSize1;
		int tableSize2;
		
		//10a
		System.out.println("10a");
		bot1.addTile(new Tile(1,10));
		bot1.addTile(new Tile(1,11));
		bot1.addTile(new Tile(1,12));
		tableSize1 = table.getMelds().size();
		bot1.doTurn();
		bot1.pushToTable(table);
		tableSize2 = table.getMelds().size();
		assertTrue(tableSize1 + 1 == tableSize2);
		
		//10b
		System.out.println("10b");
		bot2.addTile(new Tile(1,10));
		bot2.addTile(new Tile(1,11));
		bot2.addTile(new Tile(1,12));
		bot2.addTile(new Tile(1,10));
		bot2.addTile(new Tile(1,11));
		bot2.addTile(new Tile(1,12));
		bot2.doTurn();
		bot2.pushToTable(table);
		
		//10c
		System.out.println("10c");
		bot1.addTile(new Tile(1,10));
		bot1.addTile(new Tile(1,11));
		bot1.addTile(new Tile(1,12));
		bot1.doTurn();
		bot1.pushToTable(table);
		
		//10d
		System.out.println("10d");
		bot1.addTile(new Tile(1,10));
		bot1.addTile(new Tile(1,11));
		bot1.addTile(new Tile(1,12));
		bot1.addTile(new Tile(1,10));
		bot1.addTile(new Tile(1,11));
		bot1.addTile(new Tile(1,12));
		bot1.doTurn();
		bot1.pushToTable(table);
		
		//10e
		System.out.println("10e");
		bot3.addTile(new Tile(1,1));
		bot3.doTurn();
		bot3.pushToTable(table);
		
		//10f
		System.out.println("10f");
		bot3.doTurn();
		bot3.pushToTable(table);
	}

	public static void R11() {}
	
	public static void R12() {}
	public static void R13() {}
	public static void R14() {}

	public static void R15() {
		Table table = new Table();
		Player p1 = new Player();
		AI bot = new AI(2);
		
		table.registerObserver(p1);
		table.registerObserver(bot);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile(1,10));
		tiles.add(new Tile(2,10));
		tiles.add(new Tile(3,10));
		
		Set run = new Set(tiles);
		
		p1.addTile(new Tile(1,1));
		p1.playMeld(run);
		p1.pushToTable(table);
		
		int initial = table.getMelds().size();
		
		//15b
		bot.addTile(new Tile(1,10));
		
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		assertTrue(initial == table.getMelds().size());
		
		//15a
		bot.addTile(new Tile(1,11));
		bot.addTile(new Tile(1,12));
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		assertTrue(initial == table.getMelds().size());
	}
	public static void R16() {}
	public static void R17() {}
	public static void R18() {}

	public static void R19() {}
	public static void R20() {}
	
}