package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by XXX on 21.09.2017.
 */

public class Button {
    private Rectangle rectangle;

    public Button() {
        rectangle = new Rectangle();
    }

    public void init(float x, float y, float buttonWidth, float buttonHeight) {
        rectangle.set(x,y, buttonWidth, buttonHeight);
    }

    public Rectangle getBounds() {
        return rectangle;
    }
}
