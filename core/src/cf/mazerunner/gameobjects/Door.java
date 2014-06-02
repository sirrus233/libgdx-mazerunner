package cf.mazerunner.gameobjects;

import cf.mazerunner.AssetManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Door extends GameObject {
	private boolean locked;
	
	public Door() {
		super(AssetManager.lockedDoor, 0, 0);
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
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
		
	}
}
