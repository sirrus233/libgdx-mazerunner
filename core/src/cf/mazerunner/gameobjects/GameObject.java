package cf.mazerunner.gameobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	public final Vector2 position;
	public final Rectangle bounds;
	
	public GameObject (float x, float y, float width, float height) {
		position = new Vector2(x, y);
		bounds = new Rectangle(position.x, position.y, width, height);
	}
	
	public void update(float delta) {
		bounds.x = position.x;
		bounds.y = position.y;
	}
	
	public abstract void draw(ShapeRenderer renderer);

	public void rotate() {
		float temp = bounds.width;
		bounds.width = bounds.height;
		bounds.height = temp;
	}
}
