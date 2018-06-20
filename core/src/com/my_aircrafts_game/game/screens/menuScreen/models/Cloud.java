package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.my_aircrafts_game.game.GameSettings.CLOUDS_VELOCITY_X;
import static com.my_aircrafts_game.game.GameSettings.CLOUDS_VELOCITY_Y;
import static com.my_aircrafts_game.game.GameSettings.CLOUD_MAX_SCALE;
import static com.my_aircrafts_game.game.GameSettings.CLOUD_MIN_SCALE;
import static com.my_aircrafts_game.game.GameSettings.GAME_HEIGHT;
import static com.my_aircrafts_game.game.GameSettings.GAME_WIDTH;


public class Cloud {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle cloudBounds;
    private float scale;

    public Cloud() {
        position = new Vector2();
        velocity = new Vector2();
        cloudBounds = new Rectangle();
    }

    public void init(float cloudWidth, float cloudHeight) {
        scale = MathUtils.random(CLOUD_MIN_SCALE, CLOUD_MAX_SCALE);
        position.set(MathUtils.random(GAME_WIDTH), MathUtils.random(GAME_HEIGHT));
        velocity.set(CLOUDS_VELOCITY_X, CLOUDS_VELOCITY_Y);
        cloudBounds.set(position.x, position.y, cloudWidth * scale, cloudHeight * scale);
    }

    public void update(float deltaTime) {
        position.mulAdd(velocity, deltaTime);
        cloudBounds.setPosition(position);
    }

    public float getScale() {
        return scale;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPositionX(float positionX) {
        position.set(positionX, position.y);
    }

    public Rectangle getCloudBounds() {
        return cloudBounds;
    }
}
