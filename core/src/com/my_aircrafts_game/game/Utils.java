package com.my_aircrafts_game.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import static java.lang.Math.atan2;


public class Utils {

    public static float getAngle(float x1, float y1, float x2, float y2) {
        return MathUtils.radiansToDegrees * (float) atan2(y2 - y1, x2 - x1);
    }

    public static Array<TextureRegion> initAnimationArray(TextureAtlas.AtlasRegion atlasRegion,
                                                          int framesPerRow, int rowCount) {
        Array<TextureRegion> animationRegions = new Array<TextureRegion>(framesPerRow);
        int frameWidth = atlasRegion.getRegionWidth() / framesPerRow;
        int frameHeight = atlasRegion.getRegionHeight() / rowCount;
        TextureRegion[][] tmp = atlasRegion.split(frameWidth, frameHeight);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < framesPerRow; j++) {
                animationRegions.add(tmp[i][j]);
            }
        }
        return animationRegions;
    }
}
