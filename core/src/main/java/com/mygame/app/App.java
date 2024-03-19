package com.mygame.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygame.entity.Auto;
import com.mygame.tools.ScreeApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ScreeApplicationAdapter{
    
	private Texture backGround;
	private MainGame game;
	private Auto carUser;
	private Auto carPC;
	//private int countDown = 3;
	//private boolean isCountDownInProgress = true;
	private SpriteBatch batch;
	private boolean isGameInProgress = false;
	private String winnerMessage = "";
	private BitmapFont font;
	private final float FINISH_LINE = 800.0f;
	private final float START_LINE = 100.0f;
	private Music backgroundMusic;
	
	public App(MainGame game) {
		this.game = game;
	}
	
	public void buildUserCar() {
		var carImage = new Texture("sedan.png");
		var initialPosition = new Vector2(100,150);

		this.carUser = Auto.builder(carImage)
				.position(initialPosition)
				.velocity(randomVelocity())
				.sisze(carImage.getWidth() * 0.50f, carImage.getHeight() * 0.50f)
				.build();
	}
	
	public void buildPcCar() {
		var carImage = new Texture("sedan.png");
		var initialPosition = new Vector2(100,250);
		
		this.carPC = Auto.builder(carImage)
				.position(initialPosition)
				.velocity(randomVelocity())
				.sisze(carImage.getWidth() * 0.50f, carImage.getHeight() * 0.50f)
				.build();
				
	}
	
	/**
	 * return a random velocity on each game
	 * @return
	 */
	private float randomVelocity() {
		return MathUtils.random(50.0f,500.0f);
	}
	
    @Override
    public void show() {
        super.show();                
        this.batch = new SpriteBatch();        
        this.font = new BitmapFont();
        this.backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("SuperBombermanBossmusic.ogg"));
        this.backGround = new Texture("fondo_carretera.png");
    	this.backgroundMusic.setLooping(true);
        this.backgroundMusic.play();
        this.backgroundMusic.setVolume(0.75f);
        this.buildUserCar();
        this.buildPcCar();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        this.batch.draw(backGround, 0, 0);
        this.carUser.render(batch);
        this.carPC.render(batch);
        
        //this.coutDown(batch);
        
        /*while(isCountDownInProgress) {
    		try {
    			font.draw(batch, String.valueOf((int) Math.ceil(countDown)), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
    			Thread.sleep(1000);
    			countDown --;
    			
    			if(countDown <= 0)
    				isCountDownInProgress = false;
    				this.isGameInProgress = true;
    		}catch(Exception er) {
    			er.printStackTrace();
    		}
    	}*/
        
        /*if(isCountDownInProgress) {
        	this.countDown -= delta;
        	font.draw(batch, String.valueOf((int) Math.ceil(countDown)), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);        	
        	this.isCountDownInProgress = this.countDown <= 0 ? false : true;        	
        }*/
        
        if (!isGameInProgress) {
        	/*countDown -= delta;
        	if(countDown > 0) {
        		font.draw(batch, String.valueOf((int) Math.ceil(countDown)), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        	}else {
        		this.isGameInProgress = true;
        	}*/
        	font.getData().setScale(2f);
            font.draw(batch, winnerMessage, (Gdx.graphics.getWidth() / 2f) - 80f, Gdx.graphics.getHeight() - 30f);
            font.draw(batch, "Press 'R' to restart", (Gdx.graphics.getWidth() / 2f) - 80f, Gdx.graphics.getHeight() - 60f);
            
            if(Gdx.input.isKeyJustPressed(Input.Keys.R))
            	this.restartGame();
        }//else {
        	//this.carUser.render(batch);
            //this.carPC.render(batch);
            //handleComputerCarMovement(delta);
            //checkFinishLine();
        //}
        
        batch.end();

        if (isGameInProgress) {            
            handleComputerCarMovement(delta);
            checkFinishLine();         
        }
        
        handleUserInput(delta);
        
        //Gdx.app.log("Game", this.backgroundMusic.isPlaying() + "");
        
        
        /*if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (this.carUser.getAutoSprite().getX() < this.FINISH_LINE)) {
            this.carUser.move(delta, false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && (this.carUser.getAutoSprite().getX() > this.START_LINE)) {
            this.carUser.move(delta, true);
        }*/
        
        /*this.handleUserInput(delta);
        this.handleComputerCarMovement(delta);
        this.checkFinishLine();*/
    }

    @Override
    public void dispose() {
    	super.dispose();
    	this.carPC.getAutoSprite().getTexture().dispose();
    	this.carUser.getAutoSprite().getTexture().dispose();
    	this.backGround.dispose();
    	this.backgroundMusic.stop();
    	this.backgroundMusic.dispose();
    	this.batch.dispose();
    }
    
//    private void coutDown(SpriteBatch batch) {
//    	while(isCountDownInProgress) {
//    		try {
//    			font.draw(batch, String.valueOf((int) Math.ceil(countDown)), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
//    			Thread.sleep(1000);
//    			countDown --;
//    			
//    			if(countDown <= 0)
//    				isCountDownInProgress = false;
//    				this.isGameInProgress = true;
//    		}catch(Exception er) {
//    			er.printStackTrace();
//    		}
//    	}
//    }
    
    private void handleUserInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && carUser.getAutoSprite().getX() /*+ carUser.getAutoSprite().getWidth()*/ < FINISH_LINE) {
            carUser.move(delta, false); 
            Gdx.app.log("X pos to right",carUser.getAutoSprite().getX() + "");
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && carUser.getAutoSprite().getX() > START_LINE) {
            Gdx.app.log("X pos to left", carUser.getAutoSprite().getX() + "");
            carUser.move(delta, true);
        }
    }
    
    private void handleComputerCarMovement(float delta) {
    	 if (carPC.getAutoSprite().getX() < FINISH_LINE) {
    		 carPC.move(delta, false);
    	 }
    }
    
    private void restartGame() {
        buildUserCar();
        buildPcCar();
        isGameInProgress = true;
        winnerMessage = "";
        this.countDown = 3;
        //this.isCountDownInProgress = true;
    }
    
    private void checkFinishLine() {
    	if (this.carUser.getAutoSprite().getX() >= FINISH_LINE) {
    		this.isGameInProgress = false;
    		this.winnerMessage = "¡Congrats, you win";
            Gdx.app.log("Game", "¡Congrats, you win");
        }
        if (this.carPC.getAutoSprite().getX() >= FINISH_LINE) {
        	this.isGameInProgress = false;
        	this.winnerMessage = "HE HE, you are trash XD";
            Gdx.app.log("Game", "HE HE, you are trash XD");
        }
    }
}
