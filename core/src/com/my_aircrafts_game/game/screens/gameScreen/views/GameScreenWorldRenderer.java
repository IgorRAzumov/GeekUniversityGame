package com.my_aircrafts_game.game.screens.gameScreen.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.assets.AudioManager;
import com.my_aircrafts_game.game.assets.BulletsRegions;
import com.my_aircrafts_game.game.assets.ExplosionsRegions;
import com.my_aircrafts_game.game.assets.PlanesRegions;
import com.my_aircrafts_game.game.assets.PowerUpsRegions;
import com.my_aircrafts_game.game.assets.TurretsRegions;
import com.my_aircrafts_game.game.emitters.BulletEmitter;
import com.my_aircrafts_game.game.emitters.GeneralEmitter;
import com.my_aircrafts_game.game.screens.gameScreen.models.Explosion;
import com.my_aircrafts_game.game.screens.gameScreen.models.PowerUp;
import com.my_aircrafts_game.game.screens.gameScreen.models.Turret;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;


public class GameScreenWorldRenderer {
    private PowerUpsRegions powerUpsRegions;
    private BulletsRegions bulletsRegions;
    private PlanesRegions aircraftsRegions;
    private TurretsRegions turretRegions;
    private ExplosionsRegions explosionsRegions;

    private TextureAtlas.AtlasRegion currentImage;

    public GameScreenWorldRenderer() {
        powerUpsRegions = new PowerUpsRegions();
        bulletsRegions = new BulletsRegions();
        aircraftsRegions = new PlanesRegions();
        turretRegions = new TurretsRegions();
        explosionsRegions = new ExplosionsRegions();
    }

    public void init(World world) {
    }

    public void drawWorld(SpriteBatch spriteBatch) {
        drawPowerUps(spriteBatch);
        drawBullets(spriteBatch);
        drawHero(spriteBatch);
        drawAircrafts(spriteBatch);
        drawTurrets(spriteBatch);
        drawExplosions(spriteBatch);
    }

    private void drawPowerUps(SpriteBatch spriteBatch) {
        for (PowerUp powerUp : GeneralEmitter.getInstance().getActivePowerUps()) {
            Array<TextureRegion> currentPowerUp = powerUpsRegions.getRegionsByType(powerUp.getType());
            float radius =  currentPowerUp.get(powerUp.getCurrentFrameNumber()).getRegionWidth() / 2f;
            spriteBatch.draw(currentPowerUp.get(powerUp.getCurrentFrameNumber()),
                    powerUp.getPosition().x -radius,
                    powerUp.getPosition().y - radius);
        }
    }

    private void drawBullets(SpriteBatch spriteBatch) {
        BulletEmitter.Bullet bullet;
        currentImage = bulletsRegions.getBulletImage();
        int len = GeneralEmitter.getInstance().getActiveBullets().size;
        for (int i = len; --i >= 0; ) {
            bullet = GeneralEmitter.getInstance().getActiveBullets().get(i);
            spriteBatch.draw(currentImage,
                    bullet.getPosition().x - currentImage.getRegionWidth() / 2,
                    bullet.getPosition().y - currentImage.getRegionHeight() / 2,
                    currentImage.getRegionWidth() / 2,
                    currentImage.getRegionHeight() / 2,
                    currentImage.getRegionWidth(),
                    currentImage.getRegionHeight(),
                    1.0f, 1.0f, bullet.getRotationAngle()
            );
        }
    }

    private void drawHero(SpriteBatch spriteBatch) {
        HeroAircraft heroAircraft = GeneralEmitter.getInstance().getHeroAircraft();
        currentImage = aircraftsRegions.getImageByVersionStatus(0,
                heroAircraft.getStatus());
        float radius = currentImage.getRegionWidth() / 2f;
        spriteBatch.draw(currentImage,
                heroAircraft.getPosition().x - radius,
                heroAircraft.getPosition().y - radius,
                radius, radius, radius * 2f, radius * 2f, 1f, 1f, heroAircraft.getAngle());

        if (heroAircraft.wasShotNow()) {
            AudioManager.getInstance().playSound("fire");
        }
        if (heroAircraft.wasCollisionByBullet()) {
            AudioManager.getInstance().playSound("collisionByBullet");
        }
    }

    private void drawAircrafts(SpriteBatch spriteBatch) {
        AiAircraft aiAircraft;
        float radius;
        int length = GeneralEmitter.getInstance().getActiveAircrafts().size;
        for (int i = length; --i >= 0; ) {
            aiAircraft = GeneralEmitter.getInstance().getActiveAircrafts().get(i);
            currentImage = aircraftsRegions.getImageByVersionStatus(aiAircraft.getVersion(),
                    aiAircraft.getStatus());
            radius = currentImage.getRegionWidth() / 2f;
            spriteBatch.draw(currentImage,
                    aiAircraft.getPosition().x - radius,
                    aiAircraft.getPosition().y - radius,
                    radius, radius, radius * 2f, radius * 2f, 1f, 1f, aiAircraft.getAngle());
            if (aiAircraft.wasShotNow()) {
                AudioManager.getInstance().playSound("fire");
            }

            if (aiAircraft.wasCollisionByBullet()) {
                AudioManager.getInstance().playSound("collisionByBullet");
            }

            if (aiAircraft.wasCollisionByAircraft()) {
                AudioManager.getInstance().playSound("collisionByAircraft");
            }
        }
    }

    private void drawTurrets(SpriteBatch spriteBatch) {
        for (Turret turret : GeneralEmitter.getInstance().getActiveTurrets()) {
            currentImage = turretRegions.getImageTurretByFrame(turret.getAnimation().getFrameNumber());
            float radius = currentImage.getRegionWidth() / 2f;
            spriteBatch.draw(
                    currentImage,
                    turret.getPosition().x - radius,
                    turret.getPosition().y - radius * 1.2f);//одгоняем чтоб внищу экрана
        }
    }

    private void drawExplosions(SpriteBatch spriteBatch) {
        for (Explosion explosion : GeneralEmitter.getInstance().getActiveExplosions()) {
            TextureRegion explosionRegion =
                    explosionsRegions.getImageExplosionByFrame(explosion.getFrameNumber());
            spriteBatch.draw(explosionRegion, explosion.getPosition().x - explosionRegion.getRegionWidth() / 2f,
                    explosion.getPosition().y - explosionRegion.getRegionHeight() / 2f);
        }
    }

    private void reset() {
        powerUpsRegions.reset();
        bulletsRegions.reset();
        aircraftsRegions.reset();
        turretRegions.reset();
        explosionsRegions.reset();
    }

    public TextureAtlas.AtlasRegion getAircraftDefaultImage() {
        return aircraftsRegions.getTypicalAiAircraftImage();
    }

    public TextureAtlas.AtlasRegion getHeroDefaultImage() {
        return aircraftsRegions.getTypicalHeroImage();
    }
}
