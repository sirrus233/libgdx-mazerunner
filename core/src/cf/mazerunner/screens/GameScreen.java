package cf.mazerunner.screens;

import cf.mazerunner.InputManager;
import cf.mazerunner.MazeManager;
import cf.mazerunner.Mazerunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;

public class GameScreen extends AbstractScreen {
	private MazeManager maze;	
	
	public GameScreen(Mazerunner g) {
		super.game = g;
		maze = new MazeManager();
	}

	@Override
	public void update(float delta) {
		maze.player.update(delta);
		
		if (game.input.keysTyped[InputManager.ESC]) Gdx.app.exit();
		
		if (game.input.keys[Keys.UP] || game.input.keys[Keys.W]) maze.player.position.y += maze.player.getSpeed()*delta;
		if (game.input.keys[Keys.LEFT] || game.input.keys[Keys.A]) maze.player.position.x -= maze.player.getSpeed()*delta;
		if (game.input.keys[Keys.DOWN] || game.input.keys[Keys.S]) maze.player.position.y -= maze.player.getSpeed()*delta;
		if (game.input.keys[Keys.RIGHT] || game.input.keys[Keys.D]) maze.player.position.x += maze.player.getSpeed()*delta;
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		//maze.location.draw(game.batch);
		maze.player.draw(game.batch);
		game.batch.end();		
	}
}
