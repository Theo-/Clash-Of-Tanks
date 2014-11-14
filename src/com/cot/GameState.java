package com.cot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.TH.ge.mainCore.AppContainer;
import com.TH.ge.mainCore.State;

public class GameState extends State {
	private BufferedImage map;
	private ArrayList<Block> blocks;
	private ArrayList<Rocket> rockets;
	
	private Team red;
	private Team blue;

	public GameState(AppContainer ac) {
		super(ac);
		Var.gs = this;
		Var.ac = ac;
		
		this.rockets = new ArrayList<Rocket>();
		this.blocks = new ArrayList<Block>();
		
		red = new Team(false, new Script("s1.tank"));
		blue = new Team(true, new Script("s2.tank"));
		
		ac.getWindow().setSize(new Dimension(1000,600));
		// TODO Auto-generated constructor stub
	}
	
	public void update(AppContainer app, State state) {
		red.update();
		blue.update();
		
		for(Rocket r : rockets) {
			ArrayList<Tank> l = red.getTanks();
			l.addAll(blue.getTanks());
			r.update(l);
		}
    }

    public void draw(AppContainer container, State state, Graphics g) {
    	g.setColor(Color.GRAY);
    	g.fillRect(0,0,1000,600);
    	
		red.render(g);
		blue.render(g);
		
		for(Rocket r : rockets) {
			r.drawEntity(g);
		}
    }
    
    
    public ArrayList<Rocket> getRockets() {
		return rockets;
	}

	public void setRockets(ArrayList<Rocket> rockets) {
		this.rockets = rockets;
	}

	public void onEvent(String name, Object param) {
    	
    }
    /**
     * Method called every time a key event is received
     * @param type The type of the event
     * Can Be
     * - typed
     * - released
     * - pressed
     * @param evt
     * The KeyEvent associated
     */
    public void onKeyEvent(String type, KeyEvent evt) {
    	
    }

    /**
     * Method called every time a mouse event is received
     * @param type The type of the event
     * Can Be
     * - clicked
     * - exited
     * - entered
     * - released
     * - pressed
     * @param evt
     * The KeyEvent associated
     */
    public void onMouseEvent(String type, MouseEvent evt) {
    	if(type.equals("clicked")) {
    		for(Tank t : red.getTanks()) {
    			t.angle += 1.0f;
    		}
    	}
    }
}
