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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import application.Abstract.Tile;
/**---------------------------------------------------------------------------------------------------**/
// This Class
public class Helper {
	//--------------------------------------------------------------------------------------------------//
	/** Data Fields **/
	// file contents
	public static String[] contents;
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The static method readFromFile() -> read input files and take from them to use it to construct the game board for each level.
	public static void readFromFile(ArrayList<Tile> tileList) {
		try {
			// Create a dictionary to keep the files in it.
			File directoryPath = new File("levels");
			// List of all files and directories
			contents = directoryPath.list();
			System.out.println("List of files and directories in the specified directory:");
			System.out.println(contents.length);
			// Print file names -> check order of reading + Execution.
			for (String string : contents) {
				System.out.println(string);				
			}
			// Create a file object to be able to read input files + a Scanner to scan that file object..
			File myObj = new File("levels/" + contents[Repository.currentLevel]);
			Scanner myReader = new Scanner(myObj);
			// Reading the levels files -> create the game board. 
			while (myReader.hasNextLine()) {
				// Ignore empty spaces and lines in the input files -> to obtain much understandable data.
				String data = myReader.nextLine();
				data = data.replaceAll("\\s", "");
				if (data.equals("")) {
					data = "";
				} else {
					String[] list = data.trim().split(",");
					tileList.add(Helper.generateTiles(list));
				}
			}
			// Close Reader + stop taking input files.
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	// The generateTiles() method generates tiles -> creating objects.
	public static Tile generateTiles(String[] list) {
		String id = list[0];
		String type = list[1].toLowerCase();
		String property = list[2].toLowerCase();
		String imagePath;

		// Types of the tiles -> images(id, type, property, image path)
		switch (type) {
		// In case tile is a Starter type.
		case "starter":
			// Checking the property of the tile (horizontal or vertical).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/Starter-Vertical.png";
				break;
			// Horizontal Case	
			case "horizontal":
				imagePath = "tiles/Starter-Horizontal.png";
				break;
			// In case none of other cases -> Vertical.
			default:
				imagePath = "tiles/Starter-Vertical.png";
				break;
			}
			// Create a StartTile object -> [StartTitle(String id, String type, String property, String path) constructor].
			return new StartTile(id, type, property, imagePath);
			
		// In case is a an End type.	
		case "end":
			// Checking the property of the tile (horizontal or vertical)
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/End-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/End-Horizontal.png";
				break;
			// In case none of the other cases -> Vertical.	
			default:	
				imagePath = "tiles/End-Vertical.png";
				break;
			}
			// Create an EndTile object -> [EndTile(String id, String type, String property, String path)].
			return new EndTile(id, type, property, imagePath);
			
		// In case is an Empty type.	
		case "empty":
			// Checking the property of the tile (none or free).
			switch (property) {
			// None case
			case "none":
				imagePath = "tiles/Empty-None.png";
				// Create an EmptyTile object ->  [EmptyTile(String id, String type, String property, String path)].
				return new EmptyTile(id, type, property, imagePath);
			// Free case	
			case "free":
				imagePath = "tiles/Empty-Free.png";
				// Create an EmptyFreeTile object -> [EmptyFreeTile(String id, String type, String property, String path)].
				return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
			// In case none of the other cases -> None.
			default:
				imagePath = "tiles/Empty-None.png";
				break;
			}
			// Create an EmptyFreeTile object -> [EmptyFreeTile(String id, String type, String property, String path)].
			return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
			
		// In case is a pipeTile.	
		case "pipe":
			// Checking the property of the tile (Vertical, Horizontal, 00, 01, 10, 11).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/Pipe-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/Pipe-Horizontal.png";
				break;
			// CurvedPipe Tile (open to the western north)
			case "00":
				imagePath = "tiles/Pipe-00.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern north)
			case "01":
				imagePath = "tiles/Pipe-01.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the western south)
			case "10":
				imagePath = "tiles/Pipe-10.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern south)
			case "11":
				imagePath = "tiles/Pipe-11.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// In case none of the other cases -> Vertical. 	
			default:
				imagePath = "tiles/Pipe-Vertical.png";
				break;
			}
			// Create a PipeTile object -> [PipeTile(String id, String type, String property, String path)]
			return new PipeTile(id, type, property, imagePath);
			
		// In case is a pipeStatic.	
		case "pipestatic":
			// Checking the property of the tile (Vertical, Horizontal, 00, 01, 10, 11).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/PipeStatic-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/PipeStatic-Horizontal.png";
				break;
			// CurvedPipe Tile (open to the western north)	
			case "00":
				imagePath = "tiles/PipeStatic-00.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern north)	
			case "01":
				imagePath = "tiles/PipeStatic-01.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the western south)
			case "10":
				imagePath = "tiles/PipeStatic-10.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern south)
			case "11":
				imagePath = "tiles/PipeStatic-11.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// In case none of the other cases -> Vertical.
			default:
				imagePath = "tiles/PipeStatic-Vertical.png";
				break;
			}
			// Create a PipeStatic object -> [PipeStatic(String id, String type, String property, String path)]
			return new PipeStatic(id, type, property, imagePath);

