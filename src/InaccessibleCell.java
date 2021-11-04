public class InaccessibleCell extends Cell{
    private String symbol = "\u001b[31m  I  \u001b[0m";
    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return "Inaccessible";
    }

    @Override
    public String getName() {
        return "Inaccessible";
    }
}
