package core;

import java.util.ArrayList;

public class AI extends Player{
	//MEMBERS
//private ArrayList<Tile> hand;
private Boolean status;
private IStrategy strategy;

	//CONSTRUCTORS
	public AI(int strat) {
		this.hand = new ArrayList<Tile>();
		
		if(strat == 1) {
			this.strategy = new StrategyOne();
		}else if(strat == 2){
			this.strategy = new StrategyTwo();
		}else{
			this.strategy = new StrategyThree();
		}
	}
	
	//METHODS
	@Override
	public void doTurn() {
		System.out.println("Im a bot");
		//strategy.play(checkHandPlays);
	}
	
	public ArrayList<Meld> checkHandPlays(){
		ArrayList<Meld> possiblePlays = new ArrayList<Meld>();
		possiblePlays.addAll(checkRun());
		//possiblePlays.addAll(checkSet());
		return possiblePlays;
		
	}
	
	public ArrayList<Run> checkRun(){
		
		
		ArrayList<Run> runs = new ArrayList<Run>();
		ArrayList<Tile> hold = new ArrayList<Tile>();
		
		for(int i=1; i<=4; i++) {
			
			ArrayList<Tile> colour = new ArrayList<Tile>();
			colour.addAll(colourSplitter(i));
			
			int counter = 1;
			
			for(int t=0; t<colour.size(); t++) {
			
				hold.add(this.hand.get(t));
			
				try {
				if(this.hand.get(t).getValue()+1 == this.hand.get(t+1).getValue()){
					counter++;

				}}catch(Exception IndexOutOfBoundsException) {
					if(counter <3) {
						hold.clear();
						
					}else {
						hold.add(this.hand.get(t));
						runs.add(new Run(hold));
						
					}
					counter = 1;
				}
			}
		}
			
			return runs;
		
	}
	
	public ArrayList<Set> checkSet(){
		ArrayList<Set> sets = new ArrayList<Set>();
		ArrayList<Tile> hold = new ArrayList<Tile>();

		
		for(int i=1; i<=4; i++){
			for(int t=0; t<colourSplitter(i).size(); t++) {
				
				int counter = 1;
				hold.add(colourSplitter(i).get(t));
				
				for(int j=1; j<=4; j++) {
					if(j==i){
						
						for(Tile x: colourSplitter(j)) {
							if(x.getValue() == colourSplitter(i).get(t).getValue()) {
								counter++;
								hold.add(x);
								break;
							}
						}
					}
					if(counter <3){
						hold.clear();
					}else {
						sets.add(new Set(hold));
						hold.clear();
						counter = 1;
					}
				}

			}
		}
		
		return sets;
		
		
	}
	
	public ArrayList<Tile> colourSplitter(int i) {
		
		ArrayList<Tile> colour = new ArrayList<Tile>();
		
		for(int t = 0; t<this.hand.size(); t++) {
			if(this.hand.get(t).getColour() == i) {
				colour.add(this.hand.get(t));
			}
		}
		
		return colour;
	}
	
	//GETTERS
	
}
