package cf.mazerunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import cf.mazerunner.gameobjects.Player;
import cf.mazerunner.gameobjects.Room;

public class MazeManager {
	private static final int MAZE_SIZE = 3;
	private static final int START_X = 1;
	private static final int START_Y = 1;
	private static final int START_Z = 1;
	
	private Room[][][] map;
	
	private int locationX;
	private int locationY;
	private int locationZ;
	
	public Player player;
	public Room location;
	
	public MazeManager() {
		map = new Room[MAZE_SIZE][MAZE_SIZE][MAZE_SIZE];
		player  = new Player(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, this);
		
		buildMaze();
		
		locationX = START_X;
		locationY = START_Y;
		locationZ = START_Z;
		location = map[locationX][locationY][locationZ];
	}
	
	public void moveNorth() {
		locationY += 1;
		location = map[locationX][locationY][locationZ];
	}
	public void moveEast() {
		locationX += 1;
		location = map[locationX][locationY][locationZ];
	}
	public void moveSouth() {
		locationY -= 1;
		location = map[locationX][locationY][locationZ];
	}
	public void moveWest() {
		locationX -= 1;
		location = map[locationX][locationY][locationZ];
	}
	public void moveUp() {
		locationZ += 1;
		location = map[locationX][locationY][locationZ];
	}
	public void moveDown() {
		locationZ -= 1;
		location = map[locationX][locationY][locationZ];
	}
	
	public Room getNorth() {
		if (locationY >= MAZE_SIZE - 1) {return null;}
		else {return map[locationX][locationY + 1][locationZ];}
	}
	public Room getEast() {
		if (locationX >= MAZE_SIZE - 1) {return null;}
		else {return map[locationX + 1][locationY][locationZ];}	
	}
	public Room getSouth() {
		if (locationY <= 0) {return null;}
		else {return map[locationX][locationY - 1][locationZ];}
	}
	public Room getWest() {
		if (locationX <= 0) {return null;}
		else {return map[locationX - 1][locationY][locationZ];}
	}
	public Room getUp() {
		if (locationZ >= MAZE_SIZE) {return null;}
		else {return map[locationX][locationY][locationZ + 1];}
	}
	public Room getDown() {
		if (locationZ <= 0) {return null;}
		else {return map[locationX][locationY][locationZ - 1];}
	}

	
	private void buildMaze() {
		//No rooms at z = 0 yet
		
		map[0][0][1] = new Room(this, Color.BLACK);
		
		map[1][0][1] = new Room(this, Color.YELLOW);
		map[1][0][1].addDoors(Room.EAST);
		map[1][0][1].addDoors(Room.SOUTH);
		map[1][0][1].addDoors(Room.WEST);
		
		map[2][0][1] = new Room(this, Color.BLACK);
		
		map[0][1][1] = new Room(this, Color.GREEN);
		map[0][1][1].addDoors(Room.EAST);
		map[0][1][1].addDoors(Room.SOUTH);
		map[0][1][1].addDoors(Room.WEST);
		
		map[1][1][1] = new Room(this, Color.RED);
		map[1][1][1].addDoors(Room.NORTH);
		map[1][1][1].addDoors(Room.SOUTH);
		
		map[2][1][1] = new Room(this, Color.BLUE);
		map[2][1][1].addDoors(Room.NORTH);
		map[2][1][1].addDoors(Room.EAST);
		map[2][1][1].addDoors(Room.SOUTH);
		map[2][1][1].addDoors(Room.WEST);
		
		map[0][2][1] = new Room(this, Color.RED);
		map[0][2][1].addDoors(Room.EAST);
		
		map[1][2][1] = new Room(this, Color.PURPLE);
		map[1][2][1].addDoors(Room.EAST);
		map[1][2][1].addDoors(Room.SOUTH);
		map[1][2][1].addDoors(Room.WEST);
		
		map[2][2][1] = new Room(this, Color.RED);
		map[2][2][1].addDoors(Room.WEST);
		map[2][2][1].addDoors(Room.SOUTH);
		
		//No rooms at z = 2  yet
	}
}
