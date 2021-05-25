package view;

import engine.HikeInfo;
import engine.HikingClub;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Controls the add and remove hikes scene
 */
public class AddRemoveScene extends VBox {
    /**
     * The hiking club that controls the backend of the program
     */
    private HikingClub club;
    /**
     * The main gui class that this connects to
     */
    private GUI gui;
    /**
     * The scene library that this class is part of
     */
    private SceneLibrary S;
    /**
     * Label to display error messages
     */
    private Label errLabel;

    /**
     * Instantiates a new AddRemoveScene object, creating all the buttons, text prompts, and labels
     * @param g The GUI to be used for this scene
     * @param s The scene library that this scene is part of
     */
    public AddRemoveScene(GUI g, SceneLibrary s) {
        gui = g;
        club = g.getClub();
        S = s;

        HBox instruct = new HBox();
        HBox instruct2 = new HBox();
        HBox backButton = new HBox();
        HBox gap = new HBox();
        HBox textField = new HBox();
        HBox textField2 = new HBox();
        HBox textField3 = new HBox();
        HBox gap2 = new HBox();
        HBox add = new HBox();
        HBox remove = new HBox();
        HBox errBox = new HBox();

        instruct.setAlignment(Pos.CENTER);
        instruct2.setAlignment(Pos.CENTER);
        backButton.setAlignment(Pos.CENTER);
        textField.setAlignment(Pos.CENTER);
        textField2.setAlignment(Pos.CENTER);
        textField3.setAlignment(Pos.CENTER);
        add.setAlignment(Pos.CENTER);
        remove.setAlignment(Pos.CENTER);
        errBox.setAlignment(Pos.CENTER);

        setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Label instructions = new Label("Use this screen to add/remove a hiker using corresponding text fields to do so.");
        instruct.getChildren().add(instructions);

        Label instructions2 = new Label("Locations: Everglades Trail, The Beach, Biscayne, The Hill.");
        instruct2.getChildren().add(instructions2);

        Button back = new Button("<- Back");
        back.setOnAction(e -> {
            S.setMenuScene();
        });
        backButton.getChildren().add(back);

        Label space = new Label("");
        gap.getChildren().add(space);

        Label l1 = new Label("Hiker Name: ");
        TextField text = new TextField();
        textField.getChildren().addAll(l1, text);

        Label l2 = new Label("Hike Location: ");
        TextField text2 = new TextField();
        textField2.getChildren().addAll(l2, text2);

        Label l3 = new Label("Hike Duration: ");
        TextField text3 = new TextField();
        textField3.getChildren().addAll(l3, text3);

        Label space2 = new Label("");
        gap2.getChildren().add(space2);

        errLabel = new Label("");
        errBox.getChildren().add(errLabel);

        Button addBut = new Button("Add Hiker");
        addBut.setOnAction(e -> {
            try {
                int x = Integer.parseInt(text3.getText());
                if(text.getText().equalsIgnoreCase("")) {
                    errLabel.setText("Please enter a hiker name.");
                    return;
                }
                if(!(text2.getText().equalsIgnoreCase("Everglades Trail") ||
                        text2.getText().equalsIgnoreCase("The Beach") ||
                        text2.getText().equalsIgnoreCase("Biscayne") ||
                        text2.getText().equalsIgnoreCase("The Hill"))) {
                    errLabel.setText("Please enter a valid location FROM THE LIST.");
                    return;
                }
                club.addHike(text2.getText(), x, text.getText());
                errLabel.setText("Hiker added successfully.");

            }
            catch (Exception ex) {
                errLabel.setText("Put an INTEGER for hike time, please. Oh, and do make it positive :)");
            }
        });
        add.getChildren().add(addBut);

        Button removeBut = new Button("Remove Hiker");
        removeBut.setOnAction(e -> {
            try {
                int x = Integer.parseInt(text3.getText());
                club.removeHike(text2.getText(), x, text.getText());
                errLabel.setText("Hiker removed successfully.");
            }
            catch (Exception ex) {
                errLabel.setText("Put an INTEGER for hike time, please. Oh, and do make it positive :)");
            }

        });
        remove.getChildren().add(removeBut);

        getChildren().addAll(instruct, instruct2, backButton, gap, textField, textField2, textField3,
                gap2, add, remove, errBox);
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

    /**
     *
     * @return the error label
     */
    public Label getErrLabel() {
        return errLabel;
    }
}
