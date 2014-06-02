package cf.mazerunner.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	public final Sprite sprite;
	public final Vector2 position;
	public final Rectangle bounds;
	
	public GameObject (TextureRegion img, int x, int y) {
		sprite = new Sprite(img);
		sprite.setX(x);
		sprite.setY(y);
		
		position = new Vector2(sprite.getOriginX(), sprite.getOriginY());
		bounds = sprite.getBoundingRectangle();
	}
	
	public abstract void update(float delta);
	
	public abstract void draw(SpriteBatch batch);
}
