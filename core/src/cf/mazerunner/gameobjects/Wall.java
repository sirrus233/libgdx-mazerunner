package cf.mazerunner.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Wall extends GameObject {
	private static final float WALL_WIDTH = Gdx.graphics.getWidth();
	private static final float WALL_HEIGHT = 50f;
	
	public Wall (int direction) {
		super(0, 0, WALL_WIDTH, WALL_HEIGHT);
		
		switch (direction) {
		case Room.NORTH:
			setPosition(0, Gdx.graphics.getHeight() - getBounds().height);
			break;
		case Room.EAST:
			rotate();
			setPosition(Gdx.graphics.getWidth() - getBounds().width, 0);
			break;
		case Room.SOUTH:
			break;
		case Room.WEST:
			rotate();
			break;
		default:
			System.out.println("-E- Bad wall placement.");
			break;
		}
	}

	@Override
	public void draw(ShapeRenderer renderer) {
		renderer.setColor(Color.LIGHT_GRAY);
		renderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
}
