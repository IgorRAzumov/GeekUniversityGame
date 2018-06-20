package com.my_aircrafts_game.game.screens.menuScreen.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.screens.menuScreen.models.World;

import static com.my_aircrafts_game.game.GameSettings.QUIT_BUTTON_REGION;
import static com.my_aircrafts_game.game.GameSettings.START_BUTTON_REGION;


public class MenuScreenUIRenderer {


    private TextureAtlas.AtlasRegion startButtonImage;
    private TextureAtlas.AtlasRegion quitButtonImage;
    private World world;

    public MenuScreenUIRenderer(World world) {
        reset();
        this.world = world;
    }

    public void drawUI(SpriteBatch spriteBatch) {
        drawButtons(spriteBatch);
    }

    private void drawButtons(SpriteBatch spriteBatch) {
        Rectangle buttonBounds;
        buttonBounds = world.getButtonStart().getBounds();

        spriteBatch.draw(startButtonImage, buttonBounds.x, buttonBounds.y, buttonBounds.width,
                buttonBounds.height);

        buttonBounds=world.getQuitButton().getBounds();
        spriteBatch.draw(quitButtonImage, buttonBounds.x, buttonBounds.y,
                buttonBounds.width, buttonBounds.height);
    }

    private void reset() {
        startButtonImage = Assets.getInstance().mainAtlas.findRegion(START_BUTTON_REGION);
        quitButtonImage = Assets.getInstance().mainAtlas.findRegion(QUIT_BUTTON_REGION);
    }
}
