package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.GameSettings;


public class Cloud {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle cloudBounds;
    private float scale;

    public Cloud() {
        position = new Vector2(0f, 0f);
        velocity = new Vector2(0f, 0f);
        cloudBounds = new Rectangle();
    }

    public void init(float cloudWidth, float cloudHeight) {
        scale = MathUtils.random(GameSettings.CLOUD_MIN_SCALE, GameSettings.CLOUD_MAX_SCALE);
        position.set(MathUtils.random(GameSettings.GAME_WIDTH), MathUtils.random(GameSettings.GAME_HEIGHT));
        velocity.set(GameSettings.CLOUDS_VELOCITY, 0);
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
