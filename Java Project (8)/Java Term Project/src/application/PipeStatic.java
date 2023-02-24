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
public class PipeStatic extends Pipe {
	/** Constructors **/
	public PipeStatic(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	/**LineTo: Create a new instance of LineTo.
	 * Parameters:
	 * x the horizontal coordinate of the line end point.
	 * y the vertical coordinate of the line end point.
	 **/
	// The addPath() method creates the path by adding new path elements (Movable or non-Movable pipe tiles).
	public void addPath() {	
		// Obtain pixel coordinates (x, y).
		int thisX = Repository.findXYCoordinate(this)[0]; // X
		int thisY = Repository.findXYCoordinate(this)[1]; // Y
		
		// Obtain the previous tile.
		Tile tile = Repository.pipeList.get(Repository.pipeList.indexOf(this) - 1);
		// Obtain pixel coordinates (x, y).
		int previousX = Repository.findXYCoordinate(tile)[0]; // X
		int previousY = Repository.findXYCoordinate(tile)[1]; // Y
		
		// Determining the type of the Curved Pipe Tile (Horizontal or Vertical).
		switch (this.getPropertiesFromTile()) {
		// Horizontal case
		case HORIZONTAL:
			if (thisX > previousX) {
				// Move tile to the right + Create a new instance of LineTo + add it to the path.
				Repository.path.getElements().add(new LineTo(thisX + 50, thisY));
			} else {
				// Move tile to the left + Create a new instance of LineTo + add it to the path.
				Repository.path.getElements().add(new LineTo(thisX - 50, thisY));
			}
			break;
			
		// Vertical case
		case VERTICAL:
			if (thisY > previousY) {
				// Move tile down + Create a new instance of LineTo + add it to the path.
				Repository.path.getElements().add(new LineTo(thisX, thisY + 50));
			} else {
				// Move tile up + Create a new instance of LineTo + add it to the path.
				Repository.path.getElements().add(new LineTo(thisX, thisY - 50));
			}
			break;
			
		// In case none of the other cases -> Terminate the type check for the pipe tile.	
		default:
			break;
		}
	}
	
	// The isContinue() method -> add new pipe path for the ball on the game board + Check the surrounding tiles (Horizontally + Vertically).
	@Override
	public boolean isContinue(Tile[][] twoDim, Tile previousTile) {
		// Add this to the pipe Path.
		Repository.pipeList.add(this);
		// Apply the addPath() method.
		addPath();
		
		// Obtain normal coordinates(x, y).
		int x = findTileInTwoDim(twoDim, this)[0]; // X
		int y = findTileInTwoDim(twoDim, this)[1]; // Y
		
		// Determining the type of the Curved Pipe Tile (Horizontal or vertical).
		switch (this.getPropertiesFromTile()) {
		// Horizontal case
		case HORIZONTAL:
			if (x == 0) {
				// Check the type + place of the tile to the right.
				if (Pipe.class.isAssignableFrom(twoDim[y][x + 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x + 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			}
			if (x == 3) {
				// Check the type + place of the tile to the left.
				if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x - 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE
							|| secondTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			} else {
				// Check the type + place of the tile to the left.
				if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x - 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE
							|| secondTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				// Check the type + place of the tile to the right.
				if (Pipe.class.isAssignableFrom(twoDim[y][x + 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x + 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			}
		
		// Vertical case
		case VERTICAL:
			if (y == 0) {
				// Check the type + place of the tile down.
				if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y + 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.VERTICAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			}
			if (y == 3) {
				// Check the type + place of the tile up.
				if (Pipe.class.isAssignableFrom(twoDim[y - 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y - 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE
							|| secondTile.getPropertiesFromTile() == Properties.VERTICAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			} else {
				// Check the type + place of the tile down.
				if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y + 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.VERTICAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				// Check the type + place of the tile up.
				if (Pipe.class.isAssignableFrom(twoDim[y - 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y - 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE
							|| secondTile.getPropertiesFromTile() == Properties.VERTICAL) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
				return false;
			}
			
		// In none of the other cases -> terminate the type check for the pipe tile.
		default:
			return false;
		}
	}
	
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
}
//--------------------------------------------------------------------------------------------------//