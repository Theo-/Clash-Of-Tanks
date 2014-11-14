package com.theoszymkowiak;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tank extends Entity {
	private int PA = 0;
	private Team team;
	
	public Tank(Team t) {
		this.team = t;
		this.resetPA();
		this.position = new Vector2D(0,0);
		
		try {
		    this.image = ImageIO.read(new File("resources/"+(team.isBlue() ? "blue" : "red")+"_tank.png"));
		} catch (IOException e) {
			
		}
	}
	
	public void resetPA() {
		this.PA = 1;
	}
	
	public void move() {
		this.position = new Vector2D(
				this.position.x + Math.cos(this.angle),
				this.position.y + Math.sin(this.angle)
		);
		
		int w = Var.ac.getWindow().getWidth();
		int h = Var.ac.getWindow().getHeight();
		if(this.position.x < 0) {
			this.position.x += Var.ac.getWindow().getWidth();
		}
		if(this.position.x > w) {
			this.position.x -= Var.ac.getWindow().getWidth();
		}
		
		if(this.position.y < 0) {
			this.position.y = h;
		} 
		if(this.position.y > h) {
			this.position.y = 1;
		}
	}
	
	public void turn() {
		if(canAct()) {
			this.turnRight();
		}
	}
	
	public void turnRight() {
		if(canAct()) {
			this.angle += 0.1;
		}
	}
	
	public void turnLeft() {
		if(canAct()) {
			this.angle -= 0.1;
		}
	}
	
	public void usePA() {
		PA--;
	}
	public boolean canAct() {
		return PA > 0;
	}
}
