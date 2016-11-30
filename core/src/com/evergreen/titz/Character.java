package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.evergreen.titz.Clothes.EnumChestWear;
import com.evergreen.titz.Clothes.EnumFootWear;
import com.evergreen.titz.Clothes.EnumHeadWear;
import com.evergreen.titz.Clothes.EnumLegWear;

public class Character implements Disposable {

    private static final String DEFAULT_MALE_CHARACTER_SKIN = "body/male/tanned.png";
    private static final String DEFAULT_FEMALE_CHARACTER_SKIN = "body/female/tanned.png";

    private Texture characterSheet;

    private Clothes.EnumHeadWear headWear;
    private Clothes.EnumChestWear chestWear;
    private Clothes.EnumLegWear legWear;
    private Clothes.EnumFootWear footWear;
        
    public Character(EnumHeadWear headWear, EnumChestWear chestWear, EnumLegWear legWear, EnumFootWear footWear, Genders gender) {
    	if (gender.equals(Genders.MALE))
            this.characterSheet = new Texture(Gdx.files.internal(DEFAULT_MALE_CHARACTER_SKIN));
        else if (gender.equals(Genders.FEMALE))
            this.characterSheet = new Texture(Gdx.files.internal(DEFAULT_FEMALE_CHARACTER_SKIN));
        else
            throw new IllegalArgumentException("Nice try being a gender fluid, better luck next time.");
    	
    	this.headWear = headWear;
    	this.chestWear = chestWear;
    	this.legWear = legWear;
    	this.footWear = footWear;
    }

	public Texture getCharacterSheet() {
        return characterSheet;
    }
    
	public void setHeadWear(Clothes.EnumHeadWear headWear) {
	  this.headWear = headWear;
	}
	
	public void setChestWear(Clothes.EnumChestWear chestWear) {
		this.chestWear = chestWear;
	}

	public void setLegWear(Clothes.EnumLegWear legWear) {
		this.legWear = legWear;
	}
	
	public void setFeetWear(Clothes.EnumFootWear footWear) {
		this.footWear = footWear;
	}
    
    public Texture[] getClothesTextures() {
        Texture[] wears = new Texture[5];

        wears[0] = characterSheet;
        wears[1] = headWear.getTexture();
        wears[2] = chestWear.getTexture();
        wears[3] = legWear.getTexture();
        wears[4] = footWear.getTexture();

        return wears;
    }
    
    @Override
    public void dispose() {
    	// TODO: Dispose of all unused textures
    	
        for (Texture texture : getClothesTextures()) {
            texture.dispose();
        }
    }
}
