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
import application.Abstract.Tile;
/**---------------------------------------------------------------------------------------------------**/
//This Class is a subclass of Title Class and implements the interface Movable.
public class EmptyTile extends Tile implements Movable {
	/** Constructors **/
	public EmptyTile(String id, String type, String property, String path) {
		super(id, type, property, path);
	}
	public EmptyTile(EmptyTile tile) {
		super(tile);
	}
}
//--------------------------------------------------------------------------------------------------//