package com.evergreen.titz;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.evergreen.titz.Traits.EnumChestWear;
import com.evergreen.titz.Traits.EnumFootWear;
import com.evergreen.titz.Traits.EnumHeadWear;
import com.evergreen.titz.Traits.EnumLegWear;
import com.evergreen.titz.Traits.EnumSkins;

public class Character implements Disposable {

    private static final String DEFAULT_MALE_CHARACTER_SKIN = "body/male/tanned.png";
    private static final String DEFAULT_FEMALE_CHARACTER_SKIN = "body/female/tanned.png";

    private Traits.EnumHeadWear headWear;
    private Traits.EnumChestWear chestWear;
    private Traits.EnumLegWear legWear;
    private Traits.EnumFootWear footWear;
    private Traits.EnumSkins skinType;
        
    public Character(EnumHeadWear headWear, EnumChestWear chestWear, EnumLegWear legWear, EnumFootWear footWear) {
        skinType = EnumSkins.TANNED_MALE;
    	
    	this.headWear = headWear;
    	this.chestWear = chestWear;
    	this.legWear = legWear;
    	this.footWear = footWear;
    }

    public Character(EnumHeadWear headWear, EnumChestWear chestWear, EnumLegWear legWear, EnumFootWear footWear, EnumSkins skinType) {
        this.skinType = skinType;

        this.headWear = headWear;
        this.chestWear = chestWear;
        this.legWear = legWear;
        this.footWear = footWear;
    }

    public void setSkinType(Traits.EnumSkins skinType) {
        this.skinType = skinType;
    }
    
	public void setHeadWear(Traits.EnumHeadWear headWear) {
	  this.headWear = headWear;
	}
	
	public void setChestWear(Traits.EnumChestWear chestWear) {
		this.chestWear = chestWear;
	}

	public void setLegWear(Traits.EnumLegWear legWear) {
		this.legWear = legWear;
	}
	
	public void setFeetWear(Traits.EnumFootWear footWear) {
		this.footWear = footWear;
	}
    
    public Texture[] getTraitsTextures() {
        Texture[] wears = new Texture[5];

        wears[0] = skinType.getTexture();
        wears[1] = headWear.getTexture();
        wears[2] = chestWear.getTexture();
        wears[3] = legWear.getTexture();
        wears[4] = footWear.getTexture();

        return wears;
    }
    
    @Override
    public void dispose() {
    	// TODO: Dispose of all unused textures
    	
        for (Texture texture : getTraitsTextures()) {
            texture.dispose();
        }
    }
}
