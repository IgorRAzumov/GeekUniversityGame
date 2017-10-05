package com.my_aircrafts_game.game.screens.gameScreen.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.emitters.BulletEmitter;
import com.my_aircrafts_game.game.emitters.GeneralEmitter;
import com.my_aircrafts_game.game.input.TouchDetector;
import com.my_aircrafts_game.game.screens.gameScreen.GameScreen;
import com.my_aircrafts_game.game.screens.gameScreen.models.PowerUp;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AircraftStatus;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;

import static com.badlogic.gdx.math.MathUtils.cosDeg;
import static com.badlogic.gdx.math.MathUtils.sinDeg;
import static com.my_aircrafts_game.game.GameSettings.DAMAGE_VELOCITY_Y;
import static com.my_aircrafts_game.game.GameSettings.PLAYER_CRAFT_ACCELERATION;
import static com.my_aircrafts_game.game.GameSettings.PLAYER_CRAFT_MAX_LIFE;
import static com.my_aircrafts_game.game.emitters.GeneralEmitter.getInstance;

public class GameScreenController {
    private World world;
    private TouchDetector touchDetector;

    public void init(World world) {
        this.world = world;
        touchDetector = new TouchDetector();
    }

    public void update(float deltaTime) {
        GeneralEmitter.getInstance().update(deltaTime);
        checkCollision();
        updateUI(deltaTime);


       /* if (getInstance().getHeroAircraft().getLifeCounter() < 1) ScreenManager.getInstance().
                switchScreen(ScreenManager.ScreenType.MENU);*/
    }

    private void updateUI(float deltaTime) {
        if (!GameScreen.isAndroid) {
            updateDesktop(deltaTime);
        } else {
            updateAndroid(deltaTime);
        }
    }

    private void checkCollision() {
        checkPowerUpCollision();
        checkBulletCollision();
        checkAircraftCollision();
    }

    private void checkPowerUpCollision() {
        int length = world.getActivePowerUps().size;
        if (length > 0) {
            PowerUp powerUp;
            HeroAircraft heroAircraft = world.getHeroAircraft();
            for (int i = length; --i >= 0; ) {
                powerUp = world.getActivePowerUps().get(i);
                if (heroAircraft.getHitArea().contains(powerUp.getPosition())) {
                    switch (powerUp.getType()) {
                        case LIFE_POWER_UP: {
                            if (heroAircraft.getLifeCounter() < PLAYER_CRAFT_MAX_LIFE) {
                                heroAircraft.addLife();
                                break;
                            }
                        }
                        case COIN_POWER_UP: {
                            break;
                        }
                        case KILL_ALL_POWER_UP: {
                            for (AiAircraft aiAircraft : world.getActiveAircrafts()) {
                                aiAircraft.takeDamage();
                                world.getHeroAircraft().score += 300;
                            }
                            break;
                        }
                    }
                    powerUp.setActive(false);
                }
            }
        }
    }

    private void checkBulletCollision() {
        HeroAircraft heroAircraft = world.getHeroAircraft();

        for (BulletEmitter.Bullet bullet : world.getActiveBullets()) {
            if (bullet.isItBot()) {
                if (heroAircraft.getHitArea().contains(bullet.getPosition())) {
                    heroAircraft.setCollisionByBullet(true);
                    heroAircraft.takeDamage();
                    bullet.destroy();
                }
            }

            if (!bullet.isItBot()) {
                for (AiAircraft aiAircraft : world.getActiveAircrafts()) {
                    if (aiAircraft.getHitArea().contains(bullet.getPosition())) {
                        aiAircraft.setCollisionByBullet(true);
                        aiAircraft.takeDamage();

                        heroAircraft.score += GameSettings.SCORE_FOR_CRAFT;
                        if (aiAircraft.isDamaged()) {
                            world.addExplosion(aiAircraft.getPosition(), new Vector2(0f, DAMAGE_VELOCITY_Y));
                            if (MathUtils.random() < 0.15f) {
                                getInstance().addPowerUp(aiAircraft.getPosition());
                            }
                        }
                        bullet.destroy();
                    }

                }
            }
        }
    }

    private void checkAircraftCollision() {
        HeroAircraft heroAircraft = world.getHeroAircraft();
        for (AiAircraft aiAircraft : world.getActiveAircrafts()) {
            if (!aiAircraft.isDamaged() && heroAircraft.getHitArea().overlaps(aiAircraft.getHitArea())) {
                aiAircraft.setDamagedCollision(true);
                heroAircraft.takeDamage();
                if (aiAircraft.isDamaged()) {
                    world.addExplosion(aiAircraft.getPosition(), new Vector2(0, DAMAGE_VELOCITY_Y));
                }
                if (heroAircraft.isDamaged()) {
                    world.addExplosion(heroAircraft.getPosition(), new Vector2(0, DAMAGE_VELOCITY_Y));
                }
            }
        }
    }

    private void updateDesktop(float deltaTime) {
        HeroAircraft hero = world.getHeroAircraft();
        float heroSpeed = hero.getBaseSpeed();
        boolean damageWarning = hero.isDamagedWarning();
        float velocityY = hero.getVelocity().y;

        if (velocityY < 50f && velocityY > -50f) {
            hero.setStatus(damageWarning ? AircraftStatus.DAMAGED : AircraftStatus.DEFAULT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            hero.setStatus(damageWarning ? AircraftStatus.DAMAGED_UP : AircraftStatus.DEFAULT_UP);
            hero.addSpeed(PLAYER_CRAFT_ACCELERATION * deltaTime);
            hero.setVelocity(0f, heroSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            hero.addSpeed(PLAYER_CRAFT_ACCELERATION * deltaTime);
            hero.setVelocity(-heroSpeed, 0f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            hero.addSpeed(PLAYER_CRAFT_ACCELERATION * deltaTime);
            hero.setVelocity(heroSpeed, 0f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            hero.setStatus(damageWarning ? AircraftStatus.DAMAGED_DOWN : AircraftStatus.DEFAULT_DOWN);
            hero.addSpeed(PLAYER_CRAFT_ACCELERATION * deltaTime);
            hero.setVelocity(0f, -heroSpeed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            hero.tryToFire(deltaTime);
        }
    }

    private void updateAndroid(float deltaTime) {
        touchDetector.update();

        HeroAircraft hero = world.getHeroAircraft();
        boolean damagedWarning = hero.isDamagedWarning();
        float speed = hero.getBaseSpeed();
        hero.tryToFire(deltaTime);

        if (touchDetector.isTouched) {
            float tempRotationAngle = touchDetector.getAngle(hero.getPosition().x, hero.getPosition().y);

            if (tempRotationAngle > 0f && tempRotationAngle < 180f) {
                hero.setStatus(damagedWarning ? AircraftStatus.DAMAGED_UP : AircraftStatus.DEFAULT_UP);
            }

            if (tempRotationAngle > -180f && tempRotationAngle < 0f) {
                hero.setStatus(damagedWarning ? AircraftStatus.DAMAGED_DOWN : AircraftStatus.DEFAULT_DOWN);
            }

            hero.addVelocity(speed * cosDeg(tempRotationAngle) * deltaTime * 10f,
                    speed * sinDeg(tempRotationAngle) * deltaTime * 10f);
        } else {
            hero.setStatus(damagedWarning ? AircraftStatus.DAMAGED : AircraftStatus.DEFAULT);
        }
    }

}
