package cf.mazerunner.screens;

import cf.mazerunner.InputManager;
import cf.mazerunner.Mazerunner;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class AbstractScreen extends ScreenAdapter {
	Mazerunner game;
	ShapeRenderer renderer = new ShapeRenderer();
	
	public void render(float delta) {
		update(delta);
		draw(renderer);
		InputManager.clear();
	}
	
	public abstract void update(float delta);
	
	public abstract void draw(ShapeRenderer renderer);
}
