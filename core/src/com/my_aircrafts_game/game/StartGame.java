package com.my_aircrafts_game.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.my_aircrafts_game.game.input.GameInputProcessor;


public class StartGame extends Game {
    SpriteBatch spriteBatch;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        GameInputProcessor gameInputProcessor = new GameInputProcessor();
        Gdx.input.setInputProcessor(gameInputProcessor);
        ScreenManager.getInstance().init(this);
        ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.MENU);
    }

    @Override
    public void render() {
       float deltaTime = Gdx.graphics.getDeltaTime();
        getScreen().render(deltaTime);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
