package com.my_aircrafts_game.game.screens.gameScreen.models;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;




public class Explosion extends AbstractModel implements Pool.Poolable {
    private boolean active;
    private GameAnimation animation;

    public Explosion() {
        super();
    }

    public void init(GameAnimation animation, Vector2 position, Vector2 velocity) {
        animation.init(6);
        this.animation = animation;
        this.position.set(position);
        this.velocity.set(velocity);
        active = true;
    }

    @Override
    public void update(float deltaTime) {
        position.mulAdd(velocity, deltaTime);
        animation.update(deltaTime);
    }

    @Override
    public void reset() {
        position.set(0f, 0f);
        velocity.set(0f, 0f);
        active = false;
        animation = null;
    }

    public boolean isActive() {
        return active;
    }


    public int getFrameNumber() {
        return animation.getFrameNumber();
    }
}
