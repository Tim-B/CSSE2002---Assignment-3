
package view;

//~--- non-JDK imports --------------------------------------------------------

import controllers.ButtonController;
import controllers.main;
import models.Player;
import models.impl.Game;
import view.components.ErrorAlert;
import view.components.GameEnvironmentComponent;
import view.components.MenuComponent;
import view.components.SplashScreen;

//~--- JDK imports ------------------------------------------------------------

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main GUI window. Starts new rounds and games.
 * Extends a JFrame Swing element
 *
 */
public class MainWindow extends JFrame {

    /**
     * The singleton instance of the application.
     */
    private static MainWindow instance = null;

    /**
     * Sets the button controller to the buttonController class
     */
    protected ButtonController uiController = new ButtonController();

    /**
     * The instance of the file Chooser
     */
    private final JFileChooser fileChooser = new JFileChooser();

    /**
     * The instance of the current game
     */
    protected Game game;

    /**
     * The instance of the main content panel
     */
    private JPanel mainPanel;

    /**
     * The main function of the GUI
     */
    protected MainWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setJMenuBar(new MenuComponent());

        setVisible(true);

        setSize(800, 456);

        setLocationRelativeTo(null);

        // Makes a container within the window that will be manipulated
        mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(new SplashScreen());

        add(mainPanel);

    }

    /**
     * Returns the singleton instance.
     * @return The instance
     */
    public static MainWindow getInstance() {

        if (instance == null) {

            instance = new MainWindow();

        }

        return instance;

    }

    /**
     * Gets the current game
     * @return the instance of Game that is the current game
     */
    public Game getGame() {

        return game;

    }

    /**
     * Initializes a new game
     */
    public void newGame() {

        int returnVal = fileChooser.showOpenDialog(mainPanel);

        try {

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = fileChooser.getSelectedFile();

                game = new Game(file);

                mainPanel.removeAll();

                mainPanel.add(new GameEnvironmentComponent(game));

                mainPanel.revalidate();

                mainPanel.repaint();

                updateUI();

            }

        } catch (Exception exep) {}

    }

    /**
     * Ends the current game
     * @param message the String endgame message
     */
    public void endGame(String message) {

        // Display the outcome of the game
        new ErrorAlert(message);

        game = null;

        mainPanel.removeAll();

        setMinimumSize(new Dimension(800, 456));

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(new SplashScreen());

        mainPanel.revalidate();

        mainPanel.repaint();

        updateUI();

    }

    /**
     * Starts a new round of the current game
     */
    public void newRound() {

        try {

            game.setSelected(null);

            int noMoves = 0;

            // Play all the players moves
            for (Player currentPlayer : game.allPlayers()) {

                currentPlayer.play();

                // Check if the player has won the game
                if (currentPlayer.wonGame()) {

                    MainWindow.getInstance().endGame(
                        "Game won by: " + currentPlayer.getPlayerName());

                    return;

                } else if (!currentPlayer.canMove()) {

                    noMoves++;

                }

            }

            // Check if the game is a draw
            if (noMoves == game.allPlayers().size()) {

                MainWindow.getInstance().endGame("Game is a draw");

            }

        } catch (Exception ex) {

            new ErrorAlert(ex.getMessage());

            game.getHand().setSelected(null);

        }

    }

    /**
     * Updates the entire GUI
     */
    public void updateUI() {

        validate();

        repaint();

        pack();

    }
}



