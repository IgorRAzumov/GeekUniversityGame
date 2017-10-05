package com.my_aircrafts_game.game.screens.gameScreen.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;


public class GameAnimation implements Pool.Poolable {
    private Vector2 position;
    private boolean active;
    private float time;
    private int key;
    private int frames;
    private Vector2 velocity;


    public GameAnimation() {
        position = new Vector2(0f, 0f);
        velocity = new Vector2(0f, 0f);
    }

    public void init(int frames, Vector2 position) {
        this.position.set(position);
        this.frames = frames;
        active = true;
        time = 0f;
    }

    public void init(int frames, Vector2 position, Vector2 velocity) {
        this.velocity = velocity;
        init(frames, position);
    }

    public void update(float deltaTime) {
        position.mulAdd(velocity, deltaTime);
        if (key < frames) {
            time += deltaTime * 5;
            key = (int) time;
        }
        if (key >= frames) {
            key = 0;
            time = 0;
            active = false;
        }
    }

    @Override
    public void reset() {
        key = 0;
        frames = 0;
        time = 0f;
        position.set(0f, 0f);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }


    public int getFrameNumber() {
        return key;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }


}