package com.evergreen.titz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CharacterCustomization extends Game {

	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();

		batch.dispose();
	}
}
