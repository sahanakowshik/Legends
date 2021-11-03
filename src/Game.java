public interface Game {

    public String getName();
    /**
     * Get the summary of the game
     */
    public void summary();


    /**
     * Start the game
     */
    public void startGame();

    /**
     * Get Players of the game
     */
    public Player[] getPlayers();

}