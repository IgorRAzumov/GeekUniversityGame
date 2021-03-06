package com.my_aircrafts_game.game.screens.menuScreen.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.my_aircrafts_game.game.assets.Assets;
import com.my_aircrafts_game.game.assets.AudioManager;
import com.my_aircrafts_game.game.screens.menuScreen.models.Cloud;
import com.my_aircrafts_game.game.screens.menuScreen.models.World;

import static com.my_aircrafts_game.game.GameSettings.CLOUD_REGION;
import static com.my_aircrafts_game.game.GameSettings.MENU_BACKGROUND_TEXTURE;
import static com.my_aircrafts_game.game.GameSettings.MENU_MUSIC;


public class MenuScreenBackgroundRenderer {
    private TextureAtlas.AtlasRegion cloudImage;
    private Texture background;
    private World world;

    public MenuScreenBackgroundRenderer(World world) {
        reset();
        this.world = world;
    }

    public void drawBackground(SpriteBatch spriteBatch) {
        drawSky(spriteBatch);
        drawClouds(spriteBatch);
    }

    private void drawSky(SpriteBatch spriteBatch) {
        spriteBatch.disableBlending();
        spriteBatch.draw(background, 0f, 0f);
        spriteBatch.enableBlending();
    }

    private void drawClouds(SpriteBatch spriteBatch) {
        float scale;
        float halfWidth;
        float halfHeight;
        Rectangle cloudBounds;
        for (Cloud cloud : world.getClouds()) {
            scale = cloud.getScale();
            cloudBounds = cloud.getCloudBounds();
            halfWidth = cloudBounds.width / 2f * scale;
            halfHeight = cloudBounds.height / 2f * scale;

            spriteBatch.draw(cloudImage, cloudBounds.x - halfWidth, cloudBounds.y - halfHeight,
                    halfWidth, halfHeight, halfWidth * 2f, halfHeight * 2f,
                    scale, scale, 0);
        }
    }

    public float getCloudImageWidth() {
        return cloudImage.getRegionWidth();
    }

    public float getCloudImageHeight() {
        return cloudImage.getRotatedPackedHeight();
    }

    private void reset() {
        cloudImage = Assets.getInstance().mainAtlas.findRegion(CLOUD_REGION);
        background = Assets.getInstance().assetManager.get(MENU_BACKGROUND_TEXTURE, Texture.class);
        AudioManager.getInstance().playMusic(MENU_MUSIC, true, 0.7f);
    }

    public void dispose() {
        AudioManager.getInstance().disposeMusic(MENU_MUSIC);
        background.dispose();
    }

}
