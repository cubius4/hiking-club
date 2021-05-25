package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * This scene serves as a main menu, allowing to view other scenes with other features.
 */
public class MenuScene extends VBox {
    /**
     * The GUI that this Menu scene is mounted on
     */
    private GUI gui;
    /**
     * The scene library that this menu scene belongs to
     */
    private SceneLibrary S;

    /**
     * Constructs a new menu scene object, creating all the items and components and placing them in the correct
     * place
     * @param g The GUI that this menu scene is mounted on
     * @param s The scene library that this menu scene belongs to
     */
    public MenuScene(GUI g, SceneLibrary s) {
        gui = g;
        S = s;

        HBox instruct = new HBox();
        HBox backButton = new HBox();
        HBox addOrRemove = new HBox();
        HBox list = new HBox();
        HBox gap = new HBox();
        HBox gap2 = new HBox();
        HBox gap3 = new HBox();
        HBox settings = new HBox();

        instruct.setAlignment(Pos.CENTER);
        backButton.setAlignment(Pos.CENTER);
        addOrRemove.setAlignment(Pos.CENTER);
        list.setAlignment(Pos.CENTER);
        settings.setAlignment(Pos.CENTER);

        setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label instructions = new Label("Select an option below to either change the list or view it.");
        instruct.getChildren().add(instructions);

        Label space = new Label("");
        gap.getChildren().add(space);

        Label space2 = new Label("");
        gap2.getChildren().add(space2);

        Label space3 = new Label("");
        gap3.getChildren().add(space3);

        Button back = new Button("<- Back");
        back.setOnAction(e -> {
            S.setIntroScene();
        });
        backButton.getChildren().add(back);

        Button aor = new Button("Add/Remove Hike");
        aor.setOnAction(e -> {
            S.setAddRemoveScene();
        });
        addOrRemove.getChildren().add(aor);

        Button l = new Button("See Hikes");
        l.setOnAction(e -> {
            S.setBlueScreen();
        });
        list.getChildren().add(l);

        Button set = new Button("Settings");
        set.setOnAction(e -> {
            S.setSettingsScene();
        });
        settings.getChildren().add(set);

        getChildren().addAll(instruct, backButton, gap, addOrRemove, list, gap2, gap3, settings);
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
