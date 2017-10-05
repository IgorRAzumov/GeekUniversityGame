package com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.strategy;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AircraftStatus;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;

/**
 * Created by XXX on 10.09.2017.
 */

public class StrategyTypeOne implements BaseStrategy {
    private float time;

    public StrategyTypeOne() {

    }

    public void setDirection(HeroAircraft heroAircraft, AiAircraft aiAircraft) {

    }

    @Override
    public void getDirection() {

    }

    public void update(float deltaTime) {
        time += deltaTime;
    }

  /*  private void fire(AiAircraft aiAircraft, Vector2 heroPosition) {
        int fireType = MathUtils.random(0, 5);
        switch (fireType) {
            case 1: {
                aiAircraft.fire();
                break;
            }
            case 2: {
                if (aiAircraft.getPosition().dst(heroPosition.x, heroPosition.y) < MathUtils.random(200, 500)) {
                    aiAircraft.fire();
                }
                break;
            }
            case 3: {
                if (heroPosition.y <= aiAircraft.getHitArea().y + aiAircraft.getHitArea().radius &&
                        heroPosition.y >= aiAircraft.getHitArea().y - aiAircraft.getHitArea().radius) {
                    aiAircraft.fire();
                }
                break;
            }
        }

        aiAircraft.fire();
    }*/

    private void setVelocity() {
    }

    private void turnDown(AiAircraft aiAircraft) {
        aiAircraft.setVelocity(aiAircraft.getVelocity().x * MathUtils.random(0.1f, 0.7f), -aiAircraft.getBaseSpeed());
        if (aiAircraft.isDamaged()) {
            aiAircraft.setStatus(AircraftStatus.DAMAGED_DOWN);
        } else {
            aiAircraft.setStatus(AircraftStatus.DEFAULT_DOWN);
        }
    }

    private void turnLeft(AiAircraft aiAircraft) {
        aiAircraft.setVelocity(aiAircraft.getBaseSpeed(), 0f);
        if (aiAircraft.isDamaged()) {
            aiAircraft.setStatus(AircraftStatus.DAMAGED);
        } else {
            aiAircraft.setStatus(AircraftStatus.DEFAULT);
        }
    }

    private void turnUp(AiAircraft aiAircraft) {
        aiAircraft.setVelocity(aiAircraft.getVelocity().x * MathUtils.random(0.3f, 0.7f), aiAircraft.getBaseSpeed());
        if (aiAircraft.isDamaged()) {
            aiAircraft.setStatus(AircraftStatus.DAMAGED_UP);
        } else {
            aiAircraft.setStatus(AircraftStatus.DEFAULT_UP);
        }
    }


}
