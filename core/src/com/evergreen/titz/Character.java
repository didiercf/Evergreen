package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Character {

    private final String DEFAULT_MALE_CHARACTER_SKIN = "body/male/tanned.png";
    private final String DEFAULT_FEMALE_CHARACTER_SKIN = "body/female/tanned.png";

    private Texture characterSheet;

    public Texture getCharacterSheet() {
        return characterSheet;
    }

    public Texture getHeadWear() {
        return headWear;
    }

    public Texture getChestWear() {
        return chestWear;
    }

    public Texture getLegWear() {
        return legWear;
    }

    public Texture getFeetWear() {
        return feetWear;
    }

    public Texture[] getWears() {
        Texture[] wears = new Texture[5];

        wears[0] = characterSheet;
        wears[1] = headWear;
        wears[2] = chestWear;
        wears[3] = legWear;
        wears[4] = feetWear;

        return wears;
    }

    private Texture headWear;
    private Texture chestWear;
    private Texture legWear;
    private Texture feetWear;

    public Character(String headWearFileName, String chestWearFileName, String legWearFileName, String feetWearFileName, Genders gender) {
        if (gender.equals(Genders.MALE))
            characterSheet = new Texture(Gdx.files.internal(DEFAULT_MALE_CHARACTER_SKIN));
        else if (gender.equals(Genders.FEMALE))
            characterSheet = new Texture(Gdx.files.internal(DEFAULT_FEMALE_CHARACTER_SKIN));
        else
            throw new IllegalArgumentException();

        headWear = new Texture(Gdx.files.internal("head/" + headWearFileName));
        chestWear = new Texture(Gdx.files.internal("chest/" + chestWearFileName));
        legWear = new Texture(Gdx.files.internal("legs/" + legWearFileName));
        feetWear = new Texture(Gdx.files.internal("feet/" + feetWearFileName));
    }
}
