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
import application.Abstract.Movable;
import application.Abstract.Pipe;
import application.Abstract.Tile;
import javafx.scene.shape.CubicCurveTo;
/**---------------------------------------------------------------------------------------------------**/
// This Class is a subclass of the Pipe Class and implements the interface Movable.
public class CurvedPipe extends Pipe implements Movable {
	/** Constructors **/
	public CurvedPipe(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The addPath() method creates the path by adding new path elements (Movable Curved tiles).
	/**CubicCurveTo: Creates a curved path element, defined by three new points,by drawing a Cubic Bézier curve that intersects both the current coordinates and the specified coordinates (x,y). 
	 * using the specified points (controlX1,controlY1) and (controlX2,controlY2) as Bézier control points. 
	 * All coordinates are specified in double precision. 
	**/
	@Override
	public void addPath() {
		// Obtain pixel coordinates (x, y).
		int thisX = Repository.findXYCoordinate(this)[0]; // X
		int thisY = Repository.findXYCoordinate(this)[1]; // Y
		
		// Previous Tile.
		Tile tile;
		// Previous tile coordinates.
		int previousX; // X
		int previousY; // Y
		
		// Determining the type of the Curved Pipe Tile (00, 01, 10, 11).
		switch (this.getPropertiesFromTile()) {
		
		// Case (1): The curved Tile (00) -> Curve is opened to the upper left direction (Western North).
		case CURVED_ZERO_ZERO:
			// Obtain the previous tile in the list.
			tile = Repository.pipeList.get(Repository.pipeList.indexOf(this) - 1); // The tile before in the list.
			// Previous (x, y) coordinates of the previous tile in the pipelist of the repository class.
			previousX = Repository.findXYCoordinate(tile)[0];
			previousY = Repository.findXYCoordinate(tile)[1];
			if (thisX > previousX) {// GO TO right up
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX - 50, thisY, thisX, thisY, thisX, thisY - 50);
				Repository.path.getElements().add(curve);
			} else {
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX, thisY - 50, thisX, thisY, thisX - 50, thisY);
				Repository.path.getElements().add(curve);
			}
			break;
		
		// Case (2): The curved Tile (01) -> Curve is opened to the upper right direction (Eastern North).
		case CURVED_ZERO_ONE:
			// Obtain the previous tile in the list.
			tile = Repository.pipeList.get(Repository.pipeList.indexOf(this) - 1); // The tile before in the list
			// Previous (x, y) coordinates of the previous tile in the pipelist of the repository class.
			previousX = Repository.findXYCoordinate(tile)[0];
			previousY = Repository.findXYCoordinate(tile)[1];
			if (thisY > previousY) {// GO TO down
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX, thisY - 50, thisX, thisY, thisX + 50, thisY);
				Repository.path.getElements().add(curve);
			} else {// GO TO LEFT
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX + 50, thisY, thisX, thisY, thisX, thisY - 50);
				Repository.path.getElements().add(curve);
			}
			break;
		
		// Case (3): The curved Tile (10) -> Curve is opened to the bottom left direction (Western South).
		case CURVED_ONE_ZERO:
			// Obtain the previous tile in the list.
			tile = Repository.pipeList.get(Repository.pipeList.indexOf(this) - 1); // The tile before in the list
			// Previous (x, y) coordinates of the previous tile in the pipelist of the repository class.
			previousX = Repository.findXYCoordinate(tile)[0];
			previousY = Repository.findXYCoordinate(tile)[1];
			if (thisX > previousX) {
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX - 50, thisY, thisX, thisY, thisX, thisY + 50);
				Repository.path.getElements().add(curve);
			} else {
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX, thisY + 50, thisX, thisY, thisX - 50, thisY);
				Repository.path.getElements().add(curve);
			}
			break;
			
		// Case (4): The curved Tile (11) -> Curve is opened to the bottom right direction (Eastern South).
		case CURVED_ONE_ONE:
			// Obtain the previous tile in the list.
			tile = Repository.pipeList.get(Repository.pipeList.indexOf(this) - 1); // The tile before in the list
			// Previous (x, y) coordinates of the previous tile in the pipelist of the repository class.
			previousX = Repository.findXYCoordinate(tile)[0];
			previousY = Repository.findXYCoordinate(tile)[1];
			if (thisY > previousY) {
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX, thisY + 50, thisX, thisY, thisX + 50, thisY);
				Repository.path.getElements().add(curve);
			} else {
				// Create a curved path element + add it to the path.
				CubicCurveTo curve = new CubicCurveTo(thisX + 50, thisY, thisX, thisY, thisX, thisY + 50);
				Repository.path.getElements().add(curve);
			}
			break;
			
		// Case (5): None of the other cases -> Terminate the type check for the curved tiles.
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
		int x = findTileInTwoDim(twoDim, this)[0];
		int y = findTileInTwoDim(twoDim, this)[1];
		
		// Determining the type of the Curved Pipe Tile (00, 01, 10, 11). 
		switch (this.getPropertiesFromTile()) {
		// Case (1): The curved Tile (00) -> Curve is opened to the upper left direction (Western North).
		case CURVED_ZERO_ZERO:
			if (x > 0) {
				// Check the type + place of the tile to the left.
				if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x - 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.HORIZONTAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			if (y > 0) {
				// Check the type + place of the tile up.
				if (Pipe.class.isAssignableFrom(twoDim[y - 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y - 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.VERTICAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			return false;
		
		// Case (2): The curved Tile (01) -> Curve is opened to the upper right direction (Eastern North).	
		case CURVED_ZERO_ONE:
			if (x < 3) {
				// Check the type + place of the tile to the right.
				if (Pipe.class.isAssignableFrom(twoDim[y][x + 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x + 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.HORIZONTAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			if (y > 0) {
				// Check the type + place of the tile up.
				if (Pipe.class.isAssignableFrom(twoDim[y - 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y - 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.VERTICAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			return false;
			
		// Case (3): The curved Tile (10) -> Curve is opened to the bottom left direction (Western South).
		case CURVED_ONE_ZERO:
			if (x > 0) {
				// Check the type + place of the tile to the left.
				if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x - 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.HORIZONTAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			if (y < 3) {
				// Check the type + place of the tile down.
				if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y + 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.VERTICAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			return false;

		// Case (4): The curved Tile (11) -> Curve is opened to the bottom right direction (Eastern South).
		case CURVED_ONE_ONE:
			if (x < 3) {
				// Check the type + place of the tile to the right.
				if (Pipe.class.isAssignableFrom(twoDim[y][x + 1].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y][x + 1];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.HORIZONTAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			if (y < 3) {
				// Check the type + place of the tile down.
				if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
					Pipe secondTile = (Pipe) twoDim[y + 1][x];
					// Check the type of the second tile.
					if (secondTile.getPropertiesFromTile() == Properties.VERTICAL
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
							|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE) {
						if (!secondTile.getTileId().equals(previousTile.getTileId())) {
							return secondTile.isContinue(twoDim, this);
						}
					}
				}
			}
			return false;
			
		// Case (5): None of the other cases -> Terminate the type check.
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