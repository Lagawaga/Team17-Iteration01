package core;

import junit.framework.TestCase;

public class StrategyOnePlaysTest extends TestCase{

	public void test() {
		Table table = new Table();
		AI bot = new AI(1);
		AI bot2 = new AI(1);
		
		table.registerObserver(bot);
		table.registerObserver(bot2);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		int initial = table.getMelds().size();
		//p2 should play a run
		
		bot.addTile(new Tile(1,4));
		bot.addTile(new Tile(1,10));
		bot.addTile(new Tile(1,11));
		bot.addTile(new Tile(1,12));
		bot.addTile(new Tile(1,1));
		bot.addTile(new Tile(1,8));
		bot.addTile(new Tile(1,9));
		bot.addTile(new Tile(1,10));
		
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		assertTrue(initial + 2 == table.getMelds().size());
		
		initial = table.getMelds().size();
		
		bot.addTile(new Tile(1,1));
		bot.addTile(new Tile(1,2));
		bot.addTile(new Tile(1,3));
		bot.addTile(new Tile(1,5));
		bot.addTile(new Tile(1,7));
		bot.addTile(new Tile(1,4));
		bot.addTile(new Tile(1,5));
		bot.addTile(new Tile(1,6));
		bot.addTile(new Tile(4,1));
		bot.addTile(new Tile(4,2));
		bot.addTile(new Tile (4,3));
		

		
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		//AI should be able to (and actually) play 2 melds
		assertTrue(initial + 3 == table.getMelds().size());
		
		initial = table.getMelds().size();

		bot2.addTile(new Tile(3,10));
		bot2.addTile(new Tile(1,10));
		bot2.addTile(new Tile(4,10));
		bot2.addTile(new Tile(4,10));
		bot2.addTile(new Tile(3,10));
		bot2.addTile(new Tile(2,10));
		
		bot2.addTile(new Tile(3,11));
		//bot2.addTile(new Tile(1,11));
		bot2.addTile(new Tile(4,11));
		bot2.addTile(new Tile(4,11));
		bot2.addTile(new Tile(3,11));
		//bot2.addTile(new Tile(2,11));
		
		bot2.addTile(new Tile(1,9));
		bot2.addTile(new Tile(1,10));
		bot2.addTile(new Tile(1,11));
		bot2.addTile(new Tile(2,1));
		
		((AI)bot2).doTurn();
		((AI)bot2).pushToTable(table);
		
		//System.out.println(initial);
		System.out.println(" @: " + table.getMelds().size());
		
		assertTrue(table.getMelds().size() == initial + 2 );
		
		
	}

}
