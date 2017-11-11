package com.my_aircrafts_game.game.screens.gameScreen.models;


import com.badlogic.gdx.math.Vector2;


public class Turret extends AbstractModel {
    boolean active;
    boolean fireNow;
    boolean firstFire;
    GameAnimation animation;

    public Turret() {
        super();
    }

    public void init(Vector2 position, int turretWidth, int turretHeight) {
        this.position.set(position);
        velocity.set(-80f, 0f);
        hitArea.set(this.position.x, this.position.y,turretWidth, turretHeight);
        animation = new GameAnimation();
        animation.init(9);
        firstFire = true;
        active = true;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        animation.update(deltaTime);

        if (animation.getFrameNumber() == 4 && firstFire) {
            fire();
            firstFire = false;
        }

        if (animation.getFrameNumber() == 5 && !firstFire) {
            fire();
            firstFire = true;
        }
    }

    private void fire() {
        fireNow = true;
        firstFire = !firstFire;
    }

    public void takeDamage() {
        active = false;
    }

    public boolean isFirstFire() {
        return firstFire;
    }

    public GameAnimation getAnimation() {
        return animation;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isFireNow() {
        return fireNow;
    }

    public void setFireNow(boolean fireNow) {
        this.fireNow = fireNow;
    }
}
