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
		
		maze.updateDoors();
		
		//Door collisions
		if (maze.location.hasDoor(Room.NORTH) && !maze.location.getDoor(Room.NORTH).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.NORTH).getBounds())) {
				maze.locationY++;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.SOUTH).getBounds().height);
				
				//FIXME terrible place for this, move room changing to a MazeManager method and have
				//it control room rotation
				if (maze.locationX == 2 && maze.locationY == 2) {
					maze.count = (maze.count + 1) % 4;
				}
				if (maze.locationX == 0 && maze.locationY == 2) {
					for (int i = 0; i < maze.count; i++) {
						Room temp = maze.map[1][2];
						maze.map[1][2] = maze.map[0][1];
						maze.map[0][1] = maze.map[1][0];
						maze.map[1][0] = maze.map[2][1];
						maze.map[2][1] = temp;
					}
				}
			}
		}
		if (maze.location.hasDoor(Room.EAST) && !maze.location.getDoor(Room.EAST).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.EAST).getBounds())) {
				maze.locationX++;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.setPosition(maze.location.getWall(Room.WEST).getBounds().width, maze.player.getPosition().y);
			
				if (maze.locationX == 2 && maze.locationY == 2) {
					maze.count = (maze.count + 1) % 4;
				}
				if (maze.locationX == 0 && maze.locationY == 2) {
					for (int i = 0; i < maze.count; i++) {
						Room temp = maze.map[1][2];
						maze.map[1][2] = maze.map[0][1];
						maze.map[0][1] = maze.map[1][0];
						maze.map[1][0] = maze.map[2][1];
						maze.map[2][1] = temp;
					}
				}
			}
		}
		if (maze.location.hasDoor(Room.SOUTH) && !maze.location.getDoor(Room.SOUTH).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.SOUTH).getBounds())) {
				maze.locationY--;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.setPosition(maze.player.getPosition().x, maze.location.getWall(Room.NORTH).getBounds().y - maze.player.getBounds().height);
			
				if (maze.locationX == 2 && maze.locationY == 2) {
					maze.count = (maze.count + 1) % 4;
				}
				if (maze.locationX == 0 && maze.locationY == 2) {
					for (int i = 0; i < maze.count; i++) {
						Room temp = maze.map[1][2];
						maze.map[1][2] = maze.map[0][1];
						maze.map[0][1] = maze.map[1][0];
						maze.map[1][0] = maze.map[2][1];
						maze.map[2][1] = temp;
					}
				}
			}
		}
		if (maze.location.hasDoor(Room.WEST) && !maze.location.getDoor(Room.WEST).getLocked()) {
			if (maze.player.getBounds().overlaps(maze.location.getDoor(Room.WEST).getBounds())) {
				maze.locationX--;
				maze.location = maze.map[maze.locationX][maze.locationY];
				maze.player.setPosition(maze.location.getWall(Room.EAST).getBounds().x - maze.player.getBounds().width, maze.player.getPosition().y);
			
				if (maze.locationX == 2 && maze.locationY == 2) {
					maze.count = (maze.count + 1) % 4;
				}
				if (maze.locationX == 0 && maze.locationY == 2) {
					for (int i = 0; i < maze.count; i++) {
						Room temp = maze.map[1][2];
						maze.map[1][2] = maze.map[0][1];
						maze.map[0][1] = maze.map[1][0];
						maze.map[1][0] = maze.map[2][1];
						maze.map[2][1] = temp;
					}
				}
			}
		}
		
		//Wall collisions
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
