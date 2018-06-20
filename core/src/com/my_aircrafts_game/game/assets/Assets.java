package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.my_aircrafts_game.game.ScreenManager;

import static com.my_aircrafts_game.game.GameSettings.COLLISION_BY_AIRCRAFT_SOUND;
import static com.my_aircrafts_game.game.GameSettings.COLLISION_BY_BULLET_SOUND;
import static com.my_aircrafts_game.game.GameSettings.FIRE_SOUND;
import static com.my_aircrafts_game.game.GameSettings.FONT;
import static com.my_aircrafts_game.game.GameSettings.GAME_ATLAS;
import static com.my_aircrafts_game.game.GameSettings.GAME_BACKGROUND_ZERO_LAYER;
import static com.my_aircrafts_game.game.GameSettings.GAME_MUSIC;
import static com.my_aircrafts_game.game.GameSettings.MENU_ATLAS;
import static com.my_aircrafts_game.game.GameSettings.MENU_BACKGROUND_TEXTURE;
import static com.my_aircrafts_game.game.GameSettings.MENU_MUSIC;


public class Assets {
    private static final Assets ASSETS_INSTANCE = new Assets();
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
                assetManager.load(MENU_BACKGROUND_TEXTURE, Texture.class);
                assetManager.load(MENU_ATLAS, TextureAtlas.class);
                assetManager.finishLoading();
                mainAtlas = assetManager.get(MENU_ATLAS, TextureAtlas.class);
                break;

            case GAME:
                assetManager.load(GAME_MUSIC, Music.class);
                assetManager.load(COLLISION_BY_BULLET_SOUND, Sound.class);
                assetManager.load(COLLISION_BY_AIRCRAFT_SOUND, Sound.class);
                assetManager.load(FIRE_SOUND, Sound.class);
                assetManager.load(GAME_ATLAS, TextureAtlas.class);
                assetManager.load(FONT, BitmapFont.class);
                assetManager.load(GAME_BACKGROUND_ZERO_LAYER, Texture.class);
                assetManager.finishLoading();
                mainAtlas = assetManager.get(GAME_ATLAS, TextureAtlas.class);
                break;
        }

        AudioManager.getInstance().init(type);
        mainAtlas.getTextures().first().setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear);
    }
}
