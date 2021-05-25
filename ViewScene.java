package view;

import engine.HikingClub;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * This is the menu to view hiking club information, including the list of hikers and the total hike time for
 * a certain hiker and a certain location.
 */
public class ViewScene extends VBox {
    /**
     * The hiking club
     */
    private HikingClub club;
    /**
     * The GUI
     */
    private GUI gui;
    /**
     * The SceneLibrary that this scene is stored in
     */
    private SceneLibrary S;

    /*
        HBoxes for organization. Each one of these HBoxes contains a different set of labels or buttons so that the
        GUI is laid out in an organized manner.
     */
    private HBox images = new HBox();
    private HBox backButton = new HBox();
    private HBox buttons = new HBox();
    private HBox shapes = new HBox();
    private HBox gap = new HBox();
    private HBox shapes2 = new HBox();
    private HBox shapes3 = new HBox();
    private HBox err1 = new HBox();
    private HBox err2 = new HBox();
    private HBox shapes4 = new HBox();
    private HBox gap2 = new HBox();
    private HBox gap3 = new HBox();

    /*
        Labels. Any label called space (i.e. space2, space3, etc.) is there to leave a space between 2 other labels.
     */

    /**
     * Label which can contain the names of all the hikers in the hiking club
     */
    private Label hikers = new Label(" ");
    /**
     * Informs the user that they can use this menu to check the hiker list or the total hike time of a certain
     * hiker and/or location
     */
    private Label text = new Label("This menu allows you to check your hiker list,");
    /**
     * Continuation of text
     */
    private Label text2 = new Label("or to check the total hike time of a certain hiker or location.");

    private Label space = new Label("");
    /**
     * This button, when clicked, displays the list of all hikers using the hikers label
     */
    private Button d = new Button("Print all");
    /**
     * Button which allows for returning to the previous screen
     */
    private Button back = new Button("<- Back");
    /**
     * Instructions on what Button d does
     */
    private Label l1 = new Label("Use this to print hike time for a specific hiker. ");
    /**
     * A text field to type a hiker name in order to be able to check the hike time for a specific location
     */
    private TextField text1 = new TextField();
    /**
     * When clicked, displays the total time for a hiker
     */
    private Button but1 = new Button("View Hiker Time");
    /**
     * Instructions for Button but1
     */
    private Label l2 = new Label("Use this to print hike time for a specific location. ");
    /**
     * Text field for entering a location to view the total time for a location
     */
    private TextField text3 = new TextField();
    /**
     * When clicked, displays the total time for a location
     */
    private Button but2 = new Button("View Loc Time");

    private Label space2 = new Label("");
    private Label space3 = new Label("");
    /*
        Error labels, to display any errors that come up
     */
    private Label errLabel1 = new Label("");
    private Label errLabel2 = new Label("");

    /**
     * Constructs a new ViewScene object, and initializes and sets the GUI in position.
     * @param g the GUI that this ViewScene is displayed on
     * @param s the SceneLibrary that this ViewScene belongs in
     */
    public ViewScene(GUI g, SceneLibrary s) {
        gui = g;
        club = g.getClub();
        S = s;

        images.setAlignment(Pos.CENTER);
        backButton.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        shapes.setAlignment(Pos.CENTER);
        shapes2.setAlignment(Pos.CENTER);
        shapes3.setAlignment(Pos.CENTER);
        shapes4.setAlignment(Pos.CENTER);
        err1.setAlignment(Pos.CENTER);
        err2.setAlignment(Pos.CENTER);

        setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        images.getChildren().add(hikers);
        gap.getChildren().add(space);

        d.setOnAction(e -> {
            hikers.setText(club.printHikingClub());
        });

        back.setOnAction(e -> {
            S.setMenuScene();
        });
        backButton.getChildren().add(back);

        shapes.getChildren().addAll(l1, text1);

        but1.setOnAction(e -> {
            if(club.printHikerTime(text1.getText()) == 0) {
                errLabel1.setText("Hiker not found.");
            }
            else {
                errLabel1.setText("Total Hike Duration for " + text1.getText() +
                        ": " + club.printHikerTime(text1.getText()) + " minutes");
            }
        });
        shapes2.getChildren().add(but1);

        shapes3.getChildren().addAll(l2, text3);

        but2.setOnAction(e -> {
            if(club.printLocTime(text3.getText()) == 0) {
                errLabel2.setText("Location not found.");
            }
            else {
                errLabel2.setText("Total Hike Duration for " + text3.getText() +
                        ": " + club.printLocTime(text3.getText()) + " minutes");
            }
        });
        shapes4.getChildren().add(but2);

        gap2.getChildren().add(space2);

        gap3.getChildren().add(space3);

        err1.getChildren().add(errLabel1);

        err2.getChildren().add(errLabel2);

        buttons.getChildren().addAll(backButton, d);
        getChildren().addAll(text, text2, backButton, gap, buttons, images, gap2,
                shapes, shapes2, err1, gap3, shapes3, shapes4, err2);

        setAlignment(Pos.CENTER);
    }


    /**
     * Sets the color of the background to a given color
     * @param color The name of the color that the background will be changed to
     */
    public void setColor(String color) {
        if(color.equals("black")) {
            setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if(color.equals("white")) {
            setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if(color.equals("blue")) {
            setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if(color.equals("red")) {
            setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

}
