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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**---------------------------------------------------------------------------------------------------**/
//This Class is a subclass of the Pane Class.
public class OpenPageTitle extends Pane {
	/** Data Fields **/
    private Text text;
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
    /**
     * getLayoutBounds(): Get the value of the property layoutBounds.
     * The rectangular bounds that should be used for layout calculations for this node. 
     * layoutBounds may differ from the visual bounds of the node and is computed differently depending on the node type.
     **/
	//The OpenPageTitle() method -> set the title of the open page properties + fonts.
    public OpenPageTitle(String name) {        
    	String spread = "";   
    	// Create a string -> store the open title.
    	for (char c : name.toCharArray()) {
            spread += c + " ";
        }
    	// Use the text object.
        text = new Text(spread);
        // Set the text node font -> Sets the value of the property font using an input source (fonts file).
        text.setFont(Font.loadFont(Main.class.getResource("Fonts.ttf").toExternalForm(), 48));
        // Set fill -> white.
        text.setFill(Color.WHITE);
        
        text.setEffect(new DropShadow(30, Color.BLACK));    
        // Adding the nodes to the scene -> Display
        getChildren().addAll(text);
    }
    
    // The getTitleWidth() -> get the width of the layout bounds.
    public double getTitleWidth() {
    	// The width of this Bounds.
        return text.getLayoutBounds().getWidth();
    }
    
    // The getTitleHeight() -> get the height of the layout bounds.
    public double getTitleHeight() {
    	// The height of this Bounds.
        return text.getLayoutBounds().getHeight();
    }
}
//--------------------------------------------------------------------------------------------------//