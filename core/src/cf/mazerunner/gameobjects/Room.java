package cf.mazerunner.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Room extends GameObject {
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	private Door[] doors;
	private Wall[] walls;
	
	public Room(TextureRegion img) {
		super(img, 0, 0);
		doors = new Door[4];
		walls = new Wall[4];
		
		walls[NORTH] = new Wall();
		walls[NORTH].setDirection(NORTH);
		walls[EAST] = new Wall();
		walls[EAST].setDirection(EAST);
		walls[SOUTH] = new Wall();
		walls[SOUTH].setDirection(SOUTH);
		walls[WEST] = new Wall();
		walls[WEST].setDirection(WEST);
	}
	
	public void addDoors(int direction) {
		doors[direction] = new Door();
	}
	
	public boolean hasDoor(int direction) {
		return doors[direction] != null;
	}
	
	public Door getDoor(int direction) {
		return doors[direction];
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
		
		for (Wall w : walls) {
			w.sprite.draw(batch);
		}
		
		//for (Door d : doors) {
		//	d.sprite.draw(batch);
		//}
	}
}
 