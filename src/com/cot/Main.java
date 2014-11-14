package com.cot;

import java.io.IOException;

import com.TH.ge.mainCore.AppContainer;

public class Main {
	
	public Main(String script1, String script2) throws IOException {
		AppContainer app = new AppContainer("Clash Of Tanks");
		
		app.addState(0, GameState.class);
		app.enterState(0);
		
		app.startApp();
	}
	
	
	// Initializing
	public static void main(String[] args) {
		args = new String[] {"s1.tank", "s2.tank"};
		
		if(args.length != 2) {
			System.out.println("Usage: arg1=Script1, arg2=Script2");
			System.out.println("Must be relative paths");
			System.exit(1);
		}
		
		try {
			new Main(args[0], args[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
