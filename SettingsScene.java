package view;

import engine.HikingClub;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * This scene allows for the user to change the color of the background of the GUI.
 */
public class SettingsScene extends VBox {
    /**
     * The GUI that this scene will be mounted on
     */
    private GUI gui;
    /**
     * The scene library that this scene belongs to
     */
    private SceneLibrary S;

    /**
     * Constructs a new settings scene, creating all the components and setting them in the right positions
     * @param g The GUI that this scene will be mounted on
     * @param s The scene library that this scene belongs to
     */
    public SettingsScene(GUI g, SceneLibrary s) {
        gui = g;

        S = s;

        HBox instruct = new HBox();
        HBox backButton = new HBox();
        HBox gap = new HBox();
        HBox buttons = new HBox();

        instruct.setAlignment(Pos.CENTER);
        backButton.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);

        setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label instructions = new Label("Background color setting. Click buttons to change color.");
        instruct.getChildren().add(instructions);

        Button back = new Button("<- Back");
        back.setOnAction(e -> {
            S.setMenuScene();
        });
        backButton.getChildren().add(back);

        Label space = new Label("");
        gap.getChildren().add(space);

        Button b = new Button("Black");
        b.setOnAction(e -> {
            S.setColor("black");
        });
        Button c = new Button("White");
        c.setOnAction(e -> {
            S.setColor("white");
        });
        Button d = new Button("Blue");
        d.setOnAction(e -> {
            S.setColor("blue");
        });
        Button f = new Button("Red");
        f.setOnAction(e -> {
            S.setColor("red");
        });
        buttons.getChildren().addAll(b, c, d, f);

        getChildren().addAll(instruct, backButton, gap, buttons);
        setAlignment(Pos.CENTER);
    }

    /**
     * Sets the color of the background of this scene.
     * @param color The name of the color that the background is to be set to
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
