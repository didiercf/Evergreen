package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by apollo on 11/29/2016.
 */
public class Animation {

    private static final int SPRITESHEET_HEIGHT = 21;
    private static final int SPRITESHEET_WIDTH = 13;

    private static final float ANIMATION_SPEED = 0.15f;

    private Texture spriteSheet;
    private TextureRegion[] animationFrames;
    private TextureRegion[][] splitSheet;
    private com.badlogic.gdx.graphics.g2d.Animation spriteAnimation;

    private float stateTime;

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public com.badlogic.gdx.graphics.g2d.Animation getSpriteAnimation() {
        if (spriteAnimation == null)
            throw new NullPointerException("Animation type wasn't chosen");

        return spriteAnimation;
    }

    public Animation(String spriteSheetPath) {
        spriteSheet = new Texture(Gdx.files.internal(spriteSheetPath));
        splitSheet = TextureRegion.split(spriteSheet,
                spriteSheet.getWidth()/SPRITESHEET_WIDTH,
                spriteSheet.getHeight()/SPRITESHEET_HEIGHT );

        stateTime = 0f;
    }

    public void chooseAnimation(SpritesheetValues animationValues) {
        animationFrames = new TextureRegion[animationValues.END_COL];

        int index = 0;
        for (int i = animationValues.START_COL; i <= animationValues.END_COL; i++) {
            animationFrames[index++] = splitSheet[animationValues.ROW][i];
        }

        spriteAnimation = new com.badlogic.gdx.graphics.g2d.Animation(ANIMATION_SPEED, animationFrames);
    }
}
