package com.evergreen.titz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterCustomization extends ApplicationAdapter implements InputProcessor {

	SpriteBatch batch;
	TextureRegion currentFrame;
	CharacterAnimation animation;

	@Override
	public void create () {
		batch = new SpriteBatch();
		animation = new CharacterAnimation("tanned.png");
		animation.ChooseAnimation(SpritesheetValues.SHOOT_FRONT);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		animation.setStateTime(animation.getStateTime() + Gdx.graphics.getDeltaTime());
		currentFrame = animation.getSpriteAnimation().getKeyFrame(animation.getStateTime(), true);
		batch.begin();
		batch.draw(currentFrame, 50, 50);



		if (Gdx.input.isKeyPressed(Keys.W)) {
			animation.ChooseAnimation(SpritesheetValues.SHOOT_BACK);
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			animation.ChooseAnimation(SpritesheetValues.SHOOT_RIGHT);
		}

		if (Gdx.input.isKeyPressed(Keys.A)) {
			animation.ChooseAnimation(SpritesheetValues.SHOOT_LEFT);
		}

		if (Gdx.input.isKeyPressed(Keys.S)) {
			animation.ChooseAnimation(SpritesheetValues.SHOOT_FRONT);
		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		animation.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
