package com.mygame.app;

import com.mygame.tools.ScreeApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ScreeApplicationAdapter{
    
	private MainGame game;
	
	public App(MainGame game) {
		this.game = game;
	}
	
    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
    	
    }
}
