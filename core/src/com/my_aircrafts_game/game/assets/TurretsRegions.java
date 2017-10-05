package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * Created by XXX on 23.09.2017.
 */

public class TurretsRegions {
    private Array<TextureAtlas.AtlasRegion> turretFire;

    public TurretsRegions() {
        reset();
    }

    public TextureAtlas.AtlasRegion getImageTurretByFrame(int frame) {
        return turretFire.get(frame);
    }

    public void reset() {
        turretFire = new Array<TextureAtlas.AtlasRegion>();
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire1"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire2"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire3"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire4"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire5"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire6"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire7"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire8"));
        turretFire.add(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("turret_fire9"));

    }
}
