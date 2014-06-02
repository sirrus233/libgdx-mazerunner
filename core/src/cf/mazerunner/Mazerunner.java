package cf.mazerunner;

import cf.mazerunner.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Mazerunner extends Game {
	public InputManager input;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		AssetManager.loadTextures();
		
		input = new InputManager();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
    	camera.update();
    	
		gameScreen = new GameScreen(this);
		
		Gdx.input.setInputProcessor(input);
		setScreen(gameScreen);
	}
}
