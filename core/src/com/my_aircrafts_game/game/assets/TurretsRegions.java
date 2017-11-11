package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;




public class TurretsRegions {
    private static final String TURRET_FIRE_1 = "turret_fire1";
    private static final String TURRET_FIRE_2 = "turret_fire2";
    private static final String TURRET_FIRE_3 = "turret_fire3";
    private static final String TURRET_FIRE_4 = "turret_fire4";
    private static final String TURRET_FIRE_5 = "turret_fire5";
    private static final String TURRET_FIRE_6 = "turret_fire6";
    private static final String TURRET_FIRE_7 = "turret_fire7";
    private static final String TURRET_FIRE_8 = "turret_fire8";
    private static final String TURRET_FIRE_9 = "turret_fire8";

    private Array<TextureAtlas.AtlasRegion> turretFire;

    public TurretsRegions() {
        reset();
    }

    public TextureAtlas.AtlasRegion getImageTurretByFrame(int frame) {
        return turretFire.get(frame);
    }

    public void reset() {
        turretFire = new Array<TextureAtlas.AtlasRegion>();
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_1));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_2));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_3));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_4));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_5));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_6));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_7));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_8));
        turretFire.add(Assets.getInstance().mainAtlas.findRegion(TURRET_FIRE_9));
    }
}
