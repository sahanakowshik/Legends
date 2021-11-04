public class SafeCell extends Cell implements isAccessible {
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
