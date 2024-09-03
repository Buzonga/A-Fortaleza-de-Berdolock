import java.util.Scanner;

public class MainMenu {

    public void MenuOptions() {

        Scanner scan = new Scanner(System.in);
        boolean running = true;

        do {

            System.out.println("""
                Welcome to Berdolock's Fortress.\
                \s
                \s
                Chose an option:\
                \s
                1 - Play\
                \s
                0 - Quit""");
            int op = scan.nextInt();

            switch (op) {

                case 1:
                    Intro intro = new Intro();
                    intro.IntroMsg();
                    GameMenu gameMenu = new GameMenu();
                    gameMenu.GameMenuOptions();
                    break;

                case 0:
                    System.out.println("Closing the game.");
                    running = false;
                    break;
            }
        } while (running);

            scan.close();
    }
}
