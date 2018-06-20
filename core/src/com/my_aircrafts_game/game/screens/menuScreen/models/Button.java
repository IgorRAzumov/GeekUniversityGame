package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.math.Rectangle;


public class Button {
    private Rectangle rectangle;

    Button(float x, float y, float buttonWidth, float buttonHeight) {
        rectangle = new Rectangle(x, y, buttonWidth, buttonHeight);

    }

    public Rectangle getBounds() {
        return rectangle;
    }
}
