package com.evergreen.titz;


import java.io.Console;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.evergreen.titz.Traits.*;


public class CharacterDisplay extends Actor implements Disposable {

    //Constants
    private static final int SPRITESHEET_HEIGHT = 21;
    private static final int SPRITESHEET_WIDTH = 13;

    private TextureRegion[] characterTextures;
    private ArrayList<TextureRegion[][]> sheets;
    private SpritesheetValues displayValue;
    private Character character;

    public int indexSkinType = 0;
    public int indexHeadWear = 0;
    public int indexChestWear = 0;
    public int indexLegWear = 0;
    public int indexFeetWear = 0;
    
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

        loadTextures();
    }

    /**
     * Chooses a display type; front, back, left or right
     */
    public void chooseDisplay(SpritesheetValues displayValue) {
        this.displayValue = displayValue;

        characterTextures = new TextureRegion[sheets.size()];

        for (int i = 0; i < characterTextures.length; i++) {
            characterTextures[i] = sheets.get(i)[displayValue.ROW][displayValue.START_COL];
        }
    }

    /**
     * Reloads the current textures for drawing
     */
    private void loadTextures() {
        sheets.clear();

        for(Texture texture : character.getTraitsTextures()) {
            TextureRegion[][] tempRegion = TextureRegion.split(texture,
                    texture.getWidth()/SPRITESHEET_WIDTH,
                    texture.getHeight()/SPRITESHEET_HEIGHT);

            sheets.add(tempRegion);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        loadTextures();
        chooseDisplay(displayValue);

        for(TextureRegion texture : characterTextures) {

            float windowWidth = Gdx.graphics.getWidth();
            float windowHeight = Gdx.graphics.getHeight();

            float textureWidth = windowWidth / 2.5f;
            float textureHeight = windowHeight / 2.5f;

            //batch.draw(texture, 0, 0, windowWidth, windowHeight);

            batch.draw(texture,
                        (windowWidth - (windowWidth / 4)) - (textureWidth / 2),
                        (windowHeight / 2) - (textureHeight / 2),
                        textureWidth,
                        textureHeight);
        }
    }

    @Override
    public void dispose() {
        character.dispose();
    }

    //==================Index changing===================

    public void nextSkin() {
        if (indexSkinType < EnumSkins.values().length - 1)
            indexSkinType++;
        else
            indexSkinType = 0;

        character.setSkinType(EnumSkins.values()[indexSkinType]);
    }

    public void previousSkin() {
        if (indexSkinType > 0)
            indexSkinType--;
        else
            indexSkinType = EnumSkins.values().length - 1;

        character.setSkinType(EnumSkins.values()[indexSkinType]);
    }

    public void nextHead() {
        if (indexHeadWear < EnumHeadWear.values().length - 1)
            indexHeadWear++;
        else
            indexHeadWear = 0;

        character.setHeadWear(EnumHeadWear.values()[indexHeadWear]);
    }

    public void previousHead() {
        if (indexHeadWear > 0)
            indexHeadWear--;
        else
            indexHeadWear = EnumHeadWear.values().length - 1;

        character.setHeadWear(EnumHeadWear.values()[indexHeadWear]);
    }
    
    public void nextChest() {
		if (indexChestWear < EnumChestWear.values().length - 1)
        	indexChestWear++;
        else
        	indexChestWear = 0;
		
		character.setChestWear(EnumChestWear.values()[indexChestWear]);
	}
    
	public void previousChest() {
		if (indexChestWear > 0)
        	indexChestWear--;
        else
        	indexChestWear = EnumChestWear.values().length - 1;

		character.setChestWear(EnumChestWear.values()[indexChestWear]);
	}

	public void nextLeg() {
        if (indexLegWear < EnumLegWear.values().length - 1)
            indexLegWear++;
        else
            indexLegWear = 0;

        character.setLegWear(EnumLegWear.values()[indexLegWear]);
    }

    public void previousLeg() {
        if (indexLegWear > 0)
            indexLegWear--;
        else
            indexLegWear = EnumLegWear.values().length - 1;

        character.setLegWear(EnumLegWear.values()[indexLegWear]);
    }

    public void nextFeet() {
        if (indexFeetWear < EnumFootWear.values().length - 1)
            indexFeetWear++;
        else
            indexFeetWear = 0;

        character.setFeetWear(EnumFootWear.values()[indexFeetWear]);
    }

    public void previousFeet() {
        if (indexFeetWear > 0)
            indexFeetWear--;
        else
            indexFeetWear = EnumFootWear.values().length - 1;

        character.setFeetWear(EnumFootWear.values()[indexFeetWear]);
    }
}
