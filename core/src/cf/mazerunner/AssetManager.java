package cf.mazerunner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {
	public static Texture texture;
	public static Texture badlogic;
	
	public static TextureRegion bl;
	public static TextureRegion red;
	public static TextureRegion yellow;
	public static TextureRegion green;
	public static TextureRegion blue;
	public static TextureRegion purple;
	public static TextureRegion wall;
	public static TextureRegion unlockedDoor;
	public static TextureRegion lockedDoor;
	
	
	public static void loadTextures() {
		texture = new Texture("art.png");
		badlogic = new Texture("badlogic.jpg");
		
		bl = new TextureRegion(badlogic);
		
		red = new TextureRegion(texture, 0, 0, 309, 291);
		yellow = new TextureRegion(texture, 309, 0, 303, 294);
		green = new TextureRegion(texture, 612, 0, 292, 305);
		blue = new TextureRegion(texture, 0, 292, 305, 291);
		purple = new TextureRegion(texture, 305, 292, 304, 293);
		wall = new TextureRegion(texture, 904, 0, 35, 296);
		unlockedDoor = new TextureRegion(texture, 939, 0, 61, 146);
		lockedDoor = new TextureRegion(texture, 956, 146, 61, 150);
	
	}
}
