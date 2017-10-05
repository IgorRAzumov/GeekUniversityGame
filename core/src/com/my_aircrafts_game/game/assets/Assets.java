package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.my_aircrafts_game.game.ScreenManager;

import static com.my_aircrafts_game.game.GameSettings.*;


public class Assets {
    public static final Assets ASSETS_INSTANCE = new Assets();

    public static Assets getInstance() {
        return ASSETS_INSTANCE;
    }

    public AssetManager assetManager;

    public TextureAtlas mainAtlas;


    private Assets() {
        assetManager = new AssetManager();
    }

    public void loadAssets(ScreenManager.ScreenType type) {
        assetManager.clear();

        switch (type) {
            case MENU:
                assetManager.load(MENU_MUSIC, Music.class);
                assetManager.load(BACKGROUND_TEXTURE, Texture.class);
                assetManager.load(MENU_ATLAS, TextureAtlas.class);
                assetManager.finishLoading();

                mainAtlas = assetManager.get(MENU_ATLAS, TextureAtlas.class);

                break;

            case GAME:
                assetManager.load(GAME_MUSIC, Music.class);
                assetManager.load(COLLISION_BY_BULLET, Sound.class);
                assetManager.load(COLLISION_BY_AIRCRAFT, Sound.class);
                assetManager.load(FIRE_SOUND, Sound.class);
                assetManager.load(GAME_ATLAS, TextureAtlas.class);
                assetManager.load(FONT, BitmapFont.class);
                assetManager.load("background.png", Texture.class);
                assetManager.finishLoading();

                mainAtlas = assetManager.get(GAME_ATLAS, TextureAtlas.class);
                break;
        }

        AudioManager.getInstance().init(type);
        mainAtlas.getTextures().first().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
    }
}
