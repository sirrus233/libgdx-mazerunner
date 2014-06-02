package cf.mazerunner.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Room extends GameObject {
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	private Color roomColor;
	private Door[] doors;
	private Wall[] walls;
	
	public static int sid = 0;
	public int id;
	
	public Room(Color c) {
		super(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		roomColor = c;
		doors = new Door[4];
		
		walls = new Wall[4];
		walls[NORTH] = new Wall(NORTH);
		walls[EAST] = new Wall(EAST);
		walls[SOUTH] = new Wall(SOUTH);
		walls[WEST] = new Wall(WEST);
		
		id = sid;
		sid++;
	}
	
	public void addDoors(int direction) {
		doors[direction] = new Door(direction);
	}
	
	public boolean hasDoor(int direction) {
		return doors[direction] != null;
	}
	
	public Door getDoor(int direction) {
		return doors[direction];
	}
	
	public Wall getWall(int direction) {
		return walls[direction];
	}
	
	@Override
	public void update(float delta) {
		for (int i = 0; i < walls.length; i++) {
			walls[i].update(delta);
		}
		
		for (int i = 0; i < doors.length; i++) {
			if (hasDoor(i)) {
				doors[i].update(delta);
			}
		}
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(roomColor);
		renderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
		
		for (int i = 0; i < walls.length; i++) {
			walls[i].draw(renderer);
		}
		
		for (int i = 0; i < doors.length; i++) {
			if (hasDoor(i)) {
				doors[i].draw(renderer);
			}
		}
	}
}
 