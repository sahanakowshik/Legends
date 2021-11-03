public class LegendsBoard extends Board{
    @Override
    public void createBoard() {
        for(int i=0;i<GameConstants.boardSize;i++){
            for(int j=0;j<GameConstants.boardSize;j++){
                if(GameFunctions.getRandomBoolean((float) 0.3)){
                    grid[i][j] = CellFactory.getCell("market");
                }
                else if(GameFunctions.getRandomBoolean((float) 0.2)){
                    grid[i][j] = CellFactory.getCell("inaccessible");
                }
                else{
                    grid[i][j] = CellFactory.getCell("safe");
                }
            }
        }
    }

    public void addPlayer(Player player, Board board){
        int max = GameConstants.boardSize-1;
        int min = 0;
        int i = (int)Math.floor(Math.random()*(max-min+1)+min);
        int j = (int)Math.floor(Math.random()*(max-min+1)+min);
//        board.grid[i][j] = player;
    }


}
