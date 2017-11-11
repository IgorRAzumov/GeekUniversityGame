package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.assets.BulletsRegions;

public class BulletEmitter {

    public class Bullet implements Pool.Poolable {
        private Vector2 velocity;
        private Vector2 position;
        private float rotationAngle;
        private boolean isActive;
        private boolean isBot;

        private Bullet() {
            position = new Vector2(0, 0);
            velocity = new Vector2(0, 0);
            isActive = false;
        }

        private void init(boolean isItBot, float x, float y, float vx, float vy,
                          float rotationAngle) {
            this.rotationAngle = rotationAngle;
            position.set(x, y);
            velocity.set(vx, vy);
            isActive = true;
            this.isBot = isItBot;
        }

        public void update(float deltaTime) {
            position.mulAdd(velocity, deltaTime);
        }

        @Override
        public void reset() {
            isActive = false;
            position.set(0, 0);
        }

        public void destroy() {
            isActive = false;
        }

        public boolean isItBot() {
            return isBot;
        }

        public Vector2 getPosition() {
            return position;
        }

        public float getRotationAngle() {
            return rotationAngle;
        }
    }

    private static final BulletEmitter BULLETS_EMITTER = new BulletEmitter();

    public static BulletEmitter getInstance() {
        return BULLETS_EMITTER;
    }

    public final Array<Bullet> activeBullets = new Array<Bullet>();

    private final Pool<Bullet> bulletsPool = new Pool<Bullet>(256, 4096) {
        @Override
        protected Bullet newObject() {
            return new Bullet();
        }
    };

    private TextureAtlas.AtlasRegion bulletImage;

    private BulletEmitter() {
        reset();
    }

    public void update(float deltaTime) {
        Bullet bullet;
        int len = activeBullets.size;
        for (int i = len; --i >= 0; ) {
            bullet = activeBullets.get(i);
            bullet.update(deltaTime);
            if (bullet.isActive) {
                if (bullet.position.x < bulletImage.getRegionWidth() / 2
                        || bullet.position.x > bulletImage.getRegionWidth() / 2 + GameSettings.GAME_WIDTH
                        || bullet.position.y < -bulletImage.getRegionHeight() / 2
                        || bullet.position.y > bulletImage.getRegionHeight() / 2 + GameSettings.GAME_HEIGHT) {
                    bullet.destroy();
                }
            } else {
                activeBullets.removeIndex(i);
                bulletsPool.free(bullet);
            }
        }
    }

    public void setupBullet(boolean isItBot, float x, float y, float rotationAngle) {
        Bullet bullet = bulletsPool.obtain();
        bullet.init(isItBot, x, y, GameSettings.BULLET_SPEED * MathUtils.cosDeg(rotationAngle),
                GameSettings.BULLET_SPEED * MathUtils.sinDeg(rotationAngle), rotationAngle);
        activeBullets.add(bullet);
    }

    public void reset() {
        bulletsPool.clear();
        activeBullets.clear();
        bulletImage = Assets.getInstance().mainAtlas.findRegion(BulletsRegions.BULLET_REGION);
    }
}
