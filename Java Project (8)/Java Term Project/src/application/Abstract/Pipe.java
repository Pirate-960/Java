package application.Abstract;
/**---------------------------------------------------------------------------------------------------**/
/** Contributers */
// Student Number (1)
// Student Name: Furkan Acar.
// Student Number: 150121534
// Student Number (2)
// Student Name: Abdelrahman Ahmed Nabil Zahran.
// Student Number: 150120998
/**---------------------------------------------------------------------------------------------------**/
// This Class is a subclass of the Tile Class.
abstract public class Pipe extends Tile {
	/** Constructors **/
	public Pipe(Pipe pipe) {
		super(pipe);
	}
	public Pipe(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	//--------------------------------------------------------------------------------------------------//
	/** Abstract Methods **/
	// addPath() method -> create path + pipes.
	abstract public void addPath();
	// isContinue -> check the next tile -> create pipe path.
	abstract public boolean isContinue(Tile[][] twoDim, Tile previousTile);
}
//--------------------------------------------------------------------------------------------------//