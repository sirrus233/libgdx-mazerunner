package cf.mazerunner;

import cf.mazerunner.screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Mazerunner extends Game {	
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		gameScreen = new GameScreen(this);
		
		Gdx.input.setInputProcessor(new InputManager());
		setScreen(gameScreen);
	}
}
