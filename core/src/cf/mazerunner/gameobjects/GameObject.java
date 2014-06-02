package cf.mazerunner.gameobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	private final Vector2 position;
	private final Rectangle bounds;
	
	public GameObject (float x, float y, float width, float height) {
		position = new Vector2(x, y);
		bounds = new Rectangle(position.x, position.y, width, height);
	}
	
	public abstract void update(float delta);
	
	public abstract void draw(ShapeRenderer renderer);
	
	public Rectangle getBounds() {
		return new Rectangle(bounds);
	}
	
	public Vector2 getPosition() {
		return new Vector2(position);
	}
	
	public void setPosition(float x, float y) {
		position.set(x,y);
		bounds.setPosition(this.position);
	}
	
	public void setPosition(Vector2 p) {
		setPosition(p.x, p.y);
	}
	
	public void updatePosition(float deltaX, float deltaY) {
		position.x += deltaX;
		position.y += deltaY;
		bounds.setPosition(position);
	}
	
	public void updatePosition(Vector2 deltaP) {
		updatePosition(deltaP.x, deltaP.y);
	}
	
	public void rotate() {
		float temp = bounds.width;
		bounds.width = bounds.height;
		bounds.height = temp;
	}
}
