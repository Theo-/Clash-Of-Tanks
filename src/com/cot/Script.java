package com.cot;

public class Script {
	public void update(Team t) {
		// Load the custom class
		
		for(Tank tank : t.getTanks()) {
			//tank.move();
			
			tank.turn();
		}
	}
}
