public class SafeCell implements Cell{
    private String symbol = "     ";
    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return "Safe";
    }

    @Override
    public String getName() {
        return "Safe";
    }
}
