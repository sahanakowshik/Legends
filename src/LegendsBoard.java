import java.util.Random;

public class LegendsBoard extends Board{
    Random random = new Random();
    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
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
                        this.setI(i);
                        this.setJ(j);
                        return;
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                try{
                    if(this.grid[i-1][j] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        this.setI(i);
                        this.setJ(j);
                        return;
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                try{
                    if(this.grid[i][j+1] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        this.setI(i);
                        this.setJ(j);
                        return;
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                try{
                    if(this.grid[i][j-1] instanceof isAccessible){
                        this.grid[i][j].setPlayer(player);
                        this.grid[i][j].setIsSet(true);
                        this.setI(i);
                        this.setJ(j);
                        return;
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        } while(true);
    }

    public boolean canMove(int i, int j){
        if(i < 0 || j < 0){
            System.out.println("Out of bounds");
            return false;
        }
        if(i >= GameConstants.boardSize || j >= GameConstants.boardSize) {
            System.out.println("Out of bounds");
            return false;
        }
        if(this.grid[i][j] instanceof isAccessible)
            return true;
        else
            return false;
    }

    public void move(int i, int j, LegendsPlayer player){
        if(this.grid[i][j] instanceof isAccessible){
            this.grid[i][j].setPlayer(player);
            this.grid[i][j].setIsSet(true);
            this.grid[this.i][this.j].setIsSet(false);
//            this.grid[this.i][this.j].setPlayer(null);
            this.setI(i);
            this.setJ(j);
        }
    }


}
