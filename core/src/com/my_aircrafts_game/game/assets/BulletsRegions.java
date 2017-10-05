package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.my_aircrafts_game.game.GameSettings;

/**
 * Created by XXX on 23.09.2017.
 */

public class BulletsRegions {
    private TextureAtlas.AtlasRegion bullet;

    public BulletsRegions() {
        reset();
    }

    public TextureAtlas.AtlasRegion getBulletImage() {
        return bullet;
    }

    public void reset() {
        bullet = com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion(GameSettings.BULLET_REGION);
    }


}
