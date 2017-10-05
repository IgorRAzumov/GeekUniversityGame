package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.screens.gameScreen.models.Explosion;
import com.my_aircrafts_game.game.screens.gameScreen.models.PowerUp;
import com.my_aircrafts_game.game.screens.gameScreen.models.Turret;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;


public class GeneralEmitter {
    private static final GeneralEmitter GENERAL_EMITTER = new GeneralEmitter();

    public static GeneralEmitter getInstance() {
        return GENERAL_EMITTER;
    }

    private GeneralEmitter() {
        reset();
    }

    public Array<PowerUp> getActivePowerUps() {
        return PowerUpEmitter.getInstance().activePowerUps;
    }

    public Array<BulletEmitter.Bullet> getActiveBullets() {
        return BulletEmitter.getInstance().activeBullets;
    }

    public Array<AiAircraft> getActiveAircrafts() {
        return AircraftEmitter.getInstance().activeAiAircrafts;
    }

    public Array<Turret> getActiveTurrets() {
        return UnitEmitter.getInstance().activeTurrets;
    }

    public Array<Explosion> getActiveExplosions() {
        return ExplosionEmitter.getInstance().activeExplosions;
    }

    public void addTurret(int regionWidth, int regionHeight) {
        UnitEmitter.getInstance().setupTurret(
                new Vector2(GameSettings.GAME_WIDTH + regionWidth /2f,regionHeight/2f),
                regionWidth, regionHeight);
    }

    public  void addPowerUp(Vector2 position) {
        PowerUpEmitter.getInstance().setupPowerUp(position);
    }

    public void addBullet(boolean isItBot, float x, float y, float rotationAngle) {
        BulletEmitter.getInstance().setupBullet(isItBot, x, y, rotationAngle);
    }

    public void addAiAircraft(int aircraftWidth, int aircraftHeigth) {
        AircraftEmitter.getInstance().setupAiAirCraft(aircraftWidth, aircraftHeigth);
    }

    public void addHeroAircraft(int heroWidth, int heroHeight) {
        AircraftEmitter.getInstance().setupHeroCraft(heroWidth,  heroHeight);
    }

    public void addExplosion(Vector2 position, Vector2 velocity) {
        ExplosionEmitter.getInstance().setupExplosion(position, velocity);
    }

    public void update(float deltaTime) {
        PowerUpEmitter.getInstance().update(deltaTime);
        BulletEmitter.getInstance().update(deltaTime);
        AircraftEmitter.getInstance().update(deltaTime);
        UnitEmitter.getInstance().update(deltaTime);
        ExplosionEmitter.getInstance().update(deltaTime);

    }

    public void reset() {
        PowerUpEmitter.getInstance().reset();
        BulletEmitter.getInstance().reset();
        AircraftEmitter.getInstance().reset();
        UnitEmitter.getInstance().reset();
        ExplosionEmitter.getInstance().reset();
    }

    public HeroAircraft getHeroAircraft() {
        return AircraftEmitter.getInstance().getHeroAircraft();
    }



}
