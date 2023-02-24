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
/** Import Libraries used in the Class */
import application.Properties;
import application.Types;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**---------------------------------------------------------------------------------------------------**/
abstract public class Tile extends ImageView {
	/** Data Fields **/ 
	private String id;
	public String typeNormal;
	public String propertyNormal;
	private Types type;
	private Properties property;
	public String path;
	private Image image;
	//--------------------------------------------------------------------------------------------------//
	/** Constructors **/
	// Obtain tile information + add it to the path
	public Tile(Tile tile) {
		this(tile.getTileId(), tile.typeNormal, tile.propertyNormal, tile.path);
		this.propertyNormal = tile.propertyNormal;
		this.typeNormal = tile.typeNormal;
		// Tile Id.
		setTileId(id);
		// Tile Type.
		setTypes(tile.typeNormal);
		// Tile property.
		setProperties(tile.propertyNormal);		
		setImage(path);
		super.setImage(getImageFromVisual());
		super.setFitHeight(100);
		super.setFitWidth(100);
		// Check free tiles.
		if (getPropertiesFromTile() == Properties.FREE) {
			super.setOpacity(0);
			System.out.println(id);
		}
	}
	//  Obtain tile information + add it to the path
	public Tile(String id, String type, String property, String path) {
		super();
		this.path = path;
		this.propertyNormal = property;
		this.typeNormal = type;
		// Tile Id.
		setTileId(id);
		// Tile Type.
		setTypes(type);
		// Tile property.
		setProperties(property);
		setImage(path);
		super.setImage(getImageFromVisual());
		super.setFitHeight(100);
		super.setFitWidth(100);
		// Check free tiles.
		if (getPropertiesFromTile() == Properties.FREE) {
			super.setOpacity(0);
			System.out.println(id);
		}
	}
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The equals() method -> check the objects of the tiles.
	@Override
	public boolean equals(Object obj) {
		if (this.getTileId() == ((Tile) obj).getTileId()) {
			return true;
		}
		return false;
	}
	
	// The getImageFromVisual() method -> Getter method of image of the tile.
	public Image getImageFromVisual() {
		return image;
	}
	
	// The setImage() method -> Setter method of image the of the tile.
	public void setImage(String path) {
		Image image2 = new Image(getClass().getResource(path).toExternalForm());
		image = image2;
	}
	
	// The getTileId() method -> Getter method of id of the tile.
	public String getTileId() {
		return id;
	}
	
	// The setTileId() method -> Setter method of id the of the tile.
 	public void setTileId(String id) {
		this.id = id;
	}
	
	// The getTypes() method -> Setter method of type of the tile.
	public Types getTypes() {
		return type;
	}
	
	// The setTypes() method -> Setter method of type of the tile.
	public void setTypes(String type) {
		// All types of the tiles -> can be read from the input files.
		if (type.toLowerCase().equals("starter")) {
			this.type = Types.STARTER;
		} else if (type.toLowerCase().equals("end")) {
			this.type = Types.END;
		} else if (type.toLowerCase().equals("empty")) {
			this.type = Types.EMPTY;
		} else if (type.toLowerCase().equals("pipe")) {
			this.type = Types.PIPE;
		} else if (type.toLowerCase().equals("pipestatic")) {
			this.type = Types.PIPESTATIC;
		} else {
			this.type = Types.EMPTY;
		}
	}
	
	// The goToRight() method -> move the tile to the right.
	public void goToRight() {
		// Create a TranslateTransition object to apply motion (movement) of the tile.
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(this);
		translate.setByX(100);
		translate.play();
	}
	
	// The goToLeft() method -> move the tile to the left.
	public void goToLeft() {
		// Create a TranslateTransition object to apply motion (movement) of the tile.
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(this);
		translate.setByX(-100);
		translate.play();
	}
	
	// The goToUp() method -> move the tile up.
	public void goToUp() {
		// Create a TranslateTransition object to apply motion (movement) of the tile.
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(this);
		translate.setByY(-100);
		translate.play();
	}
	
	// The goToDown() method -> move the tile down.
	public void goToDown() {
		// Create a TranslateTransition object to apply motion (movement) of the tile.
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(this);
		translate.setByY(+100);
		translate.play();
	}
	
	// The getPropertiesFromTile() method -> Getter method of property of the tile.
	public Properties getPropertiesFromTile() {
		return property;
	}
	
	// The getPropertiesFromTile() method -> Setter method of property of the tile.
	public void setProperties(String property) {
		// All properties of the tiles -> can be read from the input files.
		if (property.toLowerCase().equals("vertical")) {
			this.property = Properties.VERTICAL;
		} else if (property.toLowerCase().equals("horizontal")) {
			this.property = Properties.HORIZONTAL;
		} else if (property.toLowerCase().equals("none")) {
			this.property = Properties.NONE;
		} else if (property.toLowerCase().equals("free")) {
			this.property = Properties.FREE;
		} else if (property.toLowerCase().equals("00")) {
			this.property = Properties.CURVED_ZERO_ZERO;
		} else if (property.toLowerCase().equals("01")) {
			this.property = Properties.CURVED_ZERO_ONE;
		} else if (property.toLowerCase().equals("10")) {
			this.property = Properties.CURVED_ONE_ZERO;
		} else if (property.toLowerCase().equals("11")) {
			this.property = Properties.CURVED_ONE_ONE;
		} else {
			this.property = Properties.NONE;
		}
	}
}	
//--------------------------------------------------------------------------------------------------//