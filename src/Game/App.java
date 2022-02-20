package Game;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);

    public int numberOfPlayers() {
        System.out.println("----------------------------------");
        System.out.println("Ingrese la cantidad de jugadores");
        int numberOfPlayers = sc.nextInt();
        while (numberOfPlayers < 2) {
            System.out.println("Ingrese un número mayor a 1");
            numberOfPlayers = sc.nextInt();
        }
        return numberOfPlayers;
    }

    int totalPlayers = numberOfPlayers();
    Player[] player = new Player[totalPlayers];
    House house;
    int initialBetHouse = 10;

    public void setBet() {
        System.out.println("----------------------------------");
        System.out.println("Mesa de apuestas No 10. Apuesta inicial de 10 monedas");
        String nameHouse = "Mesa de apuestas No 10";
        System.out.println("----------------------------------");
        String name;
        int betAmount;
        int balancePlayer;

        for (int i = 0; i < totalPlayers; i++) {
            System.out.println("Ingresar el nombre del jugador");
            sc.nextLine();
            name = sc.nextLine();
            System.out.println("Ingresar su cantidad de dinero para jugar");
            betAmount = sc.nextInt();
            balancePlayer = betAmount;

            player[i] = new Player(name, betAmount, balancePlayer);
            System.out.println("----------------------------------");
        }
        int initialBalanceHouse = 0;

        house = new House(nameHouse, initialBalanceHouse);
        house.setInitialBet(initialBetHouse);
    }

    public int throwDice() {
        return (int) (Math.random() * 6 + 1);
    }

    public void inTheGame() {
        setBet();

        int houseBalance;
        boolean activeGame = true;

        while (activeGame) {
            for (Player value : player) {
                if (value.getBalance() > 0) {
                    if (value.getBalance() < initialBetHouse ) {
                        System.out.println("Jugador " + value.getName() + " se retira por falta de fondos");
                        System.out.println("----------------------------------");
                        break;
                    }
                    System.out.println("Jugador " + value.getName());
                    System.out.println("Su saldo para apostar es: " + value.getBalance());
                    for (int j = 0; j < 2; j++) {
                        int firstValue = throwDice();
                        System.out.println("Lanzamiento " + 1 + " es de " + firstValue);
                        System.out.println("Quiere apostar mas o mantenerse? Escriba 1 para si, 2 para no");
                        int opcion = sc.nextInt();
                        if (opcion == 1) {
                            int secondValue = throwDice();
                            int playerBalance = value.getBalance();
                            int houseBalanceBet = house.getBalance();
                            int resultBet = 0;

                            if (value.getBalance() >= house.getBalance()) {
                                if (firstValue < secondValue) {
                                    resultBet = playerBalance + houseBalanceBet;
                                    value.setBalance(resultBet);
                                    house.setBalance(0);
                                    System.out.println("Jugador " + value.getName() + " gana");
                                    System.out.println("Balance jugador " + value.getBalance());
                                } else {
                                    int houseResult = houseBalanceBet * 2;
                                    resultBet = playerBalance - houseBalanceBet;
                                    value.setBalance(resultBet);
                                    house.setBalance(houseResult);
                                    System.out.println("Jugador " + value.getName() + " pierde");
                                    System.out.println("Balance jugador " + value.getBalance());
                                    System.out.println("Balance casa " + house.getBalance());
                                }
                                break;
                            } else {
                                System.out.println("Jugador " + value.getName() + " se retira por falta de fondos");
                                System.out.println("----------------------------------");
                                break;
                            }
                        } else {
                            System.out.println("Lanzamiento " + 2 + " es de " + throwDice());
                            System.out.println("Este lanzamiento no cuenta en la apuesta");
                            int bet = value.getBalance() - initialBetHouse;
                            value.setBalance(bet);
                            System.out.println("Nuevo saldo jugador " + value.getName() + " es de " + value.getBalance());
                            if (value.getBalance() == 0 ) {
                                System.out.println("Jugador " + value.getName() + " se retira por falta de fondos");
                            }
                            houseBalance = house.getBalance() + initialBetHouse;
                            house.setBalance(houseBalance);
                            System.out.println("Banco de la casa es de : " + house.getBalance());
                            System.out.println("----------------------------------");
                            activeGame = true;
                            break;
                        }
                    }
                }else {
                    activeGame = false;
                }

            }
        }
        System.out.println("Juego finalizado");
    }


    public void guayabita() {
        inTheGame();
    }
}
