package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Renderable;

public class Character {

    private final String DEFAULT_MALE_CHARACTER_SKIN = "body/male/tanned.png";
    private final String DEFAULT_FEMALE_CHARACTER_SKIN = "body/female/tanned.png";

    private Texture characterSheet;

    private Texture headWear;
    private Texture chestWear;
    private Texture legWear;
    private Texture feetWear;

    public Character(String headWearFileName, String chestWearFileName, String legWearFileName, String feetWearFileName, String gender) {
        if (gender.equals(Genders.GENDERS.MALE))
            characterSheet = new Texture(Gdx.files.internal(DEFAULT_MALE_CHARACTER_SKIN));
        else if (gender.equals(Genders.GENDERS.FEMALE))
            characterSheet = new Texture(Gdx.files.internal(DEFAULT_FEMALE_CHARACTER_SKIN));
        else
            throw new IllegalArgumentException();

        headWear = new Texture(Gdx.files.internal(headWearFileName));
        chestWear = new Texture(Gdx.files.internal(chestWearFileName));
        legWear = new Texture(Gdx.files.internal(legWearFileName));
        feetWear = new Texture(Gdx.files.internal(feetWearFileName));
    }

    public void render(SpriteBatch batch) {
        batch.draw(characterSheet, 0, 0);
        batch.draw(headWear, 0, 0);
        batch.draw(chestWear, 0, 0);
        batch.draw(legWear, 0, 0);
        batch.draw(feetWear, 0, 0);
    }
}
