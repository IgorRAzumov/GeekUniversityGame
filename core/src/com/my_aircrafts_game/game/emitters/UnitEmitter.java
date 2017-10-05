package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.screens.gameScreen.models.Turret;


public class UnitEmitter {

    private final static UnitEmitter UNIT_EMITTER = new UnitEmitter();

    public static UnitEmitter getInstance() {
        return UNIT_EMITTER;
    }



    Array<Turret> activeTurrets;

    private UnitEmitter() {
        activeTurrets = new Array<Turret>(5);
    }


    void update(float deltaTime) {
        for (Turret turret : activeTurrets) {
            turret.update(deltaTime);
            float radius = turret.getHitArea().getWidth() / 2f;

            if (turret.isFireNow()) {
                fire(turret);
            }

            if (turret.getPosition().x < -radius || !turret.isActive()) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                turret.getPosition().x = GameSettings.GAME_WIDTH + radius;
            }
        }
    }

    void setupTurret(Vector2 position, int regionWidth, int regionHeight) {
        Turret turret = new Turret();
        turret.init(position, regionWidth,regionHeight);
        activeTurrets.add(turret);
    }

    private void fire(Turret turret) {
        Vector2 position = turret.getPosition();
        float radius = turret.getHitArea().getWidth() / 2f;
        BulletEmitter.getInstance().setupBullet(true, turret.isFirstFire()
                        ? position.x - radius * 0.51f
                        : position.x - radius * 0.39f,
                position.y + radius * 0.8f, 135f);
        turret.setFireNow(false);
    }

    void reset() {
        activeTurrets.clear();
    }

    public Array<Turret> getActiveTurrets() {
        return activeTurrets;
    }
}
