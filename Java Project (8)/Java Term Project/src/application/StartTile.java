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
import javafx.scene.shape.MoveTo;
/**---------------------------------------------------------------------------------------------------**/
// This Class is a subclass of the Pipe Class.
public class StartTile extends Pipe {
	/** Constructors **/
	public StartTile(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	public StartTile(StartTile tile) {
		super(tile);
	}
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The addPath() method -> add new path after the tile + Check the surrounding tiles (Horizontally + Vertically).
	public void addPath() {
		// Obtain pixel coordinates (x, y). 
		int thisX = Repository.findXYCoordinate(this)[0]; // X
		int thisY = Repository.findXYCoordinate(this)[1]; // Y
		// Create a new instance of MoveTo + add it the getElements() method of the path ArrayList.
		Repository.path.getElements().add(new MoveTo(thisX, thisY));
		
		// Determining the type of the Curved Pipe Tile (Horizontal or Vertical). 
		switch (this.getPropertiesFromTile()) {
		// Horizontal case
		case HORIZONTAL:
			// Create a new instance of LineTo + add it the getElements() method of the path ArrayList.
			Repository.path.getElements().add(new LineTo(thisX - 50, thisY));
			break;
		// Vertical case	
		case VERTICAL:
			// Create a new instance of LineTo + add it the getElements() method of the path ArrayList.
			Repository.path.getElements().add(new LineTo(thisX, thisY + 50));
			break;
			// In case none of the other cases -> Terminate the type check for the start tile.
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
		
		// Obtain normal coordinates (x, y)
		int x = Repository.findTileInTwoDim(twoDim, this)[0]; // X
		int y = Repository.findTileInTwoDim(twoDim, this)[1]; // Y
		
		// Determining the type of the Starter  Pipe Tile (Horizontal or Vertical).
		switch (this.getPropertiesFromTile()) {
		// Horizontal case
		case HORIZONTAL:
			// Check the type + place of the tile to the left.
			if (Pipe.class.isAssignableFrom(twoDim[y][x - 1].getClass())) {
				Pipe secondTile = (Pipe) twoDim[y][x - 1];
				// Check the type of the second tile.
				if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
						|| secondTile.getPropertiesFromTile() == Properties.CURVED_ONE_ZERO
						|| secondTile.getPropertiesFromTile() == Properties.HORIZONTAL) {
					return secondTile.isContinue(twoDim, this);
				} else {
					return false;
				}
			}
			return false;
			
		// Vertical case
		case VERTICAL:
			// Check the type + place of the tile down.
			if (Pipe.class.isAssignableFrom(twoDim[y + 1][x].getClass())) {
				Pipe secondTile = (Pipe) twoDim[y + 1][x];
				// Check the type of the second tile.
				if (secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ONE
						|| secondTile.getPropertiesFromTile() == Properties.CURVED_ZERO_ZERO
						|| secondTile.getPropertiesFromTile() == Properties.VERTICAL) {
					return secondTile.isContinue(twoDim, this);
				} else {
					return false;
				}
			}
			return false;
			
		// In case none of the other cases -> false.
		default:
			return false;
		}
	}
}
//--------------------------------------------------------------------------------------------------//