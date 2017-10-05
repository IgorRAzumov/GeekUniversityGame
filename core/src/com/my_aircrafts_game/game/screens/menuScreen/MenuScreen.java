package com.my_aircrafts_game.game.screens.menuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.my_aircrafts_game.game.ScreenManager;
import com.my_aircrafts_game.game.input.GameInputProcessor;
import com.my_aircrafts_game.game.screens.menuScreen.contoller.MenuScreenController;
import com.my_aircrafts_game.game.screens.menuScreen.models.World;
import com.my_aircrafts_game.game.screens.menuScreen.views.MenuScreenBackgroundRenderer;
import com.my_aircrafts_game.game.screens.menuScreen.views.MenuScreenUIRenderer;

public class MenuScreen implements Screen {
    private SpriteBatch spriteBatch;
    private World world;
    private MenuScreenController menuScreenController;
    private MenuScreenUIRenderer menuScreenUIRenderer;
    private MenuScreenBackgroundRenderer menuScreenBackgroundRenderer;

    public MenuScreen(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    @Override
    public void show() {
        menuScreenUIRenderer = new MenuScreenUIRenderer();
        menuScreenBackgroundRenderer = new MenuScreenBackgroundRenderer();
        menuScreenController = new MenuScreenController();

        world = new World();
        world.createClouds(70, menuScreenBackgroundRenderer.getCloudImageWidth(),
                menuScreenBackgroundRenderer.getCloudImageHeigth());
        world.createButtons();

        menuScreenUIRenderer.init(world);
        menuScreenBackgroundRenderer.init(world);
        menuScreenController.init(world);

        GameInputProcessor gip = (GameInputProcessor) Gdx.input.getInputProcessor();
        gip.clear();
    }

    @Override
    public void render(float delta) {
        menuScreenController.update(delta);

        Gdx.gl.glClearColor(0, 0, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(ScreenManager.getInstance().getCamera().combined);
        spriteBatch.begin();
        menuScreenBackgroundRenderer.drawBackground(spriteBatch);
        menuScreenUIRenderer.drawUI(spriteBatch);
        spriteBatch.end();
    }


    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        menuScreenBackgroundRenderer.dispose();
    }
}
