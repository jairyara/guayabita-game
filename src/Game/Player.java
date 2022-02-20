package Game;

public class Player {

    String name;
    int betAmount;
    int balance;

    public Player(String name, int betAmount, int balance) {
        this.name = name;
        this.betAmount = betAmount;
        this.balance = balance;
    }

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
