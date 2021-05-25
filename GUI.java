package view;

import engine.HikingClub;
import javafx.application.Application;
import javafx.stage.Stage;


/*
    
 */

/**
 * The main class of this program. It is also used as a bridge between the back end and front end of the program.
 */
public class GUI extends Application {
    /**
     * HikingClub which handles all of the back end for this program.
     */
    private HikingClub club = new HikingClub();
    /**
     * SceneLibrary which handles all of the front end for this program.
     */
    private SceneLibrary s;

    /**
     * The main method
     * @param args The command line args for the program
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts up the program.
     * @param primaryStage The stage for all scenes to be mounted on.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            s = new SceneLibrary(this);

            s.setPrimaryStage(primaryStage);
            primaryStage.setTitle("Hiking Club");

            s.setIntroScene();
            primaryStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     *
     * @return The hiking club, for use in the GUI
     */
    public HikingClub getClub() {return club;}
}
