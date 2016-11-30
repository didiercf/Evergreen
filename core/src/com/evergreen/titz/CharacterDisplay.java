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

    //Constants
    private static final int SPRITESHEET_HEIGHT = 21;
    private static final int SPRITESHEET_WIDTH = 13;

    private TextureRegion[] characterTextures;
    private ArrayList<TextureRegion[][]> sheets;
    private SpritesheetValues displayValue;
    private Character character;

    public TextureRegion[] getCharacterTextures() {
        return characterTextures;
    }

    public Character getCharacter() {
        return character;
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

    public void chooseDisplay(SpritesheetValues displayValue) {
        this.displayValue = displayValue;

        characterTextures = new TextureRegion[sheets.size()];

        for (int i = 0; i < characterTextures.length; i++) {
            characterTextures[i] = sheets.get(i)[displayValue.ROW][displayValue.START_COL];
        }
    }

    public void reloadTextures() {
        sheets.clear();

        for(Texture texture : character.getWears()) {
            TextureRegion[][] tempRegion = TextureRegion.split(texture,
                    texture.getWidth()/SPRITESHEET_WIDTH,
                    texture.getHeight()/SPRITESHEET_HEIGHT);

            sheets.add(tempRegion);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        reloadTextures();
        chooseDisplay(displayValue);

        for(TextureRegion texture : characterTextures) {
            batch.draw(texture, 0, 0);
        }
    }

    @Override
    public void dispose() {
        character.dispose();
    }
}
