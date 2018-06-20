package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.Utils;


public class ExplosionsRegions {
    private static final String EXPLOSION_REGION = "explosion";

    private Array<TextureRegion> explosions;

    public ExplosionsRegions() {
        reset();
    }

    public TextureRegion getImageExplosionByFrame(int frameNumber){
        return explosions.get(frameNumber);
    }

    public void reset() {
        explosions = Utils.initAnimationArray(
                Assets.getInstance().mainAtlas.findRegion(EXPLOSION_REGION), 6, 1);
    }
}
