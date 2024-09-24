import Model.Console;
import Repositorio.ComandoService;
import com.google.gson.Gson;
import java.util.Scanner;

public class Main {

    private static final Gson Gson = new Gson();

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Bem vindo ao Jogo! Digite 'start' para iniciar ou 'help' para ver os comandos disponíveis.");

        while (true) {

            System.out.print("> ");
            input = scanner.nextLine();


            if (input.equalsIgnoreCase("exit")) {

                System.out.println("Saindo do jogo. Até a próxima!");
                break;

            } else if (input.equalsIgnoreCase("reset")) {

                System.out.println("O jogo está reiniciando...");
                Thread.sleep(3000);

                for (int i = 0; i < 40; i++) {
                    System.out.println();
                } main(args);

                break;
            }

            ComandoService comandoService = new ComandoService(input);
            Console resultado = comandoService.getResultadoConsole();

            System.out.println(resultado.getMensagem());

        }

        scanner.close();

    }
}
