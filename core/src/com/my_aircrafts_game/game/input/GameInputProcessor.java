package com.my_aircrafts_game.game.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.ScreenManager;

import java.util.HashMap;


public class GameInputProcessor implements InputProcessor {
    class TouchInfo {
        float x;
        float y;
        boolean isTouched;
    }

    private HashMap<Integer, TouchInfo> touchMap = new HashMap<Integer, TouchInfo>();

    public GameInputProcessor() {
        for (int i = 0; i < GameSettings.QUANTITY_TOUCH; i++) {
            touchMap.put(i, new TouchInfo());
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchMap.get(pointer).x = ScreenManager.getInstance().getViewport()
                .unproject(new Vector2(screenX, 0)).x;
        touchMap.get(pointer).y = ScreenManager.getInstance().getViewport()
                .unproject(new Vector2(0, screenY)).y;
        touchMap.get(pointer).isTouched = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touchMap.get(pointer).x = 0;
        touchMap.get(pointer).y = 0;
        touchMap.get(pointer).isTouched = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touchMap.get(pointer).isTouched = true;
        touchMap.get(pointer).x = (int) ScreenManager.getInstance().getViewport().unproject(new Vector2(screenX, 0)).x;
        touchMap.get(pointer).y = (int) ScreenManager.getInstance().getViewport().unproject(new Vector2(0, screenY)).y;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    public void clear() {
        for (int i = 0; i < GameSettings.QUANTITY_TOUCH; i++) {
            touchMap.put(i, new TouchInfo());
        }
    }

    public int isTouchedInArea(float startX, float startY, float areaWidth, float areaHeight) {
        for (HashMap.Entry<Integer, TouchInfo> entry : touchMap.entrySet()) {
            if (entry.getValue().isTouched) {
                int id = entry.getKey();
                TouchInfo tInfo = entry.getValue();
                if (tInfo.x > startX && tInfo.x < startX + areaWidth
                        && tInfo.y > startY && tInfo.y < startY + areaHeight) {
                    return id;
                }
            }
        }
        return -1;
    }

    public boolean isTouched(int pointer) {
        return touchMap.get(pointer).isTouched;
    }

    public float getY(int pointer) {
        return touchMap.get(pointer).y;
    }

    public float getX(int pointer) {
        return touchMap.get(pointer).x;
    }


}

