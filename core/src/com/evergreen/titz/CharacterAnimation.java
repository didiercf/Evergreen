package com.evergreen.titz;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by apollo on 11/12/2016.
 */
public class CharacterAnimation {

    private static final float ANIMATION_SPEED = 0.15f;

    public Animation getSpriteAnimation() {
        if (spriteAnimation == null)
            throw new NullPointerException("Animation type wasn't chosen");

        return spriteAnimation;
    }

    private Animation spriteAnimation;
    private Texture spriteSheet;
    private TextureRegion[] animationFrames;
    private TextureRegion[][] splitSheet;

    public CharacterAnimation(String pSpriteSheetPath) {
        spriteSheet = new Texture(Gdx.files.internal(pSpriteSheetPath));
        splitSheet = TextureRegion.split(spriteSheet,
                                                    spriteSheet.getWidth()/SpritesheetValues.SPRITESHEET.WIDTH,
                                                    spriteSheet.getHeight()/SpritesheetValues.SPRITESHEET.HEIGHT);
    }

    public void ChooseAnimation(SpritesheetValues pAnimation) {
        animationFrames = new TextureRegion[pAnimation.END_COL];

        int index = 0;
        for (int i = pAnimation.START_COL; i <= pAnimation.END_COL; i++) {
            animationFrames[index++] = splitSheet[pAnimation.ROW][i];
        }

        spriteAnimation = new Animation(ANIMATION_SPEED, animationFrames);
    }

    public void dispose() {
        spriteSheet.dispose();
    }
}
