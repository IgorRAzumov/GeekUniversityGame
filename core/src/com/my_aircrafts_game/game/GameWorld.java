package com.my_aircrafts_game.game;


public class GameWorld {

    /*BitmapFont font;
    Sound aircraftCollisionSound;
    Sound explosionSound;
    HeroAircraft heroAircraft;
    WorldRenderer worldRenderer;

    public GameWorld(LevelOneBackground levelOneBackground, BitmapFont font, Sound aircraftCollisionSound,
                     Sound explosionSound) {
        GeneralEmitter.getInstance().reset();
        worldRenderer = new WorldRenderer();

        this.aircraftCollisionSound = aircraftCollisionSound;
        this.explosionSound = explosionSound;

        this.font = font;

        GeneralEmitter.getInstance().addHeroAircraft();

        for (int i = 0; i < 10; i++) {
            GeneralEmitter.getInstance().addAiAircraft();
        }

        GeneralEmitter.getInstance().addTurret(new Vector2(GameSettings.GAME_WIDTH + 80f, 80f));
        heroAircraft = GeneralEmitter.getInstance().getHeroAircraft();
    }

    public void render(SpriteBatch spriteBatch) {
        update(Gdx.graphics.getDeltaTime());

       // levelOneBackground.render(spriteBatch);
        worldRenderer.drawPowerUps(spriteBatch);
        worldRenderer.drawBullets(spriteBatch);
        worldRenderer.drawAircrafts(spriteBatch);
        worldRenderer.drawHero(spriteBatch);
        worldRenderer.drawTurrets(spriteBatch);
        worldRenderer.drawExplosions(spriteBatch);

        font.draw(spriteBatch, SCORE + GeneralEmitter.getInstance().getHeroAircraft().score,
                GameSettings.OFFSET_SCORE_POSITION_X
                        + OFFSET_SCORE_POSITION_X, SCORE_POSITION_Y);
    }

    public void update(float deltaTime) {
        checkCollision();
      //  levelOneBackground.update(deltaTime);
        getInstance().update(deltaTime);

        if (getInstance().getHeroAircraft().getLifeCounter() < 1) ScreenManager.getInstance().
                switchScreen(ScreenManager.ScreenType.MENU);
    }

    private void checkCollision() {
        checkPowerUpCollision();
        checkBulletCollision();
        checkAircraftCollision();
    }

    private void checkPowerUpCollision() {
        int length = getInstance().getActivePowerUps().size;
        PowerUp powerUp;
        for (int i = length; --i >= 0; ) {
            powerUp = getInstance().getActivePowerUps().get(i);
            if (getInstance().getHeroAircraft().getHitArea().contains(powerUp.getPosition())) {
                switch (powerUp.getType()) {
                    case LIFE_POWER_UP: {
                        if (getInstance().getHeroAircraft().getLifeCounter() < PLAYER_CRAFT_MAX_LIFE)
                            getInstance().getHeroAircraft().addLife();
                        break;
                    }
                    case COIN_POWER_UP: {
                        break;
                    }
                    case KILL_ALL_POWER_UP: {
                        for (AiAircraft aiAircraft : getInstance().getActiveAircrafts()) {
                            aiAircraft.takeDamage();
                            getInstance().getHeroAircraft().score += 300;
                        }
                        break;
                    }
                }
                powerUp.setActive(false);
            }
        }
    }

    private void checkBulletCollision() {
        for (BulletEmitter.Bullet bullet : getInstance().getActiveBullets()) {
            if (bullet.isItBot()) {
                if (getInstance().getHeroAircraft().getHitArea().contains(bullet.getPosition())) {
                   // explosionSound.play();
                   // Assets.getInstance().
                    getInstance().getHeroAircraft().takeDamage();
                    bullet.destroy();
                }
            }

            if (!bullet.isItBot()) {
                for (AiAircraft aiAircraft : getInstance().getActiveAircrafts()) {
                    if (aiAircraft.getHitArea().contains(bullet.getPosition())) {
                        explosionSound.play();
                        getInstance().getHeroAircraft().score += GameSettings.SCORE_FOR_CRAFT;
                        aiAircraft.takeDamage();
                        if (aiAircraft.isDamaged()) {
                            getInstance().addExplosion(aiAircraft.getPosition(), new Vector2(0, DAMAGE_VELOCITY_Y));
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
        for (AiAircraft aiAircraft : getInstance().getActiveAircrafts()) {
            if (!aiAircraft.isDamaged() && getInstance().getHeroAircraft().getHitArea().overlaps(aiAircraft.getHitArea())) {
                aircraftCollisionSound.play();
                aiAircraft.setDamagedCollision(true);
                getInstance().getHeroAircraft().takeDamage();
                if (aiAircraft.isDamaged()) {
                    getInstance().addExplosion(aiAircraft.getPosition(), new Vector2(0, DAMAGE_VELOCITY_Y)); //aiAircraft.getPosition(), new Vector2(0, -300));
                }
                if (getInstance().getHeroAircraft().isDamaged()) {

                }
            }
        }
    }

    public HeroAircraft getHeroAircraft() {
        return getInstance().getHeroAircraft();
    }

    public void dispose() {*/
   /**/
}
