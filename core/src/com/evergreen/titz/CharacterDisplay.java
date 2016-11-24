package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;


public class CharacterDisplay extends Actor implements Disposable {

    private static final int SPRITESHEET_HEIGHT = 21;
    private static final int SPRITESHEET_WIDTH = 13;

    private static final float ANIMATION_SPEED = 0.15f;

    public Animation getSpriteAnimation() {
        if (spriteAnimation == null)
            throw new NullPointerException("Animation type wasn't chosen");

        return spriteAnimation;
    }

    public TextureRegion[] getCharacterTextures() {
        return characterTextures;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public Character getCharacter() {
        return character;
    }

    private Animation spriteAnimation;
    private TextureRegion[] characterTextures;
    private Texture spriteSheet;
    private TextureRegion[] animationFrames;
    private TextureRegion[][] splitSheet;
    private ArrayList<TextureRegion[][]> sheets;

    private SpritesheetValues displayValue;

    private Character character;

    private float stateTime;

    public CharacterDisplay(String spriteSheetPath) {
        spriteSheet = new Texture(Gdx.files.internal(spriteSheetPath));
        splitSheet = TextureRegion.split(spriteSheet,
                                            spriteSheet.getWidth()/SPRITESHEET_WIDTH,
                                            spriteSheet.getHeight()/SPRITESHEET_HEIGHT );

        stateTime = 0f;
    }

    public CharacterDisplay(Character character) {
        this.character = character;

        sheets = new ArrayList<TextureRegion[][]>();
        displayValue = SpritesheetValues.FRONT;

        for(Texture texture : character.getWears()) {
            TextureRegion[][] tempRegion = TextureRegion.split(texture,
                                                                texture.getWidth()/SPRITESHEET_WIDTH,
                                                                texture.getHeight()/SPRITESHEET_HEIGHT);

            sheets.add(tempRegion);
        }
    }

    public void chooseAnimation(SpritesheetValues animationValues) {
        animationFrames = new TextureRegion[animationValues.END_COL];

        int index = 0;
        for (int i = animationValues.START_COL; i <= animationValues.END_COL; i++) {
            animationFrames[index++] = splitSheet[animationValues.ROW][i];
        }

        spriteAnimation = new Animation(ANIMATION_SPEED, animationFrames);
    }

    public void chooseDisplay(SpritesheetValues displayValue) {
        this.displayValue = displayValue;

        characterTextures = new TextureRegion[sheets.size()];

        for (int i = 0; i < characterTextures.length; i++) {
            characterTextures[i] = sheets.get(i)[displayValue.ROW][displayValue.START_COL];
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        chooseDisplay(displayValue);

        for(TextureRegion texture : characterTextures) {
            batch.draw(texture, 0, 0);
        }
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
    }
}
