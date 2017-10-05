package com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

import static com.my_aircrafts_game.game.GameSettings.*;


public class AiAircraft extends AbstractAircraft implements Pool.Poolable {
    private static final float AI_CRAFT_ROTATION_SPEED = 180f;
    private int version;

    public AiAircraft() {
        super();
    }

    public void init(float x, float y, float vx, float vy, int aircraftWidth, int aircraftHeight,
                     int version) {
        super.init(x, y, vx, vy, aircraftWidth, aircraftHeight);
        size.set(aircraftWidth,aircraftHeight);

        rotationAngle = 0f;
        this.version = version;

        lifeCounter = AI_CRAFT_LIFE_COUNTER;
        fireRate = MathUtils.random(AI_CRAFT_MIN_FIRE_RATE, AI_CRAFT_MAX_FIRE_RATE);

        isItBot = true;
        active = true;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (!damaged) {
            tryToFire(deltaTime);
        } else {
            rotationAngle += AI_CRAFT_ROTATION_SPEED * deltaTime;

            if (position.y < size.y / 2f ) {
                active = false;
            }
        }
    }

    @Override
    public void reset() {
        version = -1;
        aircraftStatus = AircraftStatus.DEFAULT;
        position.set(0f, 0f);
        velocity.set(0f, 0f);
        size.set(0f,0f);
        hitArea.width = 0f;
        hitArea.height = 0f;
        hitArea.setPosition(0f, 0f);
        fireRate = 0f;
        fireCounter = 0f;
        baseSpeed = 0f;
        rotationAngle = 0f;

        active = false;
        damaged = false;
        wasShot = false;
        damagedWarning = false;
        isItBot = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getVersion() {
        return version;
    }
}
