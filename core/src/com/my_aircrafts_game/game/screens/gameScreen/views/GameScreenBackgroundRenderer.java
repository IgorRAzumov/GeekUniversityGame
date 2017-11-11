package com.my_aircrafts_game.game.screens.gameScreen.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.assets.AudioManager;
import com.my_aircrafts_game.game.screens.gameScreen.models.GameBackground;

import com.my_aircrafts_game.game.screens.gameScreen.models.World;

import static com.my_aircrafts_game.game.GameSettings.GAME_WIDTH;


public class GameScreenBackgroundRenderer {
    private Texture backgroundImage;
    private TextureAtlas.AtlasRegion moonImage;
    private TextureAtlas.AtlasRegion distantHousesImage;
    private TextureAtlas.AtlasRegion greenHazeImage;
    private TextureAtlas.AtlasRegion housesImage;
    private World world;

    public GameScreenBackgroundRenderer() {
        reset();
    }

    public void init(World world) {
        this.world = world;
        AudioManager.getInstance().playMusic(GameSettings.GAME_MUSIC, true, 0.5f);
    }

    public void drawBackground(SpriteBatch spriteBatch) {
        GameBackground gameBackground = world.getGameBackground();
        Rectangle boundsModel;

        boundsModel = gameBackground.getBackgroundRect();
        spriteBatch.draw(backgroundImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getBackgroundRect1();
        spriteBatch.draw(backgroundImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        GameBackground.Moon moon = world.getGameBackground().getMoon();
        if (moon.isActive()) {
            boundsModel = moon.getBounds();
            spriteBatch.draw(moonImage, boundsModel.x - boundsModel.width / 2f, boundsModel.y - boundsModel.height / 2);
        }

        boundsModel = gameBackground.getDistantHousesRect();
        spriteBatch.draw(distantHousesImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getDistantHousesRect1();
        spriteBatch.draw(distantHousesImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getGreenHazeRect();
        spriteBatch.draw(greenHazeImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getGreenHazeRect1();
        spriteBatch.draw(greenHazeImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getHousesRect();
        spriteBatch.draw(housesImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);

        boundsModel = gameBackground.getHousesRect1();
        spriteBatch.draw(housesImage, boundsModel.x, boundsModel.y, GAME_WIDTH, boundsModel.height);
    }

    public void reset() {
        backgroundImage = Assets.getInstance().assetManager.get(GameSettings.GAME_BACKGROUND_ZERO_LAYER, Texture.class);
        distantHousesImage = Assets.getInstance().mainAtlas.findRegion(GameSettings.GAME_BACKGROUND_FIRST_LAYER);
        greenHazeImage = Assets.getInstance().mainAtlas.findRegion(GameSettings.GAME_BACKGROUND_SECOND_LAYER);
        housesImage = Assets.getInstance().mainAtlas.findRegion(GameSettings.GAME_BACKGROUND_THIRD_LAYER);
        moonImage = Assets.getInstance().mainAtlas.findRegion(GameSettings.GAME_BACKGROUND_ADDITION);
    }

    public float getDistantHousesImageHeight() {
        return distantHousesImage.getRegionHeight();
    }

    public float getGreenHazeImageHeight() {
        return greenHazeImage.getRegionHeight();
    }

    public float getHousesImageHeight() {
        return housesImage.getRegionHeight();
    }

    public void dispose() {
        backgroundImage.dispose();
        AudioManager.getInstance().disposeMusic(GameSettings.MENU_MUSIC);
    }

    public float getMoonImageWidth() {
        return moonImage.getRegionWidth();
    }

    public float getMoonImageHeight() {
        return moonImage.getRegionHeight();
    }
}