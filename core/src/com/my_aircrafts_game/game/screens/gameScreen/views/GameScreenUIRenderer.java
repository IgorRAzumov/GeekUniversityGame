package com.my_aircrafts_game.game.screens.gameScreen.views;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;

import java.awt.Font;

import static com.my_aircrafts_game.game.GameSettings.FONT;
import static com.my_aircrafts_game.game.GameSettings.OFFSET_SCORE_POSITION_X;


public class GameScreenUIRenderer {
    private World world;
    BitmapFont font;

    public void init(World world) {
        this.world = world;
        reset();

    }

    public void drawUI(SpriteBatch spriteBatch) {
        font.draw(spriteBatch, GameSettings.SCORE + world.getHeroAircraft().score,
                GameSettings.OFFSET_SCORE_POSITION_X + GameSettings.OFFSET_SCORE_POSITION_X,
                GameSettings.SCORE_POSITION_Y);
    }

    public void reset() {
        font = Assets.getInstance().assetManager.get(FONT, BitmapFont.class);
    }
}
