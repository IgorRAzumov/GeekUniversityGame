package com.my_aircrafts_game.game.screens.gameScreen.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.emitters.BulletEmitter;
import com.my_aircrafts_game.game.emitters.GeneralEmitter;
import com.my_aircrafts_game.game.emitters.UnitEmitter;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;

public class World {
    private int score;
    private int money;

    private GameBackground gameBackground;

    public void createBackground(float baseSpeed, float distantHousesImageHeight,
                                 float greenHazeImageHeight, float housesImageHeight,
                                 float moonImageWidth, float moonImageHeight) {
        gameBackground = new GameBackground(baseSpeed, distantHousesImageHeight,
                greenHazeImageHeight, housesImageHeight);
        gameBackground.initMoon(new Vector2(1100f, 100f), new Vector2(-20f, 5f),
                moonImageWidth, moonImageHeight);
    }

    public void addTurret(int regionWidth, int regionHeight) {
        GeneralEmitter.getInstance().addTurret(regionWidth, regionHeight);
    }

    public void addAircrafts(int startAiAircraftsQuantity, int aircraftWidth, int aircraftHeight) {
        for (int i = startAiAircraftsQuantity; --i >= 0; ) {
            GeneralEmitter.getInstance().addAiAircraft(aircraftWidth, aircraftHeight);
        }
    }

    public void addHeroAircraft(int heroWidth, int heroHeight) {
        GeneralEmitter.getInstance().addHeroAircraft(heroWidth, heroHeight);
    }

    public void addExplosion(Vector2 position, Vector2 velocity) {
        GeneralEmitter.getInstance().addExplosion(position, velocity);
    }

    public GameBackground getGameBackground() {
        return gameBackground;
    }

    public HeroAircraft getHeroAircraft() {
        return GeneralEmitter.getInstance().getHeroAircraft();
    }

    public Array<PowerUp> getActivePowerUps() {
        return GeneralEmitter.getInstance().getActivePowerUps();
    }

    public Array<AiAircraft> getActiveAircrafts() {
        return GeneralEmitter.getInstance().getActiveAircrafts();
    }

    public Array<BulletEmitter.Bullet> getActiveBullets() {
        return GeneralEmitter.getInstance().getActiveBullets();
    }

    public Array<Turret> getActiveTurrets() {
        return UnitEmitter.getInstance().getActiveTurrets();
    }

    public void addPowerUp(Vector2 position) {
        GeneralEmitter.getInstance().addPowerUp(position);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }
}

