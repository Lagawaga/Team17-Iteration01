package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements Observer{
	//MEMBERS
	private Boolean status;
	private int pointCounter;
	public ArrayList<Tile> hand;
	Scanner input = new Scanner(System.in);
	//These are observed from Table
	public Table tableSnapshot;
	//private	ArrayList<Meld> Melds;
	protected boolean gameOver = false;
	
	//CONSTRUCTORS
	public Player() {
		this.hand = new ArrayList<Tile>();
		this.status = false;
		this.tableSnapshot = new Table();
		}
	
	//METHODS
	public void drawHand() {
		System.out.println("Drawing Hand...");
		for(int i = 0; i<14; i++) {
			drawTile(this.tableSnapshot.getPile());
		}
		sortHand();
		System.out.println("Your Hand:");
		printTiles(this.hand);
		System.out.println("\n");
	}
	
	public void removeTile(int c, int v) {
		
		for (Tile t : hand) {
			
			if(t.getColour() == c && t.getValue() == v) {
				this.hand.remove(t);
				break;
			}
		}
		
	}
	
	public void sortHand() {
		ArrayList<Tile> blue = new ArrayList<Tile>();
		ArrayList<Tile> red = new ArrayList<Tile>();
		ArrayList<Tile> green = new ArrayList<Tile>();
		ArrayList<Tile> orange = new ArrayList<Tile>();
		ArrayList<Tile> finished = new ArrayList<Tile>();
		
		for(int i = 0; i < this.hand.size(); i++) {
			
			if(this.hand.get(i).getColour() == 1) {
				blue.add(this.hand.get(i));
			}
			
			if(this.hand.get(i).getColour() == 2) {
				red.add(this.hand.get(i));
			}
			
			if(this.hand.get(i).getColour() == 3) {
				green.add(this.hand.get(i));
			}
			
			if(this.hand.get(i).getColour() == 4) {
				orange.add(this.hand.get(i));
			}
			
		}
		
		insertionSort(blue);
		insertionSort(red);
		insertionSort(green);
		insertionSort(orange);
		
		Collections.sort(blue, new Comparator<Tile>() {
			public int compare(Tile s2, Tile s1) {
				return Integer.compare(s2.getValue(), s1.getValue());
			}
		});
		Collections.sort(red, new Comparator<Tile>() {
			public int compare(Tile s2, Tile s1) {
				return Integer.compare(s2.getValue(), s1.getValue());
			}
		});
		Collections.sort(green, new Comparator<Tile>() {
			public int compare(Tile s2, Tile s1) {
				return Integer.compare(s2.getValue(), s1.getValue());
			}
		});
		Collections.sort(orange, new Comparator<Tile>() {
			public int compare(Tile s2, Tile s1) {
				return Integer.compare(s2.getValue(), s1.getValue());
			}
		});
		
		finished.addAll(blue);
		finished.addAll(red);
		finished.addAll(green);
		finished.addAll(orange);
		
		this.hand = finished;
		
	}
	
	public ArrayList<Tile> insertionSort(ArrayList<Tile> input) {
		for(int i =1; i < input.size(); i++) {
			for(int j = i; j > 0; j--) {
				if(input.get(j).getValue() < input.get(j-1).getValue()) {
					Tile temp = input.get(j);
					Tile x = input.get(j);
					Tile y = input.get(j-1);
					x = y;
					y = temp;
					
				}
			}	
		}
		return input;
	}

	public void playMeld(Meld m) {
		printNew(m);
		this.tableSnapshot.getMelds().add(m);
	
		if(this.status == false) {
			int meldPoints = 0;
			
			for(int i = 0; i < m.getTiles().size(); i++) {
				meldPoints += m.getTiles().get(i).getValue();
			}
			
			this.pointCounter += meldPoints;
			
			if(pointCounter >= 30) {
				this.status = true;
			}
		}
	}
	
	public void addTile(Tile t) {
		this.hand.add(t);
	}

	public void drawTile(Pile p) {
		this.hand.add(p.getTile(0));
		p.removeTile();
	}
	
	public ArrayList<Tile> fromHand() {
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		int choice;
		while(true) {
			printTiles(tiles);
			System.out.println("Select tile from hand:");
			printTiles(this.hand);
			choice = input.nextInt();
			
			System.out.println("1.Select more");
			System.out.println("2.Continue");
			int moreTiles = input.nextInt();
			
			if(moreTiles == 1) {
				try {
					tiles.add(this.hand.get(choice - 1));
					this.hand.remove(choice -1);
					}catch(Exception e) {
						System.out.println("Invalid.");
						continue;
					}
				continue;
			}
			if(moreTiles == 2) {
				try {
					tiles.add(this.hand.get(choice - 1));
					this.hand.remove(choice -1);
					}catch(Exception e) {
						System.out.println("Invalid.");
						continue;
					}
				break;
			}
			else {
				System.out.println("Invalid.");
				continue;
			}
		}
		return tiles;
	}
	
	public ArrayList<Tile> fromMeld(){
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		Meld meld;
		int tileNum;
		meld = selectMeld();
		while(true) {
			if(meld.getTiles().isEmpty()) {
				System.out.println("This meld is empty!");
				this.tableSnapshot.getMelds().remove(meld);
				break;
			}
			System.out.println("Select tiles:");
			printTiles(meld.getTiles());
			tileNum = input.nextInt();
			
			System.out.println("1.Select more from this meld");
			System.out.println("2.Select from different meld");
			System.out.println("3.Done");
			int moreTiles = input.nextInt();
			
			if(moreTiles == 1) {
				try {
					tiles.add(meld.getTiles().get(tileNum - 1));
					meld.getTiles().remove(tileNum -1);
					}catch(Exception e) {
						System.out.println("Invalid.");
						continue;
					}
				continue;
			}
			if(moreTiles == 2) {
				try {
					tiles.add(meld.getTiles().get(tileNum - 1));
					meld.getTiles().remove(tileNum -1);
					}catch(Exception e) {
						System.out.println("Invalid.");
						continue;
					}
				meld = selectMeld();
				continue;
			}
			if(moreTiles == 3) {
				try {
					tiles.add(meld.getTiles().get(tileNum - 1));
					meld.getTiles().remove(tileNum -1);
					}catch(Exception e) {
						System.out.println("Invalid.");
						continue;
					}
				break;
			}
			else {
				System.out.println("Invalid.");
				continue;
			}
		}
		return tiles;
	}
	
	public boolean endTurn() {
		ArrayList<Meld> invalidMelds = checkInvalid();
		if(invalidMelds.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<Meld> checkInvalid(){
		ArrayList<Meld> invalidMelds = new ArrayList<Meld>();
		for(Meld m : this.tableSnapshot.getMelds()) {
			if(!m.isValid()) {
				invalidMelds.add(m);
			}
		}
		return invalidMelds;
	}
	
	//UI
	public void doTurn() {
		System.out.println("USER TURN");
		System.out.println("1.Play tiles.");
		System.out.println("2.Draw tile & end turn.");
		
		try {
			int n = input.nextInt();
			
			switch(n) {
				case 1: 
					playOptions();
					break;
				case 2:
					endTurn();
					break;
				default:
					System.out.println("Invalid choice.");
					doTurn();
					break;
			}
		}catch(InputMismatchException e) {
			System.out.println("INVALID");
			
		}
		
	}
	private void playOptions() {
		printTiles(hand);
		System.out.println("1.Create Meld");
		System.out.println("2.Modity Meld");
		System.out.println("3.End Turn");
		
		int n = input.nextInt();
		switch(n) {
			case 1:
				createMeld();
				break;
			case 2: 
				if (this.status == false) {
					System.out.println("Must have 30 or more points to do this.");
					playOptions();
					break;
				}
				else
					modifyMeld();
					break;
			case 3: 
				break;
			case 4:
				doTurn();
				break;
			default:
				System.out.println("Invalid choice.");
				playOptions();
				break;
		}
	}
	
	public ArrayList<Tile> fromMeldAndHand(){
		 ArrayList<Tile> tiles = new ArrayList<Tile>();
		 
		 while(true) {
			 System.out.println("1.Choose tiles from Hand");
			 System.out.println("2.Choose tiles from Melds");
			 System.out.println("3.Done");
			 System.out.println("4.Back");
			 int n = input.nextInt();
			 
			 if(n == 1) {
				 
				 System.out.println("Select tile from hand:");
				 printTiles(this.hand);
				 int choice = input.nextInt();
				 	 
			 }
			 
			 if(n == 2) {
				 
			 }
			 
			 if(n == 3) {
				 
			 }
			 
			 if(n == 4){
				 
			 }
			 
			 else {
				 System.out.println("Invalid.");
			 }
			  
		 }
			 
		 
		
	}

	public void createMeld() {
		
		ArrayList<Tile> buffer = new ArrayList<Tile>();
		ArrayList<Tile> tmp = new ArrayList<Tile>();
		String printBuffer = "{ ";
		String bracket = "}";
		while(true) {
			System.out.println("\n" + printBuffer + bracket);
			System.out.println("1. Use tile(s) from hand");
			System.out.println("2. Use tile(s) from table");
			System.out.println("3. End");
			
			int n = input.nextInt();
			switch(n) {
			case 1:
				tmp = fromHand();
				buffer.addAll(tmp);
				for (Tile t: tmp) {
					printBuffer += ("*" + t.toString() + " ");
				}
				continue;
			case 2:
				if (this.status == false) {
					System.out.println("Must have 30 or more points to do this.");
					continue;
				}
				
				tmp = fromMeld();
				buffer.addAll(tmp);
				for(Tile t: tmp) {
					printBuffer += ("!" + t.toString() + " ");
				}
				continue;
			case 3:
				try {
				Run testRun = new Run(buffer);
				Set testSet = new Set(buffer);
				
				if(testRun.isValid()) {
					playMeld(testRun);
					break;
				}else if(testSet.isValid()) {
					playMeld(testSet);
					break;
				}else {
					System.out.println("INVAID MELD");
					break;
				}
				}catch (Exception e) {
					System.out.println("Nothing was played.");
					createMeld();
					break;
				}
				
			default:
				System.out.println("Invalid choice.");
				
			}
			break;
		}
		
	}
	
	private void modifyMeld() {
		Meld meld = selectMeld();
		System.out.println("Select tiles");
		printTiles(meld.getTiles());
		int tileNum = input.nextInt();
		
		while(true) {
			System.out.println("1.Use tile(s) from hand.");
			System.out.println("2.Use tile(s) form a meld");
			System.out.println("3.Back");
			
			try {
				int n = input.nextInt();
				switch(n) {
				case 1:
					addToMeld(fromHand());
					break;
				case 2:
					fromMeld();
				case 3:
					doTurn();
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}catch(Exception e) {
				System.out.println("Please enter a valid number");
				doTurn();
				
			}
			
		}
	}
	
	public void addToMeld(ArrayList<Tile> tiles) {
		int choice;
		Meld meld;
		
		while(true) {
			System.out.println("Select meld to add to:");
			displayMelds();
			choice = input.nextInt();
			try {
				meld = this.tableSnapshot.getMelds().get(choice -1);
				break;
			}catch (Exception e){
				System.out.println("Invalid.");
				continue;
			}
		}
		while(!tiles.isEmpty()) {
			while(true) {
				System.out.println("Select position you'd like to add ["+ tiles.get(0).toString()+"] to:");
				printTiles(this.tableSnapshot.getMelds().get(choice -1).getTiles());
				int position = input.nextInt();
				try {
				meld.getTiles().add(position -1,tiles.get(0));
				tiles.remove(0);
				break;
				} catch(Exception e) {
					System.out.println("Invalid.");
					continue;
				}
			}
		}
		
		System.out.println("New Meld:");
		//printTiles(Melds.get(choice -1).getTiles());
		displayMelds();
		System.out.println("----------------------------------------------");
		doTurn();
	}
	
	public Meld selectMeld() {
		int meldNum;
		while(true) {
			System.out.println("Select meld to take from:");
			displayMelds();
			meldNum = input.nextInt();
			try {
				return this.tableSnapshot.getMelds().get(meldNum -1);
			}catch (Exception e){
				System.out.println("Invalid.");
				continue;
			}
		}
	}
	public void displayMelds() {
		for(Meld m : this.tableSnapshot.getMelds()) {
            printTiles(m.getTiles());
        }
	}
	
	public void printTiles(ArrayList<Tile> tiles) {
		String printVal = "{ ";
		int counter = 1;
		for (Tile t : tiles) {
			printVal += counter + ".[" + t.toString() + "] ";
			counter++;
		}
		printVal += "}";
		System.out.println(printVal);
	}
	
	public void printNew(Meld newMeld) {
		String printVal = "";
		for(Meld m : this.tableSnapshot.getMelds()) {
			printVal += "{ ";
			ArrayList<Tile> tmp = m.getTiles();
			for (Tile t : tmp) {
				printVal +=  "[" + t.toString() + "] ";
			}
			printVal += "}\n";
        }
		
			printVal += "*{ ";
			ArrayList<Tile> tiles = newMeld.getTiles();
			for (Tile t : tiles) {
				printVal +=  "[" + t.toString() + "] ";
			}
			printVal += "} \n";
		
		
        System.out.println(printVal);
	}
	
	//OBSERVER METHODS
	public void update(Table table) {
		//this.Melds = (ArrayList<Meld>) table.getMelds().clone();
		this.tableSnapshot.setMelds((ArrayList<Meld>) table.getMelds().clone());
		this.tableSnapshot.setPile( table.getPile());
		this.tableSnapshot.status = table.status;
		this.tableSnapshot.setObservers(table.getObservers());
	}
	public void pushToTable(Table table) {
		if (this.hand.isEmpty()) {
			this.gameOver = true;
			System.out.println("Player Wins!\n");
		}
		if(!this.gameOver && table.getMelds().containsAll(this.tableSnapshot.getMelds()) && this.tableSnapshot.getMelds().containsAll(table.getMelds())) {
			System.out.println("No actions performed. Drawing Tile...");
			if(this.tableSnapshot.getPile().getPile().isEmpty()) {
				System.out.println("Can't draw tile. Pile is empty.\n");
			}
			else {
			drawTile(table.getPile());
			System.out.println("New Hand:");
			printTiles(this.hand);
			System.out.println("\n");
			}
		}
		
		table.updateTable(this.tableSnapshot.getMelds(), this.gameOver, this.status, this.tableSnapshot.getPile());
	}
	
	//GETTERS
	public ArrayList<Tile> getHand() {
		return this.hand;
	}
	public Boolean getStatus() {
		return this.status;
	}
	public Tile getTile(int i) {
		return this.hand.get(i);
	}
	public int getSize() {
		return this.hand.size();
	}
	//SETTERS
	public void setStatus(boolean b) {
		this.status = b;
	}
	public void setGameOver(boolean b) {
		this.gameOver = b;
	}
}
