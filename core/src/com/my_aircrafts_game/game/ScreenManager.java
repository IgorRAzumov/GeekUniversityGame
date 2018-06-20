package com.my_aircrafts_game.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.screens.gameScreen.GameScreen;
import com.my_aircrafts_game.game.screens.menuScreen.MenuScreen;


public class ScreenManager {
    public enum ScreenType {
        MENU, GAME
    }

    private static final ScreenManager SCREEN_MANAGER_INSTANCE = new ScreenManager();

    public static ScreenManager getInstance() {
        return SCREEN_MANAGER_INSTANCE;
    }

    private Game game;
    private Viewport viewport;
    private Camera camera;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;

    private ScreenManager(){}

    public void init(Game game) {
        this.game = game;
        camera = new OrthographicCamera(GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT);
        viewport = new FitViewport(GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT, camera);
        viewport.update(GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT, true);
        viewport.apply();
        menuScreen = new MenuScreen(((StartGame) game).spriteBatch);
        gameScreen = new GameScreen(((StartGame) game).spriteBatch);
    }

    public Camera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void onResize(int width, int height) {
        viewport.update(width, height, true);
        viewport.apply();
    }

    public void switchScreen(ScreenType type) {
        Screen screen = game.getScreen();
        Assets.getInstance().assetManager.clear();
        Assets.getInstance().assetManager.dispose();
        Assets.getInstance().assetManager = new AssetManager();
        if (screen != null) {
            screen.dispose();
        }
        switch (type) {
            case MENU:
               Assets.getInstance().loadAssets(ScreenType.MENU);
                game.setScreen(menuScreen);
                break;
            case GAME:
                Assets.getInstance().loadAssets(ScreenType.GAME);
                game.setScreen(gameScreen);
                break;
        }
    }
}
