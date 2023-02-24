package application;
/**---------------------------------------------------------------------------------------------------**/
/** Contributers **/
// Student Number (1)
// Student Name: Furkan Acar.
// Student Number: 150121534
// Student Number (2)
// Student Name: Abdelrahman Ahmed Nabil Zahran.
// Student Number: 150120998
/**---------------------------------------------------------------------------------------------------**/
/** Import Libraries and Classes used in the Class **/
import java.util.ArrayList;

import application.Abstract.Pipe;
import application.Abstract.Tile;
import javafx.scene.shape.Path;
/**---------------------------------------------------------------------------------------------------**/
public class Repository {
	/** Data Fields **/
	public static ArrayList<Pipe> pipeList = new ArrayList<Pipe>();
	public static Path path = new Path();
	public static Tile[][] twoDim = new Tile[4][4];
	public static ArrayList<Tile> tileList = new ArrayList<Tile>();
	public static int currentLevel = 0;
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The incrementLevel() -> Increase the level number -> activate the next level button.
	public static void incrementLevel() {
		if (Helper.contents.length - 1 > currentLevel) {
			currentLevel++;
		}
	}
	
	// The decrementLevel() method -> Decrease the level number -> activate the previous level button.
	public static void decrementLevel() {
		if(currentLevel != 0) {
			currentLevel--;
			}
	}
	
	// The Static method RunAgain() -> Clear all lists when the current level is completed to update the next level.
	public static void runAgain() {
		pipeList = new ArrayList<Pipe>();
		path = new Path();
		twoDim = new Tile[4][4];
		tileList = new ArrayList<Tile>();
	}
	
	// The static method find TileInTwoDim -> the position of the selected tile.
	public static int[] findTileInTwoDim(Tile[][] list, Tile tile) {
		// Position of the object(tile) -> point.
		int[] positions = new int[2];
		
		// Searching for the point by checking (x, y) of the point.
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				// Checking the equality of the tile id till the same id one is found (point 1 == point 2).
				if (list[i][j].getTileId().equals(tile.getTileId())) {
					// Obtain new coordinates of the point.
					positions[0] = j;
					positions[1] = i;
					return positions;
				}
			}
		}
		return positions;
	}
	
	// The static method findXYCoordinates() of int[] type -> convert (normal coordinate -> pixel coordinate).
	public static int[] findXYCoordinate(Tile tile) {
		// Position of the object(ball) in pixel.
		int[] coordinates = new int[2];
		
		// X position coordinate.
		int x = (findTileInTwoDim(twoDim, tile)[0] * 100 + 50);
		coordinates[0] = x;
		
		// Y position coordinate.
		int y = (findTileInTwoDim(twoDim, tile)[1] * 100 + 50);
		coordinates[1] = y;
		
		return coordinates;
	}
}	
//--------------------------------------------------------------------------------------------------//