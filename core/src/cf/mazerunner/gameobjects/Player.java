package cf.mazerunner.gameobjects;

import cf.mazerunner.InputManager;
import cf.mazerunner.MazeManager;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends GameObject {
	private static final float PLAYER_WIDTH = 80f;
	private static final float PLAYER_HEIGHT = 80f;
	private static final float SPEED = 350f;
	
	private MazeManager maze;
	
	public Player(int x, int y, MazeManager m) {
		super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		maze = m;
	}

	@Override
	public void update(float delta) {	
		// Handle movement input
		if (InputManager.keys[Keys.UP] || InputManager.keys[Keys.W]) updatePosition(0, SPEED*delta);
		if (InputManager.keys[Keys.LEFT] || InputManager.keys[Keys.A]) updatePosition(-SPEED*delta, 0);
		if (InputManager.keys[Keys.DOWN] || InputManager.keys[Keys.S]) updatePosition(0, -SPEED*delta);
		if (InputManager.keys[Keys.RIGHT] || InputManager.keys[Keys.D]) updatePosition(SPEED*delta, 0);
		
		checkDoorCollisions();
		checkWallCollisions();
	}
	
	private void checkDoorCollisions() {
		if (maze.location.hasDoor(Room.NORTH) && !maze.location.getDoor(Room.NORTH).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.NORTH).getBounds())) {
				maze.moveNorth();
				maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.SOUTH).getBounds().height);
			}
		}
		if (maze.location.hasDoor(Room.EAST) && !maze.location.getDoor(Room.EAST).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.EAST).getBounds())) {
				maze.moveEast();
				maze.player.setPosition(maze.location.getWall(Room.WEST).getBounds().width, maze.player.getPosition().y);
			}
		}
		if (maze.location.hasDoor(Room.SOUTH) && !maze.location.getDoor(Room.SOUTH).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.SOUTH).getBounds())) {
				maze.moveSouth();
				maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.NORTH).getBounds().y - maze.player.getBounds().height);
			}
		}
		if (maze.location.hasDoor(Room.WEST) && !maze.location.getDoor(Room.WEST).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.WEST).getBounds())) {
				maze.moveWest();
				maze.player.setPosition(maze.location.getWall(Room.EAST).getBounds().x - maze.player.getBounds().width, maze.player.getPosition().y);
			}
		}
	}
	
	private void checkWallCollisions() {
		if (maze.player.getBounds().overlaps(maze.location.getWall(Room.NORTH).getBounds())) {
			maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.NORTH).getBounds().y - maze.player.getBounds().height);
		}
		if (maze.player.getBounds().overlaps(maze.location.getWall(Room.EAST).getBounds())) {
			maze.player.setPosition(maze.location.getWall(Room.EAST).getBounds().x - maze.player.getBounds().width, maze.player.getPosition().y);
		}
		if (maze.player.getBounds().overlaps(maze.location.getWall(Room.SOUTH).getBounds())) {
			maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.SOUTH).getBounds().height);
		}
		if (maze.player.getBounds().overlaps(maze.location.getWall(Room.WEST).getBounds())) {
			maze.player.setPosition(maze.location.getWall(Room.WEST).getBounds().width, maze.player.getPosition().y);
		}
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(Color.BLACK);
		renderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
	}
}
