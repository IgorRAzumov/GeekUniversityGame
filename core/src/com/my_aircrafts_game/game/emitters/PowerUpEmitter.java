package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.my_aircrafts_game.game.screens.gameScreen.models.PowerUp;


public class PowerUpEmitter {
   public  enum PowerUpType {LIFE_POWER_UP, KILL_ALL_POWER_UP, COIN_POWER_UP}

    private static final PowerUpEmitter POWER_UP_EMITTER = new PowerUpEmitter();

    static PowerUpEmitter getInstance() {
        return POWER_UP_EMITTER;
    }

    private Pool<PowerUp> powerUpPool;
    Array<PowerUp> activePowerUps;

    private PowerUpEmitter() {
        powerUpPool = new Pool<PowerUp>(10) {
            @Override
            protected PowerUp newObject() {
                return new PowerUp();
            }
        };
        activePowerUps = new Array<PowerUp>();
    }

    void setupPowerUp(Vector2 position) {
        PowerUp powerUp = powerUpPool.obtain();
        powerUp.init(position, getTypePowerUp());
        activePowerUps.add(powerUp);
    }

    void update(float deltaTime) {
        int length = activePowerUps.size;
        PowerUp powerUp;
        for (int i = length; --i >= 0; ) {
            powerUp = activePowerUps.get(i);
            powerUp.update(deltaTime);
            if (!powerUp.isActive()) {
                activePowerUps.removeIndex(i);
            }
        }
    }

    private PowerUpType getTypePowerUp() {
        PowerUpType type = null;
        switch (MathUtils.random(1, PowerUpType.values().length)) {
            case 1: {
                type = PowerUpType.LIFE_POWER_UP;
                break;
            }
            case 2: {
                type = PowerUpType.COIN_POWER_UP;
                break;
            }
            case 3: {
                type = PowerUpType.KILL_ALL_POWER_UP;
                break;
            }
        }
        if (type == null) new RuntimeException("wrong powerUp type");
        return type;
    }

    void reset() {
        activePowerUps.clear();
        powerUpPool.clear();
    }
}
