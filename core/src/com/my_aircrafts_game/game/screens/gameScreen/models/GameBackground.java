package com.my_aircrafts_game.game.screens.gameScreen.models;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.my_aircrafts_game.game.GameSettings;

import static com.my_aircrafts_game.game.GameSettings.GAME_HEIGHT;
import static com.my_aircrafts_game.game.GameSettings.GAME_WIDTH;


public class GameBackground {
    public class Moon {
        private Vector2 position;
        private Vector2 velocity;
        private Rectangle bounds;
        private boolean active;

        private Moon() {
            position = new Vector2();
            velocity = new Vector2();
            bounds = new Rectangle();
        }

        private void init(Vector2 position, Vector2 velocity, float width, float height) {
            this.position.set(position);
            this.velocity.set(velocity);
            bounds.set(position.x, position.y, width, height);
            active = true;

        }

        private void update(float deltaTime) {
            position.mulAdd(velocity, deltaTime);
            bounds.setPosition(position);
        }

        public boolean isActive() {
            return active;
        }

        public Rectangle getBounds() {
            return bounds;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

    private float baseSpeed;
    private Rectangle backgroundRect;
    private Rectangle backgroundRect1;
    private Rectangle distantHousesRect;
    private Rectangle distantHousesRect1;
    private Rectangle greenHazeRect;
    private Rectangle greenHazeRect1;
    private Rectangle housesRect;
    private Rectangle housesRect1;
    private Moon moon;


    public GameBackground(float baseSpeed, float distantHousesRectHeight, float greenHazeRectHeight,
                          float housesRectHeight) {
        this.baseSpeed = baseSpeed;

        backgroundRect = new Rectangle(-GAME_WIDTH / 2f, 0f, GAME_WIDTH, GAME_HEIGHT);
        backgroundRect1 = new Rectangle(GAME_WIDTH / 2f, 0f, GAME_WIDTH, GAME_HEIGHT);

        distantHousesRect = new Rectangle(-GAME_WIDTH / 2f, 0f, GAME_WIDTH, distantHousesRectHeight);
        distantHousesRect1 = new Rectangle(GAME_WIDTH / 2f, 0f, GAME_WIDTH, distantHousesRectHeight);


        greenHazeRect = new Rectangle(-GAME_WIDTH / 2f, 0f, GAME_WIDTH, greenHazeRectHeight);
        greenHazeRect1 = new Rectangle(GAME_WIDTH / 2f, 0f, GAME_WIDTH, greenHazeRectHeight);

        housesRect = new Rectangle(-GAME_WIDTH / 2f, 0f, GAME_WIDTH, housesRectHeight);
        housesRect1 = new Rectangle(GAME_WIDTH / 2f, 0f, GAME_WIDTH, housesRectHeight);

        moon = new Moon();
    }

    public void initMoon(Vector2 position, Vector2 velocity, float width, float height) {
        moon.init(position, velocity, width, height);
    }

    public void update(float deltaTime) {
        if (moon.isActive()) {
            moon.update(deltaTime);
        }
        updateRectangleBounds(-deltaTime, backgroundRect, backgroundRect1, 0.15f * baseSpeed);
        updateRectangleBounds(-deltaTime, distantHousesRect, distantHousesRect1, 0.3f * baseSpeed);
        updateRectangleBounds(-deltaTime, greenHazeRect, greenHazeRect1, 0.6f * baseSpeed);
        updateRectangleBounds(-deltaTime, housesRect, housesRect1, 0.8f * baseSpeed);
    }

    public void resetBackground(Rectangle backgroundRect, Rectangle backgroundRect1) {
        backgroundRect.set(backgroundRect1);
        backgroundRect1.set(GAME_WIDTH, 0, GAME_WIDTH, backgroundRect.height);
    }


    private void updateRectangleBounds(float deltaTime, Rectangle rectangle, Rectangle rectangle1,
                                       float speed) {
        rectangle.x += deltaTime * speed;
        rectangle1.x += deltaTime * speed;
    }

    public float getBaseSpeed() {
        return baseSpeed;
    }

    public Rectangle getBackgroundRect1() {
        return backgroundRect1;
    }

    public Rectangle getBackgroundRect() {
        return backgroundRect;
    }

    public Rectangle getDistantHousesRect1() {
        return distantHousesRect1;
    }

    public Rectangle getDistantHousesRect() {
        return distantHousesRect;
    }

    public Rectangle getGreenHazeRect1() {
        return greenHazeRect1;
    }

    public Rectangle getGreenHazeRect() {
        return greenHazeRect;
    }

    public Rectangle getHousesRect1() {
        return housesRect1;
    }

    public Rectangle getHousesRect() {
        return housesRect;
    }

    public Moon getMoon() {
        return moon;
    }

}
