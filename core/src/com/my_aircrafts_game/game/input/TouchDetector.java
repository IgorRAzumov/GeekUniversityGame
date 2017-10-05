package com.my_aircrafts_game.game.input;

import com.badlogic.gdx.Gdx;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.Utils;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AbstractAircraft;


public class TouchDetector {
    public boolean isTouched;
    int lastId;
    AbstractAircraft playerAircraft;
    float touchX;
    float touchY;


    public TouchDetector() {
        lastId = -1;
    }


    public void update() {
        isTouched = false;
        GameInputProcessor gip = (GameInputProcessor) Gdx.input.getInputProcessor();

        if (lastId == -1) {
            lastId = gip.isTouchedInArea(0, 0, GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT);
        }

        if (lastId > -1) {
            isTouched = true;
            touchX = gip.getX(lastId);
            touchY = gip.getY(lastId);
        }

        if (lastId > -1 && !gip.isTouched(lastId)) lastId = -1;
    }

    public float getAngle(float x, float y) {
        return Utils.getAngle(x, y, touchX, touchY);
    }
}
