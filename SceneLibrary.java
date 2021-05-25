package view;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Stores all the scenes to be used in this program's GUI, as well as their roots.
 */
public class SceneLibrary {
    /**
     * The width of the GUI
     */
    private static final int width = 500;
    /**
     * The height of the GUI
     */
    private static final int height = 600;

    /**
     * The GUI itself
     */
    private GUI gui;
    /**
     * The stage to which every scene is mounted on
     */
    private Stage primaryStage;

    private Scene introScene;
    private Scene blueScreen;
    private Scene menuScene;
    private Scene addRemove;
    private Scene settingsScene;

    private IntroFrame intro;
    private ViewScene blue;
    private MenuScene menu;
    private AddRemoveScene aor;
    private SettingsScene settings;

    /**
     * Creates and initializes a new SceneLibrary object, as well as instantiating every scene to be used in
     * the program.
     * @param g The GUI to be used for this program
     */
    public SceneLibrary(GUI g) {
        gui = g;

        intro = new IntroFrame(this);
        blue = new ViewScene(gui, this);
        menu = new MenuScene(gui, this);
        aor = new AddRemoveScene(gui, this);
        settings = new SettingsScene(gui, this);

        introScene = new Scene(intro, width, height);
        blueScreen = new Scene(blue, width, height);
        menuScene = new Scene(menu, width, height);
        addRemove = new Scene(aor, width, height);
        settingsScene = new Scene(settings, width, height);
    }

    /**
     * Sets the primary stage for all scenes to be mounted on
     * @param stage The stage to be used as the primary stage
     */
    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     *
     * @return The intro scene
     */
    public IntroFrame getIntro() {return intro;}

    /**
     * Sets the intro scene
     */
    public void setIntroScene() { primaryStage.setScene(introScene); }

    /**
     *
     * @return The menu for viewing a hike's information
     */
    public ViewScene getBlue() {return blue;}

    /**
     * Sets the hike information menu
     */
    public void setBlueScreen() {
        primaryStage.setScene(blueScreen);
    }

    /**
     *
     * @return The home scene
     */
    public MenuScene getMenu() {return menu;}

    /**
     * Sets the home scene
     */
    public void setMenuScene() {
        primaryStage.setScene(menuScene);
    }

    /**
     *
     * @return The scene which allows you to add or remove a hike from the list of hikes
     */
    public AddRemoveScene getAor() {return aor;}

    /**
     * Sets the scene for adding and removing hikes from the list
     */
    public void setAddRemoveScene() {
        primaryStage.setScene(addRemove);
    }

    /**
     *
     * @return The settings scene
     */
    public SettingsScene getSettings() {return settings;}

    /**
     * Sets the settings scene
     */
    public void setSettingsScene() {
        primaryStage.setScene(settingsScene);
    }

    /**
     * When the option for a color is selected in the settings scene, this method sets the color of each
     * scene by calling each individual scene root's setColor method
     * @param color The color to set all scenes to
     */
    public void setColor(String color) {
        intro.setColor(color);
        blue.setColor(color);
        menu.setColor(color);
        aor.setColor(color);
        settings.setColor(color);
    }
}
