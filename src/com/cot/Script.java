package com.cot;

public class Script {
	private String file_name;
	
	public Script(String name_file) {
		file_name = name_file;
	}
	
	public void update(Team t) {
		// Load the custom class
		
		for(Tank tank : t.getTanks()) {
			//tank.move();
			
			//tank.turn();
			tank.fire();
		}
	}
}
