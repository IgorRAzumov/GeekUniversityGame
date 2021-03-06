package com.my_aircrafts_game.game.screens.menuScreen.contoller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.ScreenManager;
import com.my_aircrafts_game.game.input.GameInputProcessor;
import com.my_aircrafts_game.game.screens.menuScreen.models.Cloud;
import com.my_aircrafts_game.game.screens.menuScreen.models.World;

public class MenuScreenController {
    private World world;

    public MenuScreenController(World world) {
        this.world = world;
    }

    public void update(float deltaTime) {
        checkTouchButton();

        for (Cloud cloud : world.getClouds()) {
            cloud.update(deltaTime);
            checkBounds(cloud);
        }
    }

    private void checkTouchButton() {
        GameInputProcessor gip = (GameInputProcessor) Gdx.input.getInputProcessor();
        Rectangle buttonBounds;

        buttonBounds = world.getButtonStart().getBounds();
        if (gip.isTouchedInArea(buttonBounds.x, buttonBounds.y,
                buttonBounds.width, buttonBounds.height) > -1) {
            ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.GAME);
        }

        buttonBounds = world.getQuitButton().getBounds();
        if (gip.isTouchedInArea(buttonBounds.x, buttonBounds.y,
                buttonBounds.width, buttonBounds.height) > -1) {
            Gdx.app.exit();
        }
    }

    private void checkBounds(Cloud cloud) {
        Rectangle cloudBounds = cloud.getCloudBounds();
        float halfWidth = cloudBounds.width / 2f * cloud.getScale();

        if (cloudBounds.x < -halfWidth) {
            cloud.setPositionX(GameSettings.GAME_WIDTH + halfWidth);
        }
    }
}
