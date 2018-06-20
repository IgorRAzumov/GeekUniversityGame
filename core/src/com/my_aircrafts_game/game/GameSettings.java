package com.my_aircrafts_game.game;


public class GameSettings {
    //MenuScreenController

    public static final float CLOUD_MIN_SCALE = 0.5f;
    public static final float CLOUD_MAX_SCALE = 0.9f;
    public static final int CLOUDS_QUANTITY = 70;
    public static final float CLOUDS_VELOCITY_X = -100f;
    public static final float CLOUDS_VELOCITY_Y = 0;
    public static final float START_BUTTON_WIDTH = 300f;
    public static final float START_BUTTON_POSITION_X = 50f;
    public static final float START_BUTTON_POSITION_Y = 50f;
    public static final float START_BUTTON_HEIGHT = 167;
    public static final float QUIT_BUTTON_POSITION_X = 930f;
    public static final float QUIT_BUTTON_POSITION_Y = 50f;
    public static final float QUIT_BUTTON_WIDTH = 300f;
    public static final float QUIT_BUTTON_HEIGHT = 167;


    //GameWorld
    public static final int SCORE_FOR_CRAFT = 100;
    public static final int MONEY_FOR_COIN = 1;
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
    public static final int AI_CRAFT_LIFE_COUNTER = 2;
    //Player AirCraft
    public static final float PLAYER_CRAFT_ROTATION_ANGLE = 0f;
    public static final float PLAYER_CRAFT_MIN_SPEED = 150f;
    public static final float PLAYER_CRAFT_MAX_SPEED = 300f;
    public static final float PLAYER_CRAFT_ACCELERATION = 75f;
    public static final float PLAYER_CRAFT_DECELERATION = 0.97f;
    public static final float PLAYER_CRAFT_FIRE_RATE = 0.25f;
    public static final int PLAYER_CRAFT_MAX_LIFE = 7;
    // Bullet
    public static final float BULLET_SPEED = 500f;
    //GameInputProcessor
    public static final int QUANTITY_TOUCH = 5;

    //Assets

    public static final String GAME_BACKGROUND_FIRST_LAYER = "distantHouses";
    public static final String GAME_BACKGROUND_SECOND_LAYER = "greenHaze";
    public static final String GAME_BACKGROUND_THIRD_LAYER = "houses";
    public static final String GAME_BACKGROUND_ADDITION = "moon";
    public static final String GAME_BACKGROUND_ZERO_LAYER = "background.png";
    public static final String MENU_ATLAS = "menuAtlas.atlas";
    public static final String GAME_ATLAS = "levelOneAtlas.atlas";

    //Sounds and Music
    public static final String MENU_MUSIC = "menuMusic.mp3";
    public static final String GAME_MUSIC = "gameMusic.mp3";
    public static final String COLLISION_BY_BULLET_SOUND = "collisionBullet.wav";
    public static final String COLLISION_BY_AIRCRAFT_SOUND = "collisionAircraft.wav";
    public static final String FIRE_SOUND = "fire.wav";
    public static final String FONT = "font.fnt";

    //Menu Screen Ui
    public static final String START_BUTTON_REGION = "startButtonClick";
    public static final String QUIT_BUTTON_REGION = "quitButtonClick";

    //Menu Screen Background
    public static final String CLOUD_REGION = "white_cloud";
    public static final String MENU_BACKGROUND_TEXTURE = "menuBackground.jpg";
    //Menu Screen
    public static final int MENU_BACKGROUND_CLOUDS_QUANTITY = 70;

    public static float BACKGROUND_BASE_SPEED = 100;
}
