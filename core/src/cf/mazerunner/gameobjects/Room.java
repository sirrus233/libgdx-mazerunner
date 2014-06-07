package cf.mazerunner.gameobjects;

import cf.mazerunner.MazeManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Room extends GameObject {
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	private MazeManager maze;
	private Color roomColor;
	private Door[] doors;
	private Wall[] walls;
	
	public Room(MazeManager m, Color c) {
		super(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		maze = m;
		roomColor = c;
		
		doors = new Door[4];
		
		walls = new Wall[4];
		walls[NORTH] = new Wall(NORTH);
		walls[EAST] = new Wall(EAST);
		walls[SOUTH] = new Wall(SOUTH);
		walls[WEST] = new Wall(WEST);
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
		updateDoorLocks();
		
		for (int i = 0; i < walls.length; i++) {
			walls[i].update(delta);
		}
		
		for (int i = 0; i < doors.length; i++) {
			if (hasDoor(i)) {
				doors[i].update(delta);
			}
		}
	}
	
	private void updateDoorLocks() {
		//Update NORTH door
		if (doors[NORTH] != null) {
			if (maze.getNorth() != null) {doors[NORTH].setUnlocked(maze.getNorth().hasDoor(SOUTH));}
			else {doors[NORTH].setUnlocked(false);}
		}
		//Update EAST door
		if (doors[EAST] != null) {
			if (maze.getEast() != null) {doors[EAST].setUnlocked(maze.getEast().hasDoor(WEST));}
			else {doors[EAST].setUnlocked(false);}
		}
		//Update SOUTH door
		if (doors[SOUTH] != null) {
			if (maze.getSouth() != null) {doors[SOUTH].setUnlocked(maze.getSouth().hasDoor(NORTH));}
			else {doors[SOUTH].setUnlocked(false);}
		}
		//Update WEST door
		if (doors[WEST] != null) {
			if (maze.getWest() != null) {doors[WEST].setUnlocked(maze.getWest().hasDoor(EAST));}
			else {doors[WEST].setUnlocked(false);}
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
 