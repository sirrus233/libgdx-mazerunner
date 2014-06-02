package cf.mazerunner.screens;

import cf.mazerunner.InputManager;
import cf.mazerunner.MazeManager;
import cf.mazerunner.Mazerunner;
import cf.mazerunner.gameobjects.Room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen extends AbstractScreen {
	private MazeManager maze;	
	
	public GameScreen(Mazerunner g) {
		super.game = g;
		maze = new MazeManager();
	}

	@Override
	public void update(float delta) {
		maze.location.update(delta);
		maze.player.update(delta);
		
		//Door collisions
		if (maze.location.hasDoor(Room.NORTH) && !maze.location.getDoor(Room.NORTH).isLocked()) {
			if (maze.player.bounds.overlaps(maze.location.getDoor(Room.NORTH).bounds)) {
				maze.locationY++;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.position.y = maze.location.getWall(Room.SOUTH).bounds.height;
			}
		}
		if (maze.location.hasDoor(Room.EAST) && !maze.location.getDoor(Room.EAST).isLocked()) {
			if (maze.player.bounds.overlaps(maze.location.getDoor(Room.EAST).bounds)) {
				maze.locationX++;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.position.x = maze.location.getWall(Room.WEST).bounds.width;
			}
		}
		if (maze.location.hasDoor(Room.SOUTH) && !maze.location.getDoor(Room.SOUTH).isLocked()) {
			if (maze.player.bounds.overlaps(maze.location.getDoor(Room.SOUTH).bounds)) {
				maze.locationY--;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.position.y = maze.location.getWall(Room.NORTH).bounds.y - maze.player.bounds.height;
			}
		}
		if (maze.location.hasDoor(Room.WEST) && !maze.location.getDoor(Room.WEST).isLocked()) {
			if (maze.player.bounds.overlaps(maze.location.getDoor(Room.WEST).bounds)) {
				maze.locationX--;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.position.x = maze.location.getWall(Room.EAST).bounds.x - maze.player.bounds.width;
			}
		}
		
		//Wall collisions
		if (maze.player.bounds.overlaps(maze.location.getWall(Room.NORTH).bounds)) {
			maze.player.position.y = maze.location.getWall(Room.NORTH).bounds.y - maze.player.bounds.height;
		}
		if (maze.player.bounds.overlaps(maze.location.getWall(Room.EAST).bounds)) {
			maze.player.position.x = maze.location.getWall(Room.EAST).bounds.x - maze.player.bounds.width;
		}
		if (maze.player.bounds.overlaps(maze.location.getWall(Room.SOUTH).bounds)) {
			maze.player.position.y = maze.location.getWall(Room.SOUTH).bounds.height;
		}
		if (maze.player.bounds.overlaps(maze.location.getWall(Room.WEST).bounds)) {
			maze.player.position.x = maze.location.getWall(Room.WEST).bounds.width;
		}
		
		
		if (InputManager.keysTyped[InputManager.ESC]) Gdx.app.exit();
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.begin(ShapeType.Filled);
		maze.location.draw(renderer);
		maze.player.draw(renderer);
		renderer.end();		
	}
}
