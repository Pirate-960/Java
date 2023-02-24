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
import application.Abstract.Pipe;
import application.Abstract.Tile;
import javafx.scene.shape.LineTo;
/**---------------------------------------------------------------------------------------------------**/
// This Class is a subclass of the Pipe Class.
public class EndTile extends Pipe {
	/** Constructors **/
	public EndTile(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The findTileInTwoDim() method -> the position of the selected tile(Point).
	public int[] findTileInTwoDim(Tile[][] list, Tile tile) {
		// Position of the object(tile) -> point.
		int[] positions = new int[2];

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
	
	// The addPath() method -> add new path after the tile + Check the surrounding tiles (Horizontally + Vertically).
	public void addPath() {
		// Obtain pixel coordinates (x, y). 
		int thisX = Repository.findXYCoordinate(this)[0];
		int thisY = Repository.findXYCoordinate(this)[1];
		
		// Determining the type of the End Pipe Tile (horizontal or vertical).
		switch (this.getPropertiesFromTile()) {
		// Horizontal End Tile.
		case HORIZONTAL:
			// Add the tile to the path list + add a line using (x, y) coordinates.
			Repository.path.getElements().add(new LineTo(thisX, thisY));
			break;
			
		// Vertical End Tile.
		case VERTICAL:
			// Add the tile to the path list + add a line using (x, y) coordinates.
			Repository.path.getElements().add(new LineTo(thisX, thisY));
			break;
			
		// None of the other cases -> terminate the type check for the end tile. 
		default:
			break;
		}
	}
	
	// The isContinue() method 
	@Override
	public boolean isContinue(Tile[][] twoDim, Tile previousTile) {
		// Add this to the pipe Path.
		Repository.pipeList.add(this);
		// Apply the addPath() method.
		addPath();
		
		// Obtain normal coordinates(x, y).
		int x = findTileInTwoDim(twoDim, this)[0];
		int y = findTileInTwoDim(twoDim, this)[1];
		
		// Determining the type of the End Pipe Tile (horizontal or vertical).
		switch (this.getPropertiesFromTile()) {
		// Horizontal End Tile.
		case HORIZONTAL:
			// Check the type + place of the tile to the left.
			if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
				// Check the type of the second tile.
				if (previousTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE
						|| previousTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
						|| previousTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
					return true;
				}
			}
			return false;
			
		// Vertical End Tile.
		case VERTICAL:
			// Check the type + place of the tile down.
			if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
				// Check the type of the second tile.
				if (previousTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
						|| previousTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
						|| previousTile.getPropertiesFromTile() == Properties.VERTICAL) {
					return true;
				}
			}
			return false;
			
		default:
			return false;
		}
	}
}
//--------------------------------------------------------------------------------------------------//