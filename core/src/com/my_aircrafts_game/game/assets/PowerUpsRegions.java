package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.Utils;
import com.my_aircrafts_game.game.emitters.PowerUpEmitter;

import static com.my_aircrafts_game.game.assets.Assets.getInstance;


public class PowerUpsRegions {
    public static final String COIN_POWER_UP = "coin_power_up";
    private static final String KILL_ALL_POWER_UP = "kill_all_power_up";
    private static final String LIFE_POWER_UP = "life_power_up";
    private static final int COIN_POWER_UP_FRAMES = 4;
    private static final int KILL_ALL_POWER_UP_FRAMES = 4;
    private static final int LIFE_POWER_UP_FRAMES = 4;


    private Array<TextureRegion> coinPowerUp;
    private Array<TextureRegion> killAllPowerUp;
    private Array<TextureRegion> lifePowerUp;

    public PowerUpsRegions() {
        reset();
    }

    public void reset() {
        coinPowerUp = Utils.initAnimationArray(getInstance().mainAtlas.findRegion(COIN_POWER_UP),
                COIN_POWER_UP_FRAMES, 1);

        killAllPowerUp = Utils.initAnimationArray(
                getInstance().mainAtlas.findRegion(KILL_ALL_POWER_UP), KILL_ALL_POWER_UP_FRAMES, 1);

        lifePowerUp = Utils.initAnimationArray(getInstance().mainAtlas.findRegion(LIFE_POWER_UP),
                LIFE_POWER_UP_FRAMES, 1);
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
        return tempRegions;
    }
}
