package com.mygame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Auto {
	//private Texture autoImage;
	private Sprite autoSprite;
	private Vector2 position;
	float velocity;
	
	public static class Builder{
		private Auto auto;
		
		public Builder(Texture sprite) {
			this.auto = new Auto(new Sprite(sprite));
		}
		
		public Builder position(Vector2 position) {
			this.auto.autoSprite.setPosition(position.x,position.y);
			return this;
		}
		
		public Builder velocity(float velocity) {
			this.auto.setVelocity(velocity);
			return this;
		}
		
		public Builder sisze(float width, float height) {
			this.auto.autoSprite.setSize(width, height);
			return this;
		}
		
		public Auto build() {
			return this.auto;
		}
	}
	
	public static Builder builder(Texture sprite) {
		return new Builder(sprite);
	}
	
	/**
	 * @param autoImage
	 * @param position
	 * @param velocity
	 */
	public Auto(Sprite autoSprite, Vector2 position, float velocity) {
		super();
		this.autoSprite = autoSprite;
		this.position = position;
		this.velocity = velocity;
	}

	public Auto(Sprite sprite) {
		//this.autoImage = autoImage;
		this.autoSprite = sprite;
	}
	
	public Auto() {
		
	}	

	/**
	 * @return the autoSprite
	 */
	public Sprite getAutoSprite() {
		return autoSprite;
	}

	/**
	 * @param autoSprite the autoSprite to set
	 */
	public void setAutoSprite(Sprite autoSprite) {
		this.autoSprite = autoSprite;
	}

	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * @return the velocity
	 */
	public float getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	
	
	public void move(float delta, boolean toLeft) {
		float movement = toLeft == true ? -this.velocity : this.velocity;
	    this.autoSprite.translateX(movement * delta);

	}
	
	public void render(SpriteBatch batch) {
		this.autoSprite.draw(batch);
	}
	
	public void setSize(float width, float height) {
        this.autoSprite.setSize(width, height);
    }
}
