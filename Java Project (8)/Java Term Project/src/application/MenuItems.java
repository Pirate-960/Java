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
import javafx.beans.binding.Bindings;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**---------------------------------------------------------------------------------------------------**/
//This Class is a subclass of the Pane Class.
public class MenuItems extends Pane {
	/** Data Fields **/
    private Text text;
    private Effect shadow = new DropShadow(5, Color.BLACK);
    private Effect blur = new BoxBlur(1, 1, 3);
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
    /**
     * hoverProperty(): Whether or not this Node is being hovered over. Typically this is due to the mouse being over the node
     * though it could be due to a pen hovering on a graphics tablet or other form of input. 
     */
	// The MenuItems() method -> Create the items of the menu + modifying them and applying requested fonts + colors + Effects.
    public MenuItems(String name) {
    	// Create a Polygon Shape
        Polygon ItemBoxShape = new Polygon(
                0, 0,
                200, 0,
                215, 15,
                200, 30,
                0, 30
        );
        // Set color fonts.
        ItemBoxShape.setStroke(Color.color(1, 1, 1, 0.75));
        // Set effect -> GaussianBlur(): Create a new instance of GaussianBlur with default parameters.
        ItemBoxShape.setEffect(new GaussianBlur());
        // Set the fill part of the buttons (items) of the menu.
        ItemBoxShape.fillProperty().bind(Bindings.when(pressedProperty()).then(Color.color(0, 0, 0, 0.75)).otherwise(Color.color(0, 0, 0, 0.25)));
        
        // Use the text object.
        text = new Text(name);
        // Set the value of the property translateX -> Sets the value of the property translateX..
        text.setTranslateX(5);
        // Set the value of the property translateY -> Defines the y coordinate of the translation that is added to this Node'stransform. 
        text.setTranslateY(20);
        // Set the text node font -> Sets the value of the property font using an input source (fonts file).
        text.setFont(Font.loadFont(Main.class.getResource("Fonts.ttf").toExternalForm(), 14));
        // Set fill -> white.
        text.setFill(Color.WHITE);
        
        // When there is no mouse or any mouse action taken on the item it is Blurred -> effect is active
        text.effectProperty().bind(Bindings.when(hoverProperty()).then(shadow).otherwise(blur));
        // Adding the nodes to the scene -> Display
        getChildren().addAll(ItemBoxShape, text);
    }
    
    // The setOnAction() -> create a mouse event (action) -> mouse actions are applicable.
    public void setOnAction(Runnable action) {
        setOnMouseClicked(e -> action.run());
    }
}
//--------------------------------------------------------------------------------------------------//