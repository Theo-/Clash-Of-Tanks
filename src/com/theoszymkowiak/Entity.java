package com.theoszymkowiak;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Entity {
	public Vector2D position;
	public BufferedImage image;
	
	public double angle = 0; // In radians
	
	public void drawEntity(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		/*double rotationRequired = getAngle();
		double locationX = image.getWidth(null) / 2;
		double locationY = image.getHeight(null) / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// Drawing the rotated image at the required drawing locations
		g2d.drawImage(op.filter(image, null), (int)position.x, (int)position.y, null);*/
		
        g2d.translate(position.x-(image.getWidth())*(Math.sin(angle)), position.y-(image.getHeight()/2)*Math.cos(angle)); // Translate the center of our coordinates.
        g2d.rotate(angle);  // Rotate the image by 1 radian.
        g2d.drawImage(image, 0,0, null);
        g2d.dispose();	
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}
