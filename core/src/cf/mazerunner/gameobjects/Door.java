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
			setPosition((Gdx.graphics.getWidth() - getBounds().width) / 2, Gdx.graphics.getHeight() - getBounds().height);
			break;
		case Room.EAST:
			rotate();
			setPosition(Gdx.graphics.getWidth() - getBounds().width, (Gdx.graphics.getHeight() - getBounds().height) / 2);
			break;
		case Room.SOUTH:
			setPosition((Gdx.graphics.getWidth() - getBounds().width) / 2, 0);
			break;
		case Room.WEST:
			rotate();
			setPosition(0, (Gdx.graphics.getHeight() - getBounds().height) / 2);
			break;
		default:
			System.out.println("-E- Bad door placement.");
			break;
		}
		
		locked = false;
	}
	
	public boolean getLocked() {
		return locked;
	}
	
	public void setLocked(boolean l) {
		locked = l;
	}
	
	public void setUnlocked(boolean u) {
		setLocked(!u);
	}
	
	@Override
	public void draw(ShapeRenderer renderer) {
		if (locked) {
			renderer.setColor(Color.GRAY);
		} else {
			renderer.setColor(Color.WHITE);
		}
		renderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
}
