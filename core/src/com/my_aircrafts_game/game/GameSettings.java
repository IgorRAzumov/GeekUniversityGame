package com.my_aircrafts_game.game;


public class GameSettings {

    public static final int GAME_WIDTH = 1280;
    public static final int GAME_HEIGHT = 720;

    // Abstract AirCraft
    public static final float AI_CRAFT_ROTATION_ANGLE = 0f;
    public static final float CRAFT_ROTATION_SPEED = 360f;

    //AI AirCrafts


    public static final float AI_CRAFT_MIN_SPEED = 100f;
    public static final float AI_CRAFT_MAX_SPEED = 300f;
    public static final float DAMAGE_VELOCITY_Y = -500f;
    public static final float AI_CRAFT_MIN_FIRE_RATE = 2f;
    public static final float AI_CRAFT_MAX_FIRE_RATE = 5f;
    public static final int AI_CRAFT_LIFE_COUNTER = 5;


    //Player AirCraft
    public static final String PLAYER_REGION = "heroAircraft";


    public static final String HERO_DEFAULT = "hero_default";
    public static final String HERO_DEFAULT_UP = "hero_default_up";
    public static final String HERO_DEFAULT_DOWN = "hero_default_down";
    public static final String HERO_DAMAGED = "hero_damaged";
    public static final String HERO_DAMAGED_UP = "hero_damaged_up";
    public static final String HERO_DAMAGED_DOWN = "hero_damaged_down";

    public static final String SCORE = "SCORE: ";
    public static final float PLAYER_CRAFT_ROTATION_ANGLE = 0f;
    public static final float PLAYER_CRAFT_MIN_SPEED = 150f;
    public static final float PLAYER_CRAFT_MAX_SPEED = 300f;
    public static final float PLAYER_CRAFT_ACCELERATION = 75f;
    public static final float PLAYER_CRAFT_DECELERATION = 0.97f;
    public static final float PLAYER_CRAFT_FIRE_RATE = 0.25f;
    public static final int PLAYER_CRAFT_LIFE_COUNTER = 8;
    public static final int PLAYER_CRAFT_MAX_LIFE = 7;

    // Bullet
    public static final String BULLET_REGION = "rocket";
    public static final float BULLET_SPEED = 500f;

    //GameInputProcessor
    public static final int QUANTITY_TOUCH = 5;

    //Assets
    public static final String MENU_MUSIC = "menuMusic.mp3";
    public static final String BACKGROUND_TEXTURE = "menuBackground.jpg";
    public static final String MENU_ATLAS = "menuAtlas.atlas";
    public static final String GAME_MUSIC = "gameMusic.mp3";
    public static final String COLLISION_BY_BULLET = "collisionBullet.wav";
    public static final String COLLISION_BY_AIRCRAFT = "collisionAircraft.wav";
    public static final String GAME_ATLAS = "levelOneAtlas.atlas";
    public static final String FONT = "font.fnt";
    public static final String FIRE_SOUND = "fire.wav";

    //MenuScreenController
    public static final String CLOUD_REGION = "white_cloud";
    public static final float CLOUD_MIN_SCALE = 0.5f;
    public static final float CLOUD_MAX_SCALE = 0.9f;
    public static final int CLOUDS_QUANTITY = 70;
    public static final float CLOUDS_VELOCITY = -100f;

    //GameWorld
    public static final int SCORE_FOR_CRAFT = 100;
    public static final float OFFSET_SCORE_POSITION_X = 20f;
    public static final float SCORE_POSITION_Y = 700f;
    public static final int AI_CRAFTS_START_COUNT = 7;

    //com.my_aircrafts_game.game.screens.gameScreen.models.Explosion
    public  static  final  float EXPLOSION_TIME_ACCELERATION = 3f;
    public  static  final  int ONE_FRAME_EXPLOSION_RADIUS =64;
    public  static  final  int QUANTITY_FRAMES_EXPLOSION = 6;
}
