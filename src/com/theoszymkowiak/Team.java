package com.theoszymkowiak;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Team {
	private Script programmerScript;
	private ArrayList<Tank> tanks;
	private boolean isBlue;
	private Flag flag;
	
	public Team(boolean isB, Script s) {
		this.isBlue = isB;
		this.programmerScript = s;
		
		tanks = new ArrayList<Tank>();
		
		for(int i = 0; i < 5; i++) {
			Tank t = new Tank(this);
			tanks.add(t);
			if(isB || true) {
				t.setPosition(new Vector2D(400, (600/5)*i));
			} 
			if(isB) {
				//t.setPosition(new Vector2D(600, (600/5)*i));
				t.setAngle(Math.PI);
			}
		}
		
		this.flag = new Flag(this);
	}
	
	public void update() {
		programmerScript.update(this);
	}
	
	public ArrayList<Tank> getTanks() {
		return this.tanks;
	}
	
	public void render(Graphics g) {
		for(Tank t : tanks) {
			t.drawEntity(g);
		}
		flag.drawEntity(g);
	}

	public Script getProgrammerScript() {
		return programmerScript;
	}

	public void setProgrammerScript(Script programmerScript) {
		this.programmerScript = programmerScript;
	}

	public boolean isBlue() {
		return isBlue;
	}

	public void setBlue(boolean isBlue) {
		this.isBlue = isBlue;
	}

	public void setTanks(ArrayList<Tank> tanks) {
		this.tanks = tanks;
	}
}
