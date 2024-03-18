package com.mygame.tools;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class ScreeApplicationAdapter extends ApplicationAdapter implements Screen{

	/** Called when this screen becomes the current screen for a {@link Game}. */
	@Override
	public void show () {
	}

	/** Called when the screen should render itself.
	 * @param delta The time in seconds since the last render. */
	@Override
	public void render (float delta) {
	}

	/** @see ApplicationListener#resize(int, int) */
	@Override
	public void resize (int width, int height) {
	}

	/** @see ApplicationListener#pause() */
	@Override
	public void pause () {
	}

	/** @see ApplicationListener#resume() */
	@Override
	public void resume () {
	}

	/** Called when this screen is no longer the current screen for a {@link Game}. */
	@Override
	public void hide () {
	}

	/** Called when this screen should release all resources. */
	@Override
	public void dispose () {
	}
	
}
