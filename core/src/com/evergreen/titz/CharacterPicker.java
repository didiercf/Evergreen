package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by 1458214 on 2016-11-15.
 */
public class CharacterPicker implements Screen {

    final CharacterCustomization game;

    TextureRegion currentFrame;
    CharacterAnimation animation;

    public CharacterPicker(final CharacterCustomization game) {
        this.game = game;

        animation = new CharacterAnimation("tanned.png");
    }

    @Override
    public void show() {
        animation.ChooseAnimation(SpritesheetValues.WALK_FRONT);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        animation.setStateTime(animation.getStateTime() + Gdx.graphics.getDeltaTime());
        currentFrame = animation.getSpriteAnimation().getKeyFrame(animation.getStateTime(), true);
        game.batch.begin();
        game.batch.draw(currentFrame, 50, 50);


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            animation.ChooseAnimation(SpritesheetValues.WALK_BACK);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            animation.ChooseAnimation(SpritesheetValues.WALK_RIGHT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            animation.ChooseAnimation(SpritesheetValues.WALK_LEFT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            animation.ChooseAnimation(SpritesheetValues.WALK_FRONT);
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        animation.dispose();
    }
}