package com.my_aircrafts_game.game.assets;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AircraftStatus;

import static com.my_aircrafts_game.game.GameSettings.*;

public class PlanesRegions {
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> version11;
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> version12;
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> version21;
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> version22;
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> boss;
    private ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion> hero;

    public PlanesRegions() {
        reset();
    }

    public TextureAtlas.AtlasRegion getImageByVersionStatus(int version, AircraftStatus status) {
        switch (version) {
            case 11:
                return version11.get(status);
            case 12:
                return version12.get(status);
            case 21:
                return version21.get(status);
            case 22:
                return version22.get(status);
            case 1:
                return boss.get(status);
            case 0:
                return hero.get(status);
        }

        return null;
    }

    public void reset() {
        version11 = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>();
        version11.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion("aircraft_11_default"));
        version11.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_11_default_up"));
        version11.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_11_default_down"));
        version11.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion("aircraft_11_damaged"));
        version11.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_11_damaged_up"));
        version11.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_11_damaged_down"));

        version12 = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>();
        version12.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion("aircraft_12_default"));
        version12.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_12_default_up"));
        version12.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_12_default_down"));
        version12.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion("aircraft_12_damaged"));
        version12.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_12_damaged_up"));
        version12.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_12_damaged_down"));


        version21 = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>();
        version21.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion("aircraft_21_default"));
        version21.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_21_default_up"));
        version21.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_21_default_down"));
        version21.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion("aircraft_21_damaged"));
        version21.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_21_damaged_up"));
        version21.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_21_damaged_down"));


        version22 = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>(6);
        version22.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion("aircraft_22_default"));
        version22.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_22_default_up"));
        version22.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_22_default_down"));
        version22.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion("aircraft_22_damaged"));
        version22.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion("aircraft_22_damaged_up"));
        version22.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion("aircraft_22_damaged_down"));


        boss = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>(6);
        boss.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion("boss_1_default"));
        boss.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion("boss_1_default_up"));
        boss.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion("boss_1_default_down"));
        boss.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion("boss_1_damaged"));
        boss.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion("boss_1_damaged_up"));
        boss.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion("boss_1_damaged_down"));

        hero = new ObjectMap<AircraftStatus, TextureAtlas.AtlasRegion>(6);
        hero.put(AircraftStatus.DEFAULT, Assets.getInstance().mainAtlas.findRegion(HERO_DEFAULT));
        hero.put(AircraftStatus.DEFAULT_UP, Assets.getInstance().mainAtlas.findRegion(HERO_DEFAULT_UP));
        hero.put(AircraftStatus.DEFAULT_DOWN, Assets.getInstance().mainAtlas.findRegion(HERO_DEFAULT_DOWN));
        hero.put(AircraftStatus.DAMAGED, Assets.getInstance().mainAtlas.findRegion(HERO_DAMAGED));
        hero.put(AircraftStatus.DAMAGED_UP, Assets.getInstance().mainAtlas.findRegion(HERO_DAMAGED_UP));
        hero.put(AircraftStatus.DAMAGED_DOWN, Assets.getInstance().mainAtlas.findRegion(HERO_DAMAGED_DOWN));
    }

    public TextureAtlas.AtlasRegion getTypicalAiAircraftImage() {
        return version11.get(AircraftStatus.DEFAULT);//because all the planes
    }

    public TextureAtlas.AtlasRegion getTypicalHeroImage() {
        return hero.get(AircraftStatus.DEFAULT);
    }
}
