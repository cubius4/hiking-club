package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * This scene is the first menu a user will see when they load up the program.
 */
public class IntroFrame extends VBox {
    /**
     * The scene library that this scene belongs to
     */
    private SceneLibrary S;

    /**
     * Constructs a new IntroFrame object, creating all the scene's items and components and placing them in the
     * correct places.
     * @param s The scene library that this scene will belong to
     */
    public IntroFrame(SceneLibrary s) {
        S = s;

        setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox startLabel = new HBox();
        startLabel.setAlignment(Pos.CENTER);
        HBox image = new HBox();
        image.setAlignment(Pos.CENTER);
        Label sl = new Label("Welcome to Hiking Club! Click Start to begin.");
        Button firstButton = new Button("Start");
        firstButton.setOnAction(e -> S.setMenuScene());
        startLabel.getChildren().add(sl);
        getChildren().addAll(image, startLabel, firstButton);

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
