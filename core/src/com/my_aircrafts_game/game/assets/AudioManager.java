package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.ObjectMap;

import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.ScreenManager;


public class AudioManager {
    private static final AudioManager AUDIO_MANAGER = new AudioManager();

    public static AudioManager getInstance() {
        return AUDIO_MANAGER;
    }

    private ScreenManager.ScreenType screenType;
    private ObjectMap<String, Music> musics;
    private ObjectMap<String, Sound> sounds;

    private AudioManager() {
        musics = new ObjectMap<String, Music>();
        sounds = new ObjectMap<String, Sound>();
    }

    public void init(ScreenManager.ScreenType screenType) {
        this.screenType = screenType;
        reset(screenType);
    }


    public void playMusic(String music, boolean looping, float volume) {
        musics.get(music).play();
        musics.get(music).setLooping(looping);
        musics.get(music).setVolume(volume);
    }

    public void playSound(String sound) {
        sounds.get(sound).play();
    }

    void reset(ScreenManager.ScreenType screenType) {
        dispose();
        musics.clear();
        sounds.clear();

        switch (screenType) {
            case MENU: {
                musics.put("menuMusic", Assets.getInstance().assetManager.get(GameSettings.MENU_MUSIC, Music.class));
                break;
            }
            case GAME: {
                musics.put("gameMusic", Assets.getInstance().assetManager.get(GameSettings.GAME_MUSIC, Music.class));

                sounds.put("collisionByBullet", Assets.getInstance().assetManager.get(GameSettings.COLLISION_BY_BULLET, Sound.class));
                sounds.put("collisionByAircraft", Assets.getInstance().assetManager.get(GameSettings.COLLISION_BY_AIRCRAFT, Sound.class));
                sounds.put("fire", Assets.getInstance().assetManager.get(GameSettings.FIRE_SOUND, Sound.class));
                break;
            }
        }
    }

    public void dispose() {
        for (Music music : musics.values()) {
           music.stop();
            music.dispose();
        }
        for (Sound sound : sounds.values()) {
            sound.stop();
            sound.dispose();
        }
    }

    public void disposeMusic(String music) {
        musics.get(music).stop();
        musics.get(music).dispose();

    }
}
