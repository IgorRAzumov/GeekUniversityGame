package com.my_aircrafts_game.game.screens.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.GameSettings;
import com.my_aircrafts_game.game.ScreenManager;
import com.my_aircrafts_game.game.emitters.GeneralEmitter;
import com.my_aircrafts_game.game.screens.gameScreen.controller.GameScreenBackgroundController;
import com.my_aircrafts_game.game.screens.gameScreen.controller.GameScreenController;
import com.my_aircrafts_game.game.screens.gameScreen.models.Turret;
import com.my_aircrafts_game.game.screens.gameScreen.models.World;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.AiAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.models.aircrafts.HeroAircraft;
import com.my_aircrafts_game.game.screens.gameScreen.views.GameScreenBackgroundRenderer;
import com.my_aircrafts_game.game.screens.gameScreen.views.GameScreenUIRenderer;
import com.my_aircrafts_game.game.screens.gameScreen.views.GameScreenWorldRenderer;


public class GameScreen implements Screen {
    private static final String DAMAGE_ALARM = "damageAlarm";
    public static boolean isAndroid = true;

    private SpriteBatch spriteBatch;
    private GameScreenBackgroundController gameScreenBackgroundController;
    private GameScreenBackgroundRenderer gameScreenBackgroundRenderer;
    private GameScreenController gameScreenController;
    private GameScreenUIRenderer gameScreenUIRenderer;
    private GameScreenWorldRenderer gameScreenWorldRenderer;
    private World world;

    private ShaderProgram shaderProgram;
    private ShapeRenderer shapeRenderer;

    public GameScreen(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        // isAndroid = Gdx.app.getType() == Application.ApplicationType.Android;
    }

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        gameScreenBackgroundController = new GameScreenBackgroundController();
        gameScreenBackgroundRenderer = new GameScreenBackgroundRenderer();
        gameScreenController = new GameScreenController();
        gameScreenUIRenderer = new GameScreenUIRenderer();
        gameScreenWorldRenderer = new GameScreenWorldRenderer();
        createWorld();
        gameScreenBackgroundController.init(world);
        gameScreenBackgroundRenderer.init(world);
        gameScreenController.init(world);
        gameScreenUIRenderer.init(world);
        gameScreenWorldRenderer.init(world);

        shaderProgram = new ShaderProgram(Gdx.files.internal("vertex.glsl").readString(),
                Gdx.files.internal("fragment.glsl").readString());
        if (!shaderProgram.isCompiled()) {
            throw new IllegalArgumentException("Error compiling shader: " + shaderProgram.getLog());
        }
    }

    private void createWorld() {
        TextureAtlas.AtlasRegion image;
        world = new World();
        world.createBackground(GameSettings.BACKGROUND_BASE_SPEED,
                gameScreenBackgroundRenderer.getDistantHousesImageHeight(),
                gameScreenBackgroundRenderer.getGreenHazeImageHeight(),
                gameScreenBackgroundRenderer.getHousesImageHeight(),
                gameScreenBackgroundRenderer.getMoonImageWidth(),
                gameScreenBackgroundRenderer.getMoonImageHeight());

        image = gameScreenWorldRenderer.getAircraftDefaultImage();////
        world.addTurret(image.getRegionWidth(), image.getRegionHeight());

        image = gameScreenWorldRenderer.getAircraftDefaultImage();
        world.addAircraft(3, image.getRegionWidth(), image.getRegionHeight());

        image = gameScreenWorldRenderer.getHeroDefaultImage();
        world.addHeroAircraft(image.getRegionWidth(), image.getRegionHeight());

    }

    private void drawDebug() {
        HeroAircraft heroAircraft = GeneralEmitter.getInstance().getHeroAircraft();
        Rectangle hitArea = heroAircraft.getHitArea();

        shapeRenderer.setProjectionMatrix(ScreenManager.getInstance().getCamera().combined);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(hitArea.x, hitArea.y, hitArea.width, hitArea.height);

        for (AiAircraft aiAircraft : world.getActiveAircrafts()) {
            hitArea = aiAircraft.getHitArea();
            shapeRenderer.rect(hitArea.x, hitArea.y, hitArea.width, hitArea.height);
        }

        for (Turret turret : world.getActiveTurrets()) {
            hitArea = turret.getHitArea();
            shapeRenderer.rect(hitArea.x, hitArea.y, hitArea.width, hitArea.height);
        }

        shapeRenderer.end();
    }

    @Override
    public void render(float delta) {
        gameScreenBackgroundController.update(delta);
        gameScreenController.update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(ScreenManager.getInstance().getCamera().combined);
        spriteBatch.totalRenderCalls = 0;
        spriteBatch.begin();

        spriteBatch.setShader(shaderProgram);
        int damageAlarm = shaderProgram.getUniformLocation(DAMAGE_ALARM);
        shaderProgram.setUniformf(damageAlarm, world.getHeroAircraft().getDamageAlarm());
        gameScreenBackgroundRenderer.drawBackground(spriteBatch);
        gameScreenWorldRenderer.drawWorld(spriteBatch);
        gameScreenUIRenderer.drawUI(spriteBatch);

        spriteBatch.end();
        spriteBatch.setShader(null);

        if (world.getHeroAircraft().getLifeCounter() < 1) {
            ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.MENU);
        }
        //  drawDebug();
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().onResize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shaderProgram.dispose();
    }
}
