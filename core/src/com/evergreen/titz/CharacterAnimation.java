package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by apollo on 11/12/2016.
 */
public class CharacterAnimation implements Disposable {

    private static final int SPRITESHEET_HEIGHT = 21;
    private static final int SPRITESHEET_WIDTH = 13;

    private static final float ANIMATION_SPEED = 0.15f;

    public Animation getSpriteAnimation() {
        if (spriteAnimation == null)
            throw new NullPointerException("Animation type wasn't chosen");

        return spriteAnimation;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    private Animation spriteAnimation;
    private Texture spriteSheet;
    private TextureRegion[] animationFrames;
    private TextureRegion[][] splitSheet;

    private float stateTime;

    public CharacterAnimation(String pSpriteSheetPath) {
        spriteSheet = new Texture(Gdx.files.internal(pSpriteSheetPath));
        splitSheet = TextureRegion.split(spriteSheet,
                                                    spriteSheet.getWidth()/SPRITESHEET_WIDTH,
                                                    spriteSheet.getHeight()/SPRITESHEET_HEIGHT );

        stateTime = 0f;
    }

    public void ChooseAnimation(SpritesheetValues animationValues) {
        animationFrames = new TextureRegion[animationValues.END_COL];

        int index = 0;
        for (int i = animationValues.START_COL; i <= animationValues.END_COL; i++) {
            animationFrames[index++] = splitSheet[animationValues.ROW][i];
        }

        spriteAnimation = new Animation(ANIMATION_SPEED, animationFrames);
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
    }
}
