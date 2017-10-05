package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.my_aircrafts_game.game.screens.gameScreen.models.Explosion;
import com.my_aircrafts_game.game.screens.gameScreen.models.GameAnimation;


 class ExplosionEmitter {
    private static final ExplosionEmitter EXPLOSION_EMITTER = new ExplosionEmitter();

    static ExplosionEmitter getInstance() {
        return EXPLOSION_EMITTER;
    }

    private static int idGenerator;
    private Pool<Explosion> explosionPool;
    Array<Explosion> activeExplosions;

    private ExplosionEmitter() {
        explosionPool = new Pool<Explosion>(20) {
            @Override
            protected Explosion newObject() {
                return new Explosion();
            }
        };
        activeExplosions = new Array<Explosion>();
        idGenerator = 0;
    }

    void setupExplosion(Vector2 position, Vector2 velocity) {
        GameAnimation animation = new GameAnimation();
        Explosion explosion = explosionPool.obtain();
        explosion.init(animation, position, velocity);
        activeExplosions.add(explosion);
    }

    public void update(float deltaTime) {
        Explosion explosion;
        int length = activeExplosions.size;
        for (int i = length; --i >= 0; ) {
            explosion = activeExplosions.get(i);
            explosion.update(deltaTime);
            if (explosion.getPosition().y < 0) {
                activeExplosions.removeIndex(i);
                explosionPool.free(explosion);
            }
        }
    }

    public static int generateId() {
        return idGenerator++;
    }

    void reset() {
        explosionPool.clear();
        activeExplosions.clear();
        idGenerator = 0;
    }
}
