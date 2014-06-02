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
		super.update(delta);
		
		// Handle movement input
		if (InputManager.keys[Keys.UP] || InputManager.keys[Keys.W]) position.y += SPEED*delta;
		if (InputManager.keys[Keys.LEFT] || InputManager.keys[Keys.A]) position.x -= SPEED*delta;
		if (InputManager.keys[Keys.DOWN] || InputManager.keys[Keys.S]) position.y -= SPEED*delta;
		if (InputManager.keys[Keys.RIGHT] || InputManager.keys[Keys.D]) position.x += SPEED*delta;
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(Color.BLACK);
		renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
