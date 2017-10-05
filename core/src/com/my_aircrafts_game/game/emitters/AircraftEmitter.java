package com.my_aircrafts_game.game.emitters;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;

import static com.my_aircrafts_game.game.GameSettings.*;


public class AircraftEmitter {
    public HeroAircraft getHeroAircraft() {
        return heroAircraft;
    }

    private HeroAircraft heroAircraft;

    private static final AircraftEmitter AI_AIR_CRAFT_EMITTER = new AircraftEmitter();

    public static AircraftEmitter getInstance() {
        return AI_AIR_CRAFT_EMITTER;
    }

    public final Array<AiAircraft> activeAiAircrafts = new Array<AiAircraft>();

    private final Pool<AiAircraft> aiAirCraftsPool = new Pool<AiAircraft>(10, 15) {
        @Override
        protected AiAircraft newObject() {
            return new AiAircraft();
        }
    };

    private AircraftEmitter() {
    }

    public void update(float deltaTime) {
        updateAiAircrafts(deltaTime);
        updateHeroAircraft(deltaTime);
    }

    private void updateHeroAircraft(float deltaTime) {
        heroAircraft.update(deltaTime);
        Vector2 position = heroAircraft.getPosition();
        float radius = heroAircraft.getSize().x / 2f;

        if (position.x > GAME_WIDTH - radius) {
            position.x = GAME_WIDTH - radius;
        }
        if (position.x < radius) {
            position.x = radius;
        }
        if (position.y > GAME_HEIGHT + radius)
            position.y = GAME_HEIGHT + radius;

        if (position.y < -radius)
            position.y = -radius;
    }

    private void updateAiAircrafts(float deltaTime) {
        AiAircraft aiAircraft;
        int length = activeAiAircrafts.size;
        for (int i = length; --i >= 0; ) {
            aiAircraft = activeAiAircrafts.get(i);
            aiAircraft.update(deltaTime);

            Vector2 position = aiAircraft.getPosition();
            float radius = aiAircraft.getSize().x / 2f;

            if (position.x < -radius) {
                aiAircraft.setActive(false);
            }

            if (position.y > GAME_HEIGHT + radius) {
                position.y = GAME_HEIGHT + radius;
            }

            if (position.y < -radius) {
                position.y = -radius;
            }

            if (!aiAircraft.isActive()) {
                activeAiAircrafts.removeIndex(i);
                aiAirCraftsPool.free(aiAircraft);
                setupAiAirCraft((int) radius * 2, (int) radius * 2);
            }
        }
    }

    public HeroAircraft setupHeroCraft(int aircraftWidth, int aircraftHeight) {
        heroAircraft = new HeroAircraft();
        heroAircraft.init(GAME_WIDTH / 2f,
                GAME_HEIGHT / 2f,
                PLAYER_CRAFT_MIN_SPEED,
                0f,
                aircraftWidth,
                aircraftHeight);
        return heroAircraft;
    }

    public void setupAiAirCraft(int aircraftWidth, int aircraftHeight) {
        AiAircraft aiAircraft = aiAirCraftsPool.obtain();
        aiAircraft.init(
                MathUtils.random(GAME_WIDTH + aircraftWidth / 2f, GAME_WIDTH + aircraftWidth * 5),
                MathUtils.random(240f, GAME_HEIGHT - aircraftHeight / 2f),
                -MathUtils.random(AI_CRAFT_MIN_SPEED, AI_CRAFT_MAX_SPEED),
                0f,
                aircraftWidth,
                aircraftHeight,
                getActualVersion());
        activeAiAircrafts.add(aiAircraft);
    }

    private int getActualVersion() {
        switch (MathUtils.random(0, 4)) {
            case 0:
                return 11;
            case 1:
                return 12;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 1;
        }
        throw new RuntimeException("Incorrect type aiAircraft version");
    }

    public void reset() {
        aiAirCraftsPool.clear();
        activeAiAircrafts.clear();
    }

    public void dispose() {
        for (AiAircraft aiAircraft : activeAiAircrafts) {
            aiAircraft.dispose();
        }
    }
}