		// In case of none of the other cases -> EmptyFreeTile (Free Movable Tile)
		default:
			// Create an EmptyFreeTile -> [EmptyFreeTile(String id, String type, String property, String path)] 
			return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
		}
	}
	
	// The method Tile generateTilesFromTile() generates tiles -> create objects to change the reference of the old ones.
	public static Tile generateTilesFromTile(Tile tile) {
		String id = tile.getTileId();
		String type = tile.typeNormal;
		String property = tile.propertyNormal;
		String imagePath;

		// Types of the tiles -> images(id, type, property, image path)
		switch (type) {
		// In case tile is a Starter type.
		case "starter":
			// Checking the property of the tile (horizontal or vertical).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/Starter-Vertical.png";
				break;
			// Horizontal Case	
			case "horizontal":
				imagePath = "tiles/Starter-Horizontal.png";
				break;
			// In case none of other cases -> Vertical.
			default:
				imagePath = "tiles/Starter-Vertical.png";
				break;
			}
			// Create a StartTile object -> [StartTitle(String id, String type, String property, String path) constructor].
			return new StartTile(id, type, property, imagePath);
			
		// In case is a an End type.	
		case "end":
			// Checking the property of the tile (horizontal or vertical)
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/End-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/End-Horizontal.png";
				break;
			// In case none of the other cases -> Vertical.	
			default:	
				imagePath = "tiles/End-Vertical.png";
				break;
			}
			// Create an EndTile object -> [EndTile(String id, String type, String property, String path)].
			return new EndTile(id, type, property, imagePath);
			
		// In case is an Empty type.	
		case "empty":
			// Checking the property of the tile (none or free).
			switch (property) {
			// None case
			case "none":
				imagePath = "tiles/Empty-None.png";
				// Create an EmptyTile object ->  [EmptyTile(String id, String type, String property, String path)].
				return new EmptyTile(id, type, property, imagePath);
			// Free case	
			case "free":
				imagePath = "tiles/Empty-Free.png";
				// Create an EmptyFreeTile object -> [EmptyFreeTile(String id, String type, String property, String path)].
				return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
			// In case none of the other cases -> None.
			default:
				imagePath = "tiles/Empty-None.png";
				break;
			}
			// Create an EmptyFreeTile object -> [EmptyFreeTile(String id, String type, String property, String path)].
			return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
			
		// In case is a pipeTile.	
		case "pipe":
			// Checking the property of the tile (Vertical, Horizontal, 00, 01, 10, 11).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/Pipe-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/Pipe-Horizontal.png";
				break;
			// CurvedPipe Tile (open to the western north)
			case "00":
				imagePath = "tiles/Pipe-00.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern north)
			case "01":
				imagePath = "tiles/Pipe-01.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the western south)
			case "10":
				imagePath = "tiles/Pipe-10.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern south)
			case "11":
				imagePath = "tiles/Pipe-11.png";
				// Create a CurvedPipe object -> [CurvedPipe(String id, String type, String property, String path)]
				return new CurvedPipe(id, type, property, imagePath);
			// In case none of the other cases -> Vertical. 	
			default:
				imagePath = "tiles/Pipe-Vertical.png";
				break;
			}
			// Create a PipeTile object -> [PipeTile(String id, String type, String property, String path)]
			return new PipeTile(id, type, property, imagePath);
			
		// In case is a pipeStatic.	
		case "pipestatic":
			// Checking the property of the tile (Vertical, Horizontal, 00, 01, 10, 11).
			switch (property) {
			// Vertical case
			case "vertical":
				imagePath = "tiles/PipeStatic-Vertical.png";
				break;
			// Horizontal case
			case "horizontal":
				imagePath = "tiles/PipeStatic-Horizontal.png";
				break;
			// CurvedPipe Tile (open to the western north)	
			case "00":
				imagePath = "tiles/PipeStatic-00.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern north)	
			case "01":
				imagePath = "tiles/PipeStatic-01.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the western south)
			case "10":
				imagePath = "tiles/PipeStatic-10.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// CurvedPipe Tile (open to the eastern south)
			case "11":
				imagePath = "tiles/PipeStatic-11.png";
				// Create a CurvedPipeStatic object -> [CurvedPipeStatic(String id, String type, String property, String path)]
				return new CurvedPipeStatic(id, type, property, imagePath);
			// In case none of the other cases -> Vertical.
			default:
				imagePath = "tiles/PipeStatic-Vertical.png";
				break;
			}
			// Create a PipeStatic object -> [PipeStatic(String id, String type, String property, String path)]
			return new PipeStatic(id, type, property, imagePath);

		// In case of none of the other cases -> EmptyFreeTile (Free Movable Tile)
		default:
			// Create an EmptyFreeTile -> [EmptyFreeTile(String id, String type, String property, String path)] 
			return new EmptyFreeTile(id, type, property, "tiles/Empty-Free.png");
		}			
	}
}
//--------------------------------------------------------------------------------------------------//