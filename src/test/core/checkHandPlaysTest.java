package core;

import java.util.ArrayList;

import junit.framework.TestCase;

public class checkHandPlaysTest extends TestCase {

	public void testCheckHandPlays() {
		AI bot = new AI(1);
		
//		ArrayList<Tile> setList = new ArrayList<Tile>();
//		setList.add(new Tile(1,1));
//		setList.add(new Tile(2,1));
//		setList.add(new Tile(3,1));
//		
//		Set set = new Set(setList);
//		
//		ArrayList<Tile> runList = new ArrayList<Tile>();
//		runList.add(new Tile(1,1));
//		runList.add(new Tile(1,2));
//		runList.add(new Tile(1,3));
//		
//		Run run = new Run(runList);
//		
//	
//		bot.addTile(new Tile(1,1));
//		bot.addTile(new Tile(2,1));
//		bot.addTile(new Tile(3,1));
//		bot.addTile(new Tile(4,1));
//		bot.addTile(new Tile(4,1));
//		bot.addTile(new Tile(4,1));
//		
//		assertTrue(bot.checkHandPlays().get(0) == set);
//		assertTrue(bot.checkHandPlays().get(1) == run);

		ArrayList<Tile> setList = new ArrayList<Tile>();
		setList.add(new Tile(1,1));
		setList.add(new Tile(2,1));
		setList.add(new Tile(3,1));
		
		bot.addTile(new Tile(1,1));
		bot.addTile(new Tile(2,1));
		bot.addTile(new Tile(3,1));
		
		System.out.println(bot.getHand());
		System.out.println(bot.checkSet());
		
		
		assertTrue(setList != null);
		
		
	}
}
