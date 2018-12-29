package ui;

import model.Coin;

public class Main {

    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println("Current status: " + coin.checkStatus());
        System.out.println("Flipping");
        coin.flip();
        System.out.println("Current status: " + coin.checkStatus());

        System.out.println("Flipping");
        coin.flip();
        System.out.println("Current status: " + coin.checkStatus());

        System.out.println("Flipping");
        coin.flip();
        System.out.println("Current status: " + coin.checkStatus());

        System.out.println("Flipping");
        coin.flip();
        System.out.println("Current status: " + coin.checkStatus());
    }

}
