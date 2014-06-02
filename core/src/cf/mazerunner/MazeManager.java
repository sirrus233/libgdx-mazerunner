package cf.mazerunner;

import cf.mazerunner.gameobjects.Player;
import cf.mazerunner.gameobjects.Room;

public class MazeManager {
	public Room[][] map;
	public Player player;
	public Room location;
	
	public MazeManager() {
		map = new Room[3][3];
		player  = new Player(50, 50);
		
		buildMaze();
		
		location = map[1][1];
	}
	
	private void buildMaze() {
		/*
		map[0][0] = new Room(AssetManager.bl);
		
		map[1][0] = new Room(AssetManager.yellow);
		map[1][0].addDoors(Room.EAST);
		map[1][0].addDoors(Room.SOUTH);
		map[1][0].addDoors(Room.WEST);
		
		map[2][0] = new Room(AssetManager.bl);
		
		map[0][1] = new Room(AssetManager.green);
		map[0][1].addDoors(Room.EAST);
		map[0][1].addDoors(Room.SOUTH);
		map[0][1].addDoors(Room.WEST);
		*/
		map[1][1] = new Room(AssetManager.red);
		map[1][1].addDoors(Room.NORTH);
		map[1][1].addDoors(Room.SOUTH);
		/*
		map[2][1] = new Room(AssetManager.blue);
		map[2][1].addDoors(Room.NORTH);
		map[2][1].addDoors(Room.EAST);
		map[2][1].addDoors(Room.SOUTH);
		map[2][1].addDoors(Room.WEST);
		
		map[0][2] = new Room(AssetManager.red);
		map[0][2].addDoors(Room.EAST);
		
		map[1][2] = new Room(AssetManager.yellow);
		map[1][2].addDoors(Room.EAST);
		map[1][2].addDoors(Room.SOUTH);
		map[1][2].addDoors(Room.WEST);
		
		map[2][2] = new Room(AssetManager.red);
		map[2][2].addDoors(Room.WEST);
		map[2][2].addDoors(Room.SOUTH);
		*/
	}
}
