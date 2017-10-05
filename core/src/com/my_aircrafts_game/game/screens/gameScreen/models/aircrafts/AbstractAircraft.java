package com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.emitters.BulletEmitter;
import com.my_aircrafts_game.game.screens.gameScreen.models.AbstractModel;

import static com.my_aircrafts_game.game.GameSettings.DAMAGE_VELOCITY_Y;


public abstract class AbstractAircraft extends AbstractModel {
    AircraftStatus aircraftStatus;
    protected Vector2 size;

    protected int lifeCounter;
    protected float baseSpeed;
    protected float rotationAngle;

    protected float fireRate;
    protected float fireCounter;

    protected boolean damagedWarning;

    protected boolean isItBot;

    protected boolean damaged;
    protected boolean active;


    //sounds flags
    protected boolean collisionByBullet;
    protected boolean wasShot;
    protected boolean collisionByAircraft;

    public AbstractAircraft() {
        super();
        aircraftStatus = AircraftStatus.DEFAULT;
        size = new Vector2(0f,0f);
    }


    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        //reset sound flags
        collisionByBullet = false;
        collisionByAircraft = false;
        wasShot = false;
    }

    public void tryToFire(float deltaTime) {
        fireCounter += deltaTime;
        if (fireCounter > fireRate) {
            fireCounter = 0;
            fire();
            wasShot = true;
        }
    }

    public void fire() {
        float radius = size.x / 2f;
        BulletEmitter.getInstance().setupBullet(isItBot,
                position.x + MathUtils.cosDeg(isItBot ? rotationAngle - 180f : 0f) * radius,
                position.y + MathUtils.sinDeg(isItBot ? rotationAngle - 180f : 0f) * radius,
                isItBot
                        ? rotationAngle - 180f
                        : 0f);
    }

    public void takeDamage() {
        if (--lifeCounter <= 0) {
            damaged = true;
            setDamagedVelocity();
        }
        damagedWarning = lifeCounter < 4;
    }

    private void setDamagedVelocity() {
        velocity.set(0f, DAMAGE_VELOCITY_Y);

    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public int getLifeCounter() {
        return lifeCounter;
    }

    public void addLife() {
        lifeCounter++;
    }


    public AircraftStatus getStatus() {
        return aircraftStatus;
    }

    public void setStatus(AircraftStatus aircraftStatus) {
        this.aircraftStatus = aircraftStatus;
    }


    public boolean wasShotNow() {
        return wasShot;
    }


    public boolean isDamaged() {
        return damaged;
    }

    public void setDamagedCollision(boolean value) {
        damaged = value;
        setDamagedVelocity();
        collisionByAircraft = true;
    }


    public boolean isDamagedWarning() {
        return damagedWarning;
    }

    public float getAngle() {
        return rotationAngle;
    }

    public float getBaseSpeed() {
        return baseSpeed;
    }

    public void dispose() {

    }


    public boolean wasCollisionByBullet() {
        return collisionByBullet;
    }

    public void setCollisionByBullet(boolean collision) {
        collisionByBullet = collision;
    }


    public boolean wasCollisionByAircraft() {
        return collisionByAircraft;
    }

    public Vector2 getSize() {
        return size;
    }
}

