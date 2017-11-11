package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class BulletsRegions {
    public static final String BULLET_REGION = "rocket";

    private TextureAtlas.AtlasRegion bullet;

    public BulletsRegions() {
        reset();
    }

    public TextureAtlas.AtlasRegion getBulletImage() {
        return bullet;
    }

    public void reset() {
        bullet = Assets.getInstance().mainAtlas.findRegion(BULLET_REGION);
    }
}
