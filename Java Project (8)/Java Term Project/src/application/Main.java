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
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.util.List;

import application.Abstract.Movable;
import application.Abstract.Tile;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
/**---------------------------------------------------------------------------------------------------**/
// This Class is a subclass of the Application Class.
public class Main extends Application {// ADDPATH İ PİPE IN İÇNE KOY
	/** Data Fields **/
	public Tile objectForMove = null;
	public PathTransition pathTransition = new PathTransition(); // Property for ball animation.
	public final int duration = 1250; // time for ball animation.
 	public int numberMovement = 0;
	public boolean isCompleted = false;
	public Stage primaryStageGlobal;
	private static final int WIDTH = 1280;   
	private static final int HEIGHT = 720;   
	private Pane root = new Pane();
	private VBox menuBox = new VBox(-5);  
	private Line line;
	// The List<Pair<String, Runnable>> -> Create the list event -> buttons <<Buttons>>.
    private List<Pair<String, Runnable>> menuData = Arrays.asList(
            new Pair<String, Runnable>("Play Game", () -> {generateGameBoard(primaryStageGlobal);}),
            new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
    );
	//--------------------------------------------------------------------------------------------------//
	/** Methods **/
	// The generateGameBoard() -> Create the the game board by generating the tiles on the screen(Stage) + 2 Horizontal Boxes for 1 -> (Level Name + Number of Movements) 2 -> (next level + previous Button).
	public void generateGameBoard(Stage primaryStage) {
		numberMovement = 0;
		Label levelName = new Label("Level " + ( Repository.currentLevel +1) +"\nNumber of Moves: " + numberMovement);
		isCompleted = false;
		
		// RunAgain() -> Clear all lists when the current level is completed to update the next level.
		Repository.runAgain();
		// Create an ArrayList of the tiles.
		ArrayList<Tile> tileList = Repository.tileList;
		ArrayList<Tile> tileListCopy = new ArrayList<Tile>();
		Tile[][] twoDim = Repository.twoDim;
		// Create Button (Next Level)
		Button nextLevel = new Button("Next Level");
		
		Helper.readFromFile(tileList);
		
		// Display Event of the copy tile list using helper class.
		tileList.forEach((e) -> {
			tileListCopy.add(Helper.generateTilesFromTile(e));
		});
		
		int count = 0;
		try {
			// Create a Grid PAne to display a 2D Array to display a game board of 16 tiles (4x4).
			GridPane gridPane = new GridPane();
			// Displaying the tiles of the game board in a 2D array [4][4].
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					// Tiles in the 2D Array + Add them to the Grid Pane.
					twoDim[i][j] = (tileList.get(count));
					gridPane.add((tileList.get(count)), j, i);
					count++;
				}
			}
			// Display the tiles area -> applicable for the mouse event.
			for (int i = 0; i < twoDim.length; i++) {
				for (int j = 0; j < twoDim[i].length; j++) {
					// The area of the mouse Event.
					Tile tile = twoDim[i][j];
					// The hold event of the tiles by the mouse.
					tile.setOnMouseReleased((event) -> {
						objectForMove = tile;
					});
					// The access of the mouse to the screen.
					tile.setOnMouseEntered((event) -> {
						moveTiles(tileList, twoDim, tile, levelName);
						// Moving to the next Level when the current level is completed.
						nextLevel.setDisable((Helper.contents.length - 1 == Repository.currentLevel || !(isCompleted)));
					});
				}
			}
			
			// Create a Horizontal Box -> Level Name + Number of movements.
			HBox hBox = new HBox(20);
			// Horizontal Box Style (BCKGROUND -> Gold).
			hBox.setStyle("-fx-background-color: gold");
			// Distance (Top, right, Bottom, left).
			hBox.setPadding(new Insets(50, 50, 50, 150));
			// Add Level Name + number of movements -> Horizontal Box.
			hBox.getChildren().add(levelName);
			
