package cf.mazerunner.gameobjects;

import cf.mazerunner.InputManager;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends GameObject {
	private static final float PLAYER_WIDTH = 40f;
	private static final float PLAYER_HEIGHT = 40f;
	
	private float speed;
	
	public Player(int x, int y) {
		super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		speed = 200f;
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		if (InputManager.keys[Keys.UP] || InputManager.keys[Keys.W]) position.y += speed*delta;
		if (InputManager.keys[Keys.LEFT] || InputManager.keys[Keys.A]) position.x -= speed*delta;
		if (InputManager.keys[Keys.DOWN] || InputManager.keys[Keys.S]) position.y -= speed*delta;
		if (InputManager.keys[Keys.RIGHT] || InputManager.keys[Keys.D]) position.x += speed*delta;
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(Color.BLACK);
		renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
