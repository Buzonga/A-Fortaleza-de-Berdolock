import java.util.Random;

public class Dice {

    public static int rollDice(int numberDice) {

        int number = 0;
        int roll = 0;

        Random rand = new Random();

        if (numberDice >= 1) {

            for (int i = 0; i < numberDice; i++) {

                roll = rand.nextInt(6) + 1;
                number += roll;

            }

        } else {

            System.out.println("You must roll at least 1 dice");

        } return number;

    }
}
