package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.GameSettings;


public class World {
    private Array<Cloud> clouds;

    private Button startButton;
    private Button quitButton;

    public void createClouds(int quantity, float cloudOriginWidth, float cloudOriginHeight) {
        clouds = new Array<Cloud>(GameSettings.CLOUDS_QUANTITY);
        Cloud cloud;
        for (int i = quantity; --i >= 0; ) {
            cloud = new Cloud();
            cloud.init(cloudOriginWidth, cloudOriginHeight);
            clouds.add(cloud);
        }
    }

    public void createButtons() {
        startButton = new Button();
        startButton.init(50, 50, 300f, 167f);

        quitButton = new Button();
        getQuitButton().init(GameSettings.GAME_WIDTH - 300f - 50, 50, 300f, 160f);
    }

    public Array<Cloud> getClouds() {
        return clouds;
    }

    public Button getButtonStart() {
        return startButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }
}
