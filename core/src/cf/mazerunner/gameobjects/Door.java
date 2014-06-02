package cf.mazerunner.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Door extends GameObject {
	private static final float DOOR_WIDTH = 120f;
	private static final float DOOR_HEIGHT = 50f;
	
	private boolean locked;
	
	public Door(int direction) {
		super(0, 0, DOOR_WIDTH, DOOR_HEIGHT);
		
		switch (direction) {
		case Room.NORTH:
			position.x = (Gdx.graphics.getWidth() - bounds.width) / 2;
			position.y = (Gdx.graphics.getHeight() - bounds.height);
			break;
		case Room.EAST:
			rotate();
			position.x = Gdx.graphics.getWidth() - bounds.width;
			position.y = (Gdx.graphics.getHeight() - bounds.height) / 2;
			break;
		case Room.SOUTH:
			position.x = (Gdx.graphics.getWidth() - bounds.width) / 2;
			break;
		case Room.WEST:
			rotate();
			position.y = (Gdx.graphics.getHeight() - bounds.height) / 2;
			break;
		default:
			System.out.println("-E- Bad door placement.");
			break;
		}
		
		locked = false;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void unlock() {
		locked = false;
	}
	
	public void lock() {
		locked = true;
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		if (locked) {
			renderer.setColor(Color.GRAY);
		} else {
			renderer.setColor(Color.WHITE);
		}
		renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
