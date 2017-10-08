package com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts;

import com.badlogic.gdx.math.Vector2;

import static com.my_aircrafts_game.game.GameSettings.*;


public class HeroAircraft extends AbstractAircraft {
    public int score;
    private float damageAlarm;
    private float maxSpeed;


    public HeroAircraft() {
        super();
    }

    public void init(float x, float y, float vx, float vy, float rectangleWidth, float rectangleHeight) {
        super.init(x, y, vx, vy, rectangleWidth, rectangleHeight);
        size.set(rectangleWidth, rectangleHeight);
        rotationAngle = 180f;

        baseSpeed = PLAYER_CRAFT_MIN_SPEED;
        maxSpeed = PLAYER_CRAFT_MAX_SPEED;

        lifeCounter = PLAYER_CRAFT_MAX_LIFE;
        fireRate = PLAYER_CRAFT_FIRE_RATE;

        isItBot = false;
        active = true;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        velocity.scl(PLAYER_CRAFT_DECELERATION);

        if (baseSpeed > maxSpeed) {
            baseSpeed = maxSpeed;
        }

        if (damageAlarm > 0.0f) {
            damageAlarm -= deltaTime / 2.0f;
        }
    }

    @Override
    public void takeDamage() {
        damageAlarm += 0.7f;
        if (damageAlarm > 1.4f) damageAlarm = 1.4f;
        super.takeDamage();
    }

    public float getDamageAlarm() {
        return damageAlarm;
    }

    public void addSpeed(float acceleration) {
        baseSpeed += acceleration;
    }
}
