package cf.mazerunner.gameobjects;

import cf.mazerunner.AssetManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Wall extends GameObject {
	public Wall () {
		super(AssetManager.wall, 0, 0);
	}
	
	public void setDirection(int direction) {
		switch (direction) {
		case Room.NORTH:
			sprite.setRotation(0);
			sprite.setX(0);
			sprite.setY(0);
			break;
		case Room.EAST:
			sprite.setRotation(90);
			sprite.setX(0);
			sprite.setY(Gdx.graphics.getHeight());
			break;
		case Room.SOUTH:
			sprite.setRotation(180);
			sprite.setX(Gdx.graphics.getWidth());
			sprite.setY(Gdx.graphics.getHeight());
			break;
		case Room.WEST:
			sprite.setRotation(270);
			sprite.setX(Gdx.graphics.getWidth());
			sprite.setY(0);
			break;
		default:
			System.out.println("Error: Invalid parameter used to set wall direction!");
			break;
		}
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
