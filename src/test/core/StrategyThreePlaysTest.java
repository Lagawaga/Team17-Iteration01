package core;


import junit.framework.TestCase;

public class StrategyThreePlaysTest extends TestCase{
	
	public void testUnderThirty() {
		Table table = new Table();
		Player p1 = new Player();
		AI bot = new AI(3);
		
		table.registerObserver(p1);
		table.registerObserver(bot);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		int initial = table.getMelds().size();
		
		//bot should do nothing should do nothing since it doesn't have 30pts to play yet 
		bot.addTile(new Tile(1,1));
		bot.addTile(new Tile(2,2));
		bot.addTile(new Tile(3,3));
		
		((AI)bot).doTurn();
		bot.pushToTable(table);
		
		assertTrue(initial == table.getMelds().size());
	}
	
	public void testWinGame() {
		Table table = new Table();
		Player p1 = new Player();
		AI bot = new AI(3);
		
		table.registerObserver(p1);
		table.registerObserver(bot);
		table.notifyObservers();
		table.getPile().populate();
		table.getPile().shuffle();
		
		p1.addTile(new Tile(2,9));
		p1.addTile(new Tile(3,5));
		p1.addTile(new Tile(4,1));
		p1.pushToTable(table);
		
		bot.addTile(new Tile(1,1));
		bot.addTile(new Tile(1,2));
		bot.addTile(new Tile(1,3));
		bot.addTile(new Tile(2,5));
		bot.addTile(new Tile(2,6));
		bot.addTile(new Tile(2,7));
		
		((AI)bot).doTurn();
		((AI)bot).pushToTable(table);
		
		assertTrue(bot.getHand().size() == 0);
		
		
	}
		
	
	
	public void testThreeFewer(){
			Table table = new Table();
			Player p1 = new Player();
			AI bot = new AI(3);
			
			table.registerObserver(p1);
			table.registerObserver(bot);
			table.notifyObservers();
			table.getPile().populate();
			table.getPile().shuffle();
			
			p1.addTile(new Tile(2,9));
			p1.addTile(new Tile(3,5));
			p1.addTile(new Tile(4,1));
			p1.pushToTable(table);
			
			bot.addTile(new Tile(1,9));
			bot.addTile(new Tile(1,10));
			bot.addTile(new Tile(1,11));
			bot.addTile(new Tile(2,9));
			bot.addTile(new Tile(2,10));
			bot.addTile(new Tile(2,11));
			bot.addTile(new Tile(4,1));
			
			((AI)bot).doTurn();
			((AI)bot).pushToTable(table);
			
			//bot should play all possible melds since p1 has 3 fewer tiles
			assertTrue(bot.getHand().size() == 1);
		}	
	}

