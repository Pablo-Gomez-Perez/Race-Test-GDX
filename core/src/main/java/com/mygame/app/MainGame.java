package com.mygame.app;

import com.badlogic.gdx.Game;

public class MainGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.setScreen(new App(this));
	}

}