			// Level Name fonts (Text font, weight, posture) + (color).
			levelName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30));
			levelName.setTextFill(Color.BLUE);
			
			// Next Level Button: Style (BCKGROUND -> Gold).
			nextLevel.setStyle("-fx-border-color: blue");
			
			// Set mouse click for the next level Button.
			nextLevel.setOnMouseClicked(e->{
				// Increase the level.
				Repository.incrementLevel();
				// Display the Game Board.
				generateGameBoard(primaryStage);
			});
			// Disable the next level Button until the level is number 1(Level 1) in the list or is completed.
			nextLevel.setDisable((Helper.contents.length - 1 == Repository.currentLevel || !(isCompleted)));
			
			// Create Button (Previous Level)
			Button previousLevel = new Button("Prevoius Level");
			// Previous Level Button: Style (BORDER -> blue).
			previousLevel.setStyle("-fx-border-color: blue");
			
			//
			previousLevel.setOnMouseClicked(e->{
				// Decrease the level.
				Repository.decrementLevel();
				// Display the Game Board.
				generateGameBoard(primaryStage);
			}); 				
			// Disable the previous Button when the level is 0 (Level 0). 
			previousLevel.setDisable(Repository.currentLevel == 0);
			
			// Create a Horizontal Box -> 2 Buttons (next Level, Previous Level)
			HBox hBox2 = new HBox(20);
			// Horizontal Box Style (BCKGROUND -> Gold).
			hBox2.setStyle("-fx-background-color: gold");
			// Distance (Top, right, Bottom, left).
			hBox2.setPadding(new Insets(50, 50, 50, 100));
			// Add 2 Button (next Level, previous Level) -> Horizontal Box.
			hBox2.getChildren().addAll(nextLevel, previousLevel);
			
			// Create a Basic Pane display all contents of the screen.
			BorderPane basicPane = new BorderPane();
			
			// Top part of the Border Pane -> Basic Pane (a Grid Pane used to create the game board)
			basicPane.setTop(gridPane);
			
			// Center Part of the Border Pane -> Basic Pane (Level Name + Number of Movements)
			basicPane.setCenter(levelName);
			
			// Bottom Part of the Border Pane ->  Basic Pane (2 Buttons: Next Level, Previous Level)
			basicPane.setBottom(hBox2);
			
			// Bottom Part of the Border Pane ->  Basic Pane (create Ball animation)
			basicPane.getChildren().add(createBall());
			
			// Setting a the pane as a Background.
			setBackgroundImage(basicPane);
			
			// Displaying the primary Stage - Pane -> in the scene of the stage.
			setScene(primaryStage, basicPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// The Start() method -> display the stage on the screen for the user.
	@Override
	public void start(Stage primaryStage) {
		// Display the open Page.
		Scene scene = new Scene(createContent());
		
		// Set Title for the program. 
		primaryStage.setTitle("Puzzle");
		// Display scene of the stage.
		primaryStage.setScene(scene);	
		// Set a stable (constant) size.
		primaryStage.setResizable(false);
		// Show the stage on the screen.
		primaryStage.show();    
		primaryStageGlobal = primaryStage;
	}
	
	// The setScene() 
	private void setScene(Stage primaryStage, BorderPane root) {
		// Create a Scene object -> scene on the stage to -> display Pane + External form.
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		// Set Title for the program.
		primaryStage.setTitle("Puzzle");
		// Display scene of the stage.
		primaryStage.setScene(scene);
		// Set a stable (constant) size.
		primaryStage.setResizable(false);
		// Show the stage on the screen.
		primaryStage.show();
	}
	
	// The moveTiles() method -> Movement of the tiles of the Game Board.
	private void moveTiles(ArrayList<Tile> tileList, Tile[][] twoDim, Tile tile, Label levelName) {
		// Coordinates of the target Tile (x, y).
		int xOfTarget = Repository.findTileInTwoDim(twoDim, tile)[0]; // X
		int yOfTarget = Repository.findTileInTwoDim(twoDim, tile)[1]; // Y
		
		// Check if there is a tile object is created and held by the mouse event + the level not completed yet..
		if (objectForMove != null && !isCompleted) {
			// Obtain Origin point coordinates.
			int xOfOrigin = Repository.findTileInTwoDim(twoDim, objectForMove)[0]; // X
			int yOfOrigin = Repository.findTileInTwoDim(twoDim, objectForMove)[1]; // Y
			
			//
			if (((Movable.class.isAssignableFrom(tile.getClass()))
					&& (Movable.class.isAssignableFrom(objectForMove.getClass())))
					&& EmptyFreeTile.class.isAssignableFrom(tile.getClass())
					&& (!(Math.abs(xOfTarget - xOfOrigin) == 1 && Math.abs(yOfTarget - yOfOrigin) == 1))
					&& (!((Math.abs(xOfTarget - xOfOrigin) > 1) || (Math.abs(yOfTarget - yOfOrigin) > 1)))) {
				// Display the Level number + the Number of the moves.
				System.out.println(++numberMovement);
				levelName.setText("Level " + ( Repository.currentLevel +1) +"\nNumber of Moves: " + numberMovement);
				// Move the tile to the right -> (Exchange place with the other tile placed in its new position(Targeted position of the movement)).
				if (xOfTarget > xOfOrigin) {
					objectForMove.goToRight();
					tile.goToLeft();
					changePositionOfTwoObjectInList(twoDim, objectForMove, tile);
					// Move tile to the left -> (Exchange place with the other tile placed in its new position(Targeted position of the movement)).  
				} else if (xOfTarget < xOfOrigin) {
					tile.goToRight();
					objectForMove.goToLeft();
					changePositionOfTwoObjectInList(twoDim, objectForMove, tile);
				}
				// Move Tile up -> (Exchange place with the other tile placed in its new position(Targeted position of the movement)).
				if (yOfTarget < yOfOrigin) {
					objectForMove.goToUp();
					tile.goToDown();
					changePositionOfTwoObjectInList(twoDim, objectForMove, tile);
					// Move tile down -> (Exchange place with the other tile placed in its new position(Targeted position of the movement)).
				} else if (yOfTarget > yOfOrigin) {
					tile.goToUp();
					objectForMove.goToDown();
					changePositionOfTwoObjectInList(twoDim, objectForMove, tile);
				}
				
				// Assign value null to the object of the moved tile -> After Movement.
				objectForMove = null;
				
				// Check if the level is completed or not.
				checkIsGameDone(tileList, twoDim);
			} else {
				// Assign value null to the object of the moved tile -> After Movement. 
				objectForMove = null;
			}
		}
	}
	
	// The checkIsGameDone() -> Check if the Current level is completed + The ball animation executed.
	private void checkIsGameDone(ArrayList<Tile> tileList, Tile[][] twoDim) {	
		// Create event to detect movement (animation) of the ball -> completed or not.
		tileList.forEach((e) -> {
			if (e.getTypes() == application.Types.STARTER) {
				boolean isCompletedInsede = ((StartTile) e).isContinue(twoDim, null);
				if (isCompletedInsede) {
					pathTransition.setPath(Repository.path);
					Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(300),event ->  {
						// Detect the ball animation (executed or not).
						pathTransition.play();
						// Clear the pipe tiles ArrayList.
						Repository.pipeList.clear();
						// Clear the path of the ball ArrayList.
						Repository.path.getElements().clear();
						}));
					// Current Level is Completed 
					isCompleted = true;
					timeLine.setCycleCount(1);

					timeLine.play();										
				} else {
					Repository.pipeList.clear();
					Repository.path.getElements().clear();
				}									 
			}
		});
	}
	
	// The createBall() Create Ball of the game board using a circle object.
	public Circle createBall() {
		// Create circle object of the ball
		Circle circle = new Circle();
		// Center X -> the point.
		circle.setCenterX(50);
		// Center Y -> the point.
		circle.setCenterY(57);
		
		// Event starts from the starter tile and displays the ball on the tile.
		Repository.tileList.forEach((e) -> {
			if (e.getTypes() == application.Types.STARTER) {
				int x = Repository.findXYCoordinate(e)[0]; // X
				int y = Repository.findXYCoordinate(e)[1]; // Y
				circle.setCenterX(x);
				circle.setCenterY(y);
			}
		});
		
		// Radius of the circle object for the ball.
		circle.setRadius(13);
		// Use Path transition for the ball animation.
		pathTransition.setNode(circle);
		pathTransition.setDuration(Duration.millis(duration));
		Text durationText = new Text(String.valueOf(duration));
		durationText.setX(200);
		durationText.setY(500);
		return circle;
	}
	
	// The changePositionOfTwoObjectInList() -> (movement) exchanging the positions of the objects generated by these tiles.
	public void changePositionOfTwoObjectInList(Tile[][] list, Tile to, Tile from) {
		// First object -> position.
		int tempToX = Repository.findTileInTwoDim(list, to)[0]; // X
		int tempToY = Repository.findTileInTwoDim(list, to)[1]; // Y
		// Second object -> position.
		int tempFromX = Repository.findTileInTwoDim(list, from)[0]; // X
		int tempFromY = Repository.findTileInTwoDim(list, from)[1]; // Y

		Tile toCopy = Helper.generateTilesFromTile(to);
		Tile fromCopy = Helper.generateTilesFromTile(from);
		
		// Swap the objects.
		list[tempToY][tempToX] = fromCopy;
		list[tempFromY][tempFromX] = toCopy;
	}
	
	// The setBackgroundImage() -> display the background of the game board.
	private void setBackgroundImage(BorderPane root) {
		Image image = new Image(getClass().getResource("tiles/bg.png").toExternalForm());
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(600);
		imageView.setFitWidth(600);
		Background background2 = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
		root.setBackground(background2);
	}
	
	// The Launch() method -> Start Execution + Launch the program.
	public static void main(String[] args) {
		launch(args);
	}
	  
    // The createContent() -> Launching the animation and the other methods invoked in this method.
    private Parent createContent() {
        addBackground();
        addTitle();
        
        double lineX = WIDTH / 2 - 100;
        double lineY = HEIGHT / 3 + 50;

        addLine(lineX, lineY);
        addMenu(lineX + 5, lineY + 5);

        startAnimation();

        return root;
    }
    
    // The addBackGround() -> Add Background to the pane -> Display.
    private void addBackground() {
    	// Create an imageView object -> receive an input file (.png) -> external background
        ImageView imageView = new ImageView(new Image(getClass().getResource("BackGround.png").toExternalForm()));
        // SEt height + width.
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);
        // Add the background to the pane -> Display.
        root.getChildren().add(imageView);
    }
    
    // The addTitle() method -> add the title of the open page to the pane -> Display.
    private void addTitle() {
        OpenPageTitle title = new OpenPageTitle("Puzzle");
        title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
        title.setTranslateY(HEIGHT / 3);
        // Add the title to the pane -> Display.
        root.getChildren().add(title);
    }
    
    // The addLine() -> create the line object
    private void addLine(double x, double y) {
    	// Line object.
        line = new Line(x, y, x, y + 300);
        // Set the width.
        line.setStrokeWidth(3);
        // Set the color of the stroke line.
        line.setStroke(Color.color(1, 1, 1, 0.75));
        // Set the shadow Effect.
        line.setEffect(new DropShadow(5, Color.BLACK));
        line.setScaleY(0);
        // Add the line to the pane -> Display.
        root.getChildren().add(line);
    }
    
    // The startAnimation() -> start the animation for the menu of the open page.
    private void startAnimation() {
    	// Use ScaleTransition -> create a ScaleTransition object to display a vertical line on the screen.
        ScaleTransition st = new ScaleTransition(Duration.seconds(1), line);
        st.setToY(1);
        // When line is finished -> display the menu
        st.setOnFinished(e -> {
            for (int i = 0; i < menuBox.getChildren().size(); i++) {
            	// Create a node to display the pairs of the menu box.
                Node n = menuBox.getChildren().get(i);
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1 + i * 0.15), n);
                tt.setToX(0);
                tt.setOnFinished(e2 -> n.setClip(null));
                tt.play();
            }
        });
        st.play();
    }
    
    // The addMenu() is to create the menu box and then add it to the pane to display it on the screen.
    private void addMenu(double x, double y) {
        menuBox.setTranslateX(x);
        menuBox.setTranslateY(y);
        menuData.forEach(data -> {
            MenuItems item = new MenuItems(data.getKey());
            item.setOnAction(data.getValue());
            item.setTranslateX(-300);

            Rectangle clip = new Rectangle(300, 30);
            clip.translateXProperty().bind(item.translateXProperty().negate());

            item.setClip(clip);

            menuBox.getChildren().addAll(item);
        });
        root.getChildren().add(menuBox);
    }
}