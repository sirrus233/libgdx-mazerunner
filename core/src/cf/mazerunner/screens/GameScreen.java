package cf.mazerunner.screens;

import cf.mazerunner.InputManager;
import cf.mazerunner.MazeManager;
import cf.mazerunner.Mazerunner;

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
