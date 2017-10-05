package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.Utils;
import com.my_aircrafts_game.game.emitters.PowerUpEmitter;

public class PowerUpsRegions {
    private Array<TextureRegion> coinPowerUp;
    private Array<TextureRegion> killAllPowerUp;
    private Array<TextureRegion> lifePowerUp;

    public PowerUpsRegions() {
        reset();
    }

    public void reset() {
        coinPowerUp = Utils.initAnimationsArrays(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("coin_power_up"), 4);
        killAllPowerUp = Utils.initAnimationsArrays(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("kill_all_power_up"), 4);
        lifePowerUp = Utils.initAnimationsArrays(com.my_aircrafts_game.game.assets.Assets.getInstance().mainAtlas.findRegion("life_power_up"), 4);
    }

    public Array<TextureRegion> getRegionsByType(PowerUpEmitter.PowerUpType type) {
        Array<TextureRegion> tempRegions = null;
        switch (type) {
            case COIN_POWER_UP: {
                tempRegions = coinPowerUp;
                break;
            }
            case KILL_ALL_POWER_UP: {
                tempRegions = killAllPowerUp;
                break;
            }
            case LIFE_POWER_UP: {
                tempRegions = lifePowerUp;
                break;
            }

        }
        if (tempRegions == null) throw new RuntimeException("invalid type powerUp");
        return tempRegions;
    }
}
