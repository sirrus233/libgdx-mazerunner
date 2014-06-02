package cf.mazerunner.gameobjects;

import cf.mazerunner.InputManager;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends GameObject {
	private static final float PLAYER_WIDTH = 80f;
	private static final float PLAYER_HEIGHT = 80f;
	private static final float SPEED = 350f;
	
	public Player(int x, int y) {
		super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	@Override
	public void update(float delta) {	
		// Handle movement input
		if (InputManager.keys[Keys.UP] || InputManager.keys[Keys.W]) updatePosition(0, SPEED*delta);
		if (InputManager.keys[Keys.LEFT] || InputManager.keys[Keys.A]) updatePosition(-SPEED*delta, 0);
		if (InputManager.keys[Keys.DOWN] || InputManager.keys[Keys.S]) updatePosition(0, -SPEED*delta);
		if (InputManager.keys[Keys.RIGHT] || InputManager.keys[Keys.D]) updatePosition(SPEED*delta, 0);
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(Color.BLACK);
		renderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
	}
}
