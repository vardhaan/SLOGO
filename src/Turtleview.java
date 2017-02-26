import static javafx.application.Platform.exit;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import turtles.Turtle;
public class Turtleview extends Observable  implements Cloneable{
	private
	public Turtle(){
		this(0);
	}
	
	public Turtle(int id){
	
	
	
}
	/*public static final boolean SYSTEM_MENU_BAR = true;
    public static final double ANIMATION_RATE_STEP = 5.0 / 4;
    public static final double ANIMATION_RATE_CAP = 15;
    public static final double ANIMATION_FRAMERATE = 60;
    public static final String RESOURCES_LOCATION = "resources/Strings";
    public static final double ZOOM_STEP = 11.0 / 10;
    public static final double DEFAULT_SIZE = 900;
    public static final ResourceBundle myResources = ResourceBundle.getBundle(RESOURCES_LOCATION);
    protected Timeline myAnimation;
    //private InputDataGetter myInputData;
    public Scene myScene;
    private double zoom;
    
    public Turtleview() {
        this(DEFAULT_SIZE, DEFAULT_SIZE);
    }


public Turtleview(double width, double height) {
    zoom = 1;
    BorderPane myBorderPane = new BorderPane();
    myScene = new Scene(myBorderPane);
    myBorderPane.setTop(new TurtleViewMenu().getMenuBar());
    //myBorderPane.setBottom(openNewFile());
    //KeyFrame frame = new KeyFrame(Duration.seconds(1 / myInputData.getFramesPerSecond()), e -> update());
    //cellFrequencyData = new HashMap<>();
    myAnimation = new Timeline(ANIMATION_FRAMERATE);
    myAnimation.setCycleCount(Timeline.INDEFINITE);
    myAnimation.play();
// TODO Auto-generated constructor stub
	}
/*

private Node openNewFile() {
    ScrollPane simulationPane = new ScrollPane();
    simulationPane.setPrefSize(windowWidth, windowHeight);
    simulationPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle(myResources.getString("Open_File"));
    fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Turtle data", "*.xml"));
    int attemptsRemaining = 3;
    do {
        try {
            File xmlFile = fileChooser.showOpenDialog(null);
            myInputData = new InputDataGetterXML(xmlFile, myResources);
        } catch (Exception e) {
            attemptsRemaining--;
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
        if (attemptsRemaining < 0) {
            exit();
            System.exit(-1);
        }
    } while (Objects.isNull(myInputData) && Objects.isNull(myAnimation));
    //(need XML part)
    simulationGroup.getChildren().addAll(cellViews.stream().map(T::getView).collect(Collectors.toSet()));
    simulationPane.setContent(simulationGroup);
    return simulationPane;
}

*/
/* created in case

protected LineChart createChart() {
  
}
*/
	/*
private void updateData() {
    
}

/**
 * Class representing the Menubar at the top of the window which contains all user interaction with the simulation.
 * This class handles all supported menu functions:
 * File
 * -New
 * -Open
 * -Save as XML
 * -Save as PNG
 * -Exit
 * View
 * -Zoom In
 * -Zoom Out
 * -Zoom Auto
 * -Adjust Color
 * Simulation
 * -Pause
 * -Speed Up
 * -Slow Down
 * -Reverse
 * -Step Forward
 * -Step Backward
 * -Seek
 * Help
 * -View Readme
 * -About
 *
 * @see javafx.scene.control.MenuBar
 */
	/*
private class TurtleViewMenu {
    private MenuBar myMenu;

    /**
     * Constructs MenuBar used for the UI
     */
	/*
    public TurtleViewMenu() {
        Menu file = initFileMenu();
        Menu simulation = initSimulationMenu();
        Menu help = initHelpMenu();
        Menu view = initViewMenu();
        myMenu = new MenuBar(file, view, simulation, help);
        myMenu.setUseSystemMenuBar(SYSTEM_MENU_BAR);
    }

    /**
     * @return MenuBar
     * @see javafx.scene.control.MenuBar
     */
  /*
	public MenuBar getMenuBar() {
        return myMenu;
    }

    private Menu initFileMenu() {
        MenuItem newWindow = new MenuItem(myResources.getString("New..."));
        newWindow.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
        newWindow.setOnAction(e -> newSimulation());
        MenuItem open = new MenuItem(myResources.getString("Open..."));
        open.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
        //open.setOnAction(e -> ((BorderPane) myScene.getRoot()).setBottom(openNewFile()));
        MenuItem exportPNG = new MenuItem(myResources.getString("Export_As"));
        exportPNG.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        exportPNG.setOnAction(s -> exportPNG());
        MenuItem exit = new MenuItem(myResources.getString("Exit"));
        exit.setAccelerator(new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHORTCUT_DOWN));
        exit.setOnAction(s -> exit());
        return new Menu(myResources.getString("File"), null, newWindow, open, exportPNG, exit);
    }

    private Menu initSimulationMenu() {
        MenuItem pause = new MenuItem(myResources.getString("Pause"));
        pause.setAccelerator(new KeyCodeCombination(KeyCode.SPACE));
        pause.setOnAction(e -> pause.setText(myResources.getString(pause() ? myResources.getString("Unpause") : myResources.getString("Pause"))));
        MenuItem restart = new MenuItem(myResources.getString("Restart"));
        restart.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.SHORTCUT_DOWN));
        
    }

    private Menu initHelpMenu() {
        MenuItem viewHelp = new MenuItem(myResources.getString("View_Readme"));
        viewHelp.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        viewHelp.setOnAction(e -> openReadme());
        MenuItem viewJavadoc = new MenuItem(myResources.getString("View_Documentation"));
        viewJavadoc.setAccelerator(new KeyCodeCombination(KeyCode.J, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        viewJavadoc.setOnAction(e -> openJavadoc());
        MenuItem about = new MenuItem(myResources.getString("About"));
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        about.setOnAction(e -> about());
        return new Menu(myResources.getString("Help"), null, viewHelp, viewJavadoc, about);
    }

    private Menu initViewMenu() {
        MenuItem zoomAuto = new MenuItem(myResources.getString("Zoom_Auto"));
        zoomAuto.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        zoomAuto.setOnAction(e -> zoomAuto());
        MenuItem zoomIn = new MenuItem(myResources.getString("Zoom_In"));
        zoomIn.setAccelerator(new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        zoomIn.setOnAction(e -> zoomIn());
        MenuItem zoomOut = new MenuItem(myResources.getString("Zoom_Out"));
        zoomOut.setAccelerator(new KeyCodeCombination(KeyCode.MINUS, KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_DOWN));
        zoomOut.setOnAction(e -> zoomOut());
        MenuItem colorShift = new MenuItem(myResources.getString("Adjust_Color"));
        colorShift.setOnAction(e -> colorShift());
        return new Menu(myResources.getString("View"), null, zoomAuto, zoomIn, zoomOut, colorShift);
    }

    private void newSimulation() {
        Stage newStage = new Stage();
        Turtleview newUI = new Turtleview();
        newStage.setResizable(false);
        newStage.setScene(newUI.myScene);
        newStage.sizeToScene();
        newStage.setTitle(newUI.myResources.getString("Title"));
        newStage.show();
    }

    private void exit() {
        Platform.exit();
        System.exit(0);
    }

    private void zoomIn() {
        zoom /= ZOOM_STEP;
    }

    private void zoomOut() {
        zoom *= ZOOM_STEP;
    }

    private void zoomAuto() {
        zoom = 1;
    }

    private void colorShift() {
        Dialog dbox = new Dialog();
        dbox.setTitle(myResources.getString("Adjust_Color"));
        dbox.setHeaderText(myResources.getString("Adjust_Color_Content"));
        dbox.getDialogPane().getButtonTypes().add(new ButtonType(myResources.getString("Okay"), ButtonBar.ButtonData.CANCEL_CLOSE));
        GridPane content = new GridPane();
        content.getColumnConstraints().add(new ColumnConstraints(90));
        ColumnConstraints slidersColumn = new ColumnConstraints();
        slidersColumn.setHgrow(Priority.ALWAYS);
        content.getColumnConstraints().add(slidersColumn);
        Slider hSlider = new Slider(0, 360, 0);
        hSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setHueShift(hSlider.getValue())));
        content.add(new Label(myResources.getString("Hue")), 0, 0);
        content.add(hSlider, 1, 0);
        Slider sSlider = new Slider(0, 1, 1);
        sSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setSaturationShift(sSlider.getValue())));
        content.add(new Label(myResources.getString("Saturation")), 0, 1);
        content.add(sSlider, 1, 1);
        Slider lSlider = new Slider(0, 2, 1);
        lSlider.valueProperty().addListener(e -> cellViews.forEach(f -> f.setLightnessShift(lSlider.getValue())));
        content.add(new Label(myResources.getString("Lightness")), 0, 2);
        content.add(lSlider, 1, 2);
        dbox.getDialogPane().setContent(content);
        dbox.showAndWait();
    }
/*
    private void viewGraph() {
        Dialog dbox = new Dialog();
        dbox.setTitle(myResources.getString("View_Graph"));
        dbox.setHeaderText(myResources.getString("View_Graph_Content"));
        dbox.getDialogPane().getButtonTypes().add(new ButtonType(myResources.getString("Okay"), ButtonBar.ButtonData.CANCEL_CLOSE));
        dbox.getDialogPane().setContent(createChart());
        dbox.showAndWait();
    }
*/
	/*
    private boolean pause() {
        if (myAnimation.getStatus().equals(Animation.Status.PAUSED)) {
            myAnimation.play();
            return true;
        } else {
            myAnimation.pause();
            return false;
        }
    }
/*
    private void speedUp() {
        if (myAnimation.getStatus().equals(Animation.Status.RUNNING)) {
            double rate = myAnimation.getCurrentRate();
            if (rate * ANIMATION_RATE_STEP < ANIMATION_RATE_CAP) {
                myAnimation.setRate(rate * ANIMATION_RATE_STEP);
            }
            System.out.printf("New animation speed:\t%.2f\n", myAnimation.getCurrentRate());
        }
    }

    private void slowDown() {
        if (myAnimation.getStatus().equals(Animation.Status.RUNNING)) {
            myAnimation.setRate(myAnimation.getCurrentRate() / ANIMATION_RATE_STEP);
            System.out.printf("New animation speed:\t%.2f\n", myAnimation.getCurrentRate());
        }
    }
*/
 

/*
    
    private void exportPNG() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(myResources.getString("Export_File"));
        fileChooser.setInitialFileName("TurtleScreenshot1.png");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Portable Network Graphics", "*.png"));
        File output = fileChooser.showSaveDialog(null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(myScene.snapshot(null), null), "png", output);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, myResources.getString("ErrorSave")).show();
        }
    }

    private void openReadme() {
        try {
            Desktop.getDesktop().browse(new URI("http://coursework.cs.duke.edu/CompSci308_2017Spring/slogo_team01"));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, myResources.getString("ErrorReadme")).show();
        }
    }

    private void openJavadoc() {
        try {
            Desktop.getDesktop().browse(new URI("file://" + System.getProperty("user.dir").replace('\\','/') + "/doc/index.html"));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, myResources.getString("ErrorDocumentation")).show();
        }
    }

    private void about() {
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setHeaderText(myResources.getString("CellSociety"));
        about.setTitle(myResources.getString("About"));
        about.setContentText(myResources.getString("AboutContent"));
        about.showAndWait();
    }
}
}

