package com.my_aircrafts_game.game.screens.gameScreen.views;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;

import java.awt.Font;

import static com.my_aircrafts_game.game.GameSettings.FONT;
import static com.my_aircrafts_game.game.GameSettings.GAME_HEIGHT;
import static com.my_aircrafts_game.game.GameSettings.OFFSET_SCORE_POSITION_X;


public class GameScreenUIRenderer {
    private World world;
    BitmapFont font;
    TextureAtlas.AtlasRegion redLiveLine;
    TextureAtlas.AtlasRegion greenLiveLine;
    TextureRegion money;


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

        float radius = money.getRegionWidth() / 2 * 0.8f;
        spriteBatch.draw(money, 57f + redLiveLine.getRegionWidth(), GAME_HEIGHT - radius -35f,
                radius, radius, 2 * radius, 2 * radius, 0.8f, 0.8f, 0f);

        font.draw(spriteBatch,
                GameSettings.SCORE + world.getHeroAircraft().score,
                money.getRegionWidth() + redLiveLine.getRegionWidth() + 100f, 695f
        );

        font.draw(spriteBatch,
                GameSettings.SCORE + world.getHeroAircraft().score,
               money.getRegionWidth() + redLiveLine.getRegionWidth() + 100f, 695f
               );

    }

    public void reset() {
        font = Assets.getInstance().assetManager.get(FONT, BitmapFont.class);
        redLiveLine = Assets.getInstance().mainAtlas.findRegion("red_line");
        greenLiveLine = Assets.getInstance().mainAtlas.findRegion("green_line");
        TextureAtlas.AtlasRegion image = Assets.getInstance().mainAtlas.findRegion("coin_power_up");
        money = image.split(image.getRegionWidth() / 4, image.getRegionHeight())[0][0];

    }

    public void dispose() {
        font.dispose();

    }
}
