package com.my_aircrafts_game.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.StartGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GameSettings.GAME_WIDTH;
        config.height = GameSettings.GAME_HEIGHT;
        new LwjglApplication(new StartGame(), config);
    }
}
