import java.util.Random;

public class LegendsBoard extends Board{
    Random random = new Random();
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
                grid[i][j].setIsSet(false);
            }
        }
    }

    public void addPlayer(LegendsPlayer player){
        do{
            int min = 0;
            int max = GameConstants.boardSize - 1;
            int i = random.nextInt(max - min + 1) + min;
            int j = random.nextInt(max - min + 1) + min;
            if(this.grid[i][j] instanceof isAccessible){
                try{
                    if(this.grid[i+1][j] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    if(this.grid[i-1][j] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    if(this.grid[i][j+1] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try{
                    if(this.grid[i][j-1] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while(true);
    }


}
