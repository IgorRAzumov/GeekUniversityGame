package com.my_aircrafts_game.game.screens.menuScreen.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.assets.AudioManager;
import com.my_aircrafts_game.game.screens.menuScreen.models.Cloud;
import com.my_aircrafts_game.game.screens.menuScreen.models.World;


public class MenuScreenUIRenderer {
    private TextureAtlas.AtlasRegion startButtonImage;
    private TextureAtlas.AtlasRegion quitButtonImage;
    private World world;

    public MenuScreenUIRenderer() {
        reset();
    }

    public void init(World world) {
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
        spriteBatch.draw(quitButtonImage, GameSettings.GAME_WIDTH - buttonBounds.width - 50, 50,
                quitButtonImage.getRegionWidth(), quitButtonImage.getRegionHeight());
    }

   /* public float getStartButtonImageWidth() {
        return startButtonImage.getRegionWidth();
    }

    public float getStartButtonImageHeight() {
        return startButtonImage.getRotatedPackedHeight();
    }

    public float getQuitButtonImageWidth() {
        return quitButtonImage.getRegionWidth();
    }

    public float getQuitButtonImageHeight() {
        return quitButtonImage.getRotatedPackedHeight();
    }*/

    private void reset() {
        startButtonImage = Assets.getInstance().mainAtlas.findRegion("startButtonClick");
        quitButtonImage = Assets.getInstance().mainAtlas.findRegion("quitButtonClick");
    }


}
