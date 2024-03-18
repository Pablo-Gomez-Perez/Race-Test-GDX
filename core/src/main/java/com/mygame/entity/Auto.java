package com.mygame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Auto {
	private Texture autoImage;
	private Vector2 position;
	float velocity;
	
	public static class Builder{
		private Auto auto;
		
		public Builder(Texture image) {
			this.auto = new Auto(image);
		}
		
		public Builder position(Vector2 position) {
			this.auto.setPosition(position);
			return this;
		}
		
		public Builder velocity(float velocity) {
			this.auto.setVelocity(velocity);
			return this;
		}
		
		public Auto build() {
			return this.auto;
		}
	}
	
	public static Builder builder(Texture image) {
		return new Builder(image);
	}
	
	/**
	 * @param autoImage
	 * @param position
	 * @param velocity
	 */
	public Auto(Texture autoImage, Vector2 position, float velocity) {
		super();
		this.autoImage = autoImage;
		this.position = position;
		this.velocity = velocity;
	}

	public Auto(Texture autoImage) {
		this.autoImage = autoImage;
	}
	
	public Auto() {
		
	}
	
	/**
	 * @return the autoImage
	 */
	public Texture getAutoImage() {
		return autoImage;
	}

	/**
	 * @param autoImage the autoImage to set
	 */
	public void setAutoImage(Texture autoImage) {
		this.autoImage = autoImage;
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

	@Override
	public String toString() {
		return "Auto [autoImage=" + autoImage + ", position=" + position + ", velocity=" + velocity + "]";
	}
	
	public void move(float delta, boolean toLeft) {
		float movement = toLeft == true ? -this.velocity * delta : this.velocity * delta;
	    this.position.x += movement;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(autoImage, this.position.x, this.position.y);
	}
	
}
