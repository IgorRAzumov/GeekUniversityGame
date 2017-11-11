package com.my_aircrafts_game.game.screens.gameScreen.views;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.assets.PowerUpsRegions;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;

import static com.my_aircrafts_game.game.GameSettings.FONT;
import static com.my_aircrafts_game.game.GameSettings.GAME_HEIGHT;


public class GameScreenUIRenderer {
    private static final String SCORE = "SCORE: ";
    private static final String RED_LINE = "red_line";
    private static final String GREEN_LINE = "green_line";

    private World world;
    BitmapFont font;
    TextureAtlas.AtlasRegion redLiveLine;
    TextureAtlas.AtlasRegion greenLiveLine;
    TextureRegion coin;


    public void init(World world) {
        this.world = world;
        reset();

    }

    public void drawUI(SpriteBatch spriteBatch) {
        spriteBatch.draw(redLiveLine,
                40f,
                670f,
                redLiveLine.getRegionWidth(),
                redLiveLine.getRegionHeight());


        spriteBatch.draw(greenLiveLine,
                40f,
                670f,
                greenLiveLine.getRegionWidth() * world.getHeroAircraft().getLifeCounter() / GameSettings.PLAYER_CRAFT_MAX_LIFE,
                redLiveLine.getRegionHeight());

        float radius = coin.getRegionWidth() / 2 * 0.8f;
        spriteBatch.draw(coin, 57f + redLiveLine.getRegionWidth(), GAME_HEIGHT - radius - 35f,
                radius, radius, 2 * radius, 2 * radius, 0.8f, 0.8f, 0f);


        font.draw(spriteBatch,
                "x" + world.getMoney(),
                coin.getRegionWidth() + redLiveLine.getRegionWidth() + 50f, 695f
        );

        font.draw(spriteBatch, SCORE + world.getScore(),
                coin.getRegionWidth() + redLiveLine.getRegionWidth() + 90f, 695f
        );

    }

    public void reset() {
        font = Assets.getInstance().assetManager.get(FONT, BitmapFont.class);
        redLiveLine = Assets.getInstance().mainAtlas.findRegion(RED_LINE);
        greenLiveLine = Assets.getInstance().mainAtlas.findRegion(GREEN_LINE);
        TextureAtlas.AtlasRegion image = Assets.getInstance()
                .mainAtlas.findRegion(PowerUpsRegions.COIN_POWER_UP);
        coin = image.split(image.getRegionWidth() / 4, image.getRegionHeight())[0][0];

    }

    public void dispose() {
        font.dispose();

    }
}
