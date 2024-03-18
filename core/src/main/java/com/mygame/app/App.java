package com.mygame.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygame.entity.Auto;
import com.mygame.tools.ScreeApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ScreeApplicationAdapter{
    
	private MainGame game;
	private Auto carUser;
	private Auto carPC;
	private SpriteBatch batch;
	
	public App(MainGame game) {
		this.game = game;
	}
	
	public void buildUserCar() {
		var carImage = new Texture("sedan.png");
		var initialPosition = new Vector2(100,100);

		this.carUser = Auto.builder(carImage)
				.position(initialPosition)
				.velocity(randomVelocity())
				.build();
	}
	
	public void buildPcCar() {
		var carImage = new Texture("sedan.png");
		var initialPosition = new Vector2(100,300);
		
		this.carPC = Auto.builder(carImage)
				.position(initialPosition)
				.velocity(randomVelocity())
				.build();
				
	}
	
	/**
	 * return a random velocity on each game
	 * @return
	 */
	private float randomVelocity() {
		return MathUtils.random(-10000.0f,10000.0f);
	}
	
    @Override
    public void show() {
        super.show();
        this.batch = new SpriteBatch();
        this.buildUserCar();
        this.buildPcCar();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        this.carUser.render(batch);
        this.carPC.render(batch);
        batch.end();
        
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.carUser.move(delta, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.carUser.move(delta, false);
        }
    }

    @Override
    public void dispose() {
    	super.dispose();
    	this.carPC.getAutoImage().dispose();
    	this.carUser.getAutoImage().dispose();
    	this.batch.dispose();
    }
}
