package com.my_aircrafts_game.game.screens.gameScreen.models;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class AbstractModel {
    protected Vector2 velocity;
    protected Vector2 position;
    protected Rectangle hitArea;


    public AbstractModel() {
        position = new Vector2(0f, 0f);
        velocity = new Vector2(0f, 0f);
        hitArea = new Rectangle();
    }

    public void init(float x, float y, float vx, float vy,float rectangleWidth, float rectangleHeight) {
        position.set(x, y);
        velocity.set(vx, vy);
        hitArea.setSize( 0.7f* rectangleWidth, 0.4f* rectangleHeight);
    }

    public void update(float deltaTime) {
        position.mulAdd(velocity, deltaTime);
        hitArea.x = position.x - hitArea.width / 2f;
        hitArea.y = position.y - hitArea.height / 2f;

    }

    public Vector2 getPosition() {
        return position;
    }


    public void addVelocity(float x, float y) {
        velocity.add(x, y);
    }

    public void setVelocity(float vx, float vy) {
        velocity.set(vx, vy);
    }

    public Vector2 getVelocity() {
        return velocity;
    }


    public Rectangle getHitArea() {
        return hitArea;
    }
}
