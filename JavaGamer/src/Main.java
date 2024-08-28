import Comandos.ComandoPrompt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o comando");
            String help = scanner.nextLine();

            ComandoPrompt ComandoHelp = new ComandoPrompt(help);
        }
    }
}
