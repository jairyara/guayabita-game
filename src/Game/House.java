package Game;

public class House extends Player  {

    int initialBet;

    public House(String name, int balance) {
        super(name, balance);
    }

    public int getInitialBet() {
        return initialBet;
    }

    public void setInitialBet(int initialBet) {
        this.initialBet = initialBet;
    }
}
