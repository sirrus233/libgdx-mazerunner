package cf.mazerunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import cf.mazerunner.gameobjects.Player;
import cf.mazerunner.gameobjects.Room;

public class MazeManager {
	public Room[][] map;
	public Player player;
	public Room location;
	public int locationX;
	public int locationY;
	
	public MazeManager() {
		map = new Room[3][3];
		player  = new Player(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		
		buildMaze();
		
		locationX = 1;
		locationY = 1;
		location = map[locationX][locationY];
	}
	
	public void updateDoors() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				//Check NORTH door
				if (map[i][j].hasDoor(Room.NORTH)) {
					map[i][j].getDoor(Room.NORTH).setUnlocked(j < map[i].length -1 && map[i][j+1].hasDoor(Room.SOUTH));
				}
				if (map[i][j].hasDoor(Room.EAST)) {
					map[i][j].getDoor(Room.EAST).setUnlocked(i < map.length -1 && map[i+1][j].hasDoor(Room.WEST));
				}
				if (map[i][j].hasDoor(Room.SOUTH)) {
					map[i][j].getDoor(Room.SOUTH).setUnlocked(j > 0 && map[i][j-1].hasDoor(Room.NORTH));
				}
				if (map[i][j].hasDoor(Room.WEST)) {
					map[i][j].getDoor(Room.WEST).setUnlocked(i > 0 && map[i-1][j].hasDoor(Room.EAST));
				}
			}
		}
	}
	
	private void buildMaze() {
		
		map[0][0] = new Room(Color.BLACK);
		
		map[1][0] = new Room(Color.YELLOW);
		map[1][0].addDoors(Room.EAST);
		map[1][0].addDoors(Room.SOUTH);
		map[1][0].addDoors(Room.WEST);
		
		map[2][0] = new Room(Color.BLACK);
		
		map[0][1] = new Room(Color.GREEN);
		map[0][1].addDoors(Room.EAST);
		map[0][1].addDoors(Room.SOUTH);
		map[0][1].addDoors(Room.WEST);
		
		map[1][1] = new Room(Color.RED);
		map[1][1].addDoors(Room.NORTH);
		map[1][1].addDoors(Room.SOUTH);
		
		map[2][1] = new Room(Color.BLUE);
		map[2][1].addDoors(Room.NORTH);
		map[2][1].addDoors(Room.EAST);
		map[2][1].addDoors(Room.SOUTH);
		map[2][1].addDoors(Room.WEST);
		
		map[0][2] = new Room(Color.RED);
		map[0][2].addDoors(Room.EAST);
		
		map[1][2] = new Room(Color.PURPLE);
		map[1][2].addDoors(Room.EAST);
		map[1][2].addDoors(Room.SOUTH);
		map[1][2].addDoors(Room.WEST);
		
		map[2][2] = new Room(Color.RED);
		map[2][2].addDoors(Room.WEST);
		map[2][2].addDoors(Room.SOUTH);
	}
}
