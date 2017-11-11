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

    public static Array<TextureRegion> initAnimationsArrays(TextureAtlas.AtlasRegion atlasRegion,
                                                            int framesCount) {
        Array<TextureRegion> animationRegions = new Array<TextureRegion>(framesCount);
        int frameWidth = atlasRegion.getRegionWidth() / framesCount;
        int frameHeight = atlasRegion.getRegionHeight();
        TextureRegion[][] tmp = atlasRegion.split(frameWidth, frameHeight);
        //  int index = 0;
        int j = 0;// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < framesCount; i++) {
            animationRegions.add(tmp[j][i]);
        }
        return animationRegions;
    }
}
