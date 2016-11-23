package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterPicker implements Screen {

    final CharacterCustomization game;

    TextureRegion currentFrame;
    CharacterAnimation animation;

    Character character;

    public CharacterPicker(final CharacterCustomization game) {
        this.game = game;

        character = new Character("metal_helm_male.png", "chest_male.png", "metal_pants_male.png", "metal_boots_male.png", Genders.MALE.commonName);

        //animation = new CharacterAnimation("body/male/tanned.png");
    }

    @Override
    public void show() {
        //animation.chooseAnimation(SpritesheetValues.WALK_FRONT);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        //animation.setStateTime(animation.getStateTime() + Gdx.graphics.getDeltaTime());
        //currentFrame = animation.getSpriteAnimation().getKeyFrame(animation.getStateTime(), true);
        game.batch.begin();
        /*game.batch.draw(currentFrame, 50, 50);


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            animation.chooseAnimation(SpritesheetValues.WALK_BACK);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            animation.chooseAnimation(SpritesheetValues.WALK_RIGHT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            animation.chooseAnimation(SpritesheetValues.WALK_LEFT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            animation.chooseAnimation(SpritesheetValues.WALK_FRONT);
        }*/
        character.render(game.batch);

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
