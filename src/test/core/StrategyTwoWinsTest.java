package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class StrategyTwoWinsTest extends TestCase{

	public void test() {
		Table table = new Table();
		Player p = new Player();
		AI bot = new AI(2);
		
		table.registerObserver(p);
		table.registerObserver(bot);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		//p2 should play a run and win the game even if the run is not 30+
		p.drawHand();
		ArrayList<Tile> t = new ArrayList<Tile>();
		t.add(new Tile(1,10));
		t.add(new Tile(2,10));
		t.add(new Tile(3,10));
		Set set = new Set(t);
		p.playMeld(set);
		p.pushToTable(table);
		
		bot.addTile(new Tile(1,4));
		bot.addTile(new Tile(1,5));
		bot.addTile(new Tile(1,6));
		
		assertTrue(!table.getGameOver());
		
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		assertTrue(table.getGameOver());
		
	}

}
