package com.my_aircrafts_game.game.screens.gameScreen.models;


public class GameAnimation {
    private boolean active;
    private float time;
    private int key;
    private int frames;

    public GameAnimation() {
    }

    public void init(int frames) {
        this.frames = frames;
        active = true;
        time = 0f;
    }

    public void update(float deltaTime) {
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

    public void reset() {
        key = 0;
        frames = 0;
        time = 0f;
    }

    public int getFrameNumber() {
        return key;
    }

    public boolean isActive() {
        return active;
    }
}