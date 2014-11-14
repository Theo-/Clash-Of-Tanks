package com.cot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Rocket extends Entity {
	private Vector2D direction;
	
	public Rocket(Vector2D _position, Vector2D _direction) {
		this.position = _position;
		direction = _direction;
		
		try {
		    this.image = ImageIO.read(new File("resources/rocket.png"));
		} catch (IOException e) {
			
		}
	}
	
	public void update(ArrayList<Tank> tanks) {
		this.position = new Vector2D(
				this.position.x + this.direction.x,
				this.position.y + this.direction.y
		);

		Rectangle ours = new Rectangle(
			new Point(
				(int)this.position.x,
				(int)this.position.y
			),
			new Dimension(
				this.image.getWidth(null),
				this.image.getHeight(null)
			)
		);
		for(Tank t : tanks) {
			Rectangle r = new Rectangle((int)t.getPosition().x,(int)t.getPosition().y,t.getImage().getWidth(null),t.getImage().getHeight(null));
			
			if(r.intersects(ours)) {
				//System.out.println("Rocket intersects");
			}
		}
	}
}
