package cf.mazerunner.screens;

import cf.mazerunner.Mazerunner;

import com.badlogic.gdx.ScreenAdapter;

public abstract class AbstractScreen extends ScreenAdapter {
	Mazerunner game;
	
	public void render(float delta) {
		update(delta);
		draw();
		game.input.clear();
	}
	
	public abstract void update(float delta);
	
	public abstract void draw();
}
