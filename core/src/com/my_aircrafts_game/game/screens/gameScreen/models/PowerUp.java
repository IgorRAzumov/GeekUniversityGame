package com.my_aircrafts_game.game.screens.gameScreen.models;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.my_aircrafts_game.game.emitters.PowerUpEmitter;


public class PowerUp implements Pool.Poolable {
    private GameAnimation animation;
    private PowerUpEmitter.PowerUpType type;
    private Vector2 position;
    private boolean active;

    public PowerUp() {
        position = new Vector2(0f, 0f);
    }

    public void init(Vector2 position, PowerUpEmitter.PowerUpType type) {
        this.position = new Vector2(position);
        this.type = type;
        this.animation = new GameAnimation();
        animation.init(4, position);
        active = true;
    }

    public void update(float deltaTime) {
        animation.update(deltaTime);
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getCurrentFrameNumber() {
        return animation.getFrameNumber();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PowerUpEmitter.PowerUpType getType() {
        return type;
    }

    @Override
    public void reset() {
        position.set(0f, 0f);
        type = null;
        animation = null;
    }
}
