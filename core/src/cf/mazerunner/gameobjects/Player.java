package cf.mazerunner.gameobjects;

import cf.mazerunner.AssetManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject {
	
	private float speed;
	
	public Player(int x, int y) {
		super(AssetManager.bl, x, y);
		speed = 200f;
	}

	@Override
	public void update(float delta) {
		sprite.setX(position.x);
		sprite.setY(position.y);
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public float getSpeed() {
		return speed;
	}
}
