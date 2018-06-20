package com.my_aircrafts_game.game.screens.menuScreen.models;

import com.badlogic.gdx.utils.Array;

import static com.my_aircrafts_game.game.GameSettings.CLOUDS_QUANTITY;
import static com.my_aircrafts_game.game.GameSettings.QUIT_BUTTON_HEIGHT;
import static com.my_aircrafts_game.game.GameSettings.QUIT_BUTTON_POSITION_X;
import static com.my_aircrafts_game.game.GameSettings.QUIT_BUTTON_POSITION_Y;
import static com.my_aircrafts_game.game.GameSettings.QUIT_BUTTON_WIDTH;
import static com.my_aircrafts_game.game.GameSettings.START_BUTTON_HEIGHT;
import static com.my_aircrafts_game.game.GameSettings.START_BUTTON_POSITION_X;
import static com.my_aircrafts_game.game.GameSettings.START_BUTTON_POSITION_Y;
import static com.my_aircrafts_game.game.GameSettings.START_BUTTON_WIDTH;


public class World {
    private Array<Cloud> clouds;
    private Button startButton;
    private Button quitButton;

    public void createClouds(int quantity, float cloudOriginWidth, float cloudOriginHeight) {
        clouds = new Array<Cloud>(CLOUDS_QUANTITY);
        Cloud cloud;
        for (int i = quantity; --i >= 0; ) {
            cloud = new Cloud();
            cloud.init(cloudOriginWidth, cloudOriginHeight);
            clouds.add(cloud);
        }
    }

    public void createButtons() {
        startButton = new Button(START_BUTTON_POSITION_X, START_BUTTON_POSITION_Y,
                START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
        quitButton = new Button(QUIT_BUTTON_POSITION_X, QUIT_BUTTON_POSITION_Y,
                QUIT_BUTTON_WIDTH, QUIT_BUTTON_HEIGHT);
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
