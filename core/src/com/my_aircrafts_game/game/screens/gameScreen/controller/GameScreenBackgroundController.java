package com.my_aircrafts_game.game.screens.gameScreen.controller;

import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.screens.gameScreen.models.GameBackground;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;


public class GameScreenBackgroundController {
    private World world;

    public void init(World world) {
        this.world = world;
    }

    public void update(float delta) {
        GameBackground gameBackground = world.getGameBackground();
        float baseSpeed = gameBackground.getBaseSpeed();

        if (gameBackground.getBackgroundRect1().x - (delta * baseSpeed) <= 0) {
            gameBackground.resetBackground(gameBackground.getBackgroundRect(),
                    gameBackground.getBackgroundRect1());
        }

        if (gameBackground.getDistantHousesRect1().x - (delta * baseSpeed) <= 0) {
            gameBackground.resetBackground(gameBackground.getDistantHousesRect(),
                    gameBackground.getDistantHousesRect1());
        }

        if (gameBackground.getGreenHazeRect1().x - (delta * baseSpeed) <= 0) {
            gameBackground.resetBackground(gameBackground.getGreenHazeRect(),
                    gameBackground.getGreenHazeRect1());
        }

        if (gameBackground.getHousesRect1().x - (delta * baseSpeed) <= 0) {
            gameBackground.resetBackground(gameBackground.getHousesRect(),
                    gameBackground.getHousesRect1());
        }
        gameBackground.update(delta);

        GameBackground.Moon moon = world.getGameBackground().getMoon();

        Rectangle modelBounds = moon.getBounds();
        if (modelBounds.x < -modelBounds.width / 2f ||
                modelBounds.y > GameSettings.GAME_HEIGHT + modelBounds.height / 2f) {
            moon.setActive(false);
        }
    }
}
