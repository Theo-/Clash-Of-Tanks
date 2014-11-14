package com.cot;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flag extends Entity {
	private Team team;
	
	public Flag(Team t) {
		team = t;
		
		try {
		    this.image = ImageIO.read(new File("resources/"+(team.isBlue() ? "blue" : "red")+"_flag.png"));
		} catch (IOException e) {
			
		}
		
		if(team.isBlue()) {
			this.position = new Vector2D((1000.0f/4)*3, 600.0f/2);
		} else {
			this.position = new Vector2D((1000.0f/4), 600.0f/2);
		}
	}
}
